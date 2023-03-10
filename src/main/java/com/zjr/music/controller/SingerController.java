package com.zjr.music.controller;

import com.zjr.music.service.SingerService;
import com.zjr.music.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "歌手接口")
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @GetMapping("/all")
    @ApiOperation(value = "所有歌手信息")
    public Result getAllSingerList(@ApiParam(value = "当前页") int pageNow, @ApiParam(value = "所有页") int pageSize){
        return singerService.getAllSingerList(pageNow, pageSize);
    }
}
