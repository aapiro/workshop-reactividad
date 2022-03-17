package com.workshopreactividad.servidorblocking.service;

import com.workshopreactividad.servidorblocking.model.Movie;

import java.util.List;

public interface MovieBlockingService {

    void createMovie(Movie e);

    List<Movie> findAllMovies();
}
