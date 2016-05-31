package com.merryyou.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;

/**
 * Created on 2016/1/16 0016.
 *
 * @author zlf
 * @since 1.0
 */
public class RPCClient {

    public static void main(String[] args) throws Exception {
        Bizable proxy = RPC.getProxy(Bizable.class, 10010, new InetSocketAddress("192.168.1.102", 9500), new Configuration());
        String result = proxy.sayHi("郑龙飞");
        System.out.println(result);
        RPC.stopProxy(proxy);
    }
}
