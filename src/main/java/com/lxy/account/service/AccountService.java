/**
 * 
 */
package com.lxy.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.account.entity.KeepDaliyFlowEntity;
import com.lxy.account.entity.UserInfoEntity;
import com.lxy.account.mapper.KeepDaliyFlowMapper;
import com.lxy.account.request.AccountRequest;
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
	
	

}
