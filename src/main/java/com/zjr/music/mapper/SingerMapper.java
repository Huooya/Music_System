package com.zjr.music.mapper;

import com.zjr.music.entity.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SingerMapper {
    List<Singer> getAllSingerList();

}
