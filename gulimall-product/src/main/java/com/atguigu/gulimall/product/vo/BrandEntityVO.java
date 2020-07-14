package com.atguigu.gulimall.product.vo;

import com.atguigu.gulimall.product.entity.BrandEntity;
import lombok.Data;

/**
 * @Author: tzm
 * @Date: 2020/7/8 22:33
 * @description: com.atguigu.gulimall.product.vo
 * @description: some desc
 */
@Data
public class BrandEntityVO extends BrandEntity {

    /**
     * 显示状态[0-不显示；1-显示]
     */
    private String showStatusName;
}
