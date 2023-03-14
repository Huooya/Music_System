package com.zjr.music.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @create: 2023-03-14 10:43
 * @Description:
 */
@RestController
@RefreshScope  //配置热更新
@RequestMapping("/config")
@Api(value = "配置接口")
public class ConfigController {
    //在controller写下面的代码，然后启动服务，看看返回值
    @Value("${pattern.dateformat}")
    private String date;

    /**
     * 获取当前时间
     * @return
     */
    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(date));
    }
}
