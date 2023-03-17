package com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genres",
uniqueConstraints ={
        @UniqueConstraint(columnNames = "name")
})
public class Genre {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,insertable = false,unique = true)
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
