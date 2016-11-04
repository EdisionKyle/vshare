package com.vnet.jms.rabbitmq;

import java.util.Scanner;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MQSender {

	private static final String QUEUE_NAME = "hello";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(AMQP.PROTOCOL.PORT);
		factory.setUsername("rollen");
		factory.setPassword("root222");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		//队列名称|是否持久化|是否独占网络|不使用时是否自动删除|其他参数如TTL(队列存活时间)等
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Input your message. To exit press CTRL+C");
		String message = "";
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("please input：");
			message = input.next();
			//队列名称|交换机名称|路由关键字
			//当exchange为direct的时候routingKey与bindingKey必须完全一致才能消费消息
//			channel.queueBind(queue, exchange, routingKey);
			//实现公平调度的方式就是让每个消费者在同一时刻会分配一个任务
//			channel.basicQos(prefetchCount);
			//交换机名称(默认或无名交换机)|路由关键字|其他属性|消息主体
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		} while (!message.equals("quit"));
		input.close();
		channel.close();
		connection.close();
		factory.clone();
	}

}
