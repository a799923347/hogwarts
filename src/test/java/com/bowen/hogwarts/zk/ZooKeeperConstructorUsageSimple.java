package com.bowen.hogwarts.zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author zhaobaowen
 */
public class ZooKeeperConstructorUsageSimple implements Watcher {

  private static CountDownLatch countDownLatch = new CountDownLatch(1);

  public static void main(String[] args) throws IOException {
    ZooKeeper zooKeeper = new ZooKeeper("", 5000, new ZooKeeperConstructorUsageSimple());
    System.out.println(zooKeeper.getState());
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("ZooKeeper session established.");

  }

  @Override
  public void process(WatchedEvent watchedEvent) {
    System.out.println("receive watched event:" + watchedEvent);
    if (KeeperState.SyncConnected == watchedEvent.getState()) {
      countDownLatch.countDown();
    }

  }
}
