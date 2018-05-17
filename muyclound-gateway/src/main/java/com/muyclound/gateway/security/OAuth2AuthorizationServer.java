package com.muyclound.gateway.security;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * Created by yanglikai on 2018/5/15.
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
  @Resource
  private AuthenticationManager authenticationManager;
  @Resource
  private UserDetailsService userDetailsService;
  @Resource
  private RestClientDetailsServiceImpl restClientDetailsService;

  @Resource
  private TokenStore tokenStore;
  @Resource
  private JwtAccessTokenConverter jwtAccessTokenConverter;
  @Resource
  private TokenEnhancer jwtTokenEnhancer;


  /**
   * Configure.
   *
   * @param security the security
   * @throws Exception the exception
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("permitAll()");
    security.allowFormAuthenticationForClients();
  }

  /**
   * Configure.
   *
   * @param clients the clients
   * @throws Exception the exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.withClientDetails(restClientDetailsService);
  }

  /**
   * Configure.
   *
   * @param endpoints the endpoints
   * @throws Exception the exception
   */
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore)
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);

    if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
      TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
      List<TokenEnhancer> enhancers = new ArrayList<>();
      enhancers.add(jwtTokenEnhancer);
      enhancers.add(jwtAccessTokenConverter);
      enhancerChain.setTokenEnhancers(enhancers);
      endpoints.tokenEnhancer(enhancerChain).accessTokenConverter(jwtAccessTokenConverter);
    }
  }
}
