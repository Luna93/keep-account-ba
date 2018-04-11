/**
 * 
 */
package com.lxy.account.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.account.constants.OmsConstants;
import com.lxy.account.entity.KeepDaliyFlowEntity;
import com.lxy.account.entity.UserInfoEntity;
import com.lxy.account.mapper.KeepDaliyFlowMapper;
import com.lxy.account.request.AccountListRequest;
import com.lxy.account.request.AccountRequest;
import com.lxy.account.vo.MonthFlowVo;
import com.lxy.account.vo.MonthListFlowVo;
import com.lxy.account.vo.Result;

/**
 *
 * @author liuxingyue
 * @date 2018-04-09
 */
@Service
public class AccountService {
	
	@Autowired
	private KeepDaliyFlowMapper keepDaliyFlowMapper;

	@Autowired
	private LoginService loginService;
	
	public Result save(AccountRequest request){
		Integer userId = request.getUserId();
		UserInfoEntity userInfoEntity = loginService.selectById(userId);
		if(null == userInfoEntity){
			return Result.error("用户不存在");
		}
		KeepDaliyFlowEntity record = new KeepDaliyFlowEntity();
		record.setAccountTime(request.getAccountTime());
		record.setAmount(request.getAmount());
		record.setRemark(request.getRemark());
		record.setSubType(request.getSubType());
		record.setSubTypeName(request.getSubTypeName());
		record.setType(request.getType());
		record.setUserId(userId);
		keepDaliyFlowMapper.insert(record);
		return Result.ok();
	}
	
	public Result list(AccountListRequest request){
		String accountTimeStart = request.getSelectDay() + "-01";
		String accountTimeEnd = request.getSelectDay() + "-31";
		List<KeepDaliyFlowEntity> daliyFlowEntities = keepDaliyFlowMapper.selectByDate(request.getUserId(), accountTimeStart, accountTimeEnd);
		
//		System.out.println(JSON.toJSON(daliyFlowEntities));

		MonthListFlowVo monthListFlowVo = new MonthListFlowVo();
		List<MonthFlowVo> flowVos = new ArrayList<>();
		//collect(Collector c)	将流转换为其他形式。接收一个 Collector接口的 实现，用于给Stream中元素做汇总的方法
		Map<String, List<KeepDaliyFlowEntity>> map = daliyFlowEntities.stream()
		.collect(Collectors.groupingBy(KeepDaliyFlowEntity::getAccountTime, Collectors.toList()));
		
		//map = {2016-09-01=[com.lxy.account.entity.KeepDaliyFlowEntity@404e933b, com.lxy.account.entity.KeepDaliyFlowEntity@72d60d5a, com.lxy.account.entity.KeepDaliyFlowEntity@2b84c8eb], 2016-09-02=[com.lxy.account.entity.KeepDaliyFlowEntity@180be207, com.lxy.account.entity.KeepDaliyFlowEntity@2c686d76], 2016-09-03=[com.lxy.account.entity.KeepDaliyFlowEntity@6e96097c, com.lxy.account.entity.KeepDaliyFlowEntity@635857d5], 2016-09-04=[com.lxy.account.entity.KeepDaliyFlowEntity@24849a63, com.lxy.account.entity.KeepDaliyFlowEntity@4be85058]}
		//按key排序
		Map<String, List<KeepDaliyFlowEntity>> daliyfowMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.<String, List<KeepDaliyFlowEntity>>comparingByKey().reversed())
		.forEachOrdered(x->daliyfowMap.put(x.getKey(),x.getValue()));
		//daliyfowMap = {2016-09-04=[com.lxy.account.entity.KeepDaliyFlowEntity@4e867f2f, com.lxy.account.entity.KeepDaliyFlowEntity@57671947], 2016-09-03=[com.lxy.account.entity.KeepDaliyFlowEntity@3b4a2ba0, com.lxy.account.entity.KeepDaliyFlowEntity@1c4c8667], 2016-09-02=[com.lxy.account.entity.KeepDaliyFlowEntity@61cefdc6, com.lxy.account.entity.KeepDaliyFlowEntity@e8c6d99], 2016-09-01=[com.lxy.account.entity.KeepDaliyFlowEntity@64f150c3, com.lxy.account.entity.KeepDaliyFlowEntity@1cf69d84, com.lxy.account.entity.KeepDaliyFlowEntity@a407311]}
		
		daliyfowMap.forEach((accountTime, entityListByAccountTime) -> {
			MonthFlowVo monthFlowVo = new MonthFlowVo();
			monthFlowVo = entityListByAccountTime.stream()
					.reduce(monthFlowVo, (u,t)->u.sum(t),(u,t)->u);
			flowVos.add(monthFlowVo);
		});
		
		flowVos.stream()
		.collect(Collectors.groupingBy(MonthFlowVo::getSelectDay, Collectors.toList()))
		.forEach((selectDay,monthListBySelectDay) -> {
			monthListBySelectDay.stream()
			.reduce(monthListFlowVo, (u,t)->u.sum(t),(u,t)->u);
			
		});
		
		monthListFlowVo.setMonthList(flowVos);
		monthListFlowVo.setSelectMonth(request.getSelectDay());
		
		return Result.ok().put(OmsConstants.DATA_RESP, monthListFlowVo);
		
	}
	

}
