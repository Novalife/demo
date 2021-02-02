package club.daixy.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author daixiaoyong
 * @date 2021/2/2 16:46
 * @description 线程池配置
 *
 */

@EnableAsync
@Configuration
public class ThreadPoolTaskConfig {

    //核心线程数（默认线程数），线程池创建时候初始化的线程数
    private static final int    corePoolSize     = 10;

    //最大线程数（线程池最大的线程数），只有在缓存队列满了之后才会申请超过核心线程数的线程
    private static final int    maxPoolSize      = 100;

    //允许线程空闲时间（单位：默认为秒），当超过了核心线程数之外的线程在空闲时间到达后会被销毁
    private static final int    keepAliveTime    = 10;

    //缓冲队列数，用来缓冲执行任务的队列
    private static final int    queueCapacity    = 200;

    //线程池名前缀，方便我们定位处理任务所在的线程池
    private static final String threadNamePrefix = "Async-service-";

    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);

        //线程池对拒绝任务的处理策略：CallerRunsPolicy-当线程池没有能力处理时，该策略会直接在execute方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //初始化
        executor.initialize();
        return executor;
    }
}
