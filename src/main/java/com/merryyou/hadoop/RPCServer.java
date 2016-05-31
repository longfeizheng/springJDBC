package com.merryyou.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * Created on 2016/1/16 0016.
 *
 * @author zlf
 * @since 1.0
 */
public class RPCServer implements Bizable {

    public String sayHi(String name) {
        return " hi ~" + name;
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        RPC.Server server = new RPC.Builder(conf).setProtocol(Bizable.class).setInstance(new RPCServer()).setBindAddress("192.168.1.102").setPort(9500).build();
        server.start();
    }
}
