package com.atguigu.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、如何使用Nacos作为配置中心统一管理配置
 *    1.1、在common.pom.xml中引入Nacos的依赖
 *      <dependency>
 *          <groupId>com.alibaba.cloud</groupId>
 *          <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *      </dependency>
 * 2、创建一个bootstrap.properties的文件
 *      2.1 spring.application.name=gulimall-coupon
 *      2.2 spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * 3、需要给配置中心默认添加一个数据集(Data Id) gulimall-coupon.properties。Nacos的默认规则，{应用名.properties}
 * 4、给配置列表中的：应用名.properties 添加任何配置
 * 5、动态获取配置
 *     @RefreshScope  :动态获取并刷新配置
 *     @Value("${配置项的名}")  : 获取某个配置的值
 *     如果配置中心和当前的配置文件application.properties中配置了相同的项，优先使用配置中心的配置
 *
 * 6、细节
 *  1、命名空间：配置隔离；
 *      默认：public(保留空间)；默认新增的所有配置都在public空间的配置
 *      1、开发，测试，生产: 利用命名空间来做环境隔离
 *          注意：在bootstrap.properties配置文件中，需要明确使用哪个命名空间下的配置，后面跟的是命名空间的ID
 *          例：spring.cloud.nacos.config.namespace=810ba215-67af-4f07-a26e-c5a178deabcc
 *      2、每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 *
 *  2、配置集：所有的配置的集合
 *
 *  3、配置ID：类似文件名
 *          Data ID：类似文件名
 *
 *  4、配置分组：
 *          默哀所有的配置集都属于：DEFAULT_GROUP
 *          我们可以自定义组名
 *
 *  5、在项目使用中，每个微服务创建自己的命名空间，使用配置分组区分环境，dev, test, prod
 *
 *  6、同时加载多个配置集
 *      1、微服务任何配置信息，任何配置文件都可以话在配置中心
 *      2、只需要在bootstrap.properties文件中说明加载配置中心哪些配置文件即可
 *      3、取application.properties文件中值可用：@Value；@ConfigurationProperties注解
 *      4、以前SpringBoot任何方法从配置文件中获取值，都可以使用
 *      5、配置中心有配置的优先使用配置中心的
 *
 *
 */
@EnableDiscoveryClient  //开户注册中心发现端的客户
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
