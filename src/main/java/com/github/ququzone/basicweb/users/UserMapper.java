package com.github.ququzone.basicweb.users;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * user mapper.
 *
 * @author Yang XuePing
 */
@Mapper
@Component
public interface UserMapper {
    @Select("select id, phone, password, salt, nickname, head, status, created_time, updated_time from users where phone = #{phone}")
    @ResultMap("UserResult")
    User findByPhone(@Param("phone") String phone);

    @Insert("insert into users(id, phone, password, salt, nickname, head, status, created_time) " +
            "values (#{id}, #{phone}, #{password}, #{salt}, #{nickname}, #{head}, #{status}, #{createdTime})")
    void insert(User user);

    @Select("select id, phone, password, salt, nickname, head, status, created_time, updated_time from users where id = #{id}")
    @ResultMap("UserResult")
    User find(@Param("id") String id);
}
