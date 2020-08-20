package com.zy.springboottest.modules.test.repository;

import com.zy.springboottest.modules.test.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardReposotory extends JpaRepository<Card,Integer> {
}
