package com.merryyou.util;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;

import java.net.InetSocketAddress;
import java.util.List;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created on 2015/9/23 0023.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class RequestIdUtils {
    /**
     * Instantiates a new Request id utils.
     */
    private RequestIdUtils() {
    }


    /**
     * Generate the request id.
     *
     * @param randomStr the random string
     * @param ipAddr    the ip address
     * @param timestamp the timestamp
     * @return the request id.
     */
    public static String generate(String randomStr, String ipAddr, String timestamp) {
        List<String> ipArr = from(Splitter.on('.').omitEmptyStrings().splitToList(ipAddr))
                .transform(input -> Strings.padStart(
                        Integer.toHexString(Integer.parseInt(input)), 2, '0')).toList();

        if (ipArr.size() != 4) {
            // 127.0.0.1
            ipArr = Lists.newArrayList("7F", "00", "00", "01");
        }

        return String.format("%s%s%s%s%s%s", randomStr,
                ipArr.get(0), ipArr.get(1),
                Strings.padStart(timestamp, 12, '0'),
                ipArr.get(2), ipArr.get(3));
    }

    /**
     * Generate the request id.
     *
     * @return the request id.
     */
    public static String generate() {
        //                                                 HEX: 0x10000000 to 0xFFFFFFFF
        String randomStr = Long.toHexString(RandomUtils.nextLong(268435456L, 4294967295L));
        String ipAddr = NetworkUtils.getRealIp();
        if (ipAddr == null) {
            ipAddr = new InetSocketAddress(0).getHostName();
        }
        String timestamp = Long.toHexString(DateTime.now().getMillis());

        return generate(randomStr, ipAddr, timestamp);
    }
}

