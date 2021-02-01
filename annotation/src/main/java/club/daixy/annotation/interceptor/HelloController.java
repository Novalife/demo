package club.daixy.annotation.interceptor;

import club.daixy.annotation.aop.AnnotationService;
import club.daixy.annotation.aop.MyAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daixiaoyong
 * @date 2021/2/1 16:50
 * @description 自定义控制器
 */

@RestController
@RequestMapping("/test")
public class HelloController {
    @Autowired
    private AnnotationService annotationService;

    @GetMapping("hello")
    @MyAnnotation(key = "aaaa", value = "bbbb")
    public String hello() throws InterruptedException {
        System.out.println("hello begin ... ");
        annotationService.service("controller", 5);
        return "hello";
    }
}
