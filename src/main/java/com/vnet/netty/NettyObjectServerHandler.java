package com.vnet.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyObjectServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		NettyUser user = (NettyUser) msg;
		System.out.println("服务端收到：" + user.toString());
		user.setName("Zhangmh");
		ctx.write(user);
		ctx.flush();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// 打印异常信息并关闭连接
		cause.printStackTrace();
		ctx.close();
	}

}
