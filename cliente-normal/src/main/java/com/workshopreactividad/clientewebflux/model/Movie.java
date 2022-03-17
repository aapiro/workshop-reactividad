package com.workshopreactividad.clientewebflux.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Movie implements Serializable{

	int id;
    String name;
    String company;
    String description;
}
