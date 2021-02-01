package club.daixy.demo.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daixiaoyong
 * @date 2021/1/27 14:44
 * @description 具体容器角色
 */

public class ConcreateAggreate implements Aggregate {

    private List list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }
}
