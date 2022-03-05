package com.chl.web.Service;

import com.chl.web.entity.Brand;
import com.chl.web.entity.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(int[] ids);


    PageBean<Brand> selectByPage(int currenPage,int pageSize);


    PageBean<Brand> selectByPageAndCondition(int currenPage,int pageSize,Brand brand);
}
