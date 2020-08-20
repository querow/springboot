package com.zy.springboottest.modules.test.service;

import com.zy.springboottest.modules.common.vo.Result;
import com.zy.springboottest.modules.test.entity.Card;

public interface CardService {
    Result<Card> insertCard(Card card);
}
