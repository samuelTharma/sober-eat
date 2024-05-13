# sober-eat 
build & run with 
maven
java 17
mongoDB
kafka

kafka and mongoDB 
1. run the following to start the kafka and mongoDB in detached mode]
- docker-compose -f docker-compose-env.yaml up -d
create a topic called kitchen-orders in localhost:9999
https://stackoverflow.com/questions/65682557/kafka-docker-image-that-works-without-zookeeper

2. after clean build the project using mvn clean install
 - docker-compose up to start the services in docker
 - or the services can be started in IDE


# sober-eat/ order-service

to get the mock order json
http://localhost:8080/sober-eat/order-service/get

to create order
http://localhost:8080/sober-eat/order-service/create

# sober-eat/ kitchen-service
The kitchen service would accept the order, then start preparing the meal
once ready, it would notify the order service and delivery service

to send the order to kitchen service/OrderConsumer via kafka
https://piotrminkowski.com/2022/01/24/distributed-transactions-in-microservices-with-kafka-streams-and-spring-boot/
    order-received,
    [added to the queue]
    order-preparing,
    order-menu[x] finished,
    order-finished,
    order-packed

    package send to delivery service