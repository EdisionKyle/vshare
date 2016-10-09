package com.vnet.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnet.pojo.UserInfo;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/detail")
	@ResponseBody
	public Map<String, Object> detail(String id) {
		Map<String, Object> map =new HashMap<String, Object>();
		UserInfo user = new UserInfo();
		user.setId("2016031200000188");
		user.setName("田鹏程");
		user.setAge(29);
		user.setJob("Java攻城师");
		user.setBirth(new Date());
		map.put("user", user);
		return map;
	}

}
