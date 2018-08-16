/*******************************************************************************
 * @(#)SwaggerConfig.java 2017年5月27日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springcloud.common.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO 这里请补充该类型的简述说明
 * @author <a href="mailto:changj@emrubik.com">chang jiang</a>
 * @version $Revision 1.0 $ 2017年5月27日 下午2:45:19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${api.doc.desc}")
    private String apiDocDesc;

    @Value("${api.doc.title}")
    private String apiDocTitle;

    @Value("${api.doc.contact}")
    private String apiDocContact;

    @Value("${api.doc.version}")
    private String apiDocVer;

    @Value("${api.doc.path.mapping}")
    private String apiDocPathMapping;

    @Bean
    public Docket createRestApi()
    {
      return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        //.pathMapping(this.apiDocPathMapping)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.emrubik"))
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo()
    {
      return new ApiInfoBuilder()
        .title(this.apiDocTitle)
        .description(this.apiDocDesc)
        .contact(this.apiDocContact)
        .version(this.apiDocVer)
        .build();
    }
}
