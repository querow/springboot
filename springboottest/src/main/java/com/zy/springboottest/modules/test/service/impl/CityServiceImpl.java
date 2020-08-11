package com.zy.springboottest.modules.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.springboottest.modules.common.vo.SearchVo;
import com.zy.springboottest.modules.test.dao.CityDao;
import com.zy.springboottest.modules.test.entity.City;
import com.zy.springboottest.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao dao;

    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        return Optional
                .ofNullable(dao.getCitiesByCountryId(countryId))
                .orElse(Collections.emptyList());
    }

    @Override
    public PageInfo<City> getCitiesBySearchVo(int countryId, SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<City>(
                Optional.ofNullable(dao.getCitiesByCountryId(countryId))
                        .orElse(Collections.emptyList()));
    }
}
