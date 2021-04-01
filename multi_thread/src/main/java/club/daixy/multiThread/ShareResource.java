package club.daixy.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author daixiaoyong
 * @date 2021/4/1 15:30
 * @description synchronized与lock的区别
 *              详细参考：https://www.yuque.com/wenxin-ygowx/wzgykk/vtco42
 */
public class ShareResource {
    //此处为何无需加volatile？
    private int       number = 1;                  //A:1, B:2, C:3
    private Lock      lock   = new ReentrantLock();
    private Condition c1     = lock.newCondition();
    private Condition c2     = lock.newCondition();
    private Condition c3     = lock.newCondition();

    public void print5(int tem) {
        lock.lock();
        try {
            //1.判断
            while (number != 1) {
                c1.await();
            }
            //2干活
            for (int i = 0; i < tem; i++) {
                System.out.println(Thread.currentThread().getName() + "\t :" + i);
            }

            //通知
            number = 2;
            c2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int tem) {
        lock.lock();
        try {
            //1.判断
            while (number != 2) {
                c2.await();
            }
            //2干活
            for (int i = 0; i < tem; i++) {
                System.out.println(Thread.currentThread().getName() + "\t :" + i);
            }

            //通知
            number = 3;
            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int tem) {
        lock.lock();
        try {
            //1.判断
            while (number != 3) {
                c3.await();
            }
            //2干活
            for (int i = 0; i < tem; i++) {
                System.out.println(Thread.currentThread().getName() + "\t :" + i);
            }

            //通知
            number = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print5(5);
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10(10);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print15(15);
            }
        }, "C").start();
    }
}
