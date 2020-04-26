package com.zerasi.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-12-05
 */
public class UserCourse {
    private Integer id;

    private Integer uid;

    private Integer cour_id;
    
    private User user;
    
    private Course course;
    

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
}