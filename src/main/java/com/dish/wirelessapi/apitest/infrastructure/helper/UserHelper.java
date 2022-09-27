package com.dish.wirelessapi.apitest.infrastructure.helper;

import com.dish.wirelessapi.apitest.domain.model.User;
import com.dish.wirelessapi.apitest.infrastructure.model.DishUser;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {

  public User toUser(DishUser dishUser) {
    User domainUser = new User();

    domainUser.setUserActive(dishUser.isActive());
    domainUser.setUserEmail(dishUser.getEmail());
    domainUser.setUserIdentifier(dishUser.getId());
    domainUser.setFirstName(dishUser.getFirstName());
    domainUser.setLastName(dishUser.getLastName());

    return domainUser;
  }
}
