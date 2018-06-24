package com.dengchao.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//每次必须先存钱之后才能取钱，而且取钱之后必须存钱
public class Account {
    private String accountNo;
    private double balance;
    private boolean flag = false;// false表示只能存款
    // 显示定义lock对象
    private final Lock lock = new ReentrantLock();
    // 获取lock对象对应的condition
    private final Condition cond = lock.newCondition();

    public Account() {
    }

    public Account(String accountNo, double balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void draw(double drawAmount) {
        lock.lock();
        try {
            if (!flag) {
                cond.await();
            } else {
                System.out.println(Thread.currentThread().getName() + "        draw money: " + drawAmount);
                balance -= drawAmount;
                System.out.println("            " + " balance : " + balance);
                flag = false;
                cond.signalAll();
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double depositAmount) {
        lock.lock();
        try {
            if (flag) {
                cond.await();
            } else {
                System.out.println(Thread.currentThread().getName() + "        deposit money: " + depositAmount);
                balance += depositAmount;
                System.out.println("            " + " balance : " + balance);
                flag = true;
                cond.signalAll();
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}
