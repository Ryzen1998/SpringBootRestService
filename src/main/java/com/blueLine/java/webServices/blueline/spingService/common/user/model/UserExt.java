package com.blueLine.java.webServices.blueline.spingService.common.user.model;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "User_Extended")
public class UserExt {
    public UserExt(Long id, User user, String createdBy, Date createdDate, Date lastLoginDate) {
        this.id = id;
        this.user = user;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastLoginDate = lastLoginDate;
    }

    public UserExt() {
    }

    @Id
    @Column(name = "user_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private  User user;
    private String createdBy;
    private Date createdDate;
    private Date lastLoginDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
