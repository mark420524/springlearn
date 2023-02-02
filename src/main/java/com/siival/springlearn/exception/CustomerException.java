package com.siival.springlearn.exception;
/**
 * @time 2023年2月2日下午4:46:05
 * @author mark acrossxwall@gmail.com
 * @className CustomerException
 */
public class CustomerException extends RuntimeException {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7569448169005091795L;

	public CustomerException(String msg) {
		super(msg);
	}
 
}
