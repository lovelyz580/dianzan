package com.like.entity;

import java.util.Date;
import java.util.List;

public class OrderTodayeat {
    private String eatId;

    private String eatMenuid;

    private String eatUserid;

    private Date eatCreatetime;

    private Date eatUpdatetime;

    private String eatUpdatebyid;

    private Integer eatState;

    private String eatOther1;

    private String eatOther2;

    private String eatOther3;

    private String eatOther4;
    // 版本信息
    /**
     * 版本号
     */
    private String version;

    // 分页数据

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

    /**
     * 当前页数(如果不进行分页，该条数据默认为-1)
     */
    private Integer pagenumber;

    /**
     * 每页的数据量
     */
    private Integer pagesize;

    public List<String> getUuidlist() {
        return uuidlist;
    }

    public void setUuidlist(List<String> uuidlist) {
        this.uuidlist = uuidlist;
    }

    /**
     * 根据uuidlist删除信息时使用
     */
    private List<String> uuidlist;

    public String getEatId() {
        return eatId;
    }

    public void setEatId(String eatId) {
        this.eatId = eatId == null ? null : eatId.trim();
    }

    public String getEatMenuid() {
        return eatMenuid;
    }

    public void setEatMenuid(String eatMenuid) {
        this.eatMenuid = eatMenuid == null ? null : eatMenuid.trim();
    }

    public String getEatUserid() {
        return eatUserid;
    }

    public void setEatUserid(String eatUserid) {
        this.eatUserid = eatUserid == null ? null : eatUserid.trim();
    }

    public Date getEatCreatetime() {
        return eatCreatetime;
    }

    public void setEatCreatetime(Date eatCreatetime) {
        this.eatCreatetime = eatCreatetime;
    }

    public Date getEatUpdatetime() {
        return eatUpdatetime;
    }

    public void setEatUpdatetime(Date eatUpdatetime) {
        this.eatUpdatetime = eatUpdatetime;
    }

    public String getEatUpdatebyid() {
        return eatUpdatebyid;
    }

    public void setEatUpdatebyid(String eatUpdatebyid) {
        this.eatUpdatebyid = eatUpdatebyid == null ? null : eatUpdatebyid.trim();
    }

    public Integer getEatState() {
        return eatState;
    }

    public void setEatState(Integer eatState) {
        this.eatState = eatState;
    }

    public String getEatOther1() {
        return eatOther1;
    }

    public void setEatOther1(String eatOther1) {
        this.eatOther1 = eatOther1 == null ? null : eatOther1.trim();
    }

    public String getEatOther2() {
        return eatOther2;
    }

    public void setEatOther2(String eatOther2) {
        this.eatOther2 = eatOther2 == null ? null : eatOther2.trim();
    }

    public String getEatOther3() {
        return eatOther3;
    }

    public void setEatOther3(String eatOther3) {
        this.eatOther3 = eatOther3 == null ? null : eatOther3.trim();
    }

    public String getEatOther4() {
        return eatOther4;
    }

    public void setEatOther4(String eatOther4) {
        this.eatOther4 = eatOther4 == null ? null : eatOther4.trim();
    }
}