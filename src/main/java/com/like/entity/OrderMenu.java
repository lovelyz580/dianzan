package com.like.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class OrderMenu {
    private String menuId;

    private String menuName;

    private String menuSrc;

    private String menuInfo;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date menuCreatetime;

    private String menuCreatebyid;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date menuUpdatetime;

    private String menuUpdatebyid;

    private Integer menuState;

    private String menuOther1;

    private String menuOther2;

    private String menuOther3;

    private String menuOther4;

    // 版本信息
    /**
     * 版本号
     */
    private String version;

    // 分页数据
    /**
     * 当前页数(如果不进行分页，该条数据默认为-1)
     */
    private Integer pagenumber;

    /**
     * 每页的数据量
     */
    private Integer pagesize;



    /**
     * 根据uuidlist删除信息时使用
     */
    private List<String> uuidlist;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public List<String> getUuidlist() {
        return uuidlist;
    }

    public void setUuidlist(List<String> uuidlist) {
        this.uuidlist = uuidlist;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuSrc() {
        return menuSrc;
    }

    public void setMenuSrc(String menuSrc) {
        this.menuSrc = menuSrc == null ? null : menuSrc.trim();
    }

    public String getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(String menuInfo) {
        this.menuInfo = menuInfo == null ? null : menuInfo.trim();
    }

    public Date getMenuCreatetime() {
        return menuCreatetime;
    }

    public void setMenuCreatetime(Date menuCreatetime) {
        this.menuCreatetime = menuCreatetime;
    }

    public String getMenuCreatebyid() {
        return menuCreatebyid;
    }

    public void setMenuCreatebyid(String menuCreatebyid) {
        this.menuCreatebyid = menuCreatebyid == null ? null : menuCreatebyid.trim();
    }
    public Date getMenuUpdatetime() {
        return menuUpdatetime;
    }

    public void setMenuUpdatetime(Date menuUpdatetime) {
        this.menuUpdatetime = menuUpdatetime;
    }

    public String getMenuUpdatebyid() {
        return menuUpdatebyid;
    }

    public void setMenuUpdatebyid(String menuUpdatebyid) {
        this.menuUpdatebyid = menuUpdatebyid == null ? null : menuUpdatebyid.trim();
    }

    public Integer getMenuState() {
        return menuState;
    }

    public void setMenuState(Integer menuState) {
        this.menuState = menuState;
    }

    public String getMenuOther1() {
        return menuOther1;
    }

    public void setMenuOther1(String menuOther1) {
        this.menuOther1 = menuOther1 == null ? null : menuOther1.trim();
    }

    public String getMenuOther2() {
        return menuOther2;
    }

    public void setMenuOther2(String menuOther2) {
        this.menuOther2 = menuOther2 == null ? null : menuOther2.trim();
    }

    public String getMenuOther3() {
        return menuOther3;
    }

    public void setMenuOther3(String menuOther3) {
        this.menuOther3 = menuOther3 == null ? null : menuOther3.trim();
    }

    public String getMenuOther4() {
        return menuOther4;
    }

    public void setMenuOther4(String menuOther4) {
        this.menuOther4 = menuOther4 == null ? null : menuOther4.trim();
    }
}