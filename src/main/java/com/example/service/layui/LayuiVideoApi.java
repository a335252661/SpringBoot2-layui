package com.example.service.layui;

import com.example.bean.VideoVo;
import com.example.bean.basic.LayuiPageQueryResult;

/**
 * @author by cld
 * @date 2020/4/4  11:03
 * @description:
 */
public interface LayuiVideoApi {
    LayuiPageQueryResult<VideoVo> queryVideo(VideoVo vo);
}
