package threads.product_comsumer;

public class ThreadC extends Thread {
    private C c;

    ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}