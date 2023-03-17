package com.blueLine.java.webServices.blueline.spingService.weBlog.genre.repository;

import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepositoryCustom {
    void addGenre(String name);
    List<Genre> getAllGenre();
    Optional<Genre> getGenreById(int id);
    Optional<Genre> getGenreByName(String name);
    void deleteGenreById(int id);
}
