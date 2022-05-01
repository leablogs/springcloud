package com.leablogs;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class RabbitProduct {
    public static void main(String[] args) throws IOException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, TimeoutException {
        String exchange_name = "test";
        String routingKey = "test";
        String queryName = "01-Q2";
        Connection connection = getConnectionA();
        Channel channel = connection.createChannel();
        Map<String,Object> argss = new HashMap<String,Object>();
        argss.put("alternate-exchange","myAe"); // 设置备份交换器
        argss.put("x-message-ttl",6000); // 设置过期时间
        AMQP.Exchange.DeclareOk exchangeDeclare =  channel.exchangeDeclare(exchange_name,
                "direct",true,false,argss);
        Map<String, Object> argss1 = new HashMap<>();
        argss1.put("x-dead-letter-exchange"," dlx_exchange ");
        argss1.put("x-dead-letter-routing-key","dead_routing-key");
        argss1.put("x-queue-mode","lazy"); //声明惰性队列
        AMQP.Queue.DeclareOk queueDeclares = channel.queueDeclare(queryName, true, // 队列持久化
                false, false, argss1);
        AMQP.Queue.BindOk queue = channel.queueBind(queryName, exchange_name, routingKey);
        byte[] messageBodyBytyts = "Hello, world".getBytes();
        String callbackQueueNmae = channel.queueDeclare().getQueue();
        try {
            channel.txSelect(); // 开启事务
//            channel.confirmSelect(); //将消息队列设置为publisher confirm模式
            channel.basicPublish(exchange_name, routingKey,
                    new AMQP.BasicProperties().builder()
                            .contentEncoding("text/plain")
                            .deliveryMode(2) // 消息持久化
                            .replyTo(callbackQueueNmae) // 设置一个回调队列
                            .correlationId("") // 关联请求和调用rpc 后的回复
                            .priority(1)
                            .expiration("60000") // 过期时间ms
                            .userId("hidden")
                            .build()
                    , messageBodyBytyts);
//            if(!channel.waitForConfirms()){
//                // 消息确认失败 处理流程
//            }
//        channel.basicPublish(exchange_name,routingKey,true, MessageProperties.PERSISTENT_TEXT_PLAIN,
//                "mandtory test".getBytes());
            channel.addReturnListener(new ReturnListener() {
                @Override
                public void handleReturn(int replyCode, String replyText,
                                         String exchange, String routingKey,
                                         AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("返回结果时:" + new String(body));
                }
            });
            channel.txCommit(); //提交事务
        }catch (Exception e){
            e.printStackTrace();
            channel.txRollback();
        }
    }

    public static Connection getConnectionA() throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("rabbit");
        factory.setPassword("rabbit");
        factory.setVirtualHost("test");
        factory.setHost("81.69.23.63");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        return connection;
    }

    public static Connection getConnectionB() throws IOException, TimeoutException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://rabbit:rabbit@81.69.23.63:5672/test");
        Connection connection = factory.newConnection();
        return connection;

    }

    public static Channel createChannel(Connection connection) throws IOException {
        return connection.createChannel();
    }
}
