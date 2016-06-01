package com.merryyou.designpatterns.decorator;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 * 1、需要扩展一个类的功能。
2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）
缺点：产生过多相似的对象，不易排错！
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable sourceable = new Source();
        Sourceable obj = new Decorator(sourceable);
        obj.method();
    }
}
