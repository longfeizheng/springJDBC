package com.merryyou.designpatterns.state;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();
    }
}
