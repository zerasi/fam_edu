package com.zerasi.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-12-05
 */
public class UserComment {
    private Integer id;

    private String content;

    private Integer tch_id;

    private Integer uid;
    
    private Teacher teacher;
    
    private User user;

    public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTch_id() {
        return tch_id;
    }

    public void setTch_id(Integer tch_id) {
        this.tch_id = tch_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}