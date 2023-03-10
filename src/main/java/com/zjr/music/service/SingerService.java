package com.zjr.music.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjr.music.entity.Singer;
import com.zjr.music.mapper.SingerMapper;
import com.zjr.music.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class SingerService {
    @Autowired
    private SingerMapper singerMapper;

    public Result getAllSingerList(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow,pageSize);
        List<Singer> allSingerList = singerMapper.getAllSingerList();
        PageInfo<Singer> singerPageInfo = new PageInfo<>(allSingerList);
        return Result.success(singerPageInfo);
    }

}
