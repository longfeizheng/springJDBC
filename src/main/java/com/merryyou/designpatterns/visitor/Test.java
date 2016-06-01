package com.merryyou.designpatterns.visitor;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}
