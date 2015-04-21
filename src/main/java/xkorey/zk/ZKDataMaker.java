package xkorey.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by xkorey on 2015/4/21.
 */
public class ZKDataMaker {

    public boolean run = true;

    public String path = "/test_data_increase";

    ZooKeeper zk;

    public void increase(){
        int inx=0;
        try {
            zk = new ZooKeeper("localhost:8610",2000,new ZKWatcher());
            if(zk.exists(path,false)==null){
                zk.create(path,new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
            }
            while (run){
                zk.setData(path,(""+(inx++)).getBytes(),-1);
                Thread.sleep(100);
            }
            System.out.println("maker ext. the value is:"+inx);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args){
         final ZKDataMaker m = new ZKDataMaker();
        Thread t = new Thread(new Runnable() {
            public void run() {
                m.increase();
            }
        });
        t.run();
    }
}
