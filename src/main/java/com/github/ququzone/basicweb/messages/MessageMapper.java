package com.github.ququzone.basicweb.messages;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Select("select id, source, dest, title, content, readed, created_time from messages where id = #{id}")
    Message find(@Param("id") String id);

    @Select("select count(id) from messages where dest = #{dest} and readed = false")
    Long countUnread(@Param("dest") String dest);

    @Select("select id, source, dest, title, content, readed, created_time from messages where dest = #{dest} " +
            "and readed = false order by created_time desc limit #{limit}")
    @ResultMap("MessageResult")
    List<Message> unreadByDest(@Param("dest") String dest, @Param("limit") int limit);

    @Update("update messages set readed = #{readed} where id = #{id}")
    void updateReaded(@Param("id") String id, @Param("readed") Boolean readed);

    long countByDestAndQ(@Param("dest") String dest, @Param("q") String q);

    List<Message> pageByDestAndQ(@Param("dest") String dest, @Param("q") String q, @Param("limit") int limit, @Param("offset") long offset);
}
