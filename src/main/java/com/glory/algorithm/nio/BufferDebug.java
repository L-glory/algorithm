package com.glory.algorithm.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * buffer debug测试
 *
 * @author Glory
 * @create 2020-05-20 15:00
 **/
public class BufferDebug {

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("D:\\temp-2.txt", "rw")){
            // 申请内核缓存区
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            FileChannel channel = file.getChannel();
            int read = channel.read(buffer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
