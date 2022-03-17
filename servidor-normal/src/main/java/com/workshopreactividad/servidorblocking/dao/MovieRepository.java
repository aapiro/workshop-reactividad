package com.workshopreactividad.servidorblocking.dao;

import com.workshopreactividad.servidorblocking.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
}