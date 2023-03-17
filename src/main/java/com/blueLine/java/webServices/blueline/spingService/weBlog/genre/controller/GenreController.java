package com.blueLine.java.webServices.blueline.spingService.weBlog.genre.controller;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model.Genre;
import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.service.iGenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/genre")
public class GenreController {
    private final iGenreService genreService;
    @Autowired
    public GenreController(iGenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("getallgenre")
    public ServiceResponse<List<Genre>> getAllGenre(){
        ServiceResponse<List<Genre>> response = genreService.getAllGenre();
        return response;
    }
    @PostMapping("addgenre")
    public ServiceResponse<String> addNewGenre(@Valid @RequestBody String name){
       if(!name.isBlank()){
           ServiceResponse<String> response = genreService.addGenre(name.trim());
           return  response;
       }
       return new ServiceResponse<>(null,false,"Invalid Request",400);
    }
    @GetMapping("getgenrebyid")
    public ServiceResponse<Genre> getGenreById(int id){
        ServiceResponse<Genre> response = genreService.getGenreById(id);
        return response;
    }
    @GetMapping("getgenrebyname")
    public ServiceResponse<Genre> getGenreByName(String name){
        if(name.isBlank()){
            ServiceResponse<Genre> response = genreService.getGenreByName(name.trim());
            return response;
        }
        return new ServiceResponse<>(null,false,"Invalid Request",400);
    }
    @DeleteMapping("deletegenrebyid")
    public ServiceResponse<String> deleteGenreById(int id){
        ServiceResponse<String> response = genreService.deleteGenreById(id);
        return response;
    }
}
