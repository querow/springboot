package com.zy.springboottest.modules.test.controller;

import com.zy.springboottest.modules.test.entity.Country;
import com.zy.springboottest.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/country/{countryId}")
    Country getCountryByCountryId(@PathVariable int countryId){
        return service.getCountryByCountryId(countryId);
    }
    @PostMapping("/country")
    Country getCountryByCountryName(@RequestParam String countryName){
        return service.getCountryByCountryName(countryName);
    }
}
