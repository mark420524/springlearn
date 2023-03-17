package com.siival.springlearn.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @time 2023年3月16日下午7:08:05
 * @author mark acrossxwall@gmail.com
 * @className MongoService
 */
@Service
public class MongoService {
	@Autowired
	private   MongoTemplate mongoTemplate;

	public Set<String> findAll() {
		Set<String> set = mongoTemplate.getCollectionNames();
		return set;
	}
     
}
