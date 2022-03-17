package com.workshopreactividad.clientewebflux.service;

import com.workshopreactividad.clientewebflux.model.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface MovieBlockingService
{
	Flux<Movie> findAll();
	
	Mono<Movie> findById(Integer id);
 
    Mono<Movie> create(Movie e);
 
    Mono<Movie> update(Movie e);
 
    Mono<Void> delete(Integer id);
}