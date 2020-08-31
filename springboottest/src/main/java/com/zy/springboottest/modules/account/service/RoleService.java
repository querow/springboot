package com.zy.springboottest.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.zy.springboottest.modules.account.entity.Role;
import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    Result<Role> editRole(Role role);

    Result<Role> deleteRole(int roleId);

    PageInfo<Role> getRoles(SearchVo searchVo);

    List<Role> getRolesByUserId(int userId);

    List<Role> getRolesByResourceId(int resourceId);

    Role getRoleById(int roleId);
}
