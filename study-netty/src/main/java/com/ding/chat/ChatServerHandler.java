package com.ding.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    //GlobalEventExecutor.INSTANCE是全局事件执行器，是单例
   private static ChannelGroup channelGroup= new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 当客户端连接到服务端，表示用户上线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //将该客户加入聊天的信息推送给其他在线的客户端
        //该方法会将channelGroup中所有channel遍历，并发送消息
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[用户]"+channel.remoteAddress()+"上线了"+sdf.format(new Date())+"\n");
        //将当前channel加入channelGroup
        channelGroup.add(channel);
        System.out.println("[用户]"+ctx.channel().remoteAddress()+"上线了!!!"+sdf.format(new Date())+"\n");
    }

    /**
     * 表示channel处于不活跃状态，也就是客户端下线了
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[用户]"+channel.remoteAddress()+"下线了"+"\n");
        System.out.println("[用户]"+ctx.channel().remoteAddress()+"下线了"+sdf.format(new Date())+"\n");
        System.out.println("channelGroup size="+channelGroup.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //获取到当前channel
        Channel channel = ctx.channel();
        //遍历channelGroup，根据不同情况，回送不同消息
        channelGroup.forEach(channel1 -> {
            if(channel!=channel1){ //不是当前的channel，转发消息
                channel1.writeAndFlush("[客户端]"+channel.remoteAddress()+"发送了消息："+msg+sdf.format(new Date())+"\n");
            }else{//回显自己发送的消息
                channel1.writeAndFlush("[自己]发送了消息："+msg+sdf.format(new Date())+"\n");
            }
        });
    }

}
