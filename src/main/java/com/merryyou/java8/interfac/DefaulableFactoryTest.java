package com.merryyou.java8.interfac;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class DefaulableFactoryTest {
    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.notRequired());

        Defaulable defaulable1 = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable1.notRequired());
    }
}
