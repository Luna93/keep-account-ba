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
    
    private String createTime;
    
    private String updateTime;
    
	public DayFlowVo() {
		super();
	}

	/**
	 * @param type
	 * @param subType
	 * @param subTypeName
	 * @param amount
	 * @param remark
	 * @param createTime
	 * @param updateTime
	 */
	public DayFlowVo(Integer type, Integer subType, String subTypeName, BigDecimal amount, String remark,
			String createTime, String updateTime) {
		super();
		this.type = type;
		this.subType = subType;
		this.subTypeName = subTypeName;
		this.amount = amount;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}




	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
