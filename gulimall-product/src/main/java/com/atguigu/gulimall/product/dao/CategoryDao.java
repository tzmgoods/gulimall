package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author tangzm
 * @email sunlightcs@gmail.com
 * @date 2020-07-03 13:58:18
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
