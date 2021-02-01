package club.daixy.demo.chain;

/**
 * @author daixiaoyong
 * @date 2021/1/25 16:45
 * @description 请假责任链抽象处理类
 */
public abstract class LeaveHandler {
    /** 直接主管审批处理的请假天数 */
    protected int          MIN    = 1;
    /** 项目经理审批处理的请假天数 */
    protected int          MIDDLE = 3;
    /** 总经理处理的请假天数 */
    protected int          MAX    = 30;

    /** 处理人名称 */
    protected String       handlerName;

    /** 处理请假请求 */
    protected abstract void handleRequest(LeaveRequest request);
}
