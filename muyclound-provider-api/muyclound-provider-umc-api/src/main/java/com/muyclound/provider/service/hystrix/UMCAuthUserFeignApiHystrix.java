package com.muyclound.provider.service.hystrix;

import com.muyclound.provider.dto.AuthUserDto;
import com.muyclound.provider.service.UMCAuthUserFeignApi;
import com.muyclound.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Component
@Slf4j
public class UMCAuthUserFeignApiHystrix implements UMCAuthUserFeignApi {
  @Override
  public Wrapper<AuthUserDto> authPassword(String username, String password) {
    return null;
  }

  @Override
  public Wrapper<AuthUserDto> authSMS(String mobile, String verifyCode) {
    return null;
  }

  @Override
  public Wrapper<AuthUserDto> authUsername(String username) {
    return null;
  }
}
