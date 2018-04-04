package com.lxy.account.entity;

import java.math.BigDecimal;

public class TestEntity {
	/** 主键id*/
    private Integer id;
    /** 课程名*/
    private String orderNo;
    /** 用户id*/
    private Integer userId;

    /** 1:体验 2:赠送 3:套餐*/
    private Byte type;

    /** 1:购买课 2:换课 3:退费*/
    private Boolean leftBit;

    /** 订单id*/
    private Integer orderId;

    /** 当前商品乐器id， 1：钢琴， 2：小提琴， 3：手风琴， 4：古筝*/
    private Byte instrumentId;

    /** 1:25分钟 2:45分钟 3:50分钟*/
    private Integer timeType;

    /** 课程名*/
    private String name;

    /** 课程单价*/
    private BigDecimal price;

    /** 总数量*/
    private Integer totalAmount;
    
    /**0未删除 1已删除*/
    private Integer isDelete;

    /**
	 * @return the isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Boolean getLeftBit() {
        return leftBit;
    }

    public void setLeftBit(Boolean leftBit) {
        this.leftBit = leftBit;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Byte getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Byte instrumentId) {
        this.instrumentId = instrumentId;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}