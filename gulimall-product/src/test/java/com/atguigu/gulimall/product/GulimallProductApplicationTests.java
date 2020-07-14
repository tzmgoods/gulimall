package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.vo.BrandEntityVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;


    @Test
    List<BrandEntityVO> contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功.....");

//        brandEntity.setBrandId(13L);
//        brandEntity.setDescript("中国品牌华为");
//        brandService.updateById(brandEntity);
//        System.out.println("修改成功...");

        List<BrandEntityVO> vos = new ArrayList<>();
        //查询某列的那个值
        List<BrandEntity> brands = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 13));
        for (BrandEntity brand : brands) {
            BrandEntityVO vo = new BrandEntityVO();

            if (brand.getShowStatus() == 1) {
                vo.setShowStatusName("显示");
            }else {
                vo.setShowStatusName("不显示");
            }
            vos.add(vo);
        }
        brands.forEach((item) ->{
            BrandEntity entity = brands.get(0);

            System.out.println(item.getName());
        });
        return vos;
    }

}
