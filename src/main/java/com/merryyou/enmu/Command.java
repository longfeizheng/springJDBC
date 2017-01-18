package com.merryyou.enmu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public enum Command {
    ADD("add"),
    INSERT("insert"),
    UPDATE("update"),
    DEL("delete");
    private String commandStr;
    Command(String str) {
        this.commandStr = str;
    }
    private static final Map<String, Command> stringToCommand = new HashMap<String, Command>();

    static {
        for(Command item : values()){
            stringToCommand.put(item.toString(), item);
        }
    }

    public static Command fromString(String commandStr){
        return stringToCommand.get(commandStr);
    }

    @Override
    public String toString() {
        return this.commandStr;
    }
}
