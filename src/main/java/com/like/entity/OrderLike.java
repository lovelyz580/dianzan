package com.like.entity;

import java.util.Date;
import java.util.List;

public class OrderLike {
    private String likeId;

    private String likeMenuid;

    private Integer likeCount;

    private String likeUserid;

    private Date likeCreatetime;

    private Date likeUpdatetime;

    private String likeUpdateby;

    private Integer likeState;

    private String likeOther1;

    private String likeOther2;

    private String likeOther3;

    private String likeOther4;

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

    /**
     * 根据uuidlist删除信息时使用
     */
    private List<String> uuidlist;

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId == null ? null : likeId.trim();
    }

    public String getLikeMenuid() {
        return likeMenuid;
    }

    public void setLikeMenuid(String likeMenuid) {
        this.likeMenuid = likeMenuid == null ? null : likeMenuid.trim();
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getLikeUserid() {
        return likeUserid;
    }

    public void setLikeUserid(String likeUserid) {
        this.likeUserid = likeUserid == null ? null : likeUserid.trim();
    }

    public Date getLikeCreatetime() {
        return likeCreatetime;
    }

    public void setLikeCreatetime(Date likeCreatetime) {
        this.likeCreatetime = likeCreatetime;
    }

    public Date getLikeUpdatetime() {
        return likeUpdatetime;
    }

    public void setLikeUpdatetime(Date likeUpdatetime) {
        this.likeUpdatetime = likeUpdatetime;
    }

    public String getLikeUpdateby() {
        return likeUpdateby;
    }

    public void setLikeUpdateby(String likeUpdateby) {
        this.likeUpdateby = likeUpdateby == null ? null : likeUpdateby.trim();
    }

    public Integer getLikeState() {
        return likeState;
    }

    public void setLikeState(Integer likeState) {
        this.likeState = likeState;
    }

    public String getLikeOther1() {
        return likeOther1;
    }

    public void setLikeOther1(String likeOther1) {
        this.likeOther1 = likeOther1 == null ? null : likeOther1.trim();
    }

    public String getLikeOther2() {
        return likeOther2;
    }

    public void setLikeOther2(String likeOther2) {
        this.likeOther2 = likeOther2 == null ? null : likeOther2.trim();
    }

    public String getLikeOther3() {
        return likeOther3;
    }

    public void setLikeOther3(String likeOther3) {
        this.likeOther3 = likeOther3 == null ? null : likeOther3.trim();
    }

    public String getLikeOther4() {
        return likeOther4;
    }

    public void setLikeOther4(String likeOther4) {
        this.likeOther4 = likeOther4 == null ? null : likeOther4.trim();
    }
}