package com.siival.springlearn.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
@Component
public class MessageUtil {

	@Autowired
	private MessageSource messageSource;
	
	public String getValueByKey(String key) {
		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}
}
