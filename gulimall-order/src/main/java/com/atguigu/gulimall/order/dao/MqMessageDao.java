package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.MqMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author tangzm
 * @email sunlightcs@gmail.com
 * @date 2020-07-05 00:21:52
 */
@Mapper
public interface MqMessageDao extends BaseMapper<MqMessageEntity> {
	
}
