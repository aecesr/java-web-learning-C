package com.chl.web.Service;

import com.chl.web.entity.Brand;
import com.chl.web.entity.PageBean;
import com.chl.web.mapper.BrandMapper;
import com.chl.web.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-03-04 22:19
 **/


public class BranServiceImpl implements BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
//        获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        调用方法
        List<Brand> brands = mapper.selectAll();
//        释放资源
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currenPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        计算开始索引
        int begin = (currenPage - 1) * pageSize;
//        查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, pageSize);
//        查询总记录数
        int totalCount = mapper.selectTotalCount();
//        封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currenPage, int pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        计算开始索引
        int begin = (currenPage - 1) * pageSize;
//        处理brand条件，模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }
//        计算当前页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin, pageSize, brand);
//        查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);
//        封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }
}
