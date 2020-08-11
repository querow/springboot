package com.zy.springboottest.modules.test.service;

import com.zy.springboottest.modules.test.entity.Country;

public interface CountryService {

    Country getCountryByCountryId(int countryId);

    Country getCountryByCountryName(String countryName);

}
