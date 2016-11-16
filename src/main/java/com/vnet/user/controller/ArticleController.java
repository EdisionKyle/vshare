package com.vnet.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnet.service.ArticleService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public Map<String, Object> detail(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", articleService.findAllArticle());
		map.put("curtime", new Date());
		map.put("code", "10000");
		map.put("msg", "操作成功");
		return map;
	}

}
