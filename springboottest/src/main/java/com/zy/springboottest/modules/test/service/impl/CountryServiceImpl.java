package com.zy.springboottest.modules.test.service.impl;

import com.zy.springboottest.modules.test.dao.CountryDao;
import com.zy.springboottest.modules.test.entity.Country;
import com.zy.springboottest.modules.test.service.CountryService;
import com.zy.springboottest.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao dao;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Country getCountryByCountryId(int countryId) {
        return dao.getCountryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return dao.getCountryByCountryName(countryName);
    }

    @Override
    public Country mograteCountryByRedis(int countryId) {
        Country country = dao.getCountryByCountryId(countryId);
        String countryKey = String.format("country%d",countryId);
        redisUtils.set(countryKey,country);

        return (Country)redisUtils.get(countryKey) ;
    }
}
