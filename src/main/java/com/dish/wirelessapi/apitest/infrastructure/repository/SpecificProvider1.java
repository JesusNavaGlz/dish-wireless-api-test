package com.dish.wirelessapi.apitest.infrastructure.repository;

import com.dish.wirelessapi.apitest.domain.model.User;
import com.dish.wirelessapi.apitest.domain.repository.ServiceProvider1;
import org.springframework.stereotype.Repository;

@Repository
public class SpecificProvider1 implements ServiceProvider1 {
  @Override
  public void setupUser(User user) {
    System.out.println("... Sending User data to service provider 1 for processing ...");
  }
}
