package com.sobereat.orderservice.producer;

import com.sobereat.orderservice.rest.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer
{
  private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);
  private static final String TOPIC = "kitchen-orders";
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(Order message) {
    //TODO have to build order event and send it
    logger.info(String.format("#### -> Producing message -> %s", message));
    this.kafkaTemplate.send(TOPIC, message.getId(),message.getCustomer().getName());
  }
}
