package club.daixy.demo.proxy;

/**
 * @author daixiaoyong
 * @date 2021/1/25 11:42
 * @description 被代理类
 */
public class Dog {
    public Dog() {
        System.out.println("Dog无参创建实例");
    }

    final public void run() {
        System.out.println("----start run----");
    }

    public void eat() {
        System.out.println("----start eat----");
    }
}
