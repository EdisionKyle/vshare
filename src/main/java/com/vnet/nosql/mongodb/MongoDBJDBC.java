/**
 *  工程名：vshare
 *  文件名：MongoDBJDBC.java
 *  包名：com.vnet.nosql.mongodb
 *  创建时间：2017年2月13日 上午10:23:14
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.nosql.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *  类名：MongoDBJDBC
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2017年2月13日 上午10:23:14
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class MongoDBJDBC {

	public static void main(String args[]) {
		MongoClient mongoClient = null;
		MongoDatabase mongoDatabase = null;
		try {
			// 连接到 mongodb 服务
			mongoClient = new MongoClient("localhost", 27017);

			// 连接到数据库
			mongoDatabase = mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			mongoDatabase.drop();
		}
	}

}
