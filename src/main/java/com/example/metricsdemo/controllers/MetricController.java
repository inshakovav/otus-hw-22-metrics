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
        actionEmulator.doSomething(0, 300);
        return "";
    }

    @GetMapping("/api/b")
    public String method2() {
        actionEmulator.doSomething(200, 400);
        return "";
    }
}
