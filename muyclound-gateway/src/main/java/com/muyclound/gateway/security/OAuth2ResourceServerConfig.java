package com.muyclound.gateway.security;

import com.muyclound.security.core.authentication.FormAuthenticationConfig;
import com.muyclound.security.core.authentication.sms.SMSAuthenticationSecurityConfig;
import com.muyclound.security.core.authorize.AuthorizeConfigManager;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Created by yanglikai on 2018/5/16.
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
  @Resource
  private FormAuthenticationConfig formAuthenticationConfig;
  @Resource
  private SMSAuthenticationSecurityConfig smsAuthenticationSecurityConfig;
  @Resource
  private AccessDeniedHandler accessDeniedHandler;
  @Resource
  private AuthorizeConfigManager authorizeConfigManager;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    formAuthenticationConfig.configure(http);
    http.headers().frameOptions().disable();
    http.apply(smsAuthenticationSecurityConfig)
        .and()
        .headers().frameOptions().disable()
        .and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
        .and()
        .csrf().disable();

    authorizeConfigManager.config(http.authorizeRequests());
  }
}
