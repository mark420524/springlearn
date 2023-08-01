package com.siival.springlearn.config;


//@Component
public class MyConfigTree {

	public String getDmname() {
		return dmname;
	}
	public void setDmname(String dmname) {
		this.dmname = dmname;
	}
	public String getMqname() {
		return mqname;
	}
	public void setMqname(String mqname) {
		this.mqname = mqname;
	}
//	@Value("${db.name}")
	private String dmname;
//	@Value("${mq.name}")
	private String mqname;
}
