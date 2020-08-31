package com.zy.springboottest.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.zy.springboottest.modules.account.entity.Resource;
import com.zy.springboottest.modules.account.service.ResourceService;
import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @PostMapping(value = "/resources", consumes = "application/json")
    public PageInfo<Resource> getResources(@RequestBody SearchVo searchVo) {
        return resourceService.getResources(searchVo);
    }

    @PostMapping(value = "/resource", consumes = "application/json")
    public Result<Resource> insertResource(@RequestBody Resource resource) {
        return resourceService.editResource(resource);
    }

    @PutMapping(value = "/resource", consumes = "application/json")
    public Result<Resource> updateResource(@RequestBody Resource resource) {
        return resourceService.editResource(resource);
    }

    @RequestMapping("/resource/{resourceId}")
    public Resource getResourceById(@PathVariable int resourceId) {
        return resourceService.getResourceById(resourceId);
    }

    @DeleteMapping("/resource/{resourceId}")
    public Result<Resource> deleteResource(@PathVariable int resourceId) {
        return resourceService.deleteResource(resourceId);
    }
}
