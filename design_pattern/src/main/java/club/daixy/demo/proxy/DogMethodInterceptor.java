package club.daixy.demo.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @author daixiaoyong
 * @date 2021/1/25 11:51
 * @description 自定义MethodInterceptor
 */
public class DogMethodInterceptor implements MethodInterceptor {

    /**
     * @param obj cglib生成的代理对象
     * @param method 被代理对象方法
     * @param args 方法入参
     * @param proxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("-------插入前置通知--------");
        //这里是对目标类进行增强，注意这里的方法调用，不是反射！
        Object invoke = proxy.invokeSuper(obj, args);
        System.out.println("-------插入后置通知--------");
        return invoke;
    }
}
