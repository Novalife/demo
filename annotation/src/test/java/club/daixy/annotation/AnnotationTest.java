package club.daixy.annotation;

import club.daixy.annotation.aop.AnnotationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daixiaoyong
 * @date 2021/2/1 16:18
 * @description 自定义注解测试
 */

@SpringBootTest
public class AnnotationTest {

    @Autowired
    private AnnotationService annotationService;

    @Test
    public void aopTest() throws InterruptedException {
        annotationService.service("param", 2);
    }
}
