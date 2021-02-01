import club.daixy.demo.proxy.*;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daixiaoyong
 * @date 2021/1/25 10:48
 * @description 代理模式测试
 */

@SpringBootTest
public class ProxyTest {

    //静态代理
    @Test
    public void test1() {
        StaticProxy agent = new StaticProxy(new LiuYi());
        agent.saleHouse();
    }

    //jdk动态代理
    @Test
    public void test2() {
        JdkProxy jdkProxy = new JdkProxy();
        Owner instance = jdkProxy.getInstance(new LiuYi());
        instance.saleHouse();
    }

    //cglib动态代理
    @Test
    public void test3() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new DogMethodInterceptor());
        Dog proxyDog = (Dog)enhancer.create();
        proxyDog.eat();
//        proxyDog.run();
    }
}
