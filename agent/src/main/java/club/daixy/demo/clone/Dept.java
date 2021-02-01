package club.daixy.demo.clone;

import lombok.Data;

/**
 * @author daixiaoyong
 * @date 2021/1/23 9:40
 * @description
 */

@Data
public class Dept implements Cloneable{
    private int    deptNo;

    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}