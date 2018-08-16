/*******************************************************************************
 * @(#)UserMapper.java 2017年5月27日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springcloud.web.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.emrubik.oak.common.mybatis.annotation.MyBatisDao;
import com.emrubik.springcloud.web.dao.domain.User;

/**
 * TODO 这里请补充该类型的简述说明
 * @author <a href="mailto:changj@emrubik.com">chang jiang</a>
 * @version $Revision 1.0 $ 2017年5月27日 下午2:07:00
 */
@MyBatisDao
public interface UserMapper {
    @Insert("INSERT INTO tb_user(username, password) VALUES(#{username},#{password})")
    public int insertUser(@Param("username") String username, @Param("password")  String password);
    
    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     */
    public int insertUserWithBackId(User user);
}
