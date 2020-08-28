package com.zy.springboottest.modules.account.service;

import com.zy.springboottest.modules.account.entity.User;
import com.zy.springboottest.modules.common.vo.Result;

public interface UserService {
    Result<User> insertUser(User user);
    Result<User> login(User user);
}
