package com.workshopreactividad.servidorwebflux.controller;

import com.workshopreactividad.servidorwebflux.model.Movie;
import com.workshopreactividad.servidorwebflux.service.MovieServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
public class MovieController {

    private MovieServiceImpl movieServiceImpl;

    @PostMapping("/create/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmps(@RequestBody List<Movie> movie) {
        movie.forEach(movieServiceImpl::createMovie);
    }

    @PostMapping("/create/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmp(@RequestBody Movie movie) {
        movieServiceImpl.createMovie(movie);
    }

    @GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Movie> findAll() {
        return movieServiceImpl.findAllMovies();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Mono<Movie>> findMovById(@PathVariable("id") Integer id) {
        Mono<Movie> movie = movieServiceImpl.findByMovieId(id);
        return new ResponseEntity<>(movie, movie != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/emp")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Movie> update(@RequestBody Movie movie) {
        return movieServiceImpl.updateMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        movieServiceImpl.deleteMovie(id).subscribe();
    }

}
