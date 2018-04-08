/**
 * 
 */
package com.lxy.account.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.lxy.account.request.UserInfoRequest;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * 
 * @author liuxingyue
 * @date 2018-04-08
 */
public class LoginService {
	
	@Autowired
	private WxMaService wxMaService;
	
	public void miniappLogin(UserInfoRequest request){
		WxMaJscode2SessionResult sessionResult = new WxMaJscode2SessionResult();
		try {
			sessionResult = wxMaService.getUserService().getSessionInfo(request.getJsCode());
			if(sessionResult != null && StringUtils.isEmpty(sessionResult.getUnionid()) && StringUtils.isEmpty(sessionResult.getSessionKey())){
				 WxMaUserInfo wxMaUserInfo;
				 wxMaUserInfo = this.wxMaService.getUserService().getUserInfo(sessionResult.getSessionKey(),
						 request.getEncrypteData(), request.getIvStr());
	                //设置unionid
	                if(StringUtils.isNotEmpty(wxMaUserInfo.getUnionId())) {
	                	sessionResult.setUnionid(wxMaUserInfo.getUnionId());
	                }else{
	                 //   log.error("[无法通过微信用户数据获取用户unionid]");
	                }
			}
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
