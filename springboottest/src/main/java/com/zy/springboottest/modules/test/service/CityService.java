package com.zy.springboottest.modules.test.service;

import com.github.pagehelper.PageInfo;
import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;
import com.zy.springboottest.modules.test.entity.City;

import java.util.List;

public interface CityService {

    List<City> getCitiesByCountryId(int countryId);

    PageInfo<City> getCitiesBySearchVo(int countryId, SearchVo searchVo);

    PageInfo<City> getCitiesByDearchVo(SearchVo searchVo);

    Result<City> insertCity(City city);

    Result<City> updateCity(City city);

    Result<Integer> deleteCity(int cityId);
}
