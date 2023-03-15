package com.zjr.music.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cloud-test")
public interface FeignTest {
    @RequestMapping(value = "/test/hello", method = RequestMethod.GET)
    String task();

}
