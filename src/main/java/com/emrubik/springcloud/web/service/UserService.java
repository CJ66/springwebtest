/*******************************************************************************
 * @(#)UserService.java 2017年5月27日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springcloud.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrubik.springcloud.web.dao.domain.User;
import com.emrubik.springcloud.web.dao.mapper.UserMapper;

/**
 * TODO 这里请补充该类型的简述说明
 * @author <a href="mailto:changj@emrubik.com">chang jiang</a>
 * @version $Revision 1.0 $ 2017年5月27日 下午2:12:49
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userDao;

    public boolean addUser(String username, String password) {
        return userDao.insertUser(username, password) == 1 ? true : false;
    }

    public User addUserWithBackId(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insertUserWithBackId(user);// 该方法后，主键已经设置到user中了
        return user;
    }
}
