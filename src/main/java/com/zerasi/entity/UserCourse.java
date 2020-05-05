package com.zerasi.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-05-05
 */
public class UserCourse {
    private Integer id;

    private Integer uid;

    private Integer cour_id;

    private String start_date;

    private String end_date;

    /**
     * 上课地址
     */
    private String adrss;

    /**
     * 联系电话
     */
    private String acc_nbr;

    /**
     * 0 预约中 1预约成功 3上课完成 4预约失败
     */
    private String status_cd;

    private String bak1;

    private String bak2;

    private String bak3;
    
    private User user;
    
    private Course course;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCour_id() {
        return cour_id;
    }

    public void setCour_id(Integer cour_id) {
        this.cour_id = cour_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date == null ? null : start_date.trim();
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date == null ? null : end_date.trim();
    }

    public String getAdrss() {
        return adrss;
    }

    public void setAdrss(String adrss) {
        this.adrss = adrss == null ? null : adrss.trim();
    }

    public String getAcc_nbr() {
        return acc_nbr;
    }

    public void setAcc_nbr(String acc_nbr) {
        this.acc_nbr = acc_nbr == null ? null : acc_nbr.trim();
    }

    public String getStatus_cd() {
        return status_cd;
    }

    public void setStatus_cd(String status_cd) {
        this.status_cd = status_cd == null ? null : status_cd.trim();
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}