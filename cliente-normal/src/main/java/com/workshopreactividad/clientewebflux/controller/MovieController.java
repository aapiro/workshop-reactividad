package com.workshopreactividad.clientewebflux.controller;

import com.workshopreactividad.clientewebflux.model.Movie;
import com.workshopreactividad.clientewebflux.service.MovieBlockingBlockingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController 
{
    private MovieBlockingBlockingServiceImpl movieBlockingServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    //using  for collection of movies
    public List<Movie> findAll() {
    	return movieBlockingServiceImpl.findAll();
    }

    @GetMapping(value = "/{id}")
    //using Mono for single movie
    public Movie findById(@PathVariable("id") Integer id) {
        return movieBlockingServiceImpl.findById(id);
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //using Mono for single movie
    public HttpStatus create(@RequestBody Movie e) {
    	return movieBlockingServiceImpl.create(e);
    }
 
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    //using Mono for single movie
    public Movie update(@RequestBody Movie e, @PathVariable("id") Integer id) {
    	e.setId(id);
        return movieBlockingServiceImpl.update(e);
    }
 
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    // using Mono<Void> when no response content is expected
    public Void delete(@PathVariable("id") Integer id) {
    	return movieBlockingServiceImpl.delete(id);
    }
}
