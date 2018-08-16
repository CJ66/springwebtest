/*******************************************************************************
 * @(#)HelloController.java 2017年5月31日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springcloud.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO 这里请补充该类型的简述说明
 * @author <a href="mailto:changj@emrubik.com">chang jiang</a>
 * @version $Revision 1.0 $ 2017年5月31日 下午3:32:47
 */
@Controller
public class HelloController {
    
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        logger.info("hello");
        model.addAttribute("name", name);
        return "hello";
    }
    
    @RequestMapping("/index")
    public String index(Model model) {
        logger.info("index");
        return "index";
    }
    
}
