package com.example.mapperInterface.autoGeneratedMapperInteger;

import com.example.bean.exampleBean.LayUIMenu;
import com.example.bean.exampleBean.LayUIMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LayUIMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int countByExample(LayUIMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int deleteByExample(LayUIMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int deleteByPrimaryKey(Integer menuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int insert(LayUIMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int insertSelective(LayUIMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    List<LayUIMenu> selectByExampleWithRowbounds(LayUIMenuExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    List<LayUIMenu> selectByExample(LayUIMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    LayUIMenu selectByPrimaryKey(Integer menuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int updateByExampleSelective(@Param("record") LayUIMenu record, @Param("example") LayUIMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int updateByExample(@Param("record") LayUIMenu record, @Param("example") LayUIMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int updateByPrimaryKeySelective(LayUIMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table layuimenu
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    int updateByPrimaryKey(LayUIMenu record);
}