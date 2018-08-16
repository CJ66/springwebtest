package com.emrubik.springcloud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsumerController {


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(Integer a ,Integer b) {
//        return computeClient.add(10, 20);
        return a+b;
    }

}