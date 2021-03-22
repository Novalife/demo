package club.daixy.arithmetic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootTest
class ArithmeticApplicationTests {

    @Test
    void contextLoads() {
        //        System.out.println("二分查找开始");
        //        int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //        int key = 3;
        //        int index = binarySearch(array1, key);
        //        System.out.println("二分查找结束，索引值是：" + index);

        //        System.out.println("冒泡排序开始");
        //        int[] array2 = { 9, 5, 2, 7, 1, 6, 10 };
        //        bubbleSort(array2);
        //        System.out.println("冒泡排序结束，排序后是:" + Arrays.toString(array2));

        System.out.println("插入排序开始");
        int[] array3 = { 9, 5, 2, 7, 1, 6, 10 };
        insertSort(array3);
        System.out.println("插入排序结束，排序后是:" + Arrays.toString(array3));
    }

    public int binarySearch(int[] array, int key) {
        System.out.println("二分查找法");
        if (array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == array[mid]) {
                return mid;
            } else if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public void bubbleSort(int[] array) {
        System.out.println("冒泡排序法");
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
    }

    public void insertSort(int[] array) {
        System.out.println("插入排序法");
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static String appendStr(String s){
        s+="bbb";
        return s;
    }

    public static StringBuilder appendSb(StringBuilder sb){
        return sb.append("bbb");
    }

    @Test
    public void test(){
        String s = "aaa";
        String s1 = appendStr(s);
        System.out.println(s);
        System.out.println(s1);

        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder s2 = appendSb(sb);
        System.out.println(sb.toString());
        System.out.println(s2.toString());
    }

}
