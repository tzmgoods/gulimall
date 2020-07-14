package com.atguigu.gulimall.product.dto;

import lombok.Data;

/**
 * @Author: tzm
 * @Date: 2020/7/8 22:54
 * @description: com.atguigu.gulimall.product.dto
 * @description: some desc
 */
@Data
public class AttrEntityDto {

    private String attrName;
    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    private Integer searchType;
    /**
     * 值类型[0-为单个值，1-可以选择多个值]
     */
    private Integer valueType;
    /**
     * 属性图标
     */
    private String icon;
    /**
     * 可选值列表[用逗号分隔]
     */
    private String valueSelect;
}
