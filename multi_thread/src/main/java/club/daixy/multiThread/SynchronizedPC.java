package club.daixy.multiThread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author daixiaoyong
 * @date 2021/4/28 10:48
 * @description
 */
public class SynchronizedPC {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private final int            MAX_SIZE      = 10;

    private LinkedList<Object>   list          = new LinkedList<>();

    private volatile boolean     flag          = true;

    public void produce() throws InterruptedException {
        while (flag) {
            synchronized (list) {
                while (list.size() == MAX_SIZE) {
                    list.wait();
                }
                list.add(atomicInteger.getAndIncrement());
                list.notifyAll();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (flag) {
            synchronized (list) {
                while (list.size() == 0) {
                    list.wait();
                }
                list.remove();
                list.notifyAll();
            }
        }
    }
}
