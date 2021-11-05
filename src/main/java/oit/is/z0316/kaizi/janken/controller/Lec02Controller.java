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
import oit.is.z0316.kaizi.janken.model.MatchInfo;
import oit.is.z0316.kaizi.janken.model.MatchInfoMapper;
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

  @Autowired
  MatchInfoMapper matchInfoMapper;

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

  @GetMapping("match")
  public String match(@RequestParam Integer id, ModelMap model, Principal prin) {
    User user = userMapper.selectById(id);
    janken.setId(id);

    model.addAttribute("user", user);
    return "match.html";
  }

  /*
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

    model.addAttribute("user", user);
    model.addAttribute("hand", hand);
    return "match.html";
  }*/

  @GetMapping("wait")
  public String wait(@RequestParam Integer id, @RequestParam String hand, ModelMap model, Principal prin) {
    MatchInfo matchinfo = new MatchInfo();
    Integer user1 = userMapper.selectIdByName(prin.getName());
    Integer user2 = id;
    String hand1 = hand;

    matchinfo.setUser1(user1);
    matchinfo.setUser2(user2);
    matchinfo.setUser1Hand(hand1);
    matchinfo.setIsActive(true);

    matchInfoMapper.insertMatchInfo(matchinfo);

    return "wait.html";
  }

}
