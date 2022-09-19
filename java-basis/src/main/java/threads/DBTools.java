package threads;

import cn.hutool.db.Db;
import com.sun.jna.platform.win32.DBT;

public class DBTools {
    volatile private boolean prevIsA = false;

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();

        for (int i = 0; i < 20; i++) {
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }

    synchronized public void backupA() {

        try {
            while (prevIsA == true) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("★★★★★★★★");
            }
            prevIsA = true;

            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB() {
        try {
            while (prevIsA == false) {
                wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("☆☆☆☆☆☆☆☆");
            }
            prevIsA = false;

            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BackupA extends Thread {
    private DBTools dbTools;

    BackupA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}

class BackupB extends Thread {
    private DBTools dbTools;

    BackupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}