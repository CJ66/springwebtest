/*******************************************************************************
 * @(#)MyBatisConfig.java 2017年5月27日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springcloud.common.mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * springboot集成mybatis的基本入口
 * 1）创建数据源
 * 2）创建SqlSessionFactory
 * @author <a href="mailto:changj@emrubik.com">chang jiang</a>
 * @version $Revision 1.0 $ 2017年5月27日 下午12:06:15
 */
@Configuration    //该注解类似于spring配置文件
@MapperScan(basePackages="com.emrubik.springcloud.web.dao.mapper")
public class MyBatisConfig {

    @Autowired
    private Environment env;
    
    /**
     * 创建数据源
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错 
     */
    @Bean
    //@Primary
    public DataSource getDataSource() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("database.driver"));
        props.put("url", env.getProperty("database.database.url"));
        props.put("username", env.getProperty("database.username"));
        props.put("password", env.getProperty("database.password"));
        props.put("schema", env.getProperty("database.schema"));
        props.put("initialSize", env.getProperty("database.initialSize"));
        props.put("minIdle", env.getProperty("database.minIdle"));
        props.put("maxActive", env.getProperty("database.maxActive"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//指定xml文件位置
        return fb.getObject();
    }
}
