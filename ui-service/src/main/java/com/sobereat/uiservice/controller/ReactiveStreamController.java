package com.sobereat.uiservice.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sobereat")
public class ReactiveStreamController
{

  @GetMapping(value = "/numbers/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Integer> streamNumbers() {
    return Flux.range(1, 20).delayElements(Duration.ofSeconds(1));
  }
}
