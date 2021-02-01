package club.daixy.demo.mediator;

import lombok.Data;

/**
 * @author daixiaoyong
 * @date 2021/1/27 16:06
 * @description 中介者抽象类
 */

@Data
public abstract class Mediator {
    private Man   man;
    private Woman woman;

    public abstract void match(Persion persion);
}
