package com.zjr.music.controller;

import com.zjr.music.service.UserService;
import com.zjr.music.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @create: 2023-03-11 13:46
 * @Description:
 */

@RestController
@Api(value = "用户接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/getAttentionList")
    @ApiOperation(value = "获取用户关注列表")
    public Result getAttentionList(@ApiParam(value = "用户id") Integer userid){
        return userService.getAttentionIdList(userid);
    }

    @PutMapping("/addAttention")
    @ApiOperation(value = "关注用户")
    public Result addAttention(@ApiParam(value = "用户id") Integer userid, @ApiParam(value = "被关注用户id") Integer attentionid){
        return userService.addAttention(userid, attentionid);
    }

    @PostMapping("/deleteAttention")
    @ApiOperation(value = "取消关注用户")
    public Result deleteAttention(@ApiParam(value = "用户id") Integer userid, @ApiParam(value = "被关注用户id") Integer attentionid){
        return userService.deleteAttention(userid, attentionid);
    }

    @PostMapping("/selectUser")
    @ApiOperation(value = "查找用户")
    public Result selectUser(@ApiParam(value = "用户姓名") String name){
        return userService.selectUser(name);
    }

}
