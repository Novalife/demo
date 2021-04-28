package club.daixy.multiThread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author daixiaoyong
 * @date 2021/4/28 10:48
 * @description
 */
public class LockConditionPC {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private final int            MAX_SIZE      = 10;

    private LinkedList<Object>   list          = new LinkedList<>();

    private volatile boolean     flag          = true;

    private Lock                 lock          = new ReentrantLock();

    private Condition            condition     = lock.newCondition();

    public void produce() throws InterruptedException {
        while (flag) {
            lock.lock();
            while (list.size() == MAX_SIZE) {
                condition.await();
            }
            list.add(new Object());
            condition.signal();
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        while (flag) {
            lock.lock();
            while (list.size() == 0) {
                condition.await();
            }
            list.remove();
            condition.signal();
            lock.unlock();
        }
    }
}
