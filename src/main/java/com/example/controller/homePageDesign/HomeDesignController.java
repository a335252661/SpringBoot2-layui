package com.example.controller.homePageDesign;

import com.example.service.HelloServiceApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author by cld
 * @date 2019/8/12  11:12
 * @description:
 */
@Controller
@RequestMapping("homeDesign")
public class HomeDesignController {
    @Resource
    private HelloServiceApi helloServiceApi;
    @RequestMapping("")
    public String index(ModelAndView mav, HttpServletRequest request){
        return "homeDesign/homeDesignIndex";
    }

}
