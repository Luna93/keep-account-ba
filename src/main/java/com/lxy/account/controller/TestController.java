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
import com.lxy.account.vo.Result;

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
	public Result test(String code){
		LOG.info("code="+code);
//		TestEntity e = testService.select();
//		System.out.println(JSON.toJSON(e));
		LOG.error("22");
		return Result.ok().put("userId", "666").put("openId", "222");
	}

}
