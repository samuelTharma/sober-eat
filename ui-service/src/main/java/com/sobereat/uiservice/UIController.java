package com.sobereat.uiservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ui-service")
public class UIController
{
  @GetMapping(
    value = "/get",
    name = "get",
    produces = { "application/json" }
  )
  public Mono<String> get()
  {
    System.out.println("get at UI service....");
      return Mono.empty();
  }
}
