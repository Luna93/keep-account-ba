package com.lxy.account.vo;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.lxy.account.entity.KeepDaliyFlowEntity;
import com.lxy.account.utils.DateUtil;

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
	private BigDecimal dayTotalIncome = new BigDecimal(0);

	/**
	 * 当日总支出
	 */
	private BigDecimal dayTotalExpend = new BigDecimal(0);
	
	/**
	 * 当日花费列表
	 */
	private List<DayFlowVo> dayList = Lists.newArrayList();;
	
	public MonthFlowVo sum(KeepDaliyFlowEntity e) {
		if(1 == e.getType()){
			this.dayTotalIncome = this.dayTotalIncome.add(e.getAmount());
		} else {
			this.dayTotalExpend = this.dayTotalExpend.add(e.getAmount());
		}
		this.dayList.add(new DayFlowVo(e.getType(), e.getSubType()
				, e.getSubTypeName(), e.getAmount(), e.getRemark()));
		String time = e.getAccountTime();
		this.selectDay = time.substring(time.length()-2);
		this.selectWeek = DateUtil.getDayWeek(time);
		return this;
	}

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
