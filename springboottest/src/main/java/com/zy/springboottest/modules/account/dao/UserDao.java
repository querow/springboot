package com.zy.springboottest.modules.account.dao;

import com.zy.springboottest.modules.account.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    @Insert("insert into user(user_name,password,user_image,create_date) values(#{userName},#{password},#{userImage},#{createDate})")
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "user_id")
    void insertUser(User user);

    @Select("select * from user where user_name = #{userName}")
    User getUserByUserName(String userName);
}
