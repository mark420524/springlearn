package com.siival.springlearn.res;
/**
 * @time 2023年6月14日15:17:01
 * @author mark acrossxwall@gmail.com
 * @className BaseResp
 */
public class BaseResp<T> {
	
	private Integer code;
	private String message;
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
