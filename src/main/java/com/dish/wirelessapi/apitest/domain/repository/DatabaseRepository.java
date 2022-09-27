package com.dish.wirelessapi.apitest.domain.repository;

import com.dish.wirelessapi.apitest.domain.model.User;
import org.springframework.stereotype.Repository;


public interface DatabaseRepository {
  void updateDatabase(User user);
}
