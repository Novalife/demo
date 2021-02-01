package club.daixy.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义注解
 * 详细参考：https://jverson.com/spring-boot-demo/other/self-definied-annotation.html
 */
@SpringBootApplication
public class AnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }

}
