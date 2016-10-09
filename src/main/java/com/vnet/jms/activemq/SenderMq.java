package com.vnet.jms.activemq;

import org.springframework.stereotype.Component;

/**
 * 发送消息到mq服务器，所有客户端通用
 *
 * 类 名: SenderMq
 *
 */
//@Component
public class SenderMq {/*

	*//**
	 * mq_destination 为 mq通道（目的地）这里有两种：
	 * SmartSchedule-Server发送给服务器接收，SmartSchedule-Log发送给日志服务器接收
	 *//*
	@Resource
	private JmsTemplate jmsTemplate;

	*//**
	 * @param destination
	 *            消息通道
	 *
	 * @param msg
	 *            消息内容
	 *//*
	public void sendTextMessage(Destination destination, final String msg)
			throws JMSException {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage(msg);
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 0);
				message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);// 持久消息
				
				 * 对于持久消息，消息提供者会使用存储-转发机制，先将消息存储到稳定介质中，等消息发送成功后再删除
				 * 消息的持久特性就是为了在异常发生的时候保证消息的送达
				 * 一旦消息成功传送给它的所有消费者，那么jms provider会从内存/硬盘上删除这些无用的消息
				 
				return message;
			}
		});
	}

*/}