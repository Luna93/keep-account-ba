package com.lxy.account.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class AccountRequest {

    /** 用户id*/
	@NotNull(message = "用户id不能为空")
    private Integer userId;

    /** 类型：1收入 2支出*/
	@NotNull(message = "类型不能为空")
    private Integer type;

    /** 子类型*/
	@NotNull(message = "子类型不能为空")
    private Integer subType;

    /** 子类型备注*/
	@NotBlank(message = "子类型备注不能为空")
    private String subTypeName;

    /** 金额*/
	@NotNull(message = "金额不能为空")
    private BigDecimal amount;

    /** 备注*/
	@Length(max=255, message="备注过长")
    private String remark;

    /** 消费时间:YYYY-MM-dd*/
	@NotBlank(message = "消费时间不能为空")
	@Length(max=10, message="消费时间过长")
    private String accountTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.subTypeName = subTypeName == null ? null : subTypeName.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(String accountTime) {
        this.accountTime = accountTime == null ? null : accountTime.trim();
    }
}