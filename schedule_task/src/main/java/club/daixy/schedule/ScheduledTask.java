package club.daixy.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author daixiaoyong
 * @date 2021/2/2 15:01
 * @description 任务调度
 */

@Component
public class ScheduledTask {

    private static final Logger           log        = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定时任务
     */
    @Scheduled(fixedRate = 3000)
    public void printCurrentTime() {
        log.info("Current time is:{}", dataFormat.format(new Date()));
    }
}
