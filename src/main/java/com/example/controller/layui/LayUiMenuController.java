package com.example.controller.layui;

import com.example.bean.UserInfoListVo;
import com.example.bean.basic.MessageResult;
import com.example.service.layui.LayuiBaseQueryApi;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("addMenu")
    @ResponseBody
    public MessageResult addMenu(HttpServletRequest request){
        String addMenu1 = request.getParameter("addMenu1");
        String addMenu2 = request.getParameter("addMenu2");
        String menuName = request.getParameter("menuName");
        String menuUrl = request.getParameter("menuUrl");
        System.out.println(addMenu1);
        MessageResult result = layuiBaseQueryApi.addMenu(addMenu1,addMenu2,menuName,menuUrl);
        result.setMessage("菜单新增成功！");
        return result;
    }
}
