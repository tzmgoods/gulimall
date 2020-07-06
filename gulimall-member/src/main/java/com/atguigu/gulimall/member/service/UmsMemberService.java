package com.atguigu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.member.entity.UmsMemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author tangzm
 * @email sunlightcs@gmail.com
 * @date 2020-07-05 00:04:52
 */
public interface UmsMemberService extends IService<UmsMemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

