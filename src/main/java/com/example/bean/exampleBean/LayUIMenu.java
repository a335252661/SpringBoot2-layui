package com.example.bean.exampleBean;

public class LayUIMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column layuimenu.menuId
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    private Integer menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column layuimenu.level
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    private String level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column layuimenu.text
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    private String text;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column layuimenu.URL
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    private String URL;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column layuimenu.fatherMenuId
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    private Integer fatherMenuId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column layuimenu.menuId
     *
     * @return the value of layuimenu.menuId
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column layuimenu.menuId
     *
     * @param menuId the value for layuimenu.menuId
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column layuimenu.level
     *
     * @return the value of layuimenu.level
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column layuimenu.level
     *
     * @param level the value for layuimenu.level
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column layuimenu.text
     *
     * @return the value of layuimenu.text
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column layuimenu.text
     *
     * @param text the value for layuimenu.text
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column layuimenu.URL
     *
     * @return the value of layuimenu.URL
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public String getURL() {
        return URL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column layuimenu.URL
     *
     * @param URL the value for layuimenu.URL
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public void setURL(String URL) {
        this.URL = URL == null ? null : URL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column layuimenu.fatherMenuId
     *
     * @return the value of layuimenu.fatherMenuId
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public Integer getFatherMenuId() {
        return fatherMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column layuimenu.fatherMenuId
     *
     * @param fatherMenuId the value for layuimenu.fatherMenuId
     *
     * @mbggenerated Sun Mar 15 17:56:43 CST 2020
     */
    public void setFatherMenuId(Integer fatherMenuId) {
        this.fatherMenuId = fatherMenuId;
    }
}