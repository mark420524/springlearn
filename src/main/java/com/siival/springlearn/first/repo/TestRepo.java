package com.siival.springlearn.first.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siival.springlearn.first.data.TestId;

/**
 * @time 2023年1月30日下午4:06:49
 * @author mark acrossxwall@gmail.com
 * @className TestFirstRepo
 */
@Repository
public interface TestRepo extends JpaRepository<TestId, Integer>  {
	
}
