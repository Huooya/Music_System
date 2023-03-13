package com.zjr.music.service;

import com.zjr.music.entity.User;
import com.zjr.music.mapper.SingerMapper;
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

    @Autowired
    private SingerMapper singerMapper;

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

    /**
     * 关注用户/歌手
     * @param userid 用户id
     * @param attentionid 被关注用户id
     * @return success
     */
    public Result addAttention(Integer userid, Integer attentionid){
        //更新attention表
        userMapper.insertAttention(userid, attentionid);
        //查询被关注用户信息
        User user = userMapper.getUserInfo(attentionid);
        //如果是音乐人/歌手同步更新singer表
        try{
            if (user.getDynamic_state() == 1){
                //是音乐人直接更新
                singerMapper.updateSingerManAttention(attentionid);
            }
            else {
                //是用户关注用户直接更新
                userMapper.updateUserAttention(attentionid);
            }
        }catch (Exception e){
            singerMapper.updateSingerAttention(attentionid);
        }

        return Result.success();
    }

    /**
     * 取消关注
     * @param userid 用户id
     * @param attentionid 被取消关注用户id
     * @return success
     */
    public Result deleteAttention(Integer userid, Integer attentionid){
        userMapper.deleteAttention(userid, attentionid);
        return Result.success();
    }

    /**
     * 查找用户
     * @param name 用户姓名
     * @return List<User>
     */
    public Result selectUser(String name){
        List<User> userList = userMapper.selectUser(name);
        return Result.success(userList);
    }

}
