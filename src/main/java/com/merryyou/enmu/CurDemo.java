package com.merryyou.enmu;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class CurDemo {
    public static void main(String[] args) {
        test(Command.ADD);
    }
    public static void test(Command command) {
        switch (command){
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
        }
    }

}
