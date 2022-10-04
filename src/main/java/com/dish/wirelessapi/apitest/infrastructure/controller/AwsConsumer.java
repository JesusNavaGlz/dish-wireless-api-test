package com.dish.wirelessapi.apitest.infrastructure.controller;

import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class AwsConsumer {

  private GetShardIteratorResult shardIterator;
  private AmazonKinesis kinesis;

  @Value("${aws.sampleStream.name}")
  private String ipsName;

  @Value("${aws.sampleStream.id}")
  private String ipsShardId;

  private GetRecordsRequest recordsRequest;

  AwsConsumer(AmazonKinesis kinesis) {

    this.kinesis = kinesis;
  }

  @PostConstruct
  private void buildShardIterator() {
    GetShardIteratorRequest readShardsRequest = new GetShardIteratorRequest();
    readShardsRequest.setStreamName(ipsName);
    readShardsRequest.setShardIteratorType(ShardIteratorType.LATEST);
    readShardsRequest.setShardId(ipsShardId);

    this.shardIterator = kinesis.getShardIterator(readShardsRequest);

    recordsRequest = new GetRecordsRequest();
    recordsRequest.setShardIterator(shardIterator.getShardIterator());
  }

  @Scheduled(cron = "0/5 * * * * *")
  public void monitorEvents(){
    consumeEvents();
    System.out.println();
  }

  public void consumeEvents() {

    GetRecordsResult recordsResult = kinesis.getRecords(recordsRequest);

    System.out.println("Ready to listen a new batch");

    while (!recordsResult.getRecords().isEmpty()) {
      recordsResult.getRecords().stream()
          .map(record -> new String(record.getData().array()))
          .forEach(System.out::println);

      recordsRequest.setShardIterator(recordsResult.getNextShardIterator());
      recordsResult = kinesis.getRecords(recordsRequest);

    }

    System.out.println("Batch completed");

  }
}
