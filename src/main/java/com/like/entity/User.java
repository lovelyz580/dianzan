package com.like.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


/**
* 新闻表
*
* 实体类
*
 * @author Lovelyz on 2019/03/21
*/

public class User {

    /**
     * 序号(自增主键)
     */
    private Integer id;

    /**
     * 用户ID(YH+UUID)
     */
    private String userid;

    /**
     * 用户名（登录时用到）
     */
    private String userloginname;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户密码
     */
    private String userpassword;

    /**
     * 用户状态(Y：启用、N：停用)
     */
    private String userstate;

    /**
     * 用户角色(GLY:管理员、FZJG:分支机构、DYY:打印员)
     */
    private String userrole;

    /**
     * 删除状态（Y：删除、N、未删除）
     */
    private String userdeletestate;

    /**
     * 是否删除
     */
    private String userdelete;

    /**
     * 用户创建时间
     */
    private Date usercreatetime;

    /**
     * 用户更新时间
     */
    private Date userupdatetime;

    /**
     * 备份字段1
     */
    private String userother1;

    /**
     * 备份字段2
     */
    private String userother2;

    /**
     * 备份字段3
     */
    private String userother3;


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

    // 操作数据
    /**
     * 根据idlist删除信息时使用
     */
    private List<Integer> idlist;

    /**
     * 根据uuidlist删除信息时使用
     */
    private List<String> uuidlist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserloginname() {
        return userloginname;
    }

    public void setUserloginname(String userloginname) {
        this.userloginname = userloginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserstate() {
        return userstate;
    }

    public void setUserstate(String userstate) {
        this.userstate = userstate;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getUserdeletestate() {
        return userdeletestate;
    }

    public void setUserdeletestate(String userdeletestate) {
        this.userdeletestate = userdeletestate;
    }

    public String getUserdelete() {
        return userdelete;
    }

    public void setUserdelete(String userdelete) {
        this.userdelete = userdelete;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    public Date getUsercreatetime() {
        return usercreatetime;
    }

    public void setUsercreatetime(Date usercreatetime) {
        this.usercreatetime = usercreatetime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    public Date getUserupdatetime() {
        return userupdatetime;
    }

    public void setUserupdatetime(Date userupdatetime) {
        this.userupdatetime = userupdatetime;
    }

    public String getUserother1() {
        return userother1;
    }

    public void setUserother1(String userother1) {
        this.userother1 = userother1;
    }

    public String getUserother2() {
        return userother2;
    }

    public void setUserother2(String userother2) {
        this.userother2 = userother2;
    }

    public String getUserother3() {
        return userother3;
    }

    public void setUserother3(String userother3) {
        this.userother3 = userother3;
    }

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

    public List<Integer> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<Integer> idlist) {
        this.idlist = idlist;
    }

    public List<String> getUuidlist() {
        return uuidlist;
    }

    public void setUuidlist(List<String> uuidlist) {
        this.uuidlist = uuidlist;
    }
}