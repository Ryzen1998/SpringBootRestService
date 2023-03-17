package com.blueLine.java.webServices.blueline.spingService.weBlog.genre.repository;

import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface GenreRepository extends JpaRepository<Genre,Integer>,GenreRepositoryCustom {
}
