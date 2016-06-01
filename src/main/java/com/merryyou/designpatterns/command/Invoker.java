package com.merryyou.designpatterns.command;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }
    public void action(){
        command.exe();
    }
}
