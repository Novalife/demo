package club.daixy.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author daixiaoyong
 * @date 2021/2/2 17:32
 * @description 异步任务执行控制器
 */

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private AsyncTask task;

    @GetMapping("/async")
    public String executeTask() throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();

        Future<String> result1 = task.task1();
        Future<String> result2 = task.task2();
        Future<String> result3 = task.task3();

//        while (true) {
//            if (result1.isDone() && result2.isDone() && result3.isDone()) {
//                break;
//            }
//        }

        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

        long end = System.currentTimeMillis();

        long total = end - begin;
        System.out.println("多任务执行总耗时=" + total);
        return String.valueOf(total);
    }
}
