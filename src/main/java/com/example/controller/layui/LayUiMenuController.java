package com.example.controller.layui;

import com.example.bean.UserInfoListVo;
import com.example.bean.basic.MessageResult;
import com.example.service.layui.LayuiBaseQueryApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author by cld
 * @date 2019/8/27  16:09
 * @description:
 */
@Controller
@RequestMapping("menuManagement")
public class LayUiMenuController {

    @Resource
    private LayuiBaseQueryApi layuiBaseQueryApi;

    @RequestMapping("")
    private String menuManagement(){
        return "html/layUiMenuManagement";
    }

    @RequestMapping("allMenu")
    @ResponseBody
    public MessageResult layuiUpdate(){
        MessageResult result = layuiBaseQueryApi.selectAllMenu();
        return result;
    }
}
