package com.muyclound.security.core.authentication;

import com.muyclound.security.core.properties.SecurityConstants;
import javax.annotation.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 表单登录配置
 * Created by yanglikai on 2018/4/18.
 */
@Component
public class FormAuthenticationConfig {

  @Resource
  private AuthenticationSuccessHandler apiAuthenticationSuccessHandler;
  @Resource
  protected AuthenticationFailureHandler apiAuthenticationFailureHandler;

  public void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
        .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
        .successHandler(apiAuthenticationSuccessHandler)
        .failureHandler(apiAuthenticationFailureHandler);
  }
}
