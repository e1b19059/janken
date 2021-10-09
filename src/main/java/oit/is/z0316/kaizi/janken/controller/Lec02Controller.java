package oit.is.z0316.kaizi.janken.controller;

import oit.is.z0316.kaizi.janken.model.Janken;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Lec02Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
public class Lec02Controller {
  Janken janken = new Janken();

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
  }

  @GetMapping("/lec02janken")
  public String lec02janken(@RequestParam String hand, ModelMap model) {
    model.addAttribute("name", janken.getName());
    model.addAttribute("hand", hand);
    return "lec02janken.html";
  }

}
