package club.daixy.demo.iterator;

/**
 * @author daixiaoyong
 * @date 2021/1/27 14:42
 * @description 容器角色
 */

public interface Aggregate {

    void add(Object obj);

    void remove(Object obj);

    Iterator iterator();
}
