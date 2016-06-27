package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class BackupB extends Thread{
    private DBTools dbTools;
    public BackupB(DBTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
