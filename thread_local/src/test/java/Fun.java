
/**
 * @author daixiaoyong
 * @date 2021/3/10 14:46
 * @description
 */
public class Fun {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void fun() {
        String str = threadLocal.get();
        System.out.println(str);
    }
}