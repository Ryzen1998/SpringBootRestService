package com.blueLine.java.webServices.blueline.spingService.common.user.dto;

import jakarta.validation.constraints.NotBlank;

public class SignupDto {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @jakarta.validation.constraints.Email
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Username cannot be empty")
    private String userName;
    @NotBlank(message = "Phone cannot be empty")
    private String phoneNumber;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SignupDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignupDto(String name, String email, String userName, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public SignupDto() {
    }
}
