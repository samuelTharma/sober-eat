package com.sobereat.orderservice.service;

import com.sobereat.orderservice.producer.OrderProducer;
import com.sobereat.orderservice.repository.OrderRepository;
import com.sobereat.orderservice.rest.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
 // private final OrderRepository orderRepository;
  @Autowired
  private OrderProducer producer;
  public OrderService()
  {
   // this.orderRepository = orderRepository;
  }
  public Order create(Order order)
  {
   // Order created = orderRepository.insert(order);
    // notify the created to kitchen service
    // notify the created to delivery service
    // notify the created to customer service

    producer.sendMessage(order);
    return order;
  }
}
