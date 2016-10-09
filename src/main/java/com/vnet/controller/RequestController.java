package com.vnet.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/request", method = RequestMethod.GET)
public class RequestController {
	@RequestMapping("/headerInfo.do")
	public String displayHeaderInfo(
			@RequestHeader(value = "Accept") String accept,
			@RequestHeader(value = "Accept-Language") String acceptLanguage,
			@RequestHeader(value = "User-Agent", defaultValue = "foo") String userAgent,
			HttpServletResponse response) {
		System.out.println("Request请求数据");
		System.out.println(accept);
		System.out.println(userAgent);
		return "showImg";
	}

	@RequestMapping("/cookieInfo.do")
	public String displayCookie(@CookieValue("JSESSIONID") String cookie) {
		System.out.println("请求COOKIE == " + cookie);
		return "showImg";
	}
}