package com.siival.springlearn.common;
 
public  class Result {
	private Integer code;
	private String msg;
	private Object result;
	
	public static Result ok(String msg) {
		Result r = new Result();
		r.setCode(0);
		r.setMsg(msg);
		return r;
	}
	
	public static Result error(String msg) {
		Result r = new Result();
		r.setCode(-1);
		r.setMsg(msg);
		return r;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	

}
