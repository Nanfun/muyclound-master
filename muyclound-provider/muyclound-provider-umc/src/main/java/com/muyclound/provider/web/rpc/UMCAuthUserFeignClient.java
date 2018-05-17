package com.muyclound.provider.web.rpc;

import com.google.common.collect.Lists;
import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.provider.dto.AuthUserDto;
import com.muyclound.provider.exception.UMCBizException;
import com.muyclound.provider.model.domain.UMCUserDO;
import com.muyclound.provider.service.UMCAuthUserFeignApi;
import com.muyclound.provider.service.UMCUserService;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/18.
 */
@RestController
public class UMCAuthUserFeignClient implements UMCAuthUserFeignApi {
  @Resource
  private UMCUserService userService;

  /**
   * 用户密码认证.
   *
   * @param username
   * @param password
   * @return
   */
  @Override
  public Wrapper<AuthUserDto> authPassword(String username, String password) {
    if ("yanglikai".equals(username) && "yanglikai".equals(password)) {
      return WrapMapper.ok(AuthUserDto.builder().userId(10000L).userName("KK").build());
    }

    throw new UMCBizException(ErrorCodeEnum.UMC10012001);
  }

  /**
   * 短信认证.
   *
   * @param mobile
   * @param verifyCode
   * @return
   */
  @Override
  public Wrapper<AuthUserDto> authSMS(String mobile, String verifyCode) {
    if ("13671803404".equals(mobile) && "123456".equals(verifyCode)) {
      return WrapMapper.ok(AuthUserDto.builder().userId(10000L).userName("KK").build());
    }

    throw new UMCBizException(ErrorCodeEnum.UMC10012002);
  }

  /**
   * 用户名认证.
   *
   * @param username
   * @return
   */
  @Override
  public Wrapper<AuthUserDto> authUsername(String username) {
    UMCUserDO user = userService.loadByUsername(username);
    if (user == null) {
      throw new UMCBizException(ErrorCodeEnum.UMC10012001);
    }

    return WrapMapper.ok(
        AuthUserDto.builder()
            .userId(user.getId())
            .userName(user.getUserName())
            .mobile(user.getMobile())
            .role(Lists.newArrayList("ROLE_USER")).build());
  }
}
