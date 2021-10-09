package oit.is.z0316.kaizi.janken.controller;

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

  /**
   * sample21というGETリクエストがあったら sample21()を呼び出し，sample21.htmlを返す
   */

  @GetMapping("/lec02")
  public String lec02(){
    return "lec02.html";
  }

  @PostMapping("/lec02")
  public String lec02(@RequestParam String name, ModelMap model){
    model.addAttribute("name", name);
    return "lec02.html";
  }
}
