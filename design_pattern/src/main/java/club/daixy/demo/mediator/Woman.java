package club.daixy.demo.mediator;

/**
 * @author daixiaoyong
 * @date 2021/1/27 16:36
 * @description
 */
public class Woman extends Persion {

    public Woman(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    @Override
    public void match(Persion persion) {
        this.getMediator().setWoman(this);
        this.getMediator().match(persion);
    }
}
