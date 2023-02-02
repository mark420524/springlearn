package com.siival.springlearn.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.siival.springlearn.common.Result;

/**
 * @time 2023年2月2日下午4:44:56
 * @author mark acrossxwall@gmail.com
 * @className GlobalExceptionController
 */
@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CustomerException.class) 
	public Result handlerCustomerException(CustomerException e ) {
		return Result.error(e.getMessage());
	}
}
