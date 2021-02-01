package club.daixy.annotation.aop;

import java.lang.annotation.*;

/**
 * @author daixiaoyong
 * @date 2021/2/1 15:25
 * @description 自定义注解类型
 */

@Target({ ElementType.TYPE, ElementType.METHOD }) //作用于：类、方法
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期：运行时
@Documented
public @interface MyAnnotation {
    String key() default "default key";

    String value() default "";
}
