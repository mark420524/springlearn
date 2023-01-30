package com.siival.springlearn.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.siival.springlearn.config.transaction.MultipleTransaction;
import com.siival.springlearn.first.data.TestFirst;
import com.siival.springlearn.first.repo.TestFirstRepo;
import com.siival.springlearn.model.Person;
import com.siival.springlearn.second.data.TestSecond;
import com.siival.springlearn.second.repo.TestSecondRepo;

@Service
@CacheConfig(cacheNames = "person")
public class PersonService {
	
	@Autowired
	private TestFirstRepo firstRepo;
	@Autowired
	private TestSecondRepo secondRepo;
	
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
	
	@MultipleTransaction(value = {"firstTransactionManager","secondTransactionManager"})
	public void rollback(Integer times ) {
		TestFirst first = new TestFirst();
		first.setName("first" + times);
		firstRepo.save(first);
		TestSecond second = new TestSecond();
		second.setName("second"+times);
		secondRepo.save(second);
		
		Integer a = 0;
		if (a>0) {
			throw new RuntimeException("抛异常事务回滚");
		}
	}
}
