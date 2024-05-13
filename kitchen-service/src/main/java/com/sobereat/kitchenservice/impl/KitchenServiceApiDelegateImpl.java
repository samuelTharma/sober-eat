package com.sobereat.kitchenservice.impl;

import com.sobereat.kitchenservice.rest.api.KitchenServiceApiDelegate;
import com.sobereat.kitchenservice.rest.model.Order;
import org.springframework.http.ResponseEntity;

public class KitchenServiceApiDelegateImpl implements KitchenServiceApiDelegate
{
  @Override
  public ResponseEntity<Order> acceptOrder(Order order)
  {
    return KitchenServiceApiDelegate.super.acceptOrder(order);
  }

  @Override
  public ResponseEntity<Order> find()
  {
    return KitchenServiceApiDelegate.super.find();
  }
}
