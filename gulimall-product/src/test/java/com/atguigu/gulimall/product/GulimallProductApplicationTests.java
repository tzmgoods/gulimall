package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;


    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功.....");

//        brandEntity.setBrandId(13L);
//        brandEntity.setDescript("中国品牌华为");
//        brandService.updateById(brandEntity);
//        System.out.println("修改成功...");

        //查询某列的那个值
        List<BrandEntity> brands = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 13));
        brands.forEach((item) ->{
            System.out.println(item.getName());
        });
    }

}
