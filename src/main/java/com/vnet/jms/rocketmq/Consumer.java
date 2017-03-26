package com.vnet.jms.rocketmq;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 *  类名：Consumer.java
 *  说明：消息消费者
 *  创建时间：2017年3月25日 下午8:42:10
 *  Copyright (C) 2017, tianpc0318@163.com All Rights Reserved.
 *  @author milesloner
 */
public class Consumer {

	public static void main(String[] args) {
		// consumerGroup需要由应用来保证唯一
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
				"PushConsumerTest");
		consumer.setNamesrvAddr("192.168.173.133:9876");
		try {
			// 订阅指定topic下tags分别等于TagA或TagB
			consumer.subscribe("PushTopic", "push || pull");
			/**
			 * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
			 * 如果非第一次启动，那么按照上次消费的位置继续消费
			 */
			consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
			consumer.registerMessageListener(new MessageListenerConcurrently() {
				/**
				 * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
				 */
				@Override
				public ConsumeConcurrentlyStatus consumeMessage(
						List<MessageExt> list,
						ConsumeConcurrentlyContext Context) {
					Message msg = list.get(0);
					try {
						System.out.println(msg.getTags() + "--" + msg.getKeys()
								+ "--" + new String(msg.getBody(), "UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});
			/**
			 * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
			 */
			consumer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Consumer Started Successfully.");
	}

}
