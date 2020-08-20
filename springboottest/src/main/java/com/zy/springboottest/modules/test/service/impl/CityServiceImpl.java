package com.zy.springboottest.modules.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;
import com.zy.springboottest.modules.test.dao.CityDao;
import com.zy.springboottest.modules.test.entity.City;
import com.zy.springboottest.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
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
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<City>(
                Optional.ofNullable(dao.getCitiesByCountryId(countryId))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public PageInfo<City> getCitiesByDearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<City>(
                Optional.ofNullable(dao.getCitiesByDearchVo(searchVo))
                .orElse(Collections.emptyList()));

    }

    @Override
    @Transactional
    public Result<City> insertCity(City city) {
        city.setDateCreated(new Date());
        dao.insertCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,"insert success",city);
    }

    @Override
    @Transactional
    public Result<City> updateCity(City city) {
        dao.updateCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status,"updateSuccess",city);
    }

    @Override
    @Transactional
    public Result<Integer> deleteCity(int cityId) {
        dao.deleteCity(cityId);
        return new Result<>( Result.ResultStatus.SUCCESS.status,"delete success",cityId);
    }
}
