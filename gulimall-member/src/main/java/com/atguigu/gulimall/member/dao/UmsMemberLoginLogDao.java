package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.UmsMemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author tangzm
 * @email sunlightcs@gmail.com
 * @date 2020-07-05 00:04:52
 */
@Mapper
public interface UmsMemberLoginLogDao extends BaseMapper<UmsMemberLoginLogEntity> {
	
}
