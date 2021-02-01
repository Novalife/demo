import club.daixy.demo.chain.Leader;
import club.daixy.demo.chain.LeaveRequest;
import org.junit.Test;

/**
 * @author daixiaoyong
 * @date 2021/1/25 17:25
 * @description 责任链测试
 */

public class ChainTest {

    @Test
    public void test1() {
        LeaveRequest request = new LeaveRequest();
        request.setName("dxy");
        request.setLeaveDays(10);

        Leader leader1 = new Leader("直接经理",1);
        Leader leader2 = new Leader("项目经理",2);
        Leader leader3 = new Leader("总经理",3);
        leader1.setNextHandler(leader2);
        leader2.setNextHandler(leader3);

        leader1.handleRequest(request);
    }
}
