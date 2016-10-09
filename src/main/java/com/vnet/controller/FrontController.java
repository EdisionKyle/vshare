package com.vnet.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnet.pojo.UserInfo;

/**
 * 前台测试专例
 * 嘿嘿
 * 哈哈~~~
 * 异地提交~~！
 * @author pengcheng.tian
 *
 */
@Controller
@RequestMapping("/front")
public class FrontController {

	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@RequestMapping("/toAjax")
	public String toAjax() {
		System.out.println(jdbcUrl);
		return "front/ajax";
	}

	@RequestMapping("/toJson")
	public String toJson() {
		return "front/json";
	}

	@ResponseBody
	@RequestMapping("/ajax")
	public Map<String, Object> ajax(String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo user = new UserInfo();
		user.setId("MileLoner");
		user.setAge(29);
		user.setBirth(new Date());
		user.setJob("Java攻城师");
		user.setName("田鹏程");
		map.put("user", user);
		map.put("success", true);
		map.put("message", "操作成功");
		return map;
	}

}
