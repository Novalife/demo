package club.daixy.demo.chain;

import lombok.Data;

/**
 * @author daixiaoyong
 * @date 2021/1/25 16:44
 * @description 请假参数
 */

@Data
public class LeaveRequest {

    private String name;

    private int    leaveDays;
}
