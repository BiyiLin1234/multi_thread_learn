package com.multi_thread;

public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            System.out.println("111");
        }
    }

    public static void main(String[] args) {
        new TestThread1().start();
        for (int i = 0; i < 20000; i++) {
            System.out.println("222");
        }
    }
}
