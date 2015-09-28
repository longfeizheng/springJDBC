package com.merryyou.test;

import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

/**
 * Created on 2015/9/16 0016.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class AbstractTransactionalSpringExtendedTest extends
        AbstractTransactionalTestNGSpringContextTests {

    private TestSupport testSupport = new TestSupport();

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @BeforeMethod
    public void setUp() throws Exception {
        testSupport.setUp(this);
    }

    /**
     * Tear down.
     *
     * @param method the method
     * @throws Exception the exception
     */
    @AfterMethod
    public void tearDown(Method method) throws Exception {
        testSupport.tearDown(method, this);
    }
}

