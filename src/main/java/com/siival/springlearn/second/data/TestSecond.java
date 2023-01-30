package com.siival.springlearn.second.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @time 2023年1月30日下午4:04:05
 * @author mark acrossxwall@gmail.com
 * @className TestSecond
 */
@Entity
@Table(name="test_second")
public class TestSecond {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
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
	@Override
	public String toString() {
		return "TestSecond [id=" + id + ", name=" + name + "]";
	}
    
    
}
