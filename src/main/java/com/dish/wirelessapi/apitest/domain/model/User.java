package com.dish.wirelessapi.apitest.domain.model;

import lombok.*;

@Data
@NoArgsConstructor
public class User {
  private String userIdentifier;
  private String firstName;
  private String lastName;
  private boolean isUserActive;
  private String userEmail;

}
