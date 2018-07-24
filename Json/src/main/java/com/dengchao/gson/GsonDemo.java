package com.dengchao.gson;

import com.dengchao.Entity.User;
import com.dengchao.json.JsonDemo;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 3:59  2018/7/24 0024
 */
public class GsonDemo {

    public static void main(String[] args) throws ParseException, IOException {
        gsonSimple();
        parse();
    }

    private static void gsonSimple() throws ParseException {
        User user = new User();
        user.setName("dengchao");
        user.setAge(28);
        user.setEmail("dengchao0916@163.com");
        user.setIgnore("看不到我!");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("1990-07-29"));

        GsonBuilder gsonBuilder = new GsonBuilder();
        //格式化打印的数据
        gsonBuilder.setPrettyPrinting();

        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                if(field.getName().equals("name")){
                    return "Name";
                }
                return field.getName();
            }
        });
        //Gson gson = new Gson();
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(user));
    }

    public static void parse() throws IOException {
        File file = new File(JsonDemo.class.getResource("/user.json").getFile());
        //commons-io
        String content = FileUtils.readFileToString(file);
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        User user = gson.fromJson(content,User.class);
        System.out.println(user.toString());
    }
}
