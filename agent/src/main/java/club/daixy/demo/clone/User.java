package club.daixy.demo.clone;

import lombok.Data;

/**
 * @author daixiaoyong
 * @date 2021/1/23 9:42
 * @description
 */

@Data
public class User implements Cloneable {
    private String name;

    private int    age;

    private Dept   dept;

    @Override
    public Object clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.dept = (Dept) dept.clone();
        return user;
    }
}
