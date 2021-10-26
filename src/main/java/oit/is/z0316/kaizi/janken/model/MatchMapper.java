package oit.is.z0316.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  //@Select("SELECT id,name from matches where id = #{id}")
  //User selectById(int id);

  @Select("select * from matches;")
  ArrayList<Match> selectAllMatch();

  @Insert("INSERT INTO matches (user1, user2, user1Hand, user2Hand) VALUES (#{user1}, #{user2}, #{user1Hand}, #{user2Hand});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatch(Match match);


  @Insert("INSERT INTO matches (user1,user2,user1Hand,user2Hand) VALUES (123,456,'Gu','Gu');")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertTmpMatch();
}
