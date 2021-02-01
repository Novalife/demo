package club.daixy.demo.mediator;

import lombok.Data;

/**
 * @author daixiaoyong
 * @date 2021/1/27 16:30
 * @description 人抽象类
 */

@Data
public abstract class Persion {
    private String   name;

    private int      condition;

    private Mediator mediator;

    public Persion(String name, int condition, Mediator mediator) {
        this.name = name;
        this.condition = condition;
        this.mediator = mediator;
    }

    /** 相亲 */
    public abstract void match(Persion persion);
}
