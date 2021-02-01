package club.daixy.annotation;

import club.daixy.annotation.field.MyField;
import club.daixy.annotation.field.MyFieldTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author daixiaoyong
 * @date 2021/2/1 17:44
 * @description 字段注解测试
 */
public class FieldTest {

    @Test
    public void test() {
        Class<MyFieldTest> clazz = MyFieldTest.class;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyField.class)) {
                MyField annotation = field.getAnnotation(MyField.class);
                System.out.println("字段:[" + field.getName() + "], 描述:[" + annotation.description() + "], 长度:["
                        + annotation.length() + "]");
            }
        }
    }
}
