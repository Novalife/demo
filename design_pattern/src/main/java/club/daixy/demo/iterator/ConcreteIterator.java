package club.daixy.demo.iterator;

import java.util.List;

/**
 * @author daixiaoyong
 * @date 2021/1/27 14:36
 * @description 具体迭代器角色
 */

public class ConcreteIterator implements Iterator {

    private List list;

    private int  cursor;

    public ConcreteIterator(List list) {
        this.list = list;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return this.list.get(cursor++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }
}
