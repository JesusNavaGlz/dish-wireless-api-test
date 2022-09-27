package com.dish.wirelessapi.apitest.infrastructure.model;

import javax.validation.constraints.*;
import java.util.Objects;


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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DishUser dishUser = (DishUser) o;
    return isActive == dishUser.isActive && Objects.equals(id, dishUser.id) && Objects.equals(firstName,
        dishUser.firstName) && Objects.equals(lastName, dishUser.lastName) && Objects.equals(email, dishUser.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, isActive, email);
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "DishUser{" +
        "id='" + id + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", isActive=" + isActive +
        ", email='" + email + '\'' +
        '}';
  }
}
