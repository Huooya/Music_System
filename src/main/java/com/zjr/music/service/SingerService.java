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

    /**
     * 获取所有歌手列表
     * @param pageNow 当前页
     * @param pageSize 总页数
     * @return List<Singer>
     */
    public Result getAllSingerList(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow,pageSize);
        List<Singer> allSingerList = singerMapper.getAllSingerList();
        PageInfo<Singer> singerPageInfo = new PageInfo<>(allSingerList);
        return Result.success(singerPageInfo);
    }

    /**
     * 获取单个歌手信息
     * @param singerName 歌手姓名
     * @return Singer
     */
    public Result getOneSinger(String singerName){
        Singer singer = singerMapper.getSingleSinger(singerName);
        return Result.success(singer);
    }

    /**
     * 歌手热度排行榜
     * @return List<Singer>
     */
    public Result getSingerFanRank(){
        List<Singer> singerRank = singerMapper.getSingerFansRank();
        return Result.success(singerRank);
    }

    /**
     * 获取国家/地区歌手列表
     * @param area 国家/地区
     * @param sex 性别
     * @return List<Singer>
     */
    public Result getAreaSingerMan(String area, String sex){
        List<Singer> areaSingerMan = singerMapper.getAreaSingerMan(area, sex);
        return Result.success(areaSingerMan);
    }

    /**
     * 更新歌手信息
     * @param singer 歌手对象
     * @return success
     */
    public Result updateSingerInfo(Singer singer){
        singerMapper.updateSingerInfo(singer);
        return Result.success();
    }

    /**
     * 新增歌手
     * @param singer 歌手对象
     * @return success
     */
    public Result insertSinger(Singer singer){
        singerMapper.insertSinger(singer);
        return Result.success();
    }





}
