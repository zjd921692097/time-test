package com.example.demo;


import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {
    public static LocalDateTime firstTime ;
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(DemoApplication.class);


    public static void main(String[] args) {
        int count = 0;
        SpringApplication.run(DemoApplication.class, args);
        Logger.warn("asdfasdf{}","程序启动成功！");

        firstTime = LocalDateTime.now();

    }

}

