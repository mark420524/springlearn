package com.siival.springlearn.service;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.siival.springlearn.model.Person;

@Service
@CacheConfig(cacheNames = "person")
public class PersonService {
	
//	@CacheEvict 清空缓存
	@Cacheable(key = "'id:' + #p0")
	public Person getPerson(Integer id) {
		System.out.println("执行了");
		Person p = new Person();
		p.setId(id);
		p.setName("张三");
		p.setCreateTime(LocalDateTime.now());
		p.setUpdateTime(LocalDateTime.now());
		p.setMobile("12331231234");
		return p;
	}
}
