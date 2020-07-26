package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: tzm
 * @Date: 2020/7/4 21:53
 * @description: PACKAGE_NAME
 * @description: 1.整合mybatis-Plus
 * 1.1.导入依赖
 * 1.2.配置
 *   1.配置数据源
 *      1) 导入数据库驱动
 *      2) 在application.yml配置数据库的:username,password,url,driver
 *   2.配置MyBatis-Plus
 *      1) 使用MapperScan,扫描
 *      2) 告诉mybatis,sql映射文件位置
 */
@EnableDiscoveryClient  //开户注册中心发现端的客户
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
