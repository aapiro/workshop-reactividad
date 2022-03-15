package com.workshopreactividad.clientewebflux.controller;

import com.workshopreactividad.clientewebflux.model.Movie;
import com.workshopreactividad.clientewebflux.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController 
{
    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    //using Flux for collection of movies
    public Flux<Movie> findAll() {
    	return movieServiceImpl.findAll();
    }

    @GetMapping(value = "/{id}")
    //using Mono for single movie
    public Mono<Movie> findById(@PathVariable("id") Integer id) {
        return movieServiceImpl.findById(id);
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //using Mono for single movie
    public Mono<Movie> create(@RequestBody Movie e) {
    	return movieServiceImpl.create(e);
    }
 
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    //using Mono for single movie
    public Mono<Movie> update(@RequestBody Movie e, @PathVariable("id") Integer id) {
    	e.setId(id);
        return movieServiceImpl.update(e);
    }
 
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    // using Mono<Void> when no response content is expected
    public Mono<Void> delete(@PathVariable("id") Integer id) {
    	return movieServiceImpl.delete(id);
    }
}
