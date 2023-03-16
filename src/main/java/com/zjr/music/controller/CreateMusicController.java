package com.zjr.music.controller;

import com.zjr.music.service.CreateMusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create: 2023-03-16 14:55
 * @Description:
 */

@RestController
@RequestMapping("/create")
@Api(value = "创建音乐接口")
public class CreateMusicController {

    @Autowired
    private CreateMusicService createMusicService;

    @GetMapping("/test")
    @ApiOperation(value = "测试接口")
    public void Music(){
        createMusicService.Music();
    }
}
