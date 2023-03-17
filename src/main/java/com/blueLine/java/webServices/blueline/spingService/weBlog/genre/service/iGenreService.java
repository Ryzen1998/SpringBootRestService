package com.blueLine.java.webServices.blueline.spingService.weBlog.genre.service;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.model.Genre;

import java.util.List;

public interface iGenreService {
    ServiceResponse<String> addGenre(String name);
    ServiceResponse<List<Genre>> getAllGenre();
    ServiceResponse<Genre> getGenreById(int id);
    ServiceResponse<Genre> getGenreByName(String name);
    ServiceResponse<String> deleteGenreById(int id);

}
