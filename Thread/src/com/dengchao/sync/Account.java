package com.dengchao.sync;

//每次必须先存钱之后才能取钱，而且取钱之后必须存钱
public class Account {
    private String accountNo;
    private double balance;
    private boolean flag = false;// false表示只能存款

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

    public synchronized void draw(double drawAmount) {
        try {
            if (!flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "        draw money: " + drawAmount);
                balance -= drawAmount;
                System.out.println("            " + " balance : " + balance);
                flag = false;
                notifyAll();
            }
        } catch (Exception e) {
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "        deposit money: " + depositAmount);
                balance += depositAmount;
                System.out.println("            " + " balance : " + balance);
                flag = true;
                notifyAll();
            }
        } catch (Exception e) {
        }
    }
}
