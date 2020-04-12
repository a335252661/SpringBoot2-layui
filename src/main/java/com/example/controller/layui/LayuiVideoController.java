package com.example.controller.layui;

import com.example.bean.UserInfoListVo;
import com.example.bean.VideoVo;
import com.example.bean.basic.LayuiPageQueryResult;
import com.example.bean.exampleBean.UserInfo;
import com.example.service.layui.LayuiBaseQueryApi;
import com.example.service.layui.LayuiVideoApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author by cld
 * @date 2020/4/4  10:34
 * @description:
 */
@Controller
@RequestMapping("video")
public class LayuiVideoController {

    @Resource
    private LayuiVideoApi layuiVideoApi;

    @RequestMapping("")
    private String menuManagement(){
        return "html/layUiVideoQuery";
    }
    //layuiVideoQuery
    @RequestMapping("layuiVideoQuery")
    @ResponseBody
    public LayuiPageQueryResult<VideoVo> query(VideoVo vo){
        System.out.println("开始查询  G:\\广场舞蹈");
        LayuiPageQueryResult<VideoVo> resultUserInfo = layuiVideoApi.queryVideo(vo);
        return resultUserInfo;
    }

}
