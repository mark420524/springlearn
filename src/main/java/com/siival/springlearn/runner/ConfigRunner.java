package com.siival.springlearn.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.siival.springlearn.config.DurationConfig;
import com.siival.springlearn.config.MyBean;
import com.siival.springlearn.config.MyConfigTree;
import com.siival.springlearn.config.MyProperties;
@Component
public class ConfigRunner implements ApplicationRunner {

	@Autowired
	private MyBean myBean;
	
//	@Autowired
	private MyConfigTree configTree;
	@Autowired
	private MyProperties properties;
	@Autowired
	private DurationConfig durationConfig;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("mybean-name:"+myBean.getName());
//		System.out.println("config tree" + configTree.getDmname()+",mqname" + configTree.getMqname());
		System.out.println("properties:"+properties);
		System.out.println("类型自动转换:"+durationConfig.getSessionTimeout());
		System.out.println("类型校验:"+durationConfig.getNumber());

	}

}
