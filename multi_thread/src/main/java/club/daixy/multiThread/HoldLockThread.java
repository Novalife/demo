package club.daixy.multiThread;

/**
 * @author daixiaoyong
 * @date 2021/4/2 11:19
 * @description 死锁及排查
 */
public class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 持有：" + lockA + "\t 尝试获得：" + lockB);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 持有：" + lockB + "\t 尝试获得：" + lockA);
            }

        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA, lockB), "AAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "BBB").start();
    }

    /**
     * 1、查看进程
     * D:\code\demo>jps -l
     * 16456 club.daixy.multiThread.HoldLockThread
     * 11180
     * 13932 org.jetbrains.jps.cmdline.Launcher
     * 14684 sun.tools.jps.Jps
     *
     * 2、查看栈信息
     *D:\code\demo>jstack 16456
     * 2021-04-02 15:52:47
     * Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.212-b10 mixed mode):
     *
     * "DestroyJavaVM" #14 prio=5 os_prio=0 tid=0x0000000002c32800 nid=0x4c9c waiting on condition [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "BBB" #13 prio=5 os_prio=0 tid=0x000000001e806000 nid=0x4978 waiting for monitor entry [0x000000001f61e000]
     *    java.lang.Thread.State: BLOCKED (on object monitor)
     *         at club.daixy.multiThread.HoldLockThread.run(HoldLockThread.java:22)
     *         - waiting to lock <0x000000076b57e788> (a java.lang.String)
     *         - locked <0x000000076b57e7c0> (a java.lang.String)
     *         at java.lang.Thread.run(Thread.java:748)
     *
     * "AAA" #12 prio=5 os_prio=0 tid=0x000000001e805000 nid=0x4a28 waiting for monitor entry [0x000000001f51f000]
     *    java.lang.Thread.State: BLOCKED (on object monitor)
     *         at club.daixy.multiThread.HoldLockThread.run(HoldLockThread.java:22)
     *         - waiting to lock <0x000000076b57e7c0> (a java.lang.String)
     *         - locked <0x000000076b57e788> (a java.lang.String)
     *         at java.lang.Thread.run(Thread.java:748)
     *
     * "Service Thread" #11 daemon prio=9 os_prio=0 tid=0x000000001e702000 nid=0x2ee8 runnable [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "C1 CompilerThread3" #10 daemon prio=9 os_prio=2 tid=0x000000001e6e4800 nid=0x58c waiting on condition [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "C2 CompilerThread2" #9 daemon prio=9 os_prio=2 tid=0x000000001e6e1000 nid=0x3164 waiting on condition [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "C2 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x000000001e6de000 nid=0xe3c waiting on condition [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x000000001e6db000 nid=0x1098 waiting on condition [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x000000001e6d8000 nid=0x3808 runnable [0x000000001ee1e000]
     *    java.lang.Thread.State: RUNNABLE
     *         at java.net.SocketInputStream.socketRead0(Native Method)
     *         at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
     *         at java.net.SocketInputStream.read(SocketInputStream.java:171)
     *         at java.net.SocketInputStream.read(SocketInputStream.java:141)
     *         at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
     *         at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
     *         at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
     *         - locked <0x000000076b6cf4e8> (a java.io.InputStreamReader)
     *         at java.io.InputStreamReader.read(InputStreamReader.java:184)
     *         at java.io.BufferedReader.fill(BufferedReader.java:161)
     *         at java.io.BufferedReader.readLine(BufferedReader.java:324)
     *         - locked <0x000000076b6cf4e8> (a java.io.InputStreamReader)
     *         at java.io.BufferedReader.readLine(BufferedReader.java:389)
     *         at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:47)
     *
     * "Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000001e5b0800 nid=0x4ad4 waiting on condition [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001e55a800 nid=0x2364 runnable [0x0000000000000000]
     *    java.lang.Thread.State: RUNNABLE
     *
     * "Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001e541000 nid=0x35e4 in Object.wait() [0x000000001eb1f000]
     *    java.lang.Thread.State: WAITING (on object monitor)
     *         at java.lang.Object.wait(Native Method)
     *         - waiting on <0x000000076b408ed0> (a java.lang.ref.ReferenceQueue$Lock)
     *         at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:144)
     *         - locked <0x000000076b408ed0> (a java.lang.ref.ReferenceQueue$Lock)
     *         at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:165)
     *         at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:216)
     *
     * "Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x000000001c74d800 nid=0x2954 in Object.wait() [0x000000001ea1f000]
     *    java.lang.Thread.State: WAITING (on object monitor)
     *         at java.lang.Object.wait(Native Method)
     *         - waiting on <0x000000076b406bf8> (a java.lang.ref.Reference$Lock)
     *         at java.lang.Object.wait(Object.java:502)
     *         at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
     *         - locked <0x000000076b406bf8> (a java.lang.ref.Reference$Lock)
     *         at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)
     *
     * "VM Thread" os_prio=2 tid=0x000000001c748000 nid=0x4498 runnable
     *
     * "GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000002c48800 nid=0x43e0 runnable
     *
     * "GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000002c4a000 nid=0x3f1c runnable
     *
     * "GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002c4c000 nid=0x4590 runnable
     *
     * "GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002c4d800 nid=0x3348 runnable
     *
     * "GC task thread#4 (ParallelGC)" os_prio=0 tid=0x0000000002c4f800 nid=0x4958 runnable
     *
     * "GC task thread#5 (ParallelGC)" os_prio=0 tid=0x0000000002c51000 nid=0x2d84 runnable
     *
     * "GC task thread#6 (ParallelGC)" os_prio=0 tid=0x0000000002c54000 nid=0x4508 runnable
     *
     * "GC task thread#7 (ParallelGC)" os_prio=0 tid=0x0000000002c56000 nid=0x3e34 runnable
     *
     * "VM Periodic Task Thread" os_prio=2 tid=0x000000001e7c1800 nid=0xa8c waiting on condition
     *
     * JNI global references: 12
     *
     *
     * Found one Java-level deadlock:
     * =============================
     * "BBB":
     *   waiting to lock monitor 0x0000000002d2e6e8 (object 0x000000076b57e788, a java.lang.String),
     *   which is held by "AAA"
     * "AAA":
     *   waiting to lock monitor 0x0000000002d2bda8 (object 0x000000076b57e7c0, a java.lang.String),
     *   which is held by "BBB"
     *
     * Java stack information for the threads listed above:
     * ===================================================
     * "BBB":
     *         at club.daixy.multiThread.HoldLockThread.run(HoldLockThread.java:22)
     *         - waiting to lock <0x000000076b57e788> (a java.lang.String)
     *         - locked <0x000000076b57e7c0> (a java.lang.String)
     *         at java.lang.Thread.run(Thread.java:748)
     * "AAA":
     *         at club.daixy.multiThread.HoldLockThread.run(HoldLockThread.java:22)
     *         - waiting to lock <0x000000076b57e7c0> (a java.lang.String)
     *         - locked <0x000000076b57e788> (a java.lang.String)
     *         at java.lang.Thread.run(Thread.java:748)
     *
     * Found 1 deadlock.
     */
}
