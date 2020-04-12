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
@RequestMapping("functionMod")
public class LayuiFunctionModController {

    @Resource
    private LayuiVideoApi layuiVideoApi;

    @RequestMapping("")
    private String menuManagement(){
        return "html/functionMod";
    }

}
