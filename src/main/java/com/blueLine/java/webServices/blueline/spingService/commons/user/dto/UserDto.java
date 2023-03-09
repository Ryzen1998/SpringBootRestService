package com.blueLine.java.webServices.blueline.spingService.commons.user.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @jakarta.validation.constraints.Email
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Username cannot be empty")
    private String userName;
    @NotBlank(message = "Phone cannot be empty")
    private String phoneNumber;
    private boolean isActive =false;
    @Nullable
    private String role;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String userName, String phoneNumber, boolean isActive, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isActive=" + isActive +
                ", role='" + role + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto(Long id, String name, String email, String userName, String phoneNumber, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
