package com.zjr.music.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "data-service")
public interface FeignPython {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String pythonHello();
}
