package com.siival.springlearn.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
	@Autowired
	private  PlatformTransactionManager transactionManager;
	@Autowired
	private TransactionTemplate transactionTemplate;
	
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
	
	public TestFirst transactionCode(Integer id ) {
		TransactionStatus  status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			TestFirst first = new TestFirst();
			first.setName("first" + id);
			firstRepo.save(first);
			if (id>100) {
				throw new Exception("抛异常");
			}
			transactionManager.commit(status);
			return first;
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return null;
		
	}
	
	public TestFirst transactionTemplate(Integer id ) {
		final TestFirst first = new TestFirst();
		first.setName("first" + id);
		
		TestFirst s = transactionTemplate.execute(new TransactionCallback<TestFirst>() {

			@Override
			public TestFirst doInTransaction(TransactionStatus status) {
				try {
					firstRepo.save(first);
					if (id>100) {
						throw new Exception("抛异常");
					}
					return first;
				}catch(Exception e) {
					status.setRollbackOnly();
					return null;
				}
			}
			
		});
		return s;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public TestFirst saveFirstById(Integer id) throws Exception {
		TestFirst first = new TestFirst();
		first.setName("first" + id);
		firstRepo.save(first);
		if (id>100) {
			throw new Exception("异常抛出");
		}
		return first;
	}
}
