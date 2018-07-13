package com.dengchao.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService exec = Executors.newCachedThreadPool();
        // Future是一个接口，该接口用来返回异步的结果。
        Future<String> st = exec.submit(new TaskCallable());

        /* 同步结果，并且设置超时时间 */
        System.out.println(st.get(10000, TimeUnit.MILLISECONDS));
        System.out.println("finished");

    }

}

class TaskCallable implements Callable<String> {
    public String call() throws Exception {
        for (int i = 0; i < 10000; i++) {
            System.out.println("i = " + i);
        }
        //Thread.sleep(1000);
        return "callstatus=OK";
    }
}
