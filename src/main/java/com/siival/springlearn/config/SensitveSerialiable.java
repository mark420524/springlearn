package com.siival.springlearn.config;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.siival.springlearn.enums.Sensitive;
import com.siival.springlearn.enums.SensitiveStragtey;

public class SensitveSerialiable extends JsonSerializer<String> implements ContextualSerializer {

	private SensitiveStragtey strategy;
	
	@Override
	public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
			throws JsonMappingException {
		Sensitive s = property.getAnnotation(Sensitive.class);
		if (s!=null && String.class == property.getType().getTypeName().getClass()) {
			this.strategy = s.stragety();
			return this;
		}
		return prov.findValueSerializer(property.getType(), property);
	}

	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(strategy.getDesensitive().apply(value));
		
	}

}
