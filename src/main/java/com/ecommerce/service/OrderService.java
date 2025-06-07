package com.ecommerce.service;

import com.ecommerce.RedisLockUtil;
import com.ecommerce.entity.Order;
import com.ecommerce.exception.BusinessException;
import com.ecommerce.exception.ErrorEnum;
import com.ecommerce.wrapper.OrderRequest;
import com.ecommerce.dao.OrderRepository;
import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entity.Product;
import com.ecommerce.wrapper.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OrderService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private RedisLockUtil redisLockUtil;

    public Optional<Order> getOrderById(String id) {
        return orderRepo.findById(id);
    }

    public OrderResponse createOrder(OrderRequest request) {
        String lockKey = "order:lock:" + request.getProductId();
        String requestId = UUID.randomUUID().toString();
        try {
            if (!redisLockUtil.tryLock(lockKey, requestId, 30000)) {
                throw new BusinessException(ErrorEnum.TOO_FREQUENTLY);
            }
            //find product
            Product product = productRepo.findById(request.getProductId())
                    .orElseThrow(() -> new BusinessException(ErrorEnum.PRODUCT_NOT_FOUND));

            if (product.getInventory() < request.getQuantity()) {
                throw new BusinessException(ErrorEnum.INSUFFICIENT_STOCK);
            }
            // sub inventory
            product.setInventory(product.getInventory() - request.getQuantity());
            Product productSaved = productRepo.save(product);

            // create order
            Order order = new Order();
            order.setOrderId(UUID.randomUUID().toString());
            order.setProduct(productSaved);
            order.setQuantity(request.getQuantity());
            order.setTotalPrice(product.getPrice() * request.getQuantity());
            orderRepo.save(order);
            return new OrderResponse(order.getOrderId(), order.getTotalPrice());
        } finally {
            redisLockUtil.unlock(lockKey, requestId);
        }

    }
}