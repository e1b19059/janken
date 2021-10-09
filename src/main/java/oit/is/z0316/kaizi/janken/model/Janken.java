package oit.is.z0316.kaizi.janken.model;
import java.util.ArrayList;

/**
 * Spring BootでModelとして扱われるクラス フレームワークがフィールドに値を代入したり，取得したりするため，getter/setterが必要
 * これらをじゃんけん用に変更する
 */
public class Janken {
  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void initName() {
    this.name = null;
  }
}
