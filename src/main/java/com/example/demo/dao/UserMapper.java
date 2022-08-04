package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO TABLE_USER(NAME) VALUE (#{name})")
    void insert(@Param("name") String name);

    @Select("select * from table_user where name = #{name}")
    User select(@Param("name") String name);

    @Delete("delete from table_user where name = #{name}")
    void delete(@Param("name") String name);
}
