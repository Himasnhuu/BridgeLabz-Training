package com.example.junit_practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class TasksTest {

    Tasks utils = new Tasks();

    @Test
    @Timeout(2)   
    void testLongRunningTaskTimeout() throws InterruptedException {
        utils.longRunningTask();
    }
}


