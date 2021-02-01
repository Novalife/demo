package club.daixy.annotation.aop;

import org.springframework.stereotype.Component;

/**
 * @author daixiaoyong
 * @date 2021/2/1 16:08
 * @description 测试service
 */
@Component
public class AnnotationService {

    @MyAnnotation(key = "dai", value = "xiaoyong")
    public void service(String str, Integer num) throws InterruptedException {
        System.out.println("method excute");
        Thread.sleep(1000);
    }
}
