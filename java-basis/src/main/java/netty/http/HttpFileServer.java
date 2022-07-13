package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {
    private static String aa;
    private static final String DEFAULT_URL = System.getProperty("user.dir") + "/netty/";
    static {
        aa = "dddddddddddddddddd";
    }

    public void run(final int port,final String url) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup).channel(NioSctpServerChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 添加http请求消息解码器
                            socketChannel.pipeline().addLast("http-decoder",new HttpRequestDecoder());
                            // 添加 httpObjectAggregator 解码器 将多个消息转换为单一的FullHttpRequest或是FulltResponse
                            // http解码器在每个 http消息中国会生成多个消息对象
//                            HttpRequest/ httpResponse   httpContent   LastHttpContent

                            socketChannel.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));
                            socketChannel.pipeline().addLast("http-encoder",new HttpRequestEncoder());
                            // 支持 异步发送大的码流（文件） 不占用过多内存，防止java内存溢出
                            socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                            // 用于服务器业务逻辑处理
                            socketChannel.pipeline().addLast("fileServerHandler",new HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture future = b.bind("192.168.2.219",port).sync();
            System.out.println("Http 文件目录服务器启动，网址是 ：" + "http://192.168.2.219:" + port + url);
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
//        System.out.println(Math.round(11.5));
//        System.out.println(Math.round(11.6));
//        System.out.println(Math.round(-11.6));
//        System.out.println(Math.floor(11.5));
//        System.out.println(Math.ceil(11.5));
//        Short i = 1;
//        i = (short)(i+1);
//        Short i1 = 1;
//        int s = 1;
//        int s1 = 0;
//        System.out.println(s & s1);
//        System.out.println(s | s1);
        System.out.println(aa);
        for(int i = 1;i<=9;i++){
            for(int j = 1;j<=9;j++){
                System.out.print(i + "*" + j +" = " + i * j + " | ");
            }
            System.out.println();
        }
//        if(args.length>0){
//            try {
//                port = Integer.parseInt(args[0]);
//            }catch (NumberFormatException e){
//                e.printStackTrace();
//            }
//            String url = DEFAULT_URL;
//            if(args.length>1){
//                url = args[1];
//                new HttpFileServer().run(port,url);
//            }
//        }
    }
}

class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{

    HttpFileServerHandler(String url){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

    }
}

























