package com.zy.springboottest.modules.test.service.impl;

import com.zy.springboottest.modules.test.dao.CountryDao;
import com.zy.springboottest.modules.test.entity.Country;
import com.zy.springboottest.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao dao;

    @Override
    public Country getCountryByCountryId(int countryId) {
        return dao.getCountryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return dao.getCountryByCountryName(countryName);
    }
}
