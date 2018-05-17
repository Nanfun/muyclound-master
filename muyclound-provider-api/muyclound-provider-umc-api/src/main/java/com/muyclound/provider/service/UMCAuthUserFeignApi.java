package com.muyclound.provider.service;

import com.muyclound.base.constant.GlobalConstant;
import com.muyclound.provider.dto.AuthUserDto;
import com.muyclound.provider.service.hystrix.UMCAuthUserFeignApiHystrix;
import com.muyclound.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yanglikai on 2018/4/18.
 */
@FeignClient(value = GlobalConstant.UMC_PROVIDER, fallback = UMCAuthUserFeignApiHystrix.class)
public interface UMCAuthUserFeignApi {

  /**
   * 用户密码认证.
   *
   * @param username
   * @param password
   * @return
   */
  @PostMapping(value = "/api/umc/auth/password")
  Wrapper<AuthUserDto> authPassword(
      @RequestParam("username") String username,
      @RequestParam("password") String password);

  /**
   * 短信认证.
   *
   * @param mobile
   * @param verifyCode
   * @return
   */
  @PostMapping(value = "/api/umc/auth/sms")
  Wrapper<AuthUserDto> authSMS(
      @RequestParam("mobile") String mobile,
      @RequestParam("verifyCode") String verifyCode);

  /**
   * 用户名认证.
   *
   * @param username
   * @return
   */
  @PostMapping(value = "/api/umc/auth/username")
  Wrapper<AuthUserDto> authUsername(
      @RequestParam("username") String username);
}
