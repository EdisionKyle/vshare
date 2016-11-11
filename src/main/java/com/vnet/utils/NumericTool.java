/**
 *  工程名：vshare
 *  文件名：NumericTool.java
 *  包名：com.vnet.utils
 *  创建时间：2016年11月9日 下午2:27:57
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.utils;
/**
 *  类名：NumericTool
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月9日 下午2:27:57
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class NumericTool {
	/**
	 * 将浮点数小数，固定保留两位小数
	 */
	public static String toFixedNumber(Double d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%1$.2f", d);
		return "toFixedNumber="+ valStr;
	}

	public static String toDouble(Double d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%1$.2f", d * 2 + 1);
		return "toDouble="+ valStr;
	}

}
