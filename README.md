## 1.Download code

## 2.start e-commerce backend, there are 2 ways to start the backend web application(project are based on Java 17):
### Run com.ecommerce.WebApplication from IDE(e.g IntelliJ idea)
### Run cmd:java -jar ecommercebackend-0.0.1-SNAPSHOT.jar (I uploaded ecommercebackend-0.0.1-SNAPSHOT.jar in project root folder)

## 3.Call rest-api to insert products
### curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\": \"iPhone 5\", \"price\": 3999.00, \"inventory\": 100}"
### curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\": \"iPhone 10\", \"price\": 5999.00, \"inventory\": 200}"
### curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\": \"iPhone 15\", \"price\": 7999.00, \"inventory\": 300}"

## 4.Verify from Rest-api
### You will see product list by calling 
    curl -X GET http://localhost:8080/api/products
    Response: [{"id":1,"name":"iPhone 5","price":3999.0,"inventory":100},{"id":2,"name":"iPhone 10","price":5999.0,"inventory":200},{"id":3,"name":"iPhone 15","price":7999.0,"inventory":300}]
### You can create order by calling 
    curl -X POST http://localhost:8080/api/orders -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"productId\": 2, \"quantity\": 1}"
    Response: {"orderId":"090fd196-0544-46fb-84ea-36d52bf6d35a","totalPrice":5999.0} 
### You can check order detail by calling
    curl -X GET http://localhost:8080/api/orders/090fd196-0544-46fb-84ea-36d52bf6d35a
    Response: {"orderId":"090fd196-0544-46fb-84ea-36d52bf6d35a","product":{"id":2,"name":"iPhone 10","price":5999.0,"inventory":199},"quantity":1,"totalPrice":5999.0}

## 5.I uploaded ecommerce-demo.mp4 in project root folder, you can watch ecommerce-demo.mp4 which I recorded a demo for frontend to backend.


