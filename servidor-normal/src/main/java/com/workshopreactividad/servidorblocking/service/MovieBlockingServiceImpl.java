package com.workshopreactividad.servidorblocking.service;

import com.workshopreactividad.servidorblocking.dao.MovieBlockingRepository;
import com.workshopreactividad.servidorblocking.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieBlockingServiceImpl implements MovieBlockingService {

    private MovieBlockingRepository repository;

    @Override
    public void createMovie(Movie e) {
        repository.save(e);
    }

    @Override
    public List<Movie> findAllMovies() {
        return repository.findAll();
    }
}
