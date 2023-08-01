package com.siival.springlearn.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @time 2023年4月3日下午5:02:06
 * @author mark acrossxwall@gmail.com
 * @className SecondService
 */
@Service
public class SecondService {
	
	
//	@Autowired
//	private FirstService firstService;
	
	@Lazy
	public SecondService(FirstService firstService) {
		
	}
}
