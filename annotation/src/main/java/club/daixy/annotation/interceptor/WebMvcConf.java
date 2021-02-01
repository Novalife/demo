package club.daixy.annotation.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author daixiaoyong
 * @date 2021/2/1 16:56
 * @description 自定义拦截器
 */
@Configuration
public class WebMvcConf implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //使拦截器生效，此处参数是我们自定义的拦截器名
        registry.addInterceptor(new MyInterceptor());
        //添加拦截规则
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
