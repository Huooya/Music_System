package com.zjr.music.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjr.music.config.SnowflakeIdWorker;
import com.zjr.music.entity.Code;
import com.zjr.music.entity.Singer;
import com.zjr.music.entity.User;
import com.zjr.music.mapper.SingerMapper;
import com.zjr.music.service.SingerService;
import com.zjr.music.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class SingerServiceImpl implements SingerService {
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
     * 歌手入驻
     * @param singer 歌手对象
     * @return success
     */
    public Result insertSinger(Singer singer){
//        批量生成
//        if(num == null){
//            num = 1L; // 默认生成一个Num;
//        }
//        List<Code> codeEntities = new ArrayList<>();
//        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
//        for (int i = 0; i < num; i++) {
//            long id = idWorker.nextId();
//            Code codeEntity = new Code();
//            codeEntity.setCodeId(String.valueOf(id));
//            System.out.println(codeEntity);
//            codeEntities.add(codeEntity);
//        }
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        long id = idWorker.nextId();
        singer.setUserid(id);
        singerMapper.insertSinger(singer);
        return Result.success();
    }

    /**
     * 申请音乐人/歌手认证
     * @param user 歌手对象
     * @return success
     */
    public Result newSingerInfo(User user){
        //将用户已有信息同步至歌手表
        Singer singer = new Singer();
        singer.setArea(user.getArea());
        singer.setAttention(user.getAttention());
        singer.setAvatar(user.getAvatar());
        //1为已认证状态，0为未认证状态
        singer.setDynamic_state(1);
        singer.setFan(user.getFan());
        singer.setName(user.getUsername());
        singer.setSex(user.getSex());
        singer.setIntroduction(user.getIntroduction());
        singerMapper.insertSinger(singer);
        return Result.success();

    }

    /**
     * 查询歌手
     * @param name 歌手姓名
     * @return List<Singer>
     */
    public Result selectSinger(String name){
        List<Singer> singerList = singerMapper.selectSinger(name);
        return Result.success(singerList);
    }





}
