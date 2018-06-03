package com.dengchao.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dengchao.service.AccountService2;

public class Main02 {

    public static void main(String[] args) {
        // 加载 spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache-anno.xml");
        AccountService2 s = (AccountService2) context.getBean("accountServiceBean");
        s.getAccountByName("somebody");// 长度大于 4，不会被缓存
        s.getAccountByName("sbd");// 长度小于 4，会被缓存
        s.getAccountByName("somebody");// 还是查询数据库
        s.getAccountByName("sbd");// 会从缓存返回
    }
}
