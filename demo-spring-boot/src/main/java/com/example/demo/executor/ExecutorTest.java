package com.example.demo.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程，线程池测试类
 * Created by Administrator on 2018/5/23.
 */
public class ExecutorTest {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("-----主程序开始");

        int taskSize = 5;
        //创建包含5个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable callable = new MyCallable(i);
            //执行任务并获得future返回对象
            Future future = pool.submit(callable);
            futures.add(future);
        }

        for (Future future : futures) {
            System.out.println("-----"+future.get().toString());
        }

        //关闭线程池
        pool.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("-----主程序运行结束,执行时间【"+(end - start)+"】毫秒。");

    }

}

class MyCallable implements Callable<Object>{

    private Integer taskNum;

    MyCallable(Integer taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>"+this.taskNum+"线程启动");
        Long start = System.currentTimeMillis();
        Thread.sleep(10000);

        Long end = System.currentTimeMillis();
        System.out.println(">>>"+this.taskNum+"线程结束");

        return this.taskNum + "线程返回结果，任务执行时间【"+(end - start)+"】毫秒。";
    }
}
