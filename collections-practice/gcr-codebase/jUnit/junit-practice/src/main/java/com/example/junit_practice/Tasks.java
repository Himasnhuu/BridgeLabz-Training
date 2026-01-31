package com.example.junit_practice;

public class Tasks {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); 
        return "Task Completed";
    }
}

