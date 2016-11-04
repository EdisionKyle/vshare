package com.vnet.jms.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MQReceiver {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(AMQP.PROTOCOL.PORT);
		factory.setUsername("rollen");
		factory.setPassword("root222");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		//队列名称|是否持久化|是否独占网络|不使用时是否自动删除|其他参数如TTL(队列存活时间)等
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//交换机名称|交换机类型|是否持久化
//		channel.exchangeDeclare(exchange, type, durable);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		//消费者用于获取消息信道绑定的消息队列中的信息
		QueueingConsumer consumer = new QueueingConsumer(channel);
		//队列名称|自动确认|消费者
		channel.basicConsume(QUEUE_NAME, true, consumer);
		while (true) {
			//获取消息，如果没有消息，将会一直阻塞
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			//确认消息
//			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), multiple);
			String message = new String(delivery.getBody());
			System.out.println(" [X] Received '" + message + "'");
		}
	}

}