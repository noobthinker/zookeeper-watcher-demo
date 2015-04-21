package xkorey.zk;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Created by xkorey on 2015/4/21.
 */
public class ZKWatcher implements Watcher, AsyncCallback.StatCallback {


    public void processResult(int i, String s, Object o, Stat stat) {

    }

    public void process(WatchedEvent event) {

    }


}
