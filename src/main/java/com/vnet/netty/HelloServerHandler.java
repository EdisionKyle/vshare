package com.vnet.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

public class HelloServerHandler extends SimpleChannelInboundHandler<String> {
	/**
	 * ChannelHandler接口是Handler里面的最高的接口
	 * ChannelInboundHandler接口和ChannelOutboundHandler接口，继承ChannelHandler接口
	 * ChannelInBoundHandler负责数据进入并在ChannelPipeline中按照从上至下的顺序查找调用相应的InBoundHandler
	 * ChannelOutBoundHandler负责数据出去并在ChannelPipeline中按照从下至上的顺序查找调用相应的OutBoundHandler
	 * 消息在管道中都是以ChannelHandlerContext的形势传递的
	 */
	// channelRead0 在这里的作用是类似于3.x版本的messageReceived()。可以当做是每一次收到消息是触发
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)
			throws Exception {
		// 收到消息直接打印输出
		System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);

		// 返回客户端消息 - 我已经接收到了你的消息
		ctx.writeAndFlush("Received your message !\n");
		/**
		 * 写入Buffer并刷入
		 * 在3.x版本中此处有很大区别。在3.x版本中write()方法是自动flush的。在4.x版本的前面几个版本也是一样的。但是在4.0.9
		 * 之后修改为WriteAndFlush。普通的write方法将不会发送消息。需要手动在write之后flush()一次
		 */
	}

	/*
	 * 
	 * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
	 * 
	 * channelActive 和 channelInActive 在后面的内容中讲述，这里先不做详细的描述
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		System.out.println("RamoteAddress : " + ctx.channel().remoteAddress()
				+ " active !");

		ctx.writeAndFlush("Welcome to "
				+ InetAddress.getLocalHost().getHostName() + " service!\n");

		super.channelActive(ctx);
	}

}