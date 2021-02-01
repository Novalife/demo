package club.daixy.demo.chain;

import lombok.Data;

/**
 * @author daixiaoyong
 * @date 2021/1/25 16:54
 * @description 处理人
 */

@Data
public class Leader extends LeaveHandler {

    /** 级别 */
    private int    leavel;

    /** 下一个处理人 */
    private Leader nextHandler;

    public Leader(String handlerName, int leavel) {
        this.handlerName = handlerName;
        this.leavel = leavel;
    }

    private int handleDays(int leavel) {
        if (leavel == 1) {
            return this.MIN;
        } else if (leavel == 2) {
            return this.MIDDLE;
        } else if (leavel == 3) {
            return this.MAX;
        } else {
            return 0;
        }
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= handleDays(this.leavel)) {
            System.out.println(handlerName + "处理完毕");
            return;
        }
        if (this.nextHandler != null) {
            this.nextHandler.handleRequest(request);
        } else {
            System.out.println("流程结束");
        }
    }
}
