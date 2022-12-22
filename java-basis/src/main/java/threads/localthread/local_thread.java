package threads.localthread;

public class local_thread {
//    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
//        if (t1.get() == null) {
//            System.out.println("从未放入任何值");
//            t1.set("我是新放入");
//        }
//        System.out.println(t1.get());
//        System.out.println(t1.get());
        try {
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();
            for (int i = 0; i < 100; i++) {
                Tools.t1.set("Main" + (i + 1));
                System.out.println("main get value=" + Tools.t1.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Tools.t1.set("ThreadA" + (i + 1));
                    System.out.println("ThreadA get Value=" + Tools.t1.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Tools.t1.set("ThreadB" + (i + 1));
                    System.out.println("ThreadB get Value=" + Tools.t1.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Tools {
        public static ThreadLocal t1 = new ThreadLocal();
    }
}
