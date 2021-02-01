package club.daixy.threadLocal;

/**
 * @author daixiaoyong
 * @date 2019/11/21 16:40
 */

public class ThreadLocalTest {

    //    static ThreadLocal<String> localVar = new ThreadLocal<>();
    //
    //    static void print(String str) {
    //        //打印当前线程中本地内存中本地变量的值
    //        System.out.println(str + " :" + localVar.get());
    //        //清除本地内存中的本地变量
    //        localVar.remove();
    //    }

    public static void main(String[] args) {
        //        Thread t1 = new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                //设置线程1中本地变量的值
        //                localVar.set("localVar1");
        //                //调用打印方法
        //                print("thread1");
        //                //打印本地变量
        //                System.out.println("after remove : " + localVar.get());
        //            }
        //        });
        //
        //        Thread t2 = new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                //设置线程1中本地变量的值
        //                localVar.set("localVar2");
        //                //调用打印方法
        //                print("thread2");
        //                //打印本地变量
        //                System.out.println("after remove : " + localVar.get());
        //            }
        //        });
        //
        //        t1.start();
        //        t2.start();

        //-----------------------------------------
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        fun1(threadLocal);
        fun2(threadLocal);
    }

    private static void fun1(ThreadLocal<String> threadLocal) {
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("dxy");
    }

    private static void fun2(ThreadLocal<String> threadLocal) {
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        String s = threadLocal.get();
        System.out.println(s);
    }

}
