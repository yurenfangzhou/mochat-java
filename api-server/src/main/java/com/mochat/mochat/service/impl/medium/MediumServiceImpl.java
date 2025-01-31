package com.mochat.mochat.service.impl.medium;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mochat.mochat.common.util.ali.AliyunOssUtils;
import com.mochat.mochat.dao.entity.medium.MediumEnyity;
import com.mochat.mochat.dao.mapper.medium.MediumMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:媒体库
 * @author: Huayu
 * @time: 2020/12/4 18:44
 */
@Service
public class MediumServiceImpl extends ServiceImpl<MediumMapper, MediumEnyity> implements IMediumService{
    /**
     *
     *
     * @description:
     * @return:
     * @author: Huayu
     * @time: 2020/12/6 9:30
     */
    @Override
    public MediumEnyity getMediumById(Integer id) {
        MediumEnyity mediumEnyity = this.baseMapper.selectById(id);
        if(mediumEnyity != null){
            mediumEnyity.setContent(addFullPath(mediumEnyity.getContent(),mediumEnyity.getType()));
        }
        return  mediumEnyity;
    }

    @Override
    public String addFullPath(String content,Integer type){
        JSONObject js = JSON.parseObject(content);
        switch (type){
            case 2:
                js.put("imageFullPath", AliyunOssUtils.getUrl(js.getString("imagePath")));
                break;
            case 3:
                js.put("imageFullPath", AliyunOssUtils.getUrl(js.getString("imagePath")));
                break;
            case 4:
                js.put("voiceFullPath", AliyunOssUtils.getUrl(js.getString("voicePath")));
                break;
            case 5:
                js.put("videoFullPath",AliyunOssUtils.getUrl(js.getString("videoPath")));
                break;
            case 6:
                js.put("imageFullPath",AliyunOssUtils.getUrl(js.getString("imagePath")));
                break;
            case 7:
                js.put("fileFullPath",AliyunOssUtils.getUrl(js.getString("imagePath")));
                break;
        }
        return js.toString();
    }

    /**
     *
     *
     * @description: 添加素材库
     * @return:
     * @author: Huayu
     * @time: 2020/12/7 13:58
     */
    @Override
    @Transactional
    public Integer createMedium(MediumEnyity mediumEnyity) {
        Integer i = this.baseMapper.insert(mediumEnyity);
        return i;
    }

    /**
     *
     *
     * @description: 删除素材库
     * @return:
     * @author: Huayu
     * @time: 2020/12/7 14:38
     */
    @Override
    @Transactional
    public Integer deleteMedium(Integer id) {
        Integer  i = this.baseMapper.deleteById(id);
        return i;
    }

    @Override
    public List<MediumEnyity> getMediumList(String mediumGroupId, String searchStr, Integer type, Integer page, Integer pageNo){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("mediumGroupId",mediumGroupId);
        map.put("page",page);
        map.put("pageNo",pageNo);
        List<MediumEnyity> mediumList = null;
        if(type.equals(0)){
            mediumList = this.baseMapper.getAllMediumList(map);
        }else{
            map.put("type",type);
            mediumList = this.baseMapper.getMediumList(map);
        }
        return mediumList;
    }

    /**
     *
     *
     * @description: 移动分组
     * @return:
     * @author: Huayu
     * @time: 2020/12/7 14:55addFullPath
     */
    @Override
    @Transactional
    public boolean updateMediumById(MediumEnyity mediumEnyity) {
        boolean flag =   this.updateById(mediumEnyity);
        return flag;
    }

    @Override
    public Integer updateMediaByGroupId(Integer id, int mediumGroupId) {
        MediumEnyity mediumEnyity = new MediumEnyity();
        mediumEnyity.setId(id);
        mediumEnyity.setMediumGroupId(mediumGroupId);
        Integer i = this.baseMapper.updateMediaByGroupId(mediumEnyity);
        return i;
    }


}
