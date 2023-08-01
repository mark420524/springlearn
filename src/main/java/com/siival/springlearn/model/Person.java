package com.siival.springlearn.model;


import java.time.LocalDateTime;


import com.siival.springlearn.enums.Sensitive;
import com.siival.springlearn.enums.SensitiveStragtey;
public class Person {
	
	
	private Integer id;
//	@JsonProperty("firstName")
	private String name;
	private LocalDateTime createTime;
//	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime updateTime;
	@Sensitive(stragety = SensitiveStragtey.MOBILE)
	private String mobile;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public Person() {
		super();
	}
	

}
