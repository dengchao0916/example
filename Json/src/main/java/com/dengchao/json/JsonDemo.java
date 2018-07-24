package com.dengchao.json;

import com.dengchao.Entity.User;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 2:31  2018/7/24 0024
 */
public class JsonDemo {
    public static void main(String[] args) throws JSONException, ParseException, IOException {
        /*JSONObjectSimple();
        createJsonByMap();
        createJsonByBean();*/
        parseJson();
    }

    private static void JSONObjectSimple() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Object nullObj = null;
        jsonObject.put("name", "王小二");
        jsonObject.put("age", 25);
        jsonObject.put("birthday", "1990-01-01");
        jsonObject.put("school", "蓝翔");
        jsonObject.put("magor", new String[]{"理发", "挖掘机"});
        jsonObject.put("has_girlfriend", false);
        jsonObject.put("car", nullObj);
        jsonObject.put("house", nullObj);
        jsonObject.put("comment", "这是一个注释");
        System.out.println(jsonObject.toString());
    }

    private static void createJsonByMap() {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        Object nullObj = null;
        jsonMap.put("name", "王小二");
        jsonMap.put("age", 25);
        jsonMap.put("birthday", "1990-01-01");
        jsonMap.put("school", "蓝翔");
        jsonMap.put("magor", new String[]{"理发", "挖掘机"});
        jsonMap.put("has_girlfriend", false);
        jsonMap.put("car", nullObj);
        jsonMap.put("house", nullObj);
        jsonMap.put("comment", "这是一个注释");
        System.out.println(new JSONObject(jsonMap).toString());
    }

    private static void createJsonByBean() throws ParseException {
        User user = new User();
        user.setName("dengchao");
        user.setAge(28);
        user.setEmail("dengchao0916@163.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("1990-07-29"));
        System.out.println(new JSONObject(user));
    }

    private static void parseJson() throws IOException, JSONException {
        File file = new File(JsonDemo.class.getResource("/data.json").getFile());
        //commons-io
        String content = FileUtils.readFileToString(file);
        JSONObject jsonObject = new JSONObject(content);
        if (jsonObject.isNull("nickname")){
            System.out.println("没有nickname");
        }
        System.out.println("name :" + jsonObject.getString("name"));
        System.out.println("age :" + jsonObject.getDouble("age"));
        System.out.println("girlfriend :" + jsonObject.getBoolean("has_girlfriend"));
        JSONArray jsonArray = jsonObject.getJSONArray("major");
        for (int i = 0; i < jsonArray.length(); i++) {
            String str = (String)jsonArray.get(i);
            System.out.println(str);
        }
    }
}
