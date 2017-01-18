package com.merryyou.annotation;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class ProcessingTest {
    public static void main(String[] args) throws NumException, IllegalAccessException {
        Student student = new Student();
        student.setId("ccc");
        student.setName("姓名");
        student.setAge(18);
        student.setSex("男");
        System.out.println(new Processing().save(student));
    }
}
