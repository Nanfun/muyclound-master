package com.muyclound.gateway.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/5/16.
 */
@Component("apiAuthenticationFailureHandler")
public class ApiAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                      AuthenticationException exception) throws IOException, ServletException {

    logger.info("登录失败");

    //// 记录失败次数 和原因 ip等信息 5次登录失败,锁定用户, 不允许在此登录
    //
    //response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    //response.setContentType("application/json;charset=UTF-8");
    //response.getWriter().write(objectMapper.writeValueAsString(WrapMapper.error(exception.getMessage())));

  }
}
