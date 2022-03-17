package com.workshopreactividad.clientewebflux.service;

import com.workshopreactividad.clientewebflux.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieBlockingBlockingServiceImpl implements MovieBlockingService {

    @Autowired
    RestTemplate restTemplate;

    final String PATH_URI = "http://localhost:8080/get/all";

    public List<Movie> findAll() {
        return Arrays.asList(restTemplate.getForEntity(PATH_URI, Movie[].class).getBody());
    }

    @Override
    public Movie findById(Integer id) {
        return null;
    }

    public HttpStatus create(Movie movie) {
        return restTemplate.postForEntity(PATH_URI,movie, HttpStatus.class).getBody();
    }

    @Override
    public Movie update(Movie e) {
        return null;
    }

    @Override
    public Void delete(Integer id) {
        return null;
    }

}