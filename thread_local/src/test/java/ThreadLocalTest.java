import org.junit.Test;

/**
 * @author daixiaoyong
 * @date 2021/3/10 14:27
 * @description
 */

public class ThreadLocalTest {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Test
    public void test(){
        threadLocal.set("dxy");
        Fun fun = new Fun();
        fun.fun();
    }
}