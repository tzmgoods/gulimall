package com.atguigu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.member.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author tangzm
 * @email sunlightcs@gmail.com
 * @date 2020-07-05 00:04:52
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

