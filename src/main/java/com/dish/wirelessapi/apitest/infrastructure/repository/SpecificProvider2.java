package com.dish.wirelessapi.apitest.infrastructure.repository;

import com.dish.wirelessapi.apitest.domain.model.User;
import com.dish.wirelessapi.apitest.domain.repository.ServiceProvider2;
import org.springframework.stereotype.Repository;

@Repository
public class SpecificProvider2 implements ServiceProvider2 {
  @Override
  public void setupUser(User user) {
    System.out.println("... Sending User data to service provider 1 for processing ...");
  }
}
