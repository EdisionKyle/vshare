package com.vnet.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HelloServer {

	/**
	 * 服务端监听的端口地址
	 */
	private static final int portNumber = 7878;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Bootstrap负责启动引导
		 * Buffer是Netty自己封装的缓存器
		 * Channel负责管理和建立连接
		 * Handler是责任链路模式中的处理者
		 * Util是Netty提供和使用到的一些工具
		 */
		EventLoopGroup bossGroup = new NioEventLoopGroup();// EventLoopGroup管理Channel连接
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			// boss 用来接收进来的连接
			// worker 用来处理已经被接收的连接
			b.group(bossGroup, workerGroup);// 为了处理Channel中的事件和IO操作
			/**
			 * Netty的架构使用了非常复杂的主从式Reactor线程模型。简单的说就是：
			 * 父线程组（代码中的parentBosser）担任（acceptor）的角色。
			 * 负责接收客户端的连接请求，处理完成请求，
			 * 创建一个Channel并注册到子线程组（代码中的childWorker）中的某个线程上面，
			 * 然后这个线程将负责Channel的读写，编解码等操作。
			 */
			b.channel(NioServerSocketChannel.class);
//			b.option(ChannelOption.SO_KEEPALIVE, true);// 设置Channel选项配置
			b.childHandler(new HelloServerInitializer());

			// 服务器绑定端口监听
			ChannelFuture f = b.bind(portNumber).sync();
			// 监听服务器关闭监听，为了防止线程停止
			f.channel().closeFuture().sync();

			// 可以简写为
			/* b.bind(portNumber).sync().channel().closeFuture().sync(); */
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}