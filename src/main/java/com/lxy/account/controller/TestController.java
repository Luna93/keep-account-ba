/**
 * 
 */
package com.lxy.account.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxy.account.entity.TestEntity;
import com.lxy.account.service.TestService;

/**
 *
 * @author liuxingyue
 * @date 2018-04-04
 */
@RestController
public class TestController {
	
	private Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@Resource
	private TestService testService;
	
	@RequestMapping("/test")
	public void test(){
		LOG.info("111");
		TestEntity e = testService.select();
		System.out.println(JSON.toJSON(e));
		LOG.error("22");
	}

}
