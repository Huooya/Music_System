package com.zjr.music.service;

import com.zjr.music.entity.Singer;
import com.zjr.music.entity.User;
import com.zjr.music.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;


public interface SingerService {
    Result getAllSingerList(int pageNow, int pageSize);
    Result getOneSinger(String singerName);
    Result getSingerFanRank();
    Result getAreaSingerMan(String area, String sex);
    Result updateSingerInfo(Singer singer);
    Result insertSinger(Singer singer);
    Result newSingerInfo(User user);
    Result selectSinger(String name);
}
