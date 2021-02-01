package club.daixy.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author daixiaoyong
 * @date 2021/1/25 11:03
 * @description jdk动态代理
 */
public class JdkProxy implements InvocationHandler {
    private Owner owner;

    public Owner getInstance(Owner owner) {
        this.owner = owner;
        Class<? extends Owner> clazz = owner.getClass();
        return (Owner) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.owner, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("find buyer，对价格进行初步筛选，合适的话才可以与房东进一步沟通");
    }

    private void after() {
        System.out.println("卖房后期流程");
    }
}
