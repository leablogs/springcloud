package com.leablogs.stream;

import com.leablogs.stream.sender.SinkSender;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.nio.charset.StandardCharsets;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration()
@WebAppConfiguration
public class HelloApplicationTests {
    @Autowired
    private SinkSender sinkSender;

    public void contextLoads() {
        sinkSender.output().send((Message<?>) MessageBuilder.
                withBody("From SinkSender".getBytes(StandardCharsets.UTF_8)).build());
    }


}
