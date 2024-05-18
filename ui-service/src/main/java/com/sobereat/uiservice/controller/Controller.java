package com.sobereat.uiservice.controller;

import java.time.Duration;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;

import com.sobereat.event.OrderPlaced;
import com.sobereat.uiservice.model.MenuItemStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ui-service")
public class Controller
{
  private static final Logger logger = LoggerFactory.getLogger(Controller.class);

  @GetMapping(value = "/get", name = "get", produces = { "application/json" })
  public Mono<OrderPlaced> getOrder()
  {
    OrderPlaced orderPlaced = new OrderPlaced();
    orderPlaced.setId("3232");
    return Mono.just(orderPlaced);
  }

  @GetMapping("order-status/{orderId}")
  public Flux<MenuItemStatus> getOrderStatus(@PathVariable("orderId") String orderId)
  {
    return Flux
      .fromStream(this::prepareStream)
      .delayElements(Duration.ofMillis(500))
      .doOnNext(menuItemStatus -> logger.info("Menu Item status: {}", menuItemStatus));

//    return webClient.get()
//      .uri("/some-endpoint")
//      .retrieve()
//      .onStatus(HttpStatus::is4xxClientError, clientResponse ->
//        Mono.error(new RuntimeException("Client error")))
//      .onStatus(HttpStatus::is5xxServerError, clientResponse ->
//        Mono.error(new RuntimeException("Server error")))
//      .bodyToFlux(SomeResponse.class)
//      .onErrorResume(e -> Flux.empty()); // Fallback mechanism
  }

  @PostMapping("place-order")
  public Mono<OrderPlaced> placeOrder(@RequestBody OrderPlaced orderPlaced, HttpServletRequest request)
  {
    return Mono.just(orderPlaced);
  }

  private Stream<MenuItemStatus> prepareStream()
  {
    return Stream.of(new MenuItemStatus(1, "Pizza", "Preparing"),
                     new MenuItemStatus(1, "Pizza", "Preparing"),
                     new MenuItemStatus(1, "Pizza", "Preparing"),
                     new MenuItemStatus(1, "Pizza", "Preparing"),
                     new MenuItemStatus(1, "Pizza", "Preparing"),
                     new MenuItemStatus(1, "Pizza", "Preparing")

    );
  }
}
