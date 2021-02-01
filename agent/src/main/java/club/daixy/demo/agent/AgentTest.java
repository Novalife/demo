package club.daixy.demo.agent;

import java.lang.instrument.Instrumentation;

/**
 * @description 代理
 * @author	daixiaoyong
 * @date 2019/12/12 10:44
 **/
public class AgentTest {
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("====premain 方法执行");
        System.out.println(agentOps);
    }

    public static void premain(String agentOps) {
        System.out.println("====premain 方法2执行");
        System.out.println(agentOps);
    }

    public static void main(String[] args) {
        System.out.println("====main 方法执行");
    }
}
