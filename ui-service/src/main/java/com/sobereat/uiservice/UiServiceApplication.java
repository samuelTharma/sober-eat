package com.sobereat.uiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UiServiceApplication
{
  public static void main(String[] args)
  {
    System.out.println("Hello world!");
    SpringApplication.run(UiServiceApplication.class, args);
  }
}