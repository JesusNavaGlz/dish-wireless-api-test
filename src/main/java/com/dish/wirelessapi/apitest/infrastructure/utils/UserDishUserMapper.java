package com.dish.wirelessapi.apitest.infrastructure.utils;

import com.dish.wirelessapi.apitest.domain.model.User;
import com.dish.wirelessapi.apitest.infrastructure.model.DishUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDishUserMapper {

  @Mapping(target="userIdentifier", source="id")
  @Mapping(target="userActive", source="active")
  @Mapping(target="userEmail", source="email")
  User toUser(DishUser dishUser);

  @Mapping(target="id", source="userIdentifier")
  @Mapping(target="active", source="userActive")
  @Mapping(target="email", source="userEmail")
  DishUser toDishUser(User user);
}
