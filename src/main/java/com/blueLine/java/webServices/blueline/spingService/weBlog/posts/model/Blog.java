package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.model;

import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;
import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model.Genre;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "blogPosts")
public class Blog {
    public Blog(Long id, String title, String content, Date createdOn, User createdByUser, boolean isActive, Genre genre) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
        this.createdByUser = createdByUser;
        this.isActive = isActive;
        this.genre = genre;
    }
    public Blog() {
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,insertable = false,unique = true)
    private Long id;
    @Column(length = 200)
    private String title;
    @Column(length = 1500)
    private String content;
    private Date createdOn;
    @OneToOne
    @MapsId
    private User createdByUser;
    private boolean isActive;
    @OneToOne
    @MapsId
    private Genre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
