package club.daixy.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author daixiaoyong
 * @date 2021/2/2 16:34
 * @description 异步任务
 * 详细参考：https://blog.csdn.net/k0307x1990y/article/details/91950584
 */

@Component
@Async
public class AsyncTask {

    public Future<String> task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时：" + (end - begin));
        return new AsyncResult<>("任务1");
    }

    public Future<String> task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时：" + (end - begin));
        return new AsyncResult<>("任务2");
    }

    public Future<String> task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时：" + (end - begin));
        return new AsyncResult<>("任务3");
    }
}
