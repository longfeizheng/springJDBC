package com.merryyou.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created on 2015/9/23 0023.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class NetworkUtils {
    /**
     * Instantiates a new Network utils.
     */
    private NetworkUtils() {
    }

    /**
     * Gets real ip.
     *
     * @return the real ip
     */
    public static String getRealIp() {
        // 本地IP，如果没有配置外网IP则返回它
        String localIp = null;
        // 外网IP
        String netIp = null;

        Enumeration<NetworkInterface> netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            return null;
        }

        // 是否找到外网IP
        boolean found = false;
        while (netInterfaces.hasMoreElements() && !found) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                InetAddress ip = address.nextElement();
                if (!ip.isSiteLocalAddress()
                        && !ip.isLoopbackAddress()
                        && !ip.getHostAddress().contains(":")) { // 外网IP
                    netIp = ip.getHostAddress();
                    found = true;
                    break;
                } else if (ip.isSiteLocalAddress()
                        && !ip.isLoopbackAddress()
                        && !ip.getHostAddress().contains(":")) { // 内网IP
                    localIp = ip.getHostAddress();
                }
            }
        }

        if (netIp != null && !"".equals(netIp)) {
            return netIp;
        } else {
            return localIp;
        }
    }
}

