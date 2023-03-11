package com.zjr.music.mapper;

import com.zjr.music.entity.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SingerMapper {
    List<Singer> getAllSingerList();
    Singer getSingleSinger(String singerName);
    List<Singer> getSingerFansRank();
    List<Singer> getAreaSingerMan(String area, String sex);
    void updateSingerInfo(Singer singer);
    void insertSinger(Singer singer);
}
