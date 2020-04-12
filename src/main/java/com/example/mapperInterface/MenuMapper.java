package com.example.mapperInterface;

import org.apache.ibatis.annotations.Param;

/**
 * @author by cld
 * @date 2020/3/18  22:13
 * @description:
 */
public interface MenuMapper {
    /**
     * 查询next菜单id
     * @return
     */
    int queryNextMenuId();

    int queryNextMenuIdByFatherId(@Param("fatherid") String fatherid);
}
