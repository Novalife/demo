package club.daixy.annotation.interceptor;

import club.daixy.annotation.aop.MyAnnotation;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author daixiaoyong
 * @date 2021/2/1 16:32
 * @description 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("MyInterceptor begin");
        MyAnnotation annotation = null;
        if (handler instanceof HandlerMethod) {
            System.out.println("method name = " + ((HandlerMethod) handler).getMethod().getName());
            annotation = ((HandlerMethod) handler).getMethodAnnotation(MyAnnotation.class);
            if (annotation == null) {
                return true;
            }

            String key = annotation.key();
            String value = annotation.value();
            System.out.println("MyAnnotation: key = " + key + ", value = " + value);
            if (!StringUtils.isEmpty(value)) {
                System.out.println("这里可以实现例如校验权限等业务逻辑");
//                return false;
            }
        }
        return true;
    }
}
