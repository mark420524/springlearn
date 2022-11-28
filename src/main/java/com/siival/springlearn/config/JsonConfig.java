package com.siival.springlearn.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class JsonConfig {

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer getCustomerBuilder() {
		return builder ->{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(formatter);
			LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(formatter);
			builder.serializerByType(LocalDateTime.class, serializer);
			builder.deserializerByType(LocalDateTime.class, deserializer);
			
		};
	}
}
