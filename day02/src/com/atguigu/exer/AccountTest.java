package com.atguigu.exer;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 * <p>
 * 分析：
 * 1.是否是多线程问题？ 是，两个储户线程
 * 2.是否有共享数据？ 有，账户（或账户余额）
 * 3.是否有线程安全问题？有
 * 4.需要考虑如何解决线程安全问题？同步机制：有三种方式。
 *
 * @author k
 * @create 2021-04-13 16:17
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Thread t1 = new Customer(account);
        Thread t2 = new Customer(account);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void doposit(double amt) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (amt > 0) {
            balance += amt;
            System.out.println(Thread.currentThread().getName() + ":存储了" + amt + "元,当前余额为" + balance);
        }
    }
}

class Customer extends Thread {
    private Account account;

    Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.doposit(1000);
        }
    }
}