package oit.is.z0316.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchInfoMapper {

  @Select("select * from matchinfo;")
  ArrayList<MatchInfo> selectAllInfo();

  @Select("select * from matchinfo where user1 = #{user1} and user2 = #{user2} and isActive = true;")
  MatchInfo selectInfoById(int user1, int user2);

  @Select("select count(*) from matchinfo where user1 = #{user1} and user2 = #{user2} and isActive = true;")
  int selectInfoCount(int user1, int user2);

  @Select("select user1Hand from matchinfo where user1 = #{user1} and user2 = #{user2} and isActive = true;")
  String select1Hand(int user1, int user2);

  @Insert("INSERT INTO matchinfo (user1,user2,user1Hand,isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertInfo(MatchInfo matchinfo);

  @Select("select id from matchinfo where user1 = #{user1} and user2 = #{user2} and isActive = true;")
  int selectId(int user1, int user2);

  @Update("UPDATE matchinfo SET isActive=false WHERE ID = #{id}")
  void updatetf(int id);

}
