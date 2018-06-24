package com.dengchao.sync;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("123456", 1000);
        new DrawThread("DrawThread", account, 800).start();
        new DepositThread("DepositThread-A", account, 800).start();
        new DepositThread("DepositThread-B", account, 800).start();
        new DepositThread("DepositThread-C", account, 800).start();
    }

}
