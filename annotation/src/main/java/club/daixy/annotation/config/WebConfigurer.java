package club.daixy.annotation.config;

import club.daixy.annotation.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author daixiaoyong
 * @date 2021/2/2 10:37
 * @description 自定义配置类
 */

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    //这个方法用来注册拦截器，我们自己写好的拦截器需要通过在这里注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register");
    }

    //这个方法用来配置静态资源，比如html,js,css等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
