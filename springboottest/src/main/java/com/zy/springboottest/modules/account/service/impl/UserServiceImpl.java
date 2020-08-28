package com.zy.springboottest.modules.account.service.impl;

import com.zy.springboottest.modules.account.dao.UserDao;
import com.zy.springboottest.modules.account.entity.User;
import com.zy.springboottest.modules.account.service.UserService;
import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public Result<User> insertUser(User user) {
        User userTmp = userDao.getUserByUserName(user.getUserName());
        if(userTmp!=null){
            return new Result<>(Result.ResultStatus.FAILD.status,"userName is repeat");
        }
        user.setCreateDate(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword(),user.getUserName()));
        userDao.insertUser(user);
        return new Result<>(Result.ResultStatus.SUCCESS.status,"insert success",userDao.getUserByUserName(user.getUserName()));
    }

    @Override
    public Result<User> login(User user) {
        User userTmp = userDao.getUserByUserName(user.getUserName());
        if(userTmp!=null&&userTmp.getPassword().equals(MD5Util.getMD5(user.getPassword(),user.getUserName()))){
            return new Result<>(Result.ResultStatus.SUCCESS.status,"login success",userTmp);
        }
        return new Result<>(Result.ResultStatus.FAILD.status,"login failse");
    }
}
