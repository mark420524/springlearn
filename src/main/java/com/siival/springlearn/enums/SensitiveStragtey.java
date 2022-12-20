package com.siival.springlearn.enums;

import java.util.function.Function;

public enum SensitiveStragtey {

	MOBILE (s-> s.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2") ) 
	;
	
	
	Function<String,String> desensitive;
	
	
	SensitiveStragtey(  Function<String,String> desensitive ){
		this.desensitive = desensitive;
	}


	public Function<String, String> getDesensitive() {
		return desensitive;
	}
	
}
