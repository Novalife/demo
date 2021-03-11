package club.daixy.threadLocal;

/**
 * @author daixiaoyong
 * @date 2021/3/10 14:46
 * @description
 */
public class Fun {

    public void fun() {
        String str = ThreadLocalUtils.get();
        System.out.println(str);
    }
}