/**
 * 
 */
package com.lxy.account.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lxy.account.config.WxMaProperties;
import com.lxy.account.constants.OmsConstants;
import com.lxy.account.entity.UserInfoEntity;
import com.lxy.account.mapper.UserInfoMapper;
import com.lxy.account.request.UserInfoRequest;
import com.lxy.account.vo.Result;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * 
 * @author liuxingyue
 * @date 2018-04-08
 */
@Service
public class LoginService {
	
	private Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private WxMaService wxMaService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private WxMaProperties wxMaProperties;
	
	public UserInfoEntity selectById(Integer userId){
		return userInfoMapper.selectById(userId);
	}
	
	public Result miniappLogin(UserInfoRequest request){
		WxMaJscode2SessionResult sessionResult = new WxMaJscode2SessionResult();
		try {
			sessionResult = wxMaService.getUserService().getSessionInfo(request.getJsCode());
			log.info("获取登录后的session信息: "+JSON.toJSON(sessionResult));
		} catch (WxErrorException e) {
            log.error("【miniAppLogin 调用微信服务失败，错误信息为： " +e.getMessage() +" 】",e );
            return Result.error("当前数据无法获取, 请刷新重试");
       
		}
		if(null == sessionResult || StringUtils.isEmpty(sessionResult.getOpenid()) || StringUtils.isEmpty(sessionResult.getSessionKey())){
			log.error("【miniAppLogin 调用微信服务返回参数异常】");
            return Result.error("当前用户数据无法获取, 请刷新重试");
		}
		String openid = sessionResult.getOpenid();
		
		//根据openid查询该用户是否存在
		UserInfoEntity userInfoEntity = userInfoMapper.selectByOpenId(openid);
		
		if(null == userInfoEntity){
			userInfoEntity = new UserInfoEntity();
			WxMaUserInfo wxMaUserInfo = new WxMaUserInfo();
			try {
				wxMaUserInfo = this.wxMaService.getUserService().getUserInfo(sessionResult.getSessionKey(),
						 request.getEncrypteData(), request.getIvStr());
				log.info("解密用户敏感数据: "+JSON.toJSONString(wxMaUserInfo));
			} catch (Exception e) {
				log.error("【miniAppLogin 获取小程序用户数据失败。参数分别为：sessionKey： "
                        + sessionResult.getSessionKey()+" , encrypteData: "+request.getEncrypteData() + " , ivStr: "+ request.getIvStr()+" 】");
                log.error("错误信息：" + e);
                return Result.error("无法通过微信用户数据获取用户unionid");
			}
			
			if(null == wxMaUserInfo) {
				log.error("【miniAppLogin 解密用户敏感数据异常】");
	            return Result.error("解密用户敏感数据异常, 请刷新重试");
			}
			userInfoEntity.setAppid(wxMaProperties.getAppid());
			userInfoEntity.setAvatarurl(wxMaUserInfo.getAvatarUrl());
			userInfoEntity.setCity(wxMaUserInfo.getCity());
			userInfoEntity.setGender(Integer.parseInt(wxMaUserInfo.getGender()));
			userInfoEntity.setLanguage(wxMaUserInfo.getLanguage());
			userInfoEntity.setNickname(wxMaUserInfo.getNickName());
			userInfoEntity.setOpenid(wxMaUserInfo.getOpenId());
			userInfoEntity.setProvince(wxMaUserInfo.getProvince());
			userInfoEntity.setUnionid(wxMaUserInfo.getUnionId());
			userInfoEntity.setCountry(wxMaUserInfo.getCountry());
			userInfoMapper.insert(userInfoEntity);
			
			
		} 
		
		
		return Result.ok().put(OmsConstants.DATA_RESP, userInfoEntity);
	}

}
