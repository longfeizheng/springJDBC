package com.merryyou.enmu;

/**
 *
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class OriDemo {
    public static final String ADD = "add";
    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    public static final String DEL = "deltete";

    public static void main(String[] args) {
//        test("add");
        test("111");//参数不符合要求的时候也可以执行
    }

    public static void test(String str){
        switch (str){
            case ADD:
                System.out.println("add");
                break;
            case INSERT:
                System.out.println("insert");
                break;
            case UPDATE:
                System.out.println("update");
                break;
            case DEL:
                System.out.println("del");
                break;
            default:
                System.out.println("参数异常");
        }
    }
}
