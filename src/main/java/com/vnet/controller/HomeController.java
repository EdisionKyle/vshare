package com.vnet.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.vnet.pojo.Stu;
import com.vnet.pojo.User;
import com.vnet.service.UserService;

@Controller
@RequestMapping("/center")
// 类级别请求路径，类内方法请求都需要加上
// @Qualifier(value="HomeController") 指定ID
public class HomeController {

	private Log logger = LogFactory.getLog(HomeController.class);

	@Resource
	private UserService userService;

	@RequestMapping("/index.do")
	public ModelAndView index() {
		logger.info("Log Print Here");
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@RequestMapping("/about.do")
	public ModelAndView about() {
		ModelAndView about = new ModelAndView("about");
		about.addObject("uname", "田鹏程");
		return about;
	}

	@RequestMapping("/forward.do")
	public String forward() {
		return "forward:/center/index.do";
	}

	@RequestMapping("/redirect.do")
	public String redirect() {
		return "redirect:http://www.baidu.com";
	}

	@RequestMapping("/showImg.do")
	public String showImg() {
		return "showImg";
	}

	@RequestMapping(value = "/user/{rurl}/{surl}")
	public ModelAndView message(@PathVariable String rurl,
			@PathVariable String surl) {
		System.out.println(rurl + "   " + surl);
		ModelAndView about = new ModelAndView("about");
		about.addObject("uname", "田鹏程");
		return about;
	}/*
	 * A、处理requet uri部分的注解： @PathVariable; B、处理request header部分的注解：
	 * 
	 * @RequestHeader, @CookieValue; C、处理request body部分的注解：@RequestParam,
	 * 
	 * @RequestBody; D、处理attribute类型是注解： @SessionAttributes, @ModelAttribute;
	 */

	// 当请求参数a不存在时会有异常发生,可以通过设置属性required=false解决,
	// 例如: @RequestParam(value="uname", required=false)
	@RequestMapping("/advice.do")
	public String advice(@RequestParam(value = "uname", required = false) String uname, @RequestParam(value = "passwd", required = false) String passwd,
			Model model) {
		System.out.println("入参:   " + uname + "   --   " + passwd);
		model.addAttribute("uname", "milesloner'friend");
		return "advice";
	}

	@RequiresPermissions("user:update")
	@ResponseBody
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.GET)
	public Map<String, Object> updateUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "10000");
		map.put("msg", "用户更新成功");
		return map;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
		String returnView = "";
		System.out.println("入参:   " + user.getUname() + "   --   "
				+ user.getHobby());
		model.addAttribute("uname", "milesloner'friend");
//		if(StringUtils.equals("root", user.getUname()) && StringUtils.equals("tianpc", user.getHobby())) {
//			request.getSession().setAttribute("uname", user.getUname());
//			model.addAttribute("msg", "验证通过，登陆成功");
//			return "advice";
//		}
		try{
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUname(), DigestUtils.md5Hex(user.getHobby()));
			Subject currentUser = SecurityUtils.getSubject();
			if (!currentUser.isAuthenticated()) {
				// 使用shiro来验证
				token.setRememberMe(true);
				currentUser.login(token);// 验证角色和权限
				model.addAttribute("msg", "验证通过，登陆成功");
				System.out.println(user.getUname() + "验证通过 by doGetAuthenticationInfo at " + new Date());
				returnView = "advice";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("msg", "账号或密码错误");
			returnView = "home";
		}
		return returnView;
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
//		request.getSession().removeAttribute("uname");
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "home";
	}

	/*
	 * @RequestMapping(value="/login.do",method=RequestMethod.POST) public
	 * String loginbyreq(HttpServletRequest req, HttpServletResponse resp, Model
	 * model){ System.out.println("入参:   " + req.getParameter("uname") +
	 * "   --   " + req.getParameter("hobby")); model.addAttribute("uname",
	 * "milesloner'friend"); return "advice"; }
	 */
	@RequestMapping("/intercept.do")
	public String interceptor(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		System.out.println("===========InterceptorController");
		return "interceptor";
	}

	@RequestMapping("/list.do")
	public String list(HttpServletRequest req, HttpServletResponse resp,
			Model model) throws Exception {
		User u1 = new User();
		u1.setUname("田鹏程");
		u1.setHobby("Coding");
		User u2 = new User();
		u2.setUname("魏小枚");
		u2.setHobby("Watching");
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);

		Map<String, String> info = new HashMap<String, String>();
		info.put("sex", "男");
		info.put("address", "珠海市香洲区吉大街道龙洲湾花园");
		model.addAttribute("users", users);
		model.addAttribute("info", info);
		return "list";
	}

	@RequestMapping("/toUpload.do")
	public String toUpload(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		return "upload";
	}

	@RequestMapping(value = "/upload.do")
	public String upload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, Model model) {
		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println("附件路径          " + path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			// Spring提供的MultipartFile.transferTo(File targetFile)方法实现文件的上传
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/"
				+ fileName);
		return "upload_ok";
	}

	@RequestMapping("/toAjax.do")
	public String toAjax(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		return "ajax";
	}

	@RequestMapping(value = "/ajax.do", method = RequestMethod.POST)
	public ModelAndView ajax(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		System.out.println(name + "   -   " + password);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("activityId", "000001");
		m1.put("activityName", "阿斯蒂芬1");
		Map<String, String> m2 = new HashMap<String, String>();
		m2.put("activityId", "000002");
		m2.put("activityName", "阿斯蒂芬2");
		Map<String, String> m3 = new HashMap<String, String>();
		m3.put("activityId", "000003");
		m3.put("activityName", "阿斯蒂芬3");
		Map<String, String> m4 = new HashMap<String, String>();
		m4.put("activityId", "000004");
		m4.put("activityName", "阿斯蒂芬4");
		Map<String, String> m5 = new HashMap<String, String>();
		m5.put("activityId", "000005");
		m5.put("activityName", "阿斯蒂芬5");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		// JSONObjec有键名,而JSONArray没有。
		String s = JSON.toJSONString(list, true);
		// System.out.println(s);
		resp.getWriter().print(s);

		return null;
	}

	@RequestMapping(value = "/repbody.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView repbody(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		System.out.println(name + "   -   " + password);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("activityId", "000001");
		m1.put("activityName", "阿斯蒂芬1");
		Map<String, String> m2 = new HashMap<String, String>();
		m2.put("activityId", "000002");
		m2.put("activityName", "阿斯蒂芬2");
		Map<String, String> m3 = new HashMap<String, String>();
		m3.put("activityId", "000003");
		m3.put("activityName", "阿斯蒂芬3");
		Map<String, String> m4 = new HashMap<String, String>();
		m4.put("activityId", "000004");
		m4.put("activityName", "阿斯蒂芬4");
		Map<String, String> m5 = new HashMap<String, String>();
		m5.put("activityId", "000005");
		m5.put("activityName", "阿斯蒂芬5");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/listUser.do", method = RequestMethod.GET)
	public Map<String, Object> listUser() throws Exception {
		User u1 = new User();
		u1.setUname("田鹏程");
		u1.setHobby("Coding");
		User u2 = new User();
		u2.setUname("魏小枚");
		u2.setHobby("Watching");
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", users);
		map.put("sex", "男");
		map.put("address", "珠海市香洲区吉大街道龙洲湾花园");
		System.out.println("OKKKK");
		return map;
	}

	/**
	 * 使用mybatis-paginator分页
	 * center/pageUser.do?pageIndex=1&pageSize=10&itype=1
	 * @author pengcheng.tian
	 * @param pageIndex
	 * @param pageSize
	 * @param itype
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/pageUser.do", method = RequestMethod.GET)
	public Map<String, Object> listTweet(int pageIndex, int pageSize, int itype)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageBounds pageBounds = new PageBounds(pageIndex, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		PageList<Stu> tweets = userService.findStuByPager(params,
				pageBounds);
		map.put("pagesize", tweets.getPaginator().getLimit());
		map.put("userCount", tweets.getPaginator().getTotalCount());
		map.put("userlist", tweets);
		return map;
	}

}