/**
 * 
 */
package com.lxy.account.request;


import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author liuxingyue
 * @date 2018-04-08
 */
public class UserInfoRequest {
	 /**
     * 用户登录凭证
     */
    @NotBlank(message = "jsCode不能为空")
    private String jsCode ="";

    /**
     * 微信公众号用户加密的用户数据
     */
    @NotBlank(message = "encrypteData不能为空")
    private String encrypteData;

    /**
     * 加密字符串
     */
    @NotBlank(message = "ivStr不能为空")
    private String ivStr;

	/**
	 * @return the jsCode
	 */
	public String getJsCode() {
		return jsCode;
	}

	/**
	 * @param jsCode the jsCode to set
	 */
	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}

	/**
	 * @return the encrypteData
	 */
	public String getEncrypteData() {
		return encrypteData;
	}

	/**
	 * @param encrypteData the encrypteData to set
	 */
	public void setEncrypteData(String encrypteData) {
		this.encrypteData = encrypteData;
	}

	/**
	 * @return the ivStr
	 */
	public String getIvStr() {
		return ivStr;
	}

	/**
	 * @param ivStr the ivStr to set
	 */
	public void setIvStr(String ivStr) {
		this.ivStr = ivStr;
	}
    
    

}
