package com.lxy.account.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 列表查询条件
 * @author liuxingyue
 *
 */
public class AccountListRequest {
	
	@NotNull(message = "用户id不能为空")
	private Integer userId;
	
	@NotBlank(message = "日期不能为空")
	private String selectDay;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSelectDay() {
		return selectDay;
	}

	public void setSelectDay(String selectDay) {
		this.selectDay = selectDay;
	}
	
	

}
