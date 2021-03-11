package club.daixy.threadLocal;

/**
 * @author daixiaoyong
 * @date 2021/3/11 10:54
 * @description
 */
public class ThreadLocalUtils {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void set(String str) {
        threadLocal.set(str);
    }

    public static String get(){
        return threadLocal.get();
    }
}
