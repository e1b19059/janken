package oit.is.z0316.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Lec03AuthConfiguration extends WebSecurityConfigurerAdapter {

  /**
   * 認証処理に関する設定（誰がログインできるか）
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("pass1")).roles("USER");

    auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder().encode("pass2")).roles("USER");

    auth.inMemoryAuthentication().withUser("ほんだ").password(passwordEncoder().encode("ほんだ")).roles("USER");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * 認可処理に関する設定（認証されたユーザがどこにアクセスできるか）
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Spring Securityのフォームを利用してログインを行う
    http.formLogin();
    // http://localhost:8000/sample3 で始まるURLへのアクセスはログインが必要
    // antMatchers().authenticated がantMatchersへのアクセスに認証を行うことを示す
    // antMatchers()の他にanyRequest()と書くとあらゆるアクセス先を表現できる
    // authenticated()の代わりにpermitAll()と書くと認証処理が不要であることを示す
    http.authorizeRequests().antMatchers("/lec02/**").authenticated();

    // Spring Securityの機能を利用してログアウト．ログアウト時は http://localhost:8000/ に戻る
    http.logout().logoutSuccessUrl("/");
  }
}
