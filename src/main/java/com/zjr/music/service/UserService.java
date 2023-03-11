package com.zjr.music.service;

import com.zjr.music.entity.User;
import com.zjr.music.mapper.UserMapper;
import com.zjr.music.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户关注列表
     * @param userid 用户id
     * @return List<User>
     */
    public Result getAttentionIdList(Integer userid){
        List<Integer> attentionIdList = userMapper.attentionIdList(userid);
        List<User> attentionListUser = new ArrayList<>();
        for (int i = 0; i < attentionIdList.size(); i++){
            User user = userMapper.getUserInfo(attentionIdList.get(i));
            attentionListUser.add(user);
        }
        return Result.success(attentionListUser);
    }

}
