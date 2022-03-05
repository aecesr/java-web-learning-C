package com.chl.web.entity;

import java.util.List;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-03-04 21:49
 **/

public class PageBean<T> {
    private int totalCount;
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public List<T> getRows() {
        return rows;
    }



}
