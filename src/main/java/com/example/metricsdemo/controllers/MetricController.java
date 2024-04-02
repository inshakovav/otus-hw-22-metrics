package com.example.metricsdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MetricController {
    private final ActionEmulator actionEmulator;

    @GetMapping("/api/a")
    public String method1() {
        int delay = actionEmulator.doSomething(0, 300);
        return "Call method1 with delay: " + delay;
    }

    @GetMapping("/api/b")
    public String method2() {
        int delay = actionEmulator.doSomething(200, 400);
        return "Call method2 with delay: " + delay;
    }

    @GetMapping("/api/error-code")
    public String getWithError() {
        actionEmulator.randomThrowException(15);
        return "Call method getWithError";
    }
}
