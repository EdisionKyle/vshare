package com.vnet.utils;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * 自定义Log4j输出组件
 * 
 * @author pengcheng.tian
 *
 */
public class SlogAppender extends DailyRollingFileAppender {

	@Override
	public boolean isAsSevereAsThreshold(Priority priority) {
		// 判断是否相等，而不判断优先级
		return this.getThreshold().equals(priority);
	}

}
