package com.sobereat.orderservice.repository;

import com.sobereat.orderservice.rest.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, ObjectId>
{

}
