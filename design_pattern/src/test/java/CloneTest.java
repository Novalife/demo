import club.daixy.demo.clone.Dept;
import club.daixy.demo.clone.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daixiaoyong
 * @date 2021/1/23 9:43
 * @description
 */

@SpringBootTest
public class CloneTest {
    @Test
    public void tset1() throws CloneNotSupportedException {
        Dept dept = new Dept();
        dept.setName("研发部");
        dept.setDeptNo(3);

        User user1 = new User();
        user1.setName("dxy");
        user1.setAge(20);
        user1.setDept(dept);

        User user2 = (User) user1.clone();

        System.out.println(user1==user2);
        System.out.println(user1.getDept()==user2.getDept());
        System.out.println("--------------------");

        user2.setAge(30);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println("---------------------");

        dept.setName("财务部");
        System.out.println(user1.getDept()==user2.getDept());
        System.out.println(user1);
        System.out.println(user2);

    }
}