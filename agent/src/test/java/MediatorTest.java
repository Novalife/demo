import club.daixy.demo.mediator.*;
import org.junit.Test;

/**
 * @author daixiaoyong
 * @date 2021/1/27 16:47
 * @description 中介者模式测试
 */
public class MediatorTest {

    @Test
    public void test() {
        Mediator mediator = new ConcreateMediator();
        Persion xiaoming = new Man("小明", 1, mediator);
        Persion lisi = new Man("李四", 2, mediator);
        Persion xiaohong = new Woman("小红", 1, mediator);

        xiaoming.match(lisi);
        lisi.match(xiaohong);
        xiaoming.match(xiaohong);

    }
}
