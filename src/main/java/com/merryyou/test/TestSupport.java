package com.merryyou.test;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2015/9/16 0016.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public final class TestSupport {

    /**
     * The logger instance.
     */
    private static Logger logger = LoggerFactory.getLogger(TestSupport.class);

    private Stopwatch stopwatch = null;

    /**
     * Sets up.
     *
     * @param testClass the test class
     * @throws Exception the exception
     */
    public void setUp(Object testClass) throws Exception {
        MDC.put("SeqID", RandomStringUtils.randomAlphabetic(10));
        stopwatch = Stopwatch.createStarted();

        MockitoAnnotations.initMocks(testClass);
    }

    /**
     * Tear down.
     *
     * @param method    the method
     * @param testClass the test class
     * @throws Exception the exception
     */
    public void tearDown(Method method, Object testClass) throws Exception {
        long duration = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        logger.info("Running '{}.{}' takes {} ({}ms).",
                testClass.getClass().getSimpleName(),
                method.getName(),
                DurationFormatUtils.formatDurationWords(duration, true, true),
                duration);
    }
}
