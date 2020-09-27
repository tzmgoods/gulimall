package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import org.springframework.util.StringUtils;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree(String catName) {
        //1、查询所有的分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //2、找出所有的一级分类,过滤每一个分类的ParentCid为0的分类，并将收集到一个集合中
//        List<CategoryEntity> oneLeve = entities.stream().filter(categoryEntity -> {
//            return categoryEntity.getParentCid() == 0;
//        }).collect(Collectors.toList());
        //简化
        List<CategoryEntity> oneLevel = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map((menu) -> {
            //找出当前的一级分类下的子分类
            menu.setChildren(getChildrens(menu, entities));
            return menu;
            //进行排序
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());
        //2、组装成树形结构

        return oneLevel;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //todo 1.检查当前删除的菜单，是否被的地方引用
        //逻辑删除(就是修改数据的状态)
        baseMapper.deleteBatchIds(asList);
    }

    //递归查询所有分类下的子分类:root为当前分类
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {

        //过滤分类中的parentCid 等于当前分类的Cid的分类
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            //映射当前分类下的子分类下的所有子分类,并收集到集合中
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
            //分类进行排序
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return children;
    }

}