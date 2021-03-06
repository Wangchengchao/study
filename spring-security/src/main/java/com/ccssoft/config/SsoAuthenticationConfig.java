package com.ccssoft.config;

import com.ccssoft.SsoAuthenticationFilter;
import com.ccssoft.SsoAuthenticationProvider;
import com.ccssoft.SsoLogoutFilter;
import com.ccssoft.SsoUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

/**
 * <br>
 * Date 2019/1/12 18:46<br>
 * Author Administrator<br>
 */
@Configuration
public class SsoAuthenticationConfig
    extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

  @Override
  public void configure(HttpSecurity http) {
    SsoAuthenticationFilter filter = new SsoAuthenticationFilter();
    filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
    filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler());
    filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/failure"));

    SsoAuthenticationProvider provider = new SsoAuthenticationProvider(new SsoUserDetailsService());

    http.authenticationProvider(provider)
        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
  
    http.addFilterBefore(new SsoLogoutFilter(), LogoutFilter.class);
  }
}
