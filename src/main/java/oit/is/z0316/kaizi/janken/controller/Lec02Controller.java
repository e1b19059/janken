package oit.is.z0316.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0316.kaizi.janken.model.Entry;
import oit.is.z0316.kaizi.janken.model.Janken;
import oit.is.z0316.kaizi.janken.model.Match;
import oit.is.z0316.kaizi.janken.model.MatchMapper;
import oit.is.z0316.kaizi.janken.model.User;
import oit.is.z0316.kaizi.janken.model.UserMapper;

/**
 * Lec02Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  @Autowired
  private Entry room;

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  Janken janken = new Janken();

  @GetMapping("step1")
  @Transactional
  public String lec02(ModelMap model, Principal prin) {
    ArrayList<User> userList = userMapper.selectAllUser();
    ArrayList<Match> matchList = matchMapper.selectAllMatch();

    model.addAttribute("userList", userList);
    model.addAttribute("matchList", matchList);
    model.addAttribute("room", this.room);

    return "lec02.html";
  }

  @GetMapping("step2")
  @Transactional
  public String lec02(String hand, ModelMap model, Principal prin) {
    ArrayList<User> userList = userMapper.selectAllUser();
    ArrayList<Match> matchList = matchMapper.selectAllMatch();

    model.addAttribute("userList", userList);
    model.addAttribute("matchList", matchList);
    model.addAttribute("room", this.room);
    model.addAttribute("hand", hand);

    return "lec02.html";
  }

  @GetMapping("step3")
  public String match(@RequestParam Integer id, ModelMap model, Principal prin) {
    User user = userMapper.selectById(id);
    janken.setId(id);

    model.addAttribute("user", user);
    return "match.html";
  }

  @GetMapping("step4")
  public String match(@RequestParam Integer id, @RequestParam String hand, ModelMap model, Principal prin) {
    Match match = new Match();
    Integer user1 = userMapper.selectIdByName(prin.getName());
    Integer user2 = id;
    String hand1 = hand;
    String hand2 = "Gu";

    User user = userMapper.selectById(user2);

    match.setUser1(user1);
    match.setUser2(user2);
    match.setUser1Hand(hand1);
    match.setUser2Hand(hand2);


    matchMapper.insertMatch(match);
    //確かめ
    //model.addAttribute("match", match);

    model.addAttribute("user", user);
    model.addAttribute("hand", hand);
    return "match.html";
  }


  /*@GetMapping("match2")
  public String match(@RequestParam Integer id, @RequestParam String hand1, ModelMap model, Principal prin) {
    Match match = new Match();
    int user1 = userMapper.selectIdByName(prin.getName());
    int user2 = id;
    String hand2 = "Gu";

    User user = userMapper.selectById(id);

    match.setUser1(user1);
    match.setUser2(user2);
    match.setUser1Hand(hand1);
    match.setUser2Hand(hand2);

    //matchMapper.insertMatch(match);

    matchMapper.insertMatch();
    System.out.println(match.getId());
    System.out.println(match.getUser1());
    System.out.println(match.getUser1Hand());
    System.out.println(match.getUser2());
    System.out.println(match.getUser2Hand());

    model.addAttribute("user", user);
    model.addAttribute("hand1", hand1);
    return "match.html";
  }*/

}
