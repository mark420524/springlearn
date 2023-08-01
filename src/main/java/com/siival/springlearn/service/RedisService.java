package com.siival.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siival.springlearn.util.RedisUtils;

/**
 * @time 2023年6月14日10:31:33
 * @author mark acrossxwall@gmail.com
 * @className RedisService
 */
@Service
public class RedisService {
	
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Transactional
	public long incrementByKey(String key) {
		return redisUtils.addIncrement(key);
	}

	@SuppressWarnings({"rawtypes","unchecked"})
	public void redisTransaction() {
		List<Object> list = redisTemplate.execute(new  SessionCallback<List<Object>>() {

			
			@Override
			public  List<Object> execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				operations.opsForValue().set("a", "1");
				operations.opsForValue().set("b", "1");
				return operations.exec();
			}
		});
		System.out.println(list);
	}
}
