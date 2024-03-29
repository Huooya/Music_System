package com.zjr.music.controller;

import com.zjr.music.entity.Singer;
import com.zjr.music.entity.User;
import com.zjr.music.service.FeignPython;
import com.zjr.music.service.FeignTest;
import com.zjr.music.service.SingerService;
import com.zjr.music.service.serviceImpl.SingerServiceImpl;
import com.zjr.music.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "歌手接口")
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @Autowired
    private FeignTest feignTest;

    @Autowired
    private FeignPython feignPython;

    @PostMapping("/all")
    @ApiOperation(value = "所有歌手信息")
    public Result getAllSingerList(@ApiParam(value = "当前页") int pageNow, @ApiParam(value = "所有页") int pageSize){
        return singerService.getAllSingerList(pageNow, pageSize);
    }

    @PostMapping("/oneSinger")
    @ApiOperation(value = "单个歌手信息")
    public Result getOneSinger(@ApiParam(value = "歌手姓名") String singer_name){
        return singerService.getOneSinger(singer_name);
    }

    @GetMapping("/singerFanRank")
    @ApiOperation(value = "歌手热度排行榜")
    public Result getSingerFanRank(){
        return singerService.getSingerFanRank();
    }

    @PostMapping("/areaSingerMan")
    @ApiOperation(value = "国家/地区歌手")
    public Result getAreaSingerMan(@ApiParam(value = "国家/地区") String area, @ApiParam(value = "性别") String sex){
        return singerService.getAreaSingerMan(area, sex);
    }

    @PutMapping("/updateSingerInfo")
    @ApiOperation(value = "更新歌手信息")
    public Result updateSingerInfo(@ApiParam(value = "歌手对象") @RequestBody Singer singer){
        return singerService.updateSingerInfo(singer);
    }

    @PutMapping("/insertSinger")
    @ApiOperation(value = "新增歌手")
    public Result insertSinger(@ApiParam(value = "歌手对象") @RequestBody Singer singer){
        return singerService.insertSinger(singer);
    }

    @PutMapping("/newSingerInfo")
    @ApiOperation(value = "申请歌手/音乐人认证")
    public Result newSingerInfo(@ApiParam(value = "用户对象") @RequestBody User user){
        return singerService.newSingerInfo(user);
    }

    @PostMapping("/selectSinger")
    @ApiOperation(value = "查找歌手")
    public Result selectSinger(@ApiParam(value = "歌手姓名") String name){
        return singerService.selectSinger(name);
    }

    @GetMapping("/testFeign")
    public String testFeign(){
        return feignTest.task();
    }

    @GetMapping("/pythonFeign")
    public String pythonFeign(){
        return feignPython.pythonHello();
    }


}
