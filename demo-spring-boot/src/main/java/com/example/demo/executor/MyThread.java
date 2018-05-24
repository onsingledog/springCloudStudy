package com.example.demo.executor;

import org.junit.Test;

/**
 * Created by Administrator on 2018/5/24.
 */
public class MyThread {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new YieldTehradTest());
        thread.start();
        long end = System.currentTimeMillis();
        System.out.println("-----主程序结束，公共用时："+(end-start)+" 毫秒");
    }

    /**
     * 测试线程的gitId方法
     */
    @Test
    public void testThreadGetId(){
        Thread t1 = new Thread(new Thread1(1));
        Thread t2 = new Thread(new Thread1(2));
        t1.start();
        t2.start();
        Thread t = Thread.currentThread();
        System.out.println("-----主线程结束，主线程引用名称是："+t.getName()+",id是："+t.getId());
    }

}

class Thread1 implements Runnable{

    private int i = 0;

    Thread1(int i){
        this.i = i;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(">>>线程"+i+"的引用是："+t.getName()+",id是："+t.getId());
    }
}

class YieldTehradTest implements Runnable{

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int count = 0;
        for(int i=0;i<50000000;i++){
            count += count;
//            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println(">>>线程执行总共用时："+(end-start)+" 毫秒");
    }

}
