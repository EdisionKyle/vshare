package com.vlike.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogfjTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.out.println(sdf.format(new Date()));
		PropertyConfigurator.configure("F:\\git_repo\\vshare\\vshare\\src\\main\\resources\\log4j.properties");
		Logger logger = Logger.getLogger(LogfjTest.class);
		logger.info("info：" + RandomStringUtils.randomAlphanumeric(20));
		logger.debug("debug：" + RandomStringUtils.randomAlphanumeric(20));
		logger.error("error：" + RandomStringUtils.randomAlphanumeric(20));
		
		org.slf4j.Logger sLogger = org.slf4j.LoggerFactory.getLogger(LogfjTest.class);
		sLogger.info("您好，{}，您的年龄{}，住址{}", "田鹏程", "30", "广东省深圳市南山区西丽街道");
	}

}
