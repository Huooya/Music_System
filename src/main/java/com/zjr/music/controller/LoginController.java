package com.zjr.music.controller;

import com.zjr.music.utils.JwtUtil;
import com.zjr.music.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Api(value = "登录接口")
@RequestMapping("/auth")
public class LoginController {

    @GetMapping("/login")
    @ApiOperation(value="账号密码登录接口", notes="用户登录")
    public Result login(String username, String pass) {
        //假设数据库中查询到了该用户，这里测试先所及生成一个UUID，作为用户的id
        String userId = UUID.randomUUID().toString();

        //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        info.put("username", "tom");
        info.put("pass", "admin");

        //生成JWT字符串
        String token = JwtUtil.sign(userId, info);

        return Result.success("token:" + token);
    }
}
