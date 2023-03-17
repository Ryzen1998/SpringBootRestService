package com.blueLine.java.webServices.blueline.spingService.weBlog.genre.service;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model.Genre;
import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements iGenreService{
    private final GenreRepository genreRepository;
    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public ServiceResponse<String> addGenre(String name) {
        if(!name.isBlank()){
            if(genreRepository.getGenreByName(name).isEmpty()){
                genreRepository.addGenre(name);
                return new ServiceResponse<>(null,"Success");
            }
            else return new ServiceResponse<>(null,false,"Genre already Exists",500);
        }
        return new ServiceResponse<>(null,false,"Invalid Genre",400);
    }

    @Override
    public ServiceResponse<List<Genre>> getAllGenre() {
        List<Genre> result = genreRepository.getAllGenre();
        if(!result.isEmpty()) {
            return new ServiceResponse<>(result,"Success");
        }
        return new ServiceResponse<>(null,false,"No Genres Found",404);
    }

    @Override
    public ServiceResponse<Genre> getGenreById(int id) {
        Optional<Genre> genre = genreRepository.getGenreById(id);
        if(genre.isPresent()){
            return new ServiceResponse<>(genre.get(),"Success");
        }
        return new ServiceResponse<>(null,false,"No Genre Found with the Given Id",404);
    }

    @Override
    public ServiceResponse<Genre> getGenreByName(String name) {
        Optional<Genre> genre = genreRepository.getGenreByName(name);
        if(genre.isPresent()){
            return new ServiceResponse<>(genre.get(),"Success");
        }
        return new ServiceResponse<>(null,false,"No Genre Found with the Given name",404);
    }

    @Override
    public ServiceResponse<String> deleteGenreById(int id) {
        Optional<Genre> genre = genreRepository.getGenreById(id);
        if(genre.isPresent()){
            genreRepository.deleteGenreById(id);
            return new ServiceResponse<>(null,"Success");
        }
        return new ServiceResponse<>(null,false,"No Genre Found with the Given Id",404);
    }
}
