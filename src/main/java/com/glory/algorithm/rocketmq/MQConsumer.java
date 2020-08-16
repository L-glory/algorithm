package com.glory.algorithm.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 消息消费者
 *
 * @author Glory
 * @create 2020-06-23 15:16
 **/
public class MQConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("TopicTest");
        consumer.setNamesrvAddr("cloud.glory.com:9876");
        consumer.subscribe("TopicTest", "*");
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.registerMessageListener((List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) -> {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // 启动消费端
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }

}
