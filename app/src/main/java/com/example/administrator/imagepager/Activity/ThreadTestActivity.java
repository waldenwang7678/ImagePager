package com.example.administrator.imagepager.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.administrator.imagepager.R;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);
        initView();
    }

    private void initView() {
        findViewById(R.id.thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threadTest();
            }
        });
    }

    private void threadTest() {
        int corePoolSize = 5;//核心池的大小
        int maximumPoolSize = 20; //最大线程数
        long keepAliveTime = 5;//留活时间
        TimeUnit unit = TimeUnit.SECONDS;// 留活时间单位
        BlockingQueue<Runnable> workQueue = null;
//        //创建线程池
//        ThreadPoolExecutor a = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//        a.prestartCoreThread();
//        a.allowCoreThreadTimeOut(true);  //线程数不大于核心数时也会遵守留活时间
//
//        a.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        a.shutdown();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            Log.d("ThreadTest", "threadTest: " + ("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount()));
        }
        executor.shutdown();
    }

    class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }
}