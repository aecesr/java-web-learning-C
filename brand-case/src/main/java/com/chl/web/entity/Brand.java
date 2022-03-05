package com.chl.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.apache.ibatis.annotations.Delete;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-03-04 21:44
 **/

public class Brand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private Integer status;
    private String description;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusStr() {
        if (status == null) {
            return ("未知");
        }
        return status == 0 ? "禁用" : "启用";
    }
    public Integer getStatus() {
        return status ;
    }
}
