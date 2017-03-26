package com.vnet.jms.rocketmq;

import org.apache.commons.lang3.RandomStringUtils;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 *  类名：Producer.java
 *  说明：消息生产者
 *  创建时间：2017年3月25日 下午8:39:55
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public class Producer {

	public static void main(String[] args) {
		// producerGroup保证唯一
		DefaultMQProducer producer = new DefaultMQProducer("ProducerTest");
		producer.setNamesrvAddr("192.168.173.133:9876");
		try {
			// Producer对象在使用之前必须要调用start初始化，初始化一次即可
			producer.start();

			Message msg = new Message("PushTopic", "push", "888",
					("Just for test.美" + RandomStringUtils.randomAlphanumeric(8)).getBytes("UTF-8"));

			SendResult result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:"
					+ result.getSendStatus());

			msg = new Message("PushTopic", "push", "999",
					("Just for test.俊" + RandomStringUtils.randomAlphanumeric(8)).getBytes("UTF-8"));

			result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:"
					+ result.getSendStatus());

			msg = new Message("PushTopic", "pull", "666",
					("Just for test.赢" + RandomStringUtils.randomAlphanumeric(8)).getBytes("UTF-8"));

			result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:"
					+ result.getSendStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 应用退出时，要调用shutdown来清理资源，关闭网络连接，从MetaQ服务器上注销自己
			producer.shutdown();
		}
	}

}
