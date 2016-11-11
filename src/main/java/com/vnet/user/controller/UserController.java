package com.vnet.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("uname", "test万里独行--讀");
		mav.addObject("flag", false);
		mav.addObject("isTrue", true);
		
		List<UserInfo> users = new ArrayList<UserInfo>();
		UserInfo user = new UserInfo();
		user.setId("2016031200000188");
		user.setName("田鹏程");
		user.setAge(29);
		user.setJob("Java攻城师");
		user.setBirth(new Date());
		users.add(user);
		UserInfo user1 = new UserInfo();
		user1.setId("2016031298476521");
		user1.setName("万里独行");
		user1.setAge(36);
		user1.setJob("金融领域架构师");
		user1.setBirth(new Date());
		users.add(user1);
		mav.addObject("users", users);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addr", "广东省深圳市南山区");
		map.put("edu", "华中科技大学");
		mav.addObject("uinfo", map);
		
		mav.addObject("unumber", new Double(0.38277648));
		mav.setViewName("user-detail");
		return mav;
	}

}
