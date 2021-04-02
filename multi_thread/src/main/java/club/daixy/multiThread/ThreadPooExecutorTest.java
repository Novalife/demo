package club.daixy.multiThread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author daixiaoyong
 * @date 2021/4/2 10:37
 * @description 自定义线程池
 */
public class ThreadPooExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        /**
         * 线程池最多能接受maxSize+队列容量的任务数，当任务数量超过时，触发拒绝策略
         * 1、AbortPolicy：直接抛出RejectedExecutionException异常阻止系统正常运行
         * 2、CallerRunsPolicy：不抛异常，将任务回退给调用者去执行（main 线程处理任务）
         * 3、DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务
         * 4、DiscardPlicy：直接丢弃任务，不予任何处理也不抛出异常，如果允许任务丢失，这是最好的一种方案
         */
        try {
            for (int i = 1; i <= 15; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 线程处理任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        //查看服务器的CPU处理器数量
        /**
         * 1、CPU 密集型：
         * CPU 密集的意思是该任务需要大量的运算，而没有阻塞，CPU 一直全速运行
         * CPU 密集型任务尽可能的少的线程数量，一般为 CPU 核数 + 1 个线程的线程池
         * 2、IO 密集型：
         * 由于 IO 密集型任务线程并不是一直在执行任务，可以多分配一点线程数，如 CPU * 2
         * 也可以使用公式：CPU 核数 / (1 - 阻塞系数)；其中阻塞系数在 0.8 ～ 0.9 之间
         */
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
