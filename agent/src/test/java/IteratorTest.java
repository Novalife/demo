import club.daixy.demo.iterator.Aggregate;
import club.daixy.demo.iterator.ConcreateAggreate;
import club.daixy.demo.iterator.Iterator;
import org.junit.Test;

/**
 * @author daixiaoyong
 * @date 2021/1/27 14:53
 * @description 迭代器模式测试
 */
public class IteratorTest {

    @Test
    public void test() {
        Aggregate ag = new ConcreateAggreate();
        ag.add(1);
        ag.add(2);
        ag.add(3);
        ag.add(4);
        ag.add(5);
        ag.remove(3);
        Iterator it = ag.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }
    }
}
