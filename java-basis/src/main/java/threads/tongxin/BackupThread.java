package threads.tongxin;

/**
 * 通过通信方式实现数据交叉备份
 */
public class BackupThread {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();

        for (int i = 0; i < 20; i++) {
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }

    static class DBTools {
        volatile private boolean prevIsA = false;
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

    static class BackupA extends Thread {
        private DBTools dbTools;

        BackupA(DBTools dbTools) {
            this.dbTools = dbTools;
        }

        @Override
        public void run() {
            dbTools.backupA();
        }
    }

    static class BackupB extends Thread {
        private DBTools dbTools;

        BackupB(DBTools dbTools) {
            this.dbTools = dbTools;
        }

        @Override
        public void run() {
            dbTools.backupB();
        }
    }
}
