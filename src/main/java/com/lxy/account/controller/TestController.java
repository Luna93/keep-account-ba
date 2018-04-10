/**
 * 
 */
package com.lxy.account.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxy.account.entity.KeepDaliyFlowEntity;
import com.lxy.account.entity.TestEntity;
import com.lxy.account.service.TestService;
import com.lxy.account.vo.MonthFlowVo;
import com.lxy.account.vo.MonthListFlowVo;
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
	
	
	public static void main(String[] args) throws InterruptedException {
		
		List<KeepDaliyFlowEntity> entityList = new ArrayList<KeepDaliyFlowEntity>();
		KeepDaliyFlowEntity e1 = new KeepDaliyFlowEntity();
		e1.setUserId(126);
		e1.setAccountTime("2018-04-10");
		e1.setAmount(new BigDecimal(10));
		e1.setRemark("e1");
		e1.setSubType(2);
		e1.setSubTypeName("测试e1");
		e1.setType(1);
		e1.setUpdateTime(new Date());
		e1.setCreateTime(new Date());
		entityList.add(e1);
		int i = 9;
		for (; i > 0; i--) {
			int n = 3;
			if(i/2 ==0){
				n=1;
			}
			for (int j = 0; j < n; j++) {
			//	Thread.sleep(1000);
				KeepDaliyFlowEntity e2 = new KeepDaliyFlowEntity();
				e2.setUserId(126);
				e2.setAccountTime("2018-04-0" + i);
				e2.setAmount(new BigDecimal(10));
				e2.setRemark("e"+i);
				e2.setSubType(2);
				e2.setSubTypeName("测试e"+i);
				e2.setType(1);
				e2.setUpdateTime(new Date());
				e2.setCreateTime(new Date());
				entityList.add(e2);
			}
			
		}
		System.out.println(entityList.size());
		System.out.println(JSON.toJSON(entityList));
		
		MonthListFlowVo monthListFlowVo = new MonthListFlowVo();
		List<MonthFlowVo> monthList = new ArrayList<MonthFlowVo>();
		
		//collect(Collector c)	将流转换为其他形式。接收一个 Collector接口的 实现，用于给Stream中元素做汇总的方法
		entityList.stream()
		.collect(Collectors.groupingBy(KeepDaliyFlowEntity::getAccountTime, Collectors.toList()))
		.forEach((accountTime, entityListByAccountTime) -> {
			MonthFlowVo monthFlowVo = new MonthFlowVo();
			monthFlowVo = entityListByAccountTime.stream()
					.reduce(monthFlowVo, (u,t)->u.sum(t),(u,t)->u);
			
			monthList.add(monthFlowVo);
			
//			BigDecimal monthTotalIncome = monthListFlowVo.getMonthTotalIncome();
//			BigDecimal monthTotalExpend = monthListFlowVo.getMonthTotalExpend();
//			monthListFlowVo.setMonthTotalExpend(monthTotalExpend.add(monthFlowVo.getDayTotalExpend()));
//			monthListFlowVo.setMonthTotalIncome(monthTotalIncome.add(monthFlowVo.getDayTotalIncome()));
			
		});
//		monthListFlowVo.setSelectMonth("2018-04");
		
		monthList.stream()
		.collect(Collectors.groupingBy(MonthFlowVo::getSelectDay, Collectors.toList()))
		.forEach((selectDay,monthListBySelectDay) -> {
			monthListBySelectDay.stream()
			.reduce(monthListFlowVo, (u,t)->u.sum(t),(u,t)->u);
			
		});
		monthListFlowVo.setMonthList(monthList);
		
		System.out.println(JSON.toJSON(monthListFlowVo));
		

		
		
		
		
	}

}
