package com.chl.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-28 15:34
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {

        private Integer id;

        private String brandName;

        private String companyName;

        private Integer ordered;

        private String description;

        private Integer status;

}
