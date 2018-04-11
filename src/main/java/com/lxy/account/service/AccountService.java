/**
 * 
 */
package com.lxy.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.account.entity.KeepDaliyFlowEntity;
import com.lxy.account.entity.UserInfoEntity;
import com.lxy.account.mapper.KeepDaliyFlowMapper;
import com.lxy.account.request.AccountListRequest;
import com.lxy.account.request.AccountRequest;
import com.lxy.account.vo.DayFlowVo;
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
		System.out.println(accountTimeStart);
		System.out.println(accountTimeEnd);
		List<KeepDaliyFlowEntity> daliyFlowEntities = keepDaliyFlowMapper.selectByDate(request.getUserId(), accountTimeStart, accountTimeEnd);
		MonthListFlowVo monthListFlowVo = new MonthListFlowVo();
		List<MonthFlowVo> flowVos = new ArrayList<>();
		List<DayFlowVo> dayList = new ArrayList<>();
		DayFlowVo dayFlowVo = new DayFlowVo();
		
		return null;
		
	}
	

}
