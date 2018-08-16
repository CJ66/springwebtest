/*******************************************************************************
 * @(#)UserController.java 2017年5月27日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emrubik.springcloud.web.dao.domain.User;
import com.emrubik.springcloud.web.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * TODO 这里请补充该类型的简述说明
 * @author <a href="mailto:changj@emrubik.com">chang jiang</a>
 * @version $Revision 1.0 $ 2017年5月27日 下午2:13:59
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = {
"用户管理" }, produces = "application/json; charset=utf-8", protocols = "http", authorizations = {})
public class UserController {
    @Autowired
    private UserService userService;
    
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = boolean.class, notes = "添加用户", responseContainer = "boolean", produces = "application/json; charset=utf-8")
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public boolean addUser(@RequestParam("username") String username, 
                           @RequestParam("password") String password) {
        return userService.addUser(username,password);
    }
    
    @ApiOperation("添加用户且返回已经设置了主键的user实例")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna")
    })
    @ApiResponses({
        @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/addUserWithBackId",method=RequestMethod.POST)
    public User addUserWithBackId(@RequestParam("username") String username, 
                                     @RequestParam("password") String password) {
        return userService.addUserWithBackId(username, password);
    }
}
