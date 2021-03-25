package club.daixy.multiThread;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author daixiaoyong
 * @date 2021/3/25 9:59
 * @description 手写生产者消费者
 */

//生产者不断生产芒果冰沙存放在柜台，消费者从柜台取
public class MangoIceProduceConsume {

    //柜台最多存放10杯芒果冰沙
    private final int MAX_SIZE = 10;

    //芒果冰沙内部类
    private class MangoIce {
    }

    //存放芒果冰沙的柜台（就像个容器）
    private final LinkedList<MangoIce> mangoIceLinkedList = new LinkedList<>();

    //生产
    public void produce() {
        while (true) {
            //加锁，开始准备生产
            synchronized (mangoIceLinkedList) {
                //如果仓库满了，就不能继续生产，生产者调wait进入等待，同时释放锁
                while (mangoIceLinkedList.size() == MAX_SIZE) {
                    try {
                        //释放锁
                        mangoIceLinkedList.wait();
                        //下一次被唤醒后从这里开始执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //柜台未满，开始生产
                mangoIceLinkedList.add(new MangoIce());
                System.out.println("【生产后剩余的冰沙数】：" + mangoIceLinkedList.size());
                //生产完一杯后立即唤醒所有等待的消费者线程，notifyAll也会释放锁
                mangoIceLinkedList.notifyAll();
                //让线程休眠一会，给唤醒的线程执行机会
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费
    public void consume() {
        while (true) {
            synchronized (mangoIceLinkedList) {
                //如果仓库为空，不用消费
                while (mangoIceLinkedList.size() == 0) {
                    try {
                        mangoIceLinkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //消费芒果冰沙
                mangoIceLinkedList.remove();
                System.out.println("【消费后剩余的冰沙数】：" + mangoIceLinkedList.size());
                //唤醒其他生产者或者消费者去执行
                mangoIceLinkedList.notifyAll();
                //让线程休眠一会，给唤醒的线程执行机会
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MangoIceProduceConsume produceConsume = new MangoIceProduceConsume();
        for (int i = 0; i < 10; i++) {
            executorService.submit(produceConsume::produce);
            executorService.submit(produceConsume::consume);
        }
    }
}
