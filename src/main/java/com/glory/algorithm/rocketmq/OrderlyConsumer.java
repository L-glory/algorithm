package com.glory.algorithm.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 顺序消费
 *
 * @author Glory
 * @create 2020-06-29 14:45
 **/
public class OrderlyConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("OrderTopicTest");
        consumer.setNamesrvAddr("cloud.glory.com:9876");
        consumer.subscribe("TopicTest", "*");
        consumer.registerMessageListener((List<MessageExt> msgs, ConsumeOrderlyContext context) -> {
            context.setAutoCommit(true);
            try {
                for (MessageExt msg : msgs) {
                    // 顺序消费消息
                }
                return ConsumeOrderlyStatus.SUCCESS;
            } catch (Exception e) {
                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
        });
        // 启动消费端
        consumer.start();
        System.out.printf("Order Consumer Started.%n");
    }
}
