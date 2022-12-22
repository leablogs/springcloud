package threads.conditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界队列
 * 当队列为空时，队列获取操作将会阻塞获取线程，知道队列有新增加元素
 * 当队列满时，队列插入操作将会阻塞插入线程，知道队列出现空位
 */
public class BoundedQueue<T> {
    private Object[] items;
    // 添加下标，删除的下表和数组当前数量
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    BoundedQueue(int size) {
        items = new Object[size];
    }

    //添加一个元素，如果数组满，则添加线程进入等待状态，直到有空位
    public void add(T t) throws InterruptedException {
        lock.lock();

        try {
            while (count == items.length) {
                notFull.wait();
            }
            items[addIndex] = t;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 由头部删除一个元素，如果数组为空，则删除线程进入等待状态，知道有新元素添加
    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            ;
            return (T) x;
        } finally {
            lock.unlock();
        }
    }
}
