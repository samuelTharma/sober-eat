package com.sobereat.uiservice.controller;

import com.sobereat.uiservice.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Controller
@RequestMapping("/sobereat")
public class UiController
{
//
//  //@GetMapping("/hello")
//  public Mono<String> hello(Model model)
//  {
//    model.addAttribute("message", "Hello, Reactive World!");
//    return Mono.just("hello");
//  }
//
  @GetMapping("/numbers")
  public Mono<String> numbers(Model model) {
    model.addAttribute("user", new User());
    return Mono.just("numbers");
  }
}