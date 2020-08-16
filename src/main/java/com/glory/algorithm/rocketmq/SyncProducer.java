package com.glory.algorithm.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * 同步消息生产者
 *
 * @author Glory
 * @create 2020-06-23 15:04
 **/
public class SyncProducer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        // producer初始化
        DefaultMQProducer producer = new DefaultMQProducer("glory_test_group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 启动producer
        producer.start();

        System.out.println("开始发消息");
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("test_topic" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // set delay times
            msg.setDelayTimeLevel(3);
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
        System.out.println("发送完事");
    }
}
