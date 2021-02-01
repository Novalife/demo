package club.daixy.demo.agent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author daixiaoyong
 * @date 2020/1/3 16:43
 * @description
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
//        String dateStr = "2019-12-31 17:00:00";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = format.parse(dateStr);
//        System.out.println(date);

//        Header header = new Header("thbplp53u6k514hkfe","1578905144378","md5","openapi","");
//        String jsonStr = JSON.toJSONString(requestData);
//        Map jsonMap = JSON.parseObject(jsonStr, Map.class);
//        jsonMap.put("appId", request.getHeader("appId"));
//        jsonMap.put("signType", request.getHeader("signType"));
//        jsonMap.put("timestamp", request.getHeader("timestamp"));
//        String signStr = PublicServiceSignUtils.md5(jsonMap, "appSecret");

        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        ArrayList<String> list2 = new ArrayList<>(list1);
        for (String sss:list2) {
            System.out.println(sss);
        }
        System.out.println("----------------");

        Map<String,String> map = new HashMap<>();
        map.put("x","1");
        map.put("y","2");
        map.put("z","3");
        Set<String> keySet = map.keySet();
        ArrayList<String> list3 = new ArrayList<>(keySet);
        for (String sss:list3) {
            System.out.println(sss);
        }
    }
}