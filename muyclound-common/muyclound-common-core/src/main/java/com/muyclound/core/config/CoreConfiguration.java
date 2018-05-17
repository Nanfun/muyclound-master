package com.muyclound.core.config;

import com.muyclound.core.interceptor.TokenInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created by yanglikai on 2018/5/16.
 */
@Configuration
public class CoreConfiguration {

  @Bean
  @ConditionalOnMissingBean(HandlerInterceptor.class)
  @ConditionalOnProperty(prefix = "muyclound.token.interceptor", name = "enable", havingValue = "true")
  public TokenInterceptor tokenInterceptor() {
    return new TokenInterceptor();
  }
}
