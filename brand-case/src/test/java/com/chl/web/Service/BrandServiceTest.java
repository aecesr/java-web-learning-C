package com.chl.web.Service;

import com.chl.web.entity.Brand;
import com.chl.web.entity.PageBean;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrandServiceTest {
    private final BrandService brandService = new BranServiceImpl();
    private PageBean<Brand> pageBean;

    @Test
    void selectAll() {
        List<Brand> brands= brandService.selectAll();
        brands.forEach(System.out::println);
    }


    @Test
    void add() {
        Brand s=new Brand();
        s.setCompanyName("测试");
        s.setOrdered(1);
        s.setBrandName("测试");
        s.setDescription("测试");
        brandService.add(s);
        List<Brand> brands = brandService.selectAll();
        brands.forEach(System.out::println);
    }

    @Test
    void deleteByIds() {
    }

    @Test
    void selectByPage() {
        PageBean<Brand> pageBean = brandService.selectByPage(2, 6);
        List<Brand> rows = pageBean.getRows();
        rows.forEach(System.out::println);
    }

    @Test
    void selectByPageAndCondition() {

    }
}