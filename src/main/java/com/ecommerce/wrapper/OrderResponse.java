package com.ecommerce.wrapper;


public class OrderResponse {
    private String orderId;
    private Double totalPrice;
    public OrderResponse(){
    }
    public OrderResponse(String orderId,Double totalPrice){
        this.orderId=orderId;
        this.totalPrice=totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
