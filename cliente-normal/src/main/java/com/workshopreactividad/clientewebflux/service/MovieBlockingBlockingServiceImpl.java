package com.workshopreactividad.clientewebflux.service;

import com.workshopreactividad.clientewebflux.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class MovieBlockingBlockingServiceImpl implements MovieBlockingService
{
	@Autowired
	WebClient webClient;
	
	public Flux<Movie> findAll()

	{
		return webClient.get()
			.uri("/get/all")
			.retrieve()
			.bodyToFlux(Movie.class)
			.timeout(Duration.ofMillis(10_000));
	}

	public Mono<Movie> create(Movie empl)
	{
		return webClient.post()
				.uri("/create/emp")
				.body(Mono.just(empl), Movie.class)
				.retrieve()
				.bodyToMono(Movie.class)
				.timeout(Duration.ofMillis(10_000));
	}

	public Mono<Movie> findById(Integer id)
	{
		return webClient.get()
				.uri("/get/" + id)
				.retrieve()
				.bodyToMono(Movie.class);
	}

	public Mono<Movie> update(Movie e)
	{
		return webClient.put()
				.uri("/update/emp/" + e.getId())
				.body(Mono.just(e), Movie.class)
				.retrieve()
				.bodyToMono(Movie.class);
	}

	public Mono<Void> delete(Integer id) 
	{
		return webClient.delete()
				.uri("/delete/" +id)
				.retrieve()
				.bodyToMono(Void.class);
	}

}