package com.vnet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {
	@RequestMapping("/intercept.do")
	public String interceptor(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		System.out.println("===========InterceptorController");
		return "interceptor";
	}
}