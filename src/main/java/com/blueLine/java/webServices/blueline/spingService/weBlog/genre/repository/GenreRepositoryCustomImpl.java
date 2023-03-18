package com.blueLine.java.webServices.blueline.spingService.weBlog.genre.repository;

import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = false)
public class GenreRepositoryCustomImpl implements GenreRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addGenre(String name) {
        try{
            entityManager.createNativeQuery("insert into genres (name) values (?1)").
                    setParameter(1,name).executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Genre> getAllGenre() {
        List<Genre> result = new ArrayList<>();
        try{
           result = entityManager.createNativeQuery("select id,name from genres",Genre.class).getResultList();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public Optional<Genre> getGenreById(int id) {
        Optional<Genre> response = Optional.empty();
        Genre result = null;
        try{
            result = (Genre) entityManager.createNativeQuery("select id,name from genres where id=?1",Genre.class)
                                                  .setParameter(1,id).getSingleResult();
            response = Optional.ofNullable(result);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return response;
    }

    @Override
    public Optional<Genre> getGenreByName(String name) {
        Optional<Genre> response = Optional.empty();
        Genre result = null;
        try{
             result = (Genre) entityManager.createNativeQuery("select id,name from genres where name=?1",Genre.class)
                    .setParameter(1,name).getSingleResult();
             response = Optional.ofNullable(result);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return response;
    }

    @Override
    public void deleteGenreById(int id) {
        try{
            entityManager.createNativeQuery("delete from genres where id=?1").
                    setParameter(1,id).executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
