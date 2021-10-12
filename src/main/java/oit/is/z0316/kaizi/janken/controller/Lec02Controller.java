package oit.is.z0316.kaizi.janken.controller;

import oit.is.z0316.kaizi.janken.model.Janken;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oit.is.z0316.kaizi.janken.model.Entry;

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

  Janken janken = new Janken();
  /*

  @GetMapping("/lec02")
  public String lec02(){
    janken.initName();
    return "lec02.html";
  }

  @PostMapping("/lec02")
  public String lec02(@RequestParam String name, ModelMap model){
    model.addAttribute("name", name);
    janken.setName(name);
    return "lec02.html";
  }/*

  /*
  @GetMapping("/lec02janken")
  public String lec02janken(@RequestParam String hand, ModelMap model) {
    model.addAttribute("name", janken.getName());
    model.addAttribute("hand", hand);
    return "lec02janken.html";
  }*/

  @GetMapping("step1")
  public String lec02(ModelMap model, Principal prin) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("login_user", loginUser);
    janken.setName(loginUser);
    model.addAttribute("room", this.room);

    return "lec02.html";
  }

  @GetMapping("step2")
  public String lec02(String hand, ModelMap model, Principal prin) {
    model.addAttribute("login_user", janken.getName());
    model.addAttribute("hand", hand);
    model.addAttribute("room", this.room);
    return "lec02.html";
  }

}
