package com.leablogs;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {
    public static void main(String[] args) throws IOException, URISyntaxException, NoSuchAlgorithmException, KeyManagementException, TimeoutException {

        String exchange_name = "test";
        String routingKey = "test";
        boolean autoAck = false;
        String queryName = "01-Q2";
        Channel channel = getConnectionB().createChannel();
//        String queryName= channel.queueDeclare().getQueue();
        channel.basicQos(64);
        String c = channel.basicConsume(queryName, autoAck, "myConsumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                Long deliverTag = envelope.getDeliveryTag();
                    System.out.println(new String(body));
                channel.basicAck(deliverTag, false);
            }
        });
//
//        GetResponse re = channel.basicGet(queryName,false);
//        System.out.println(re);

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
