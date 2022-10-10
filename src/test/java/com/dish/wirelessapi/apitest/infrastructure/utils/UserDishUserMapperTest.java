package com.dish.wirelessapi.apitest.infrastructure.utils;

import com.dish.wirelessapi.apitest.domain.model.User;
import com.dish.wirelessapi.apitest.infrastructure.model.DishUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserDishUserMapperTest {

  private UserDishUserMapper mapper = Mappers.getMapper(UserDishUserMapper.class);

  @Test
  public void shuoldTranslateToUser_fromDishUser(){
    DishUser dishUser= new DishUser();
    dishUser.setId("1q2b3c4d");
    dishUser.setFirstName("Jesus");
    dishUser.setLastName("Nava");
    dishUser.setActive(TRUE);
    dishUser.setEmail("some@email.com");
    dishUser.setAge(31);

    User result = mapper.toUser(dishUser);

    assertEquals(dishUser.getId(), result.getUserIdentifier());
    assertEquals(dishUser.getFirstName(), result.getFirstName());
    assertEquals(dishUser.getLastName(), result.getLastName());
    assertEquals(dishUser.getEmail(),result.getUserEmail());
  }
}