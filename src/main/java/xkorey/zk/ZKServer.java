package xkorey.zk;

import org.apache.zookeeper.server.NIOServerCnxnFactory;
import org.apache.zookeeper.server.ZooKeeperServer;
import org.apache.zookeeper.server.persistence.FileTxnSnapLog;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by xkorey on 2015/4/21.
 */
public class ZKServer  {

    NIOServerCnxnFactory serverCnxnFactory;

    public void run() throws IOException, InterruptedException {
        ZooKeeperServer zkServer = new ZooKeeperServer();
        File dataDirectory = new File("/zookeeper");
        FileTxnSnapLog ftxn = new FileTxnSnapLog(dataDirectory, dataDirectory);
        zkServer.setTxnLogFactory(ftxn);
        zkServer.setTickTime(30000);
        serverCnxnFactory = new NIOServerCnxnFactory();
        serverCnxnFactory.configure(new InetSocketAddress(8610), 60);
        serverCnxnFactory.startup(zkServer);
    }


    public static void main(String[]args){
        ZKServer s  = new ZKServer();
        try {
            s.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
