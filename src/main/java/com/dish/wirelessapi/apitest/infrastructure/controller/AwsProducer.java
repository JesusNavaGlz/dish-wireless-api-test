package com.dish.wirelessapi.apitest.infrastructure.controller;

import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.model.PutRecordsRequest;
import com.amazonaws.services.kinesis.model.PutRecordsRequestEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.util.List;

@RestController
@RequestMapping("/awsTest")
public class AwsProducer {

  private AmazonKinesis kinesis;
  @Value("${aws.sampleStream.name}")
  private String ipsStream;

  @Value("${aws.sampleStream.id}")
  private String ipsShard;

  public AwsProducer(AmazonKinesis kinesis) {
    this.kinesis = kinesis;
  }

  @PutMapping
  public void sendSampleEvent(@RequestParam String message) {
//    System.out.println("Sending message <" + message + ">");

    sendMessage(message);

//    System.out.println("Operation completed");

  }

  private void sendMessage(String message) {
    var entry = new PutRecordsRequestEntry();
    entry.setData(ByteBuffer.wrap(message.getBytes()));
    entry.setPartitionKey(ipsShard);

    var createRecordsRequest = new PutRecordsRequest();
    createRecordsRequest.setStreamName(ipsStream);
    createRecordsRequest.setRecords(List.of(entry));

    kinesis.putRecords(createRecordsRequest);
  }

}
