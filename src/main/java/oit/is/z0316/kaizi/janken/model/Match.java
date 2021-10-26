package oit.is.z0316.kaizi.janken.model;

public class Match {
  Integer id;
  Integer user1, user2;
  String user1Hand, user2Hand;

  public Match() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUser1() {
    return user1;
  }

  public void setUser1(Integer user1) {
    this.user1 = user1;
  }

  public Integer getUser2() {
    return user2;
  }

  public void setUser2(Integer user2) {
    this.user2 = user2;
  }

  public String getUser1Hand() {
    return user1Hand;
  }

  public void setUser1Hand(String user1Hand) {
    this.user1Hand = user1Hand;
  }

  public String getUser2Hand() {
    return user2Hand;
  }

  public void setUser2Hand(String user2Hand) {
    this.user2Hand = user2Hand;
  }
}
