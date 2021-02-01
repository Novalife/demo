package club.daixy.demo.mediator;

/**
 * @author daixiaoyong
 * @date 2021/1/27 16:40
 * @description 具体中介者
 */
public class ConcreateMediator extends Mediator {

    @Override
    public void match(Persion persion) {
        if (persion instanceof Man) {
            this.setMan((Man) persion);
        } else {
            this.setWoman((Woman) persion);
        }

        if (this.getMan() == null || this.getWoman() == null) {
            System.out.println("i am not a gay");
        } else {
            if (this.getMan().getCondition() == this.getWoman().getCondition()) {
                System.out.println(this.getMan().getName() + "先生与" + this.getWoman().getName() + "女士配对成功");
            } else {
                System.out.println(this.getMan().getName() + "先生与" + this.getWoman().getName() + "女士配对失败");
            }
        }

        //比较之后，将条件置空。否则会影响下一次匹配
        this.setMan(null);
        this.setWoman(null);
    }
}
