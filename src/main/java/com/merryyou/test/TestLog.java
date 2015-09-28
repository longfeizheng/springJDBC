package com.merryyou.test;

import org.slf4j.Logger;

/**
 * Created on 2015/9/17 0017.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class TestLog {
    private static final Logger logger =
            org.slf4j.LoggerFactory.getLogger(TestLog.class);
    public static void main(String[] args){
        logger.info("hello world");
        logger.error("ERROR");
    }
}
