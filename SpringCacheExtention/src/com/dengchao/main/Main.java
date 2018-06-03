package com.dengchao.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dengchao.entity.Account;
import com.dengchao.service.AccountService;

public class Main {
    public static void main(String[] args) {
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache-anno.xml");
        AccountService s = (AccountService) context.getBean("accountServiceBean");
        Account account = s.getAccountByName("someone");
        System.out.println("passwd=" + account.getPassword());
        account = s.getAccountByName("someone");
        System.out.println("passwd=" + account.getPassword());
    }

}
