package com.workshopreactividad.servidorwebflux.service;

import com.workshopreactividad.servidorwebflux.model.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface MovieServiceInterface
{
    void createMovie(Movie e);
     
    Mono<Movie> findByMovieId(Integer id);
 
    Flux<Movie> findAllMovies();
 
    Mono<Movie> updateMovie(Movie e);
 
    Mono<Void> deleteMovie(Integer id);
}