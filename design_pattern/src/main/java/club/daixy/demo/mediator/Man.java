package club.daixy.demo.mediator;

/**
 * @author daixiaoyong
 * @date 2021/1/27 16:34
 * @description 男人
 */
public class Man extends Persion {

    public Man(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    @Override
    public void match(Persion persion) {
        this.getMediator().setMan(this);
        this.getMediator().match(persion);
    }
}
