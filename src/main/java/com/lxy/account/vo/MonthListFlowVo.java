package com.lxy.account.vo;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

public class MonthListFlowVo {
	/**
	 * 月
	 */
	private String selectMonth;

	/**
	 * 当月总收入
	 */
	private BigDecimal monthTotalIncome = new BigDecimal(0);

	/**
	 * 当月总支出
	 */
	private BigDecimal monthTotalExpend = new BigDecimal(0);
	
	private List<MonthFlowVo> monthList = Lists.newArrayList();
	
	public MonthListFlowVo sum(MonthFlowVo monthFlowVo){
		this.monthTotalExpend = this.monthTotalExpend.add(monthFlowVo.getDayTotalExpend());
		this.monthTotalIncome = this.monthTotalIncome.add(monthFlowVo.getDayTotalIncome());
		return this;
	}
	

	public String getSelectMonth() {
		return selectMonth;
	}

	public void setSelectMonth(String selectMonth) {
		this.selectMonth = selectMonth;
	}

	public BigDecimal getMonthTotalIncome() {
		return monthTotalIncome;
	}

	public void setMonthTotalIncome(BigDecimal monthTotalIncome) {
		this.monthTotalIncome = monthTotalIncome;
	}

	public BigDecimal getMonthTotalExpend() {
		return monthTotalExpend;
	}

	public void setMonthTotalExpend(BigDecimal monthTotalExpend) {
		this.monthTotalExpend = monthTotalExpend;
	}

	public List<MonthFlowVo> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<MonthFlowVo> monthList) {
		this.monthList = monthList;
	}
	
}
