package com.lxy.account.vo;

import java.util.HashMap;
import java.util.Map;

import com.lxy.account.constants.OmsConstants;

/**
 * 返回数据
 */
public class Result extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Result() {
		put(OmsConstants.CODE_RESP, 200);
	}
	
	public static Result error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static Result error(String msg) {
		return error(500, msg);
	}
	
	public static Result error(int code, String msg) {
		Result r = new Result();
		r.put(OmsConstants.CODE_RESP, code);
		r.put(OmsConstants.DATA_RESP, "");
		r.put(OmsConstants.MSG_RESP, msg);
		return r;
	}

	public static Result ok(String msg) {
		Result r = new Result();
		r.put(OmsConstants.MSG_RESP, msg);
		return r;
	}
	
	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}
	
	public static Result ok() {
		Result r = new Result();
		r.put(OmsConstants.MSG_RESP, "操作成功");
		r.put(OmsConstants.DATA_RESP, "");
		return r;
	}

	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
