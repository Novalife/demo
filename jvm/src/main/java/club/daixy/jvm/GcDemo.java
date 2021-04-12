package club.daixy.jvm;

import java.util.Arrays;
import java.util.List;

/**
 * @author daixiaoyong
 * @date 2021/4/2 16:38
 * @description GC
 */
public class GcDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        Integer[] array = new Integer[]{1,2,3,4};
        List<Integer> list = Arrays.asList(array);
        list.add(5);
        System.out.println(list.size());
    }
}