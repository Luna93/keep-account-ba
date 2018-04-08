/**
 * 
 */
package com.lxy.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxy.account.request.UserInfoRequest;
import com.lxy.account.service.LoginService;

/**
 * 用户登录授权
 * @author liuxingyue
 * @date 2018-04-08
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	private LoginService loginService;
	
	@PostMapping("/miniapp-login")
	public void login(UserInfoRequest request){
		loginService.miniappLogin(request);
	}

}
