package com.zy.springboottest.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.zy.springboottest.modules.account.entity.Resource;
import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;

import java.util.List;

public interface ResourceService {
    Result<Resource> editResource(Resource resource);

    Result<Resource> deleteResource(int resourceId);

    PageInfo<Resource> getResources(SearchVo searchVo);

    List<Resource> getResourcesByRoleId(int roleId);

    Resource getResourceById(int resourceId);
}
