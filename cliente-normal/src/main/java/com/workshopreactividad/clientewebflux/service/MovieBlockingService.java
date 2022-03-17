package com.workshopreactividad.clientewebflux.service;

import com.workshopreactividad.clientewebflux.model.Movie;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface MovieBlockingService
{
	List<Movie> findAll();
	
	Movie findById(Integer id);
 
    HttpStatus create(Movie e);
 
    Movie update(Movie e);
 
    Void delete(Integer id);
}