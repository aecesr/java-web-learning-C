package com.example.homework;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/27 11:28
 */
public class Book   {
    private String name;
    private String cover;
    private String author;


    public Book(String name, String cover, String author) {
        this.name = name;
        this.cover = cover;
        this.author = author;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public String getCover() {
        return cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
