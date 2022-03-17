package com.workshopreactividad.servidorblocking.controller;

import com.workshopreactividad.servidorblocking.model.Movie;
import com.workshopreactividad.servidorblocking.service.MovieBlockingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MovieController {

    private MovieBlockingServiceImpl movieServiceImpl;

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Movie> findAll() {
        return movieServiceImpl.findAllMovies();
    }

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

}
