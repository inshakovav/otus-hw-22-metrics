package com.example.metricsdemo;

import com.example.metricsdemo.controllers.ActionEmulator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomTest {
    @Test
//    @RepeatedTest(50)
    void getRandom() {
        ActionEmulator actionEmulator = new ActionEmulator();
        actionEmulator.doSomething(50, 200);
    }
}
