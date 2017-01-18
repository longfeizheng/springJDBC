package com.merryyou.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.testng.AssertJUnit.assertEquals;


/**
 * Created on 2016/11/10 0010.
 *
 * @author zlf
 * @since 1.0
 */
public class BeanFactoryTest {

    @org.junit.Test
    public void testBean(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
        assertEquals("testStr",myTestBean.getTestStr());
    }
}
