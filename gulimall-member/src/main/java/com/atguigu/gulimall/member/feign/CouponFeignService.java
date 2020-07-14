package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: tzm
 * @Date: 2020/7/11 15:16
 * @description: com.atguigu.gulimall.member.feign
 * @description: 这是一个声明式的远程调用
 */
//告诉springCloud,@FeignClient("gulimall-coupon")是一个远程的客户端，名称叫"gulimall-coupon"
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupon();


}
