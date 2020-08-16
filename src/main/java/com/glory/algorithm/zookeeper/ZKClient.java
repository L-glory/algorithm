package com.glory.algorithm.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author Glory
 * @create 2020-07-30 14:48
 **/
public class ZKClient {

    public static void main(String[] args) throws Exception {
        // 客户端初始化
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .connectString("registry1.glory.com:2181")
                .namespace("glory")
                .build();
        // 客户端启动
        client.start();

        // watch
        PathChildrenCache cache = new PathChildrenCache(client, "/path", true);
        cache.start();
        PathChildrenCacheListener listener = (cli, event) -> {
            System.out.println("事件类型:" + event.getType());
            ChildData data = event.getData();
            if (data != null) {
                System.out.println("节点数据, " + data.getPath() + "=" + new String(data.getData()));
            }
        };
        cache.getListenable().addListener(listener);

        // 增
        /*String path = client.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.PERSISTENT) // 默认PERSISTENT
                .forPath("/path", "data".getBytes());     // data可以不设置
        System.out.println("path=" + path);*/
        // 查
        Thread.sleep(200);
        client.delete().forPath("/path");
        client.checkExists().creatingParentContainersIfNeeded().usingWatcher((Watcher) (WatchedEvent event) -> {

        });
        Thread.sleep(2000);
    }
}
