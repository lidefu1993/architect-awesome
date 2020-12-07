package com.ldf.architect.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author ldf
 * @date 2020/12/6 14:06
 **/
public class DemoForkJoinTask extends RecursiveTask<List<Integer>> {

    protected ForkJoinParam param;
    protected int begin;
    protected int end;

    public DemoForkJoinTask(ForkJoinParam param, int begin, int end){
        this.param = param;
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected List<Integer> compute() {
        if(isCompute()){
            return getResult();
        }else {
            int middle = (this.end+this.begin)/2;
            DemoForkJoinTask task1 = new DemoForkJoinTask(param, begin, middle);
            DemoForkJoinTask task2 = new DemoForkJoinTask(param, middle+1, end);
            invokeAll(task1, task2);
            List<Integer> d1 = task1.join();
            List<Integer> d2 = task2.join();
            d1.addAll(d2);
            return d1;
        }
    }

    protected boolean isCompute(){
        return this.end-this.begin <= param.getThreshold();
    }

    protected List<Integer> getResult(){
        return this.param.getMockListDataService().test(begin, end);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinParam param = new ForkJoinParam(10, new MockListDataService());
        ForkJoinPool pool = new ForkJoinPool();
        DemoForkJoinTask task = new DemoForkJoinTask(param, 1, 100);
        pool.submit(task);
        System.out.println(task.get());
    }

}
