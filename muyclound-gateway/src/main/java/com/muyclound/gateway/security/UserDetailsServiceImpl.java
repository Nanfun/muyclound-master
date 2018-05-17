package com.muyclound.gateway.security;

import com.google.common.collect.Lists;
import com.muyclound.base.enums.ErrorCodeEnum;
import com.muyclound.base.exception.BizException;
import com.muyclound.provider.dto.AuthUserDto;
import com.muyclound.provider.exception.UMCBizException;
import com.muyclound.provider.service.UMCAuthUserFeignApi;
import com.muyclound.security.core.SecurityUser;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/5/15.
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
  @Resource
  private UMCAuthUserFeignApi authUserFeignApi;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Wrapper<AuthUserDto> wrapper = authUserFeignApi.authUsername(username);
    if (wrapper == null) {
      throw new BizException(ErrorCodeEnum.GL99990002);
    }

    AuthUserDto user = wrapper.getResult();
    if (user == null) {
      throw new UMCBizException(ErrorCodeEnum.UMC10012001);
    }

    return
        SecurityUser.builder()
            .userId(user.getUserId())
            .userName(user.getUserName())
            .mobile(user.getMobile())
            .authorities(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")))
            .build();
  }
}
