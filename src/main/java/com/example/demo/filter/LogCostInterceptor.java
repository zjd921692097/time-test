package com.example.demo.filter;
import com.example.demo.DemoApplication;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogCostInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(LogCostInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        start = System.currentTimeMillis();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(DemoApplication.firstTime,end);
        if(duration.toMinutes()>=1){
            Logger.info("服务正常中！");
           return true;
        }
       // Logger.error("应用程序启动未完成，服务不能访问！");
        httpServletResponse.setStatus(500);
        Thread.sleep(6000);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("Interceptor cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}