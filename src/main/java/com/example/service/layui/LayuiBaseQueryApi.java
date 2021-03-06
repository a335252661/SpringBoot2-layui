package com.example.service.layui;


import com.example.bean.UserInfoListVo;
import com.example.bean.basic.LayuiPageQueryResult;
import com.example.bean.basic.MessageResult;
import com.example.bean.exampleBean.UserInfo;

public interface LayuiBaseQueryApi {
    LayuiPageQueryResult<UserInfo> layuiQueryUserInfo(UserInfoListVo userInfo);

    MessageResult layuiuUpdateUserInfo(UserInfoListVo userInfo);

    MessageResult ftpDowmLoad();

    MessageResult sendMail();

    /**
     * 查询所有菜单，菜单初始化
     * @return
     */
    MessageResult selectAllMenu();

    /**
     * 添加菜单
     * @param addMenu1
     * @param addMenu2
     * @param menuName
     * @return
     */
    MessageResult addMenu(String addMenu1, String addMenu2, String menuName,String menuUrl);
}
