package com.workshopreactividad.servidorwebflux.service;

import com.workshopreactividad.servidorwebflux.dao.MovieRepository;
import com.workshopreactividad.servidorwebflux.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieServiceInterface {

    private MovieRepository movieRepo;

    public void createMovie(Movie movie) {
        movieRepo.save(movie).subscribe();
    }

    public Mono<Movie> findByMovieId(Integer id) {
        return movieRepo.findById(id);
    }

    public Flux<Movie> findAllMovies() {
        return movieRepo.findAll();
    }

    public Mono<Movie> updateMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    public Mono<Void> deleteMovie(Integer id) {
        return movieRepo.deleteById(id);
    }
}