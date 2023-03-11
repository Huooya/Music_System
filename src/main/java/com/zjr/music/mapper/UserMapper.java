package com.zjr.music.mapper;

import com.zjr.music.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<Integer> attentionIdList(Integer userid);
    User getUserInfo(Integer userid);
    void insertAttention(Integer userid, Integer attentionid);
    void deleteAttention(Integer userid, Integer attentionid);
    void updateUserAttention(Integer attentionid);
}
