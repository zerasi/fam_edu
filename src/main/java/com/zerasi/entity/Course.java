package com.zerasi.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-12-05
 */
public class Course {
    private Integer id;

    private String name;

    private String content;

    private Integer price;

    private Integer cate_id;
    
    private Integer tch_id;
    
    private Teacher teacher;
    
    private Category category;

    public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public Integer getTch_id() {
        return tch_id;
    }

    public void setTch_id(Integer tch_id) {
        this.tch_id = tch_id;
    }
}