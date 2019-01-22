package com.example.demo.controller;

import com.example.demo.DemoApplication;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {
    static int count = 0;
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(TimeController.class);
    @GetMapping("/time")
    public String time(){
        count++;
        Logger.warn("第"+count+"次调time");
        return "after 2 minutes!";
    }
}
