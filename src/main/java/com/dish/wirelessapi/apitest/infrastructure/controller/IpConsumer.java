package com.dish.wirelessapi.apitest.infrastructure.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class IpConsumer {

  @StreamListener(Sink.INPUT)
  public void consume(String message) {
    System.out.println(message);
  }
}
