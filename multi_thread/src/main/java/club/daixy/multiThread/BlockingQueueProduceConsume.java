
package club.daixy.multiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author daixiaoyong
 * @date 2021/4/1 14:03
 * @description 阻塞队列实现生产者消费者
 */

public class BlockingQueueProduceConsume {
    //默认开启，进行生产和消费
    private volatile boolean flag          = true;
    private AtomicInteger    atomicInteger = new AtomicInteger();

    BlockingQueue<String>    blockingQueue = null;

    public BlockingQueueProduceConsume(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //生产者
    public void myProd() throws InterruptedException {
        String data = null;
        boolean result = false;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            result = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + " 插入数据" + data + "到队列成功");
            } else {
                System.out.println(Thread.currentThread().getName() + " 插入数据" + data + "到队列失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "停止生产");
    }

    //消费者
    public void myConsumer() throws InterruptedException {
        String result = null;
        while (flag) {
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "超过2秒未取到数据，停止消费");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "取到数据:" + result + ",消费成功");
        }
    }

    public void stop() {
        flag = false;
    }

    public static void main(String[] args) {
        BlockingQueueProduceConsume myResource = new BlockingQueueProduceConsume(new ArrayBlockingQueue(20));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "生产线程启动");
            try {
                myResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "消费线程启动");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("5秒钟到，Main线程叫停，线程结束");

        myResource.stop();
    }
}
