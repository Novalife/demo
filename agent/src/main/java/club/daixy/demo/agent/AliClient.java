package club.daixy.demo.agent;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author daixiaoyong
 * @date 2020/3/24 14:15
 * @description
 */
public class AliClient {

    public static void main(String[] args) throws ParseException {
        //        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //        Date expireDate = dateFormat.parse("2020-05-18 23:59:59");
        //        System.out.println(expireDate.after(new Date()));

        //        String[] couponIdAry = new String[1];
        //        System.out.println(couponIdAry == null);
        //        System.out.println(couponIdAry[0]);
        //        System.out.println(couponIdAry.length);
        //        couponIdAry[0] = "111";
        //        System.out.println(couponIdAry[0]);
        //        System.out.println(couponIdAry.length);

        //        BigDecimal bigDecimal = new BigDecimal("123.456");
        //        System.out.println(bigDecimal.longValue());
        //        System.out.println(bigDecimal.longValueExact());
        //        BigDecimal a = BigDecimal.TEN;
        //        System.out.println(a);

        List<String> list = null;
        for (String a : list) {
            System.out.println("aaa");
        }
    }

    public void update(BigDecimal bigDecimal) {
        bigDecimal = bigDecimal.add(BigDecimal.ONE);
    }
}
