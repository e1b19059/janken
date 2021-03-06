package oit.is.z0316.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT * from users where id = #{id}")
  User selectById(int id);

  @Select("SELECT id from users where name = #{name}")
  Integer selectIdByName(String name);


  @Select("select * from users;")
  ArrayList<User> selectAllUser();

}
