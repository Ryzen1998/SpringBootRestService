package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto;

import java.util.Date;

public class PostResponseDto {
    private String title;
    private String content;
    private String genre;
    private String createdBy;
    private Date createdOn;

    public PostResponseDto(String title, String content, String genre, String createdBy, Date createdOn) {
        this.title = title;
        this.content = content;
        this.genre = genre;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    public PostResponseDto() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
