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
import com.lxy.account.request.AccountRequest;
import com.lxy.account.service.AccountService;
import com.lxy.account.vo.Result;

/**
 * 记账
 * @author liuxingyue
 * @date 2018-04-09
 */
@RestController
@RequestMapping("/account")
public class AccountController {
	private Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/save")
	public Result save(@RequestBody @Valid AccountRequest request, BindingResult bindingResult){
		log.info("【记一笔】请求参数，request = " +JSON.toJSON(request));
		if (bindingResult.hasErrors()) {
			return Result.error("参数错误:" + bindingResult.getFieldError().getDefaultMessage());
		}
		Result result = Result.ok();
		try {
			result = accountService.save(request);
		} catch (Exception e) {
			log.error("【记一笔】请求异常，error = " + e);
			result = Result.error("系统异常");
		}
		log.info("【记一笔】返回信息：" + JSON.toJSON(result));
		return result;
		
	}

}
