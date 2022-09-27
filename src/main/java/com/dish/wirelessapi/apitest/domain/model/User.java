package com.dish.wirelessapi.apitest.domain.model;

import java.util.Objects;

public class User {
    private String userIdentifier;
    private String firstName;
    private String lastName;
    private boolean isUserActive;
    private String userEmail;

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
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

    public boolean isUserActive() {
        return isUserActive;
    }

    public void setUserActive(boolean userActive) {
        isUserActive = userActive;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User dishUser = (User) o;
        return isUserActive == dishUser.isUserActive && Objects.equals(userIdentifier, dishUser.userIdentifier) && Objects.equals(firstName,
            dishUser.firstName) && Objects.equals(lastName, dishUser.lastName) && Objects.equals(userEmail, dishUser.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdentifier, firstName, lastName, isUserActive, userEmail);
    }
}
