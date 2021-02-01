package club.daixy.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author daixiaoyong
 * @date 2021/2/1 15:39
 * @description 切面类：获取标注了自定义注解的方法，织入切面逻辑
 */
@Component
@Aspect
public class AuthAspect {

    /**
     * 定义切点，即标注了该注解的方法
     */
    @Pointcut("@annotation(club.daixy.annotation.aop.MyAnnotation)")
    public void authPointCut() {

    }

    @Around("authPointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("before ... ");
        try {
            StopWatch sw = new StopWatch();
            sw.start();
            //获取方法参数
            Object[] args = joinPoint.getArgs();
            MethodSignature sign = (MethodSignature) joinPoint.getSignature();
            String[] parameterNames = sign.getParameterNames();
            System.out.println("parameter list: ");
            for (int i = 0; i < parameterNames.length; i++) {
                System.out.println(parameterNames[i] + "=" + args[i]);
            }
            //获取注解参数
            MyAnnotation annotation = sign.getMethod().getAnnotation(MyAnnotation.class);
            System.out.println("Key = " + annotation.key());
            System.out.println("Value = " + annotation.value());

            //执行方法
            joinPoint.proceed();

            //方法执行后逻辑
            sw.stop();
            System.out.println(sw.prettyPrint());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
