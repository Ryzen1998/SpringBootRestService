package com.blueLine.java.webServices.blueline.spingService.commons.user.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_data",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "phone_number"),
                @UniqueConstraint(columnNames = "user_name")
        }
)
public class User{
    public User(){

    }

    public User(Long id, String name, String email, String userName, String password, int role, String phoneNumber, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,insertable = false,unique = true)
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @jakarta.validation.constraints.Email
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Username cannot be empty")
    @Column(name = "user_name")
    private String userName;
    @NotBlank
    private String password;
    private int role;
    @NotBlank(message = "Phone cannot be empty")
    @Column(name = "phone_number")
    private String phoneNumber;
    @Nullable
    private boolean isActive =false;


    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", UserName='" + userName + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", IsActive=" + isActive +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return userName.replaceAll(" ","");
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName.replaceAll(" ","");
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}