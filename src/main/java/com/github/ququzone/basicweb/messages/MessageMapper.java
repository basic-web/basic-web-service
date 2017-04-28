package com.github.ququzone.basicweb.messages;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * message mapper.
 *
 * @author Yang XuePing
 */
@Mapper
@Component
public interface MessageMapper {
    @Insert("insert into messages(id, source, dest, title, content, readed, created_time) " +
            "values (#{id}, #{source}, #{dest}, #{title}, #{content}, #{readed}, #{createdTime})")
    void insert(Message message);
}
