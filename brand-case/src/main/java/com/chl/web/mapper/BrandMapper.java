package com.chl.web.mapper;

import com.chl.web.entity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    // 查询所有

    @Select("SELECT * FROM tb_brand  ")
    List<Brand> selectAll();


    // 新增

    @Insert("INSERT INTO tb_brand VALUES (null,#{brandName},#{companyName},#{ordered},#{description},#{status}) ")
    void add(Brand brand);


    //批量删除
    void deleteByIds(@Param("ids") int[] ids);


    // 分页查询

    @Select("SELECT * FROM tb_brand LIMIT #{begin}, #{size} ")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);


    //查询总记录
    @Select("SELECT COUNT(*) FROM tb_brand  ")
    int selectTotalCount();

    //分页条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size, @Param("brand") Brand brand);


    //删除
    @Delete("DELETE  FROM tb_brand  WHERE id = #{id} ")
    void delete(int id);

    // 根据条件查询总记录数
    int selectTotalCountByCondition(Brand brand);

}
