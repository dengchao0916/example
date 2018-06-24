package com.dengchao.lock;

public class DepositThread extends Thread {
    private Account account;
    private double depositAmount;

    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(depositAmount);
        }
    }

}
