/**
 *  工程名：vshare
 *  文件名：ConstantDirective.java
 *  包名：com.vnet.utils.tag
 *  创建时间：2016年11月10日 上午11:00:39
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.utils.tag;

import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

/**
 *  类名：ConstantDirective
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月10日 上午11:00:39
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class ConstantDirective extends Directive {

	public String getName() {
		return "constant";
	}

	public int getType() {
		return LINE;
	}

	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		SimpleNode sn = null;
		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
			sn = (SimpleNode) node.jjtGetChild(i);
			System.out.println(sn.value(context));
		}
		writer.write("我是自定义常量标签");
		return true;
	}

}
