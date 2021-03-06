/**
 * 
 */
package com.lxy.account.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lxy.account.request.UserInfoRequest;
import com.lxy.account.service.LoginService;
import com.lxy.account.vo.Result;

/**
 * 用户登录授权
 * @author liuxingyue
 * @date 2018-04-08
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/miniapp-login")
	public Result login(@RequestBody @Valid UserInfoRequest request, BindingResult bindingResult){
		log.info("微信登录请求参数，request = " +JSON.toJSON(request));
		if (bindingResult.hasErrors()) {
			return Result.error("参数错误:" + bindingResult.getFieldError().getDefaultMessage());
		}
		Result result = Result.ok();
		try {
			result = loginService.miniappLogin(request);
		} catch (Exception e) {
			log.error("微信登录请求异常，error = " + e);
			result = Result.error("系统异常");
		}
		log.info("微信登录返回信息：" + JSON.toJSON(result));
		return result;
		
	}

}
