package com.lxy.account.vo;

import java.math.BigDecimal;
/**
 * 当日明细
 * @author liuxingyue
 *
 */
public class DayFlowVo {
	/** 类型：1收入 2支出*/
    private Integer type;

    /** 子类型*/
    private Integer subType;

    /** 子类型备注*/
    private String subTypeName;

    /** 金额*/
    private BigDecimal amount = new BigDecimal(0);

    /** 备注*/
    private String remark;
    

	public DayFlowVo() {
		super();
	}

	public DayFlowVo(Integer type, Integer subType, String subTypeName,
			BigDecimal amount, String remark) {
		super();
		this.type = type;
		this.subType = subType;
		this.subTypeName = subTypeName;
		this.amount = amount;
		this.remark = remark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSubType() {
		return subType;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
