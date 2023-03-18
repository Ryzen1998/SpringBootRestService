package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto;


import jakarta.validation.constraints.NotBlank;

public class PostDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private int genre;

    public PostDto(String title, String content, int genre) {
        this.title = title;
        this.content = content;
        this.genre = genre;
    }

    public PostDto() {
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

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
}
