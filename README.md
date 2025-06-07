## Download code

## Start e-commerce backend, there are 2 ways to start the backend web application(project are based on Java 17):
### Use memory DB by default, but you can switch to postgres DB by enabling Postgre in application.properties
### [optional]Start Redis server in your local machine, if you want to connect to redis server in another machine, please change configuration in application.properties.
### Run com.ecommerce.WebApplication from IDE(e.g IntelliJ idea)
### Run cmd:java -jar ecommercebackend-0.0.1-SNAPSHOT.jar (I uploaded ecommercebackend-0.0.1-SNAPSHOT.jar in project root folder)

## Call rest-api to insert products
### curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\": \"iPhone 5\", \"price\": 3999.00, \"inventory\": 100}"
### curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\": \"iPhone 10\", \"price\": 5999.00, \"inventory\": 200}"
### curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\": \"iPhone 15\", \"price\": 7999.00, \"inventory\": 300}"

## Verify from Rest-api
### GET: Returns a list of products (id, name, price, inventory) 
    curl -X GET http://localhost:8080/api/products
    Response: [{"id":1,"name":"iPhone 5","price":3999.0,"inventory":100},{"id":2,"name":"iPhone 10","price":5999.0,"inventory":200},{"id":3,"name":"iPhone 15","price":7999.0,"inventory":300}]
### POST: Create a new order 
    curl -X POST http://localhost:8080/api/orders -H "Content-Type: application/json" -H "Accept: application/json" -d "{\"productId\": 2, \"quantity\": 1}"
    Response: {"orderId":"090fd196-0544-46fb-84ea-36d52bf6d35a","totalPrice":5999.0} 
### GET: Retrieve order details.
    curl -X GET http://localhost:8080/api/orders/090fd196-0544-46fb-84ea-36d52bf6d35a
    Response: {"orderId":"090fd196-0544-46fb-84ea-36d52bf6d35a","product":{"id":2,"name":"iPhone 10","price":5999.0,"inventory":199},"quantity":1,"totalPrice":5999.0}

## I uploaded ecommerce-demo.mp4 in project root folder, you can watch ecommerce-demo.mp4 which I recorded a demo for frontend to backend.


