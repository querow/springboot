package com.zy.springboottest.modules.test.controller;


import com.github.pagehelper.PageInfo;
import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.common.vo.SearchVo;
import com.zy.springboottest.modules.test.entity.City;
import com.zy.springboottest.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("/cities/{countryId}")
    List<City> getCitiesByCountryId(@PathVariable int countryId){
        return service.getCitiesByCountryId(countryId);
    }

    @PostMapping(value = "/cities/{countryId}",consumes="application/json")
    public PageInfo<City> getCitiesBySearchVo(@PathVariable int countryId,@RequestBody SearchVo searchVo){
        return service.getCitiesBySearchVo(countryId, searchVo);
    }

    @PostMapping(value="/cities",consumes = "application/json")
    public PageInfo<City> getCitiesBySearchVo(@RequestBody SearchVo searchVo){
        return service.getCitiesByDearchVo(searchVo);
    }
    @PostMapping(value="/city",consumes = "application/json")
    public Result<City> insertCity(@ModelAttribute City city){
        return service.insertCity(city);
    }
    @PutMapping(value = "/city", consumes = "application/x-www-form-urlencoded")
    public Result<City> updateCity(City city){
        return service.updateCity(city);
    }

    @DeleteMapping(value="/city/{cityId}")
    public Result<Integer> deleteCity(@PathVariable int cityId){
        return service.deleteCity(cityId);
    }
}
