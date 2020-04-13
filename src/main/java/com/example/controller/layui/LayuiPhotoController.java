package com.example.controller.layui;

import com.example.service.layui.LayuiVideoApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author by cld
 * @date 2020/4/4  10:34
 * @description:
 */
@Controller
@RequestMapping("photo")
public class LayuiPhotoController {

    @Resource
    private LayuiVideoApi layuiVideoApi;

    @RequestMapping("")
    private String index(){
        return "html/layUiPhoto";
    }
    //layuiVideoQuery
//    @RequestMapping("layuiVideoQuery")
//    @ResponseBody
//    public LayuiPageQueryResult<VideoVo> query(VideoVo vo){
//        System.out.println("开始查询  G:\\广场舞蹈");
//        LayuiPageQueryResult<VideoVo> resultUserInfo = layuiVideoApi.queryVideo(vo);
//        return resultUserInfo;
//    }

}
