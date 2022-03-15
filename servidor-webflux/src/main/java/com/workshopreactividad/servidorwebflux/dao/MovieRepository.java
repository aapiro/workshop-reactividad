package com.workshopreactividad.servidorwebflux.dao;

import com.workshopreactividad.servidorwebflux.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, Integer> {
}