package club.daixy.jvm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author daixiaoyong
 * @date 2021/4/2 16:38
 * @description GC
 */
public class GcDemo {
    public static void main(String[] args) {
        //        System.out.println(Runtime.getRuntime().totalMemory());
        //        System.out.println(Runtime.getRuntime().maxMemory());
        //
        //        Integer[] array = new Integer[]{1,2,3,4};
        //        List<Integer> list = Arrays.asList(array);
        //        list.add(5);
        //        System.out.println(list.size());
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] array = twoSum(nums, target);
        for (int index : array) {
            System.out.println(index);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
