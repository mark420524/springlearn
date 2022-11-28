package com.siival.springlearn.mixins;

import org.springframework.boot.jackson.JsonMixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.siival.springlearn.model.Person;

@JsonMixin(Person.class)
public class PersonMixins {

	@JsonProperty("firstName2")
	String name;
}
