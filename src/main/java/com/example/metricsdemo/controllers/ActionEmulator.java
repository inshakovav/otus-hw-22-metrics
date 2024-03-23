package com.example.metricsdemo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

import static java.lang.Thread.sleep;

@Slf4j
@Component
public class ActionEmulator {
    private Random random = new Random();

    public void doSomething(int minMilliseconds, int maxMilliseconds) {
        int interval = random.nextInt(maxMilliseconds - minMilliseconds) + minMilliseconds;
        log.info("Random interval={}", interval);
        try {
            sleep(interval);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
