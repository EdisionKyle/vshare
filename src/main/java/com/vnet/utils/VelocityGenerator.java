/**
 *  工程名：vshare
 *  文件名：VelocityGenerator.java
 *  包名：com.vnet.utils
 *  创建时间：2016年11月8日 下午5:37:04
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 *  类名：VelocityGenerator
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月8日 下午5:37:04
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class VelocityGenerator {
	public static void main(String[] args) throws IOException {
		VelocityEngine engine = new VelocityEngine();
		//基于文件目录
		engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
		engine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "F:\\space-git\\vshare\\src\\main\\webapp\\WEB-INF\\velocity\\");
		engine.setProperty(RuntimeConstants.INPUT_ENCODING, "utf-8");
		engine.setProperty(RuntimeConstants.OUTPUT_ENCODING, "utf-8");
		engine.setProperty("directive.foreach.counter.name", "loopCounter");
		engine.setProperty("directive.foreach.counter.initial.value", 1);
		engine.init();

		Template template = engine.getTemplate("hellovelocity.vm");
		VelocityContext ctx = new VelocityContext();

		ctx.put("name", "velocity学习");
		ctx.put("date", (new Date()).toString());

		List<String> temp = new ArrayList<String>();
		temp.add("我们的爱，过了就不再有");
		temp.add("七里香的瞅瞅");
		ctx.put("list", temp);

//		StringWriter sw = new StringWriter();
//		t.merge(ctx, sw);
//		PrintWriter writer = new PrintWriter("D:\\test.html");
//		template.merge(ctx, writer);
		
		// 定义生成的html文件
		File file = new File("D:\\test.html");
		if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		//模板与context里的属性相结合写入输出流中  
        template.merge(ctx, bw);

		bw.close();
//		writer.close();
	}

}
