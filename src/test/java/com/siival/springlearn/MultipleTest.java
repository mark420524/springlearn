package com.siival.springlearn;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.siival.springlearn.config.transaction.TransactionConstant;
import com.siival.springlearn.first.data.TestFirst;
import com.siival.springlearn.first.repo.TestFirstRepo;
import com.siival.springlearn.first.repo.TestRepo;
import com.siival.springlearn.second.data.TestSecond;
import com.siival.springlearn.second.repo.TestSecondRepo;
import com.siival.springlearn.first.data.TestId;
/**
 * @time 2023年1月30日下午4:18:44
 * @author mark acrossxwall@gmail.com
 * @className MultipleTest
 */
@SpringBootTest
public class MultipleTest {

	@Autowired
	private TestFirstRepo firstRepo;
	@Autowired
	private TestSecondRepo secondRepo;
	@Autowired
	private TestRepo testRepository;
	
	@Test
	public void testFirst() {
		Integer id = 1;
		Optional<TestFirst> o = firstRepo.findById(id);
		System.out.println(o.isPresent()?o:"null");
	}
	
	@Test
	public void testSecond() {
		Integer id = 1;
		Optional<TestSecond> o = secondRepo.findById(id);
		System.out.println(o.isPresent()?o:"null");
	}
	
	
	@Test
	public void testSaveMultiple() {
		Integer times = 1;
		TestFirst first = new TestFirst();
		first.setName("first"+times);
		firstRepo.save(first);
		TestSecond second = new TestSecond();
		second.setName("second"+times);
		secondRepo.save(second);
		
	}
	@Transactional(transactionManager = TransactionConstant.SECOND_TRANSACTION_MANAGER)
	@Test
	public void testRollback() {
		Integer times = 3;
		TestFirst first = new TestFirst();
		first.setName("first" + times);
		firstRepo.save(first);
		TestSecond second = new TestSecond();
		second.setName("second"+times);
		secondRepo.save(second);
		
		Integer a = 1;
		if (a>0) {
			throw new RuntimeException("抛异常事务回滚");
		}
	}
	
	@Test
    public void testGenerateId() {
        TestId t = new TestId();
        t.setName("test1");
        testRepository.save(t);
    }
}
