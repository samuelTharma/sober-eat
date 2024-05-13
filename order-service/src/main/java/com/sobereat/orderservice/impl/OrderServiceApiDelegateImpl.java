package com.sobereat.orderservice.impl;

import java.util.ArrayList;
import java.util.List;

import com.sobereat.orderservice.rest.api.OrderServiceApiDelegate;
import com.sobereat.orderservice.rest.model.Customer;
import com.sobereat.orderservice.rest.model.Menu;
import com.sobereat.orderservice.rest.model.Order;
import com.sobereat.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceApiDelegateImpl implements OrderServiceApiDelegate
{
  @Autowired
  private OrderService orderService;

  @Override
  public ResponseEntity<Order> create(Order order)
  {
    System.out.println("order " + order);
    orderService.create(order);
    return ResponseEntity.ok(order);
  }

  @Override
  public ResponseEntity<Order> find()
  {
    System.out.println(" getting order ..... ");
    Order order1 = new Order();
    List<Object> menuList = new ArrayList<>();
    Menu menu1 = new Menu();
    menu1.setId("1");
    menu1.setName("pizza");
    Menu menu2 = new Menu();
    menu2.setId("2");
    menu2.setName("bread");
    order1.setId("11");
    menuList.add(menu1);
    menuList.add(menu2);
    order1.setMenu(menuList);
    Customer customer = new Customer();
    customer.setName("John");
    customer.setAddress("22, London Street, L29 7TU");
    customer.setPhoneNumber("676676722");
    order1.setCustomer(customer);
    return ResponseEntity.ok(order1);
  }
}
