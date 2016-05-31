package com.merryyou.redis;

import org.junit.Test;
/**
 * Created by YourName on 2015/10/26 0026.
 */
public class OrderDaoTest extends BaseTest {
    @Test
    public void orderDaoTest() {
        OrderDao orderDao = applicationContext.getBean(OrderDao.class);
        orderDao.save(order);
        System.out.println(orderDao.read("10000").getCreateDate());
        orderDao.delete("10000");
        System.out.println(orderDao.read("10000"));
    }
}
