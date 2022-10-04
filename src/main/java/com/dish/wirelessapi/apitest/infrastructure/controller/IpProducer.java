package com.dish.wirelessapi.apitest.infrastructure.controller;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/awsTest")
@EnableBinding(Source.class)
public class IpProducer {

  private Source source;

  public IpProducer(Source source) {
    this.source = source;
  }

  @PostMapping
  public void sendMessage(@RequestParam String message){
    source.output().send(MessageBuilder.withPayload(message).build());
  }
}
