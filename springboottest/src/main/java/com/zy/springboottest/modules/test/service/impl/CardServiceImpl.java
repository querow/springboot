package com.zy.springboottest.modules.test.service.impl;

import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.test.entity.Card;
import com.zy.springboottest.modules.test.repository.CardReposotory;
import com.zy.springboottest.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardReposotory cardReposotory;

    @Override
    @Transactional
    public Result<Card> insertCard(Card card) {
        cardReposotory.saveAndFlush(card);
        return new Result<>(Result.ResultStatus.SUCCESS.status,"insert success",card);
    }
}
