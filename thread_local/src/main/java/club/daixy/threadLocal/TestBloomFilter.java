package club.daixy.threadLocal;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author daixiaoyong
 * @date 2021/4/12 12:21
 * @description 布隆过滤器
 */
public class TestBloomFilter {

    private static int                  total       = 1000000;

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), total);

    public static void main(String[] args) {
        //初始化100W条数据到布隆过滤器
        for (int i = 0; i < total; i++) {
            bloomFilter.put(i);
        }

        //匹配已在过滤器中的值，是否有匹配不上的
        for (int i = 0; i < total; i++) {
            if (!bloomFilter.mightContain(i)) {
                System.out.println(i + "不在过滤器中");
            }
        }

        //测试不在过滤器范围内的数据，有多少会被检测出来
        int count = 0;
        for (int i = -1000; i < 0; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
            }
        }
        System.out.println("1000个数据中，误判数量为：" + count);
    }
}
