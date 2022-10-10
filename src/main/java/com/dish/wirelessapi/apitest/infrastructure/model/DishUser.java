package com.dish.wirelessapi.apitest.infrastructure.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class DishUser {

  @NotNull
  private String id;

  @NotNull
  private String firstName;

  @NotNull
  private String lastName;

  @NotNull
  @Max(65)
  @Min(18)
  private Integer age;
  private boolean isActive;

  @Email
  @NotNull
  @NotEmpty
  private String email;
}
