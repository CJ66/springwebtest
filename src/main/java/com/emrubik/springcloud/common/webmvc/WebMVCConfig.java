/*******************************************************************************
 * @(#)WebMVCConfig.java 2017年5月31日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springcloud.common.webmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * TODO 这里请补充该类型的简述说明
 * @author <a href="mailto:changj@emrubik.com">chang jiang</a>
 * @version $Revision 1.0 $ 2017年5月31日 下午4:45:49
 */
@Configuration
@EnableWebMvc//无需使用该注解，否则会覆盖掉SpringBoot的默认配置值
public class WebMVCConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/hello").setViewName("/hello");
//    }
}
