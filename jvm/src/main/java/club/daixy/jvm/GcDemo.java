package club.daixy.jvm;

/**
 * @author daixiaoyong
 * @date 2021/4/2 16:38
 * @description GC
 */
public class GcDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
    }
}