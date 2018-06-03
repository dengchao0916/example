package com.dengchao.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dengchao.entity.Account;
import com.dengchao.service.AccountService4;

public class Main04 {

    public static void main(String[] args) {
        // 加载 spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache-anno.xml");
        AccountService4 s = (AccountService4) context.getBean("accountServiceBean");
        Account account = s.getAccountByName("someone");
        account.setPassword("123");
        s.updateAccount(account);
        account.setPassword("321");
        s.updateAccount(account);
        account = s.getAccountByName("someone");
        System.out.println(account.getPassword());
    }
}
