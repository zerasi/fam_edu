package com.zerasi.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-12-05
 */
public class Category {
    private Integer id;

    private String name;

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
}