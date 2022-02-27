package com.example.entity;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/24 10:19
 */
public class Book  {
   private  Integer id;
   private String name;
   private String cover;
   private String auther;

    public Book(Integer id, String name, String cover, String auther) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.auther = auther;
    }

    public Book() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCover() {
        return cover;
    }

    public String getAuther() {
        return auther;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", auther='" + auther + '\'' +
                '}';
    }
}
