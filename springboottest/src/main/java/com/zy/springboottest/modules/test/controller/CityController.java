package com.zy.springboottest.modules.test.controller;


import com.github.pagehelper.PageInfo;
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
}
