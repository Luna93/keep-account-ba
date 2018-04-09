package com.lxy.account.vo;

import java.math.BigDecimal;
import java.util.List;

public class MonthListFlowVo {
	/**
	 * 月
	 */
	private String selectMonth;

	/**
	 * 当月总收入
	 */
	private BigDecimal monthTotalIncome;

	/**
	 * 当月总支出
	 */
	private BigDecimal monthTotalExpend;
	
	private List<MonthFlowVo> monthList;

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
