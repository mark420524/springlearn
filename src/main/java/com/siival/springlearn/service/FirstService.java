package com.siival.springlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @time 2023年4月3日下午5:01:40
 * @author mark acrossxwall@gmail.com
 * @className FirstService
 */
@Service
public class FirstService {
//	@Autowired
//	private SecondService secondService;
	
	
	public FirstService(SecondService firstService) {
		
	}

}
