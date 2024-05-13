package com.sobereat.kitchenservice.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer
{
  private final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

  @KafkaListener(topics = "kitchen-orders", groupId = "group_id")
  public void consume(String message) throws IOException
  {
    logger.info(String.format("#### -> Consumed message -> %s", message));
  }
}
