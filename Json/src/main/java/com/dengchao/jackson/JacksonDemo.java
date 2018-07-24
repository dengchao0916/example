package com.dengchao.jackson;


import com.dengchao.Entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 2:39  2018/7/24 0024
 */
public class JacksonDemo {
    public static void main(String[] args) throws ParseException, IOException {
        User user = new User();
        user.setName("dengchao");
        user.setAge(28);
        user.setEmail("dengchao0916@163.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("1990-07-29"));

        //对象转json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        List<User> users = new ArrayList<>();
        users.add(user);
        String jsonList = mapper.writeValueAsString(users);
        System.out.println(jsonList);

        //json转对象
        String jsonStr = "{\"name\":\"dengchao\",\"age\":28,\"birthday\":649180800000,\"email\":\"dengchao0916@163.com\"}";
        User user1 = mapper.readValue(jsonStr, User.class);
        System.out.println(user1.toString());

        String jsonListStr = "[{\"name\":\"zhangsan\",\"age\":20,\"birthday\":844099200000,\"email\":\"zhangsan@163.com\"}]";
        List<User> beanList = mapper.readValue(jsonListStr, new TypeReference<List<User>>() {
        });
        System.out.println(beanList);
    }
}
