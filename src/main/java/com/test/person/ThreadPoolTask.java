package com.test.person;

import java.io.Serializable;

/**
 * @author huangchangling on 2017/6/9 0009
 */



public class ThreadPoolTask implements Runnable, Serializable {

    private Object attachData;

    ThreadPoolTask(Object tasks) {
        this.attachData = tasks;
    }

    public void run() {

        System.out.println("开始执行任务：" + attachData);

        attachData = null;
    }

    public Object getTask() {
        return this.attachData;
    }
}

