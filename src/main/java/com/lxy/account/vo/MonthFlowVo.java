package com.lxy.account.vo;

import java.math.BigDecimal;
import java.util.List;

public class MonthFlowVo {

	/**
	 * 日
	 */
	private String selectDay;
	
	/**
	 * 周
	 */
	private String selectWeek;
	
	/**
	 * 当日总收入
	 */
	private BigDecimal dayTotalIncome;

	/**
	 * 当日总支出
	 */
	private BigDecimal dayTotalExpend;
	
	/**
	 * 当日花费列表
	 */
	private List<DayFlowVo> dayList;

	public String getSelectDay() {
		return selectDay;
	}

	public void setSelectDay(String selectDay) {
		this.selectDay = selectDay;
	}

	public String getSelectWeek() {
		return selectWeek;
	}

	public void setSelectWeek(String selectWeek) {
		this.selectWeek = selectWeek;
	}

	public BigDecimal getDayTotalIncome() {
		return dayTotalIncome;
	}

	public void setDayTotalIncome(BigDecimal dayTotalIncome) {
		this.dayTotalIncome = dayTotalIncome;
	}

	public BigDecimal getDayTotalExpend() {
		return dayTotalExpend;
	}

	public void setDayTotalExpend(BigDecimal dayTotalExpend) {
		this.dayTotalExpend = dayTotalExpend;
	}

	public List<DayFlowVo> getDayList() {
		return dayList;
	}

	public void setDayList(List<DayFlowVo> dayList) {
		this.dayList = dayList;
	}
	
	
	
	

}
