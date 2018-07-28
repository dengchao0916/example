package com.dengchao.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 6:53  2018/7/28 0028
 */
public class FastjsonDemo {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "One");
        map.put("key2", "Two");
        String mapJson = JSON.toJSONString(map, true);
        System.out.println(mapJson);
        String dateJson = JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat);
        String dateJson1 = JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(dateJson);
        System.out.println(dateJson1);

        List<Map> list = new ArrayList<>();
        list.add(map);
        String listJson = JSON.toJSONString(list);
        List<Map> list1 = JSON.parseArray(listJson, Map.class);
        for (Map<String, Object> temp : list1) {
            System.out.println(temp.get("key1"));
            System.out.println(temp.get("key2"));
        }
    }

}
