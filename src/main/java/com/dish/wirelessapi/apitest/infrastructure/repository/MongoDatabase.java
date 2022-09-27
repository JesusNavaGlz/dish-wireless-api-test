package com.dish.wirelessapi.apitest.infrastructure.repository;

import com.dish.wirelessapi.apitest.domain.model.User;
import com.dish.wirelessapi.apitest.domain.repository.DatabaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDatabase implements DatabaseRepository {
  @Override
  public void updateDatabase(User user) {
    System.out.println("Executing some really complex database operations");
  }
}
