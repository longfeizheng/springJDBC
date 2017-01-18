package com.merryyou.enmu;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Created on 2016/11/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class LightTest {
    //1.定义枚举类型

    public static void main(String[] args) {
        //1.遍历枚举类型
        System.out.println("演示枚举类型的遍历。。。。。");
        testTraversalEnum();
        //2.演示EnumMap对象的使用
        System.out.println("演示EnumMap对象的使用。。。。。");
        testEnumMap();
        //3.演示EnumSet对象的使用
        System.out.println("演示EnumSet对象的使用。。。。。");
        testEnumSet();
    }

    /**
     * 演示EnumSet对象的使用 EnumSet是一个抽象类，获取一个类型的枚举类型内容<BR/>
     */
    private static void testEnumSet() {
        EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);
        for (Light aLightSetElement : currEnumSet) {
            System.out.println("当前EnumSet中数据为：" + aLightSetElement);
        }
    }

    /**
     * 演示EnumMap对象的使用 EnumMap跟HashMap的使用差不多，只不过key要是枚举类型
     */
    private static void testEnumMap() {
        EnumMap<Light, String> currEnumMap = new EnumMap<Light, String>(Light.class);
        currEnumMap.put(Light.GREEN, "绿灯");
        currEnumMap.put(Light.RED, "红灯");
        currEnumMap.put(Light.YELLLOW, "黄灯");

        for (Light light : Light.values()) {
            System.out.println("[key=" + light.name() + ",value=" + currEnumMap.get(light) + "]");
        }
    }

    /**
     * 演示枚举类型遍历
     */
    private static void testTraversalEnum() {
        Light[] values = Light.values();
        for (Light light : values) {
            System.out.println("当前灯name:" + light.name());
            System.out.println("当前灯ordinal:" + light.ordinal());
            System.out.println("当前灯name:" + light);
        }
    }

    public enum Light {
        //利用构造函数传参
        RED(1), GREEN(2), YELLLOW(3);
        //定义私有变量
        private int nCode;

        Light(int _nCode) {
            this.nCode = _nCode;
        }

        @Override
        public String toString() {
            return String.valueOf(nCode);
        }
    }
}
