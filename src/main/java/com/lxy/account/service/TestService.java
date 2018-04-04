/**
 * 
 */
package com.lxy.account.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxy.account.entity.TestEntity;
import com.lxy.account.mapper.TestMapper;

/**
 *
 * @author liuxingyue
 * @date 2018-04-04
 */
@Service
public class TestService {
	@Resource
	private TestMapper testMapper;
	
	public TestEntity select(){
		return testMapper.select();
	}

}
