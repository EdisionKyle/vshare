package com.vnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vnet.pojo.User;

@Controller
@RequestMapping("/admin")
@SessionAttributes("loginUser")
public class SessionAttributesController {
	@RequestMapping(value = "/info.do")
	public String login(@RequestParam("uid") String uid, ModelMap model) {
		User user = new User();
		user.setUname("田鹏程");
		user.setHobby("Mahjong");
		System.out.println("名字ID:" + uid);
		model.addAttribute("loginUser", user);
		return "about";
	}
	
	@RequestMapping(value = "/detail.do")
	public String detail(@ModelAttribute("loginUser") User user, ModelMap model) {
		//模型数据中不存在将抛出HttpSessionRequiredException Expected session attribute "loginUser"
		System.out.println("名字ID:" + user.getUname());
		model.addAttribute("uname", "田鹏程");
		return "about";
	}
}