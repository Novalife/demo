package club.daixy.jvm;

/**
 * @author daixiaoyong
 * @date 2021/4/28 9:27
 * @description final修饰的变量是引用不能改变还是引用的对象不能改变
 * https://blog.csdn.net/i_am_tomato/article/details/46762081
 */

public class Persion {
    private String name;
    private int    age;

    public Persion(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public static void main(String[] args) {
        final Persion persion = new Persion("zhansan",18);
        persion.setName("lisi");
        System.out.println(persion);
    }
}
