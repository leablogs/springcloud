package threads.maps;

import java.util.HashMap;
import java.util.UUID;

/**
 * 并发执行put操作时会引起死循环，是因为多线程会导致hashmap的Entry链表行程环形数据结构
 * 一旦行程环形数据结构，Entry的next节点永远不会为空，就会产生死循环获取entry
 */
public class HashMapDemo {
    final static HashMap<String, String> map = new HashMap<>(2);

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    });
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

}
