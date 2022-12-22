package threads.product_comsumer;

public class ThreadP extends Thread {
    private P p;

    ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
