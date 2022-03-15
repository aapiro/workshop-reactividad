package com.workshopreactividad.clientewebflux.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer
{  
	Logger logger = LoggerFactory.getLogger(WebFluxConfig.class);
	
	@Bean
	public WebClient getWebClient()	{

		HttpClient httpClient = HttpClient.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
				.responseTimeout(Duration.ofMillis(10000))
				.doOnConnected(conn ->
						conn.addHandlerLast(new ReadTimeoutHandler(10000, TimeUnit.MILLISECONDS))
								.addHandlerLast(new WriteTimeoutHandler(10000, TimeUnit.MILLISECONDS)));

		return WebClient.builder()
				.baseUrl("http://localhost:8080")
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.build();
	}
}