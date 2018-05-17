package com.muyclound.provider.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.muyclound.core.service.RedisService;
import com.muyclound.core.utils.RedisUtil;
import com.muyclound.provider.model.domain.UMCUserDO;
import com.muyclound.provider.model.domain.UMCUserTokenDO;
import com.muyclound.provider.model.dto.UMCUserCreateDto;
import com.muyclound.provider.model.dto.UMCUserTokenCreateDto;
import com.muyclound.provider.model.enums.RedisKey;
import com.muyclound.provider.repository.UMCUserRepository;
import com.muyclound.provider.repository.UMCUserTokenRepository;
import com.muyclound.util.json.JSONUtil;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikai on 2018/5/14.
 */
@Service
public class UMCUserService {
  @Resource
  private UMCUserRepository userRepository;
  @Resource
  private UMCUserTokenRepository userTokenRepository;
  @Resource
  private RedisService redisService;

  @Transactional(rollbackFor = Exception.class)
  public UMCUserCreateDto createUser(UMCUserDO target) {
    boolean isOK = userRepository.insert(target);

    return
        UMCUserCreateDto.builder()
            .userId(target.getId())
            .build();
  }

  public UMCUserDO loadByUsername(String username) {
    /* 获取缓存 */
    String key = RedisUtil.format(RedisKey.UMC_USER_INFO.key, username);
    String value = redisService.getKey(key);
    if (StringUtils.isNotBlank(value)) {
      return JSONUtil.toBean(value, UMCUserDO.class);
    }

    UMCUserDO user = userRepository.selectOne(
        new EntityWrapper<UMCUserDO>().where("user_name={0}", username));
    if (user == null) {
      return null;
    }

    /* 缓存用户信息 */
    redisService.setKey(key, JSONUtil.toJSON(user), RedisKey.UMC_USER_INFO.expired);
    return user;
  }

  public UMCUserDO loadByMobile(String mobile) {
    return
        userRepository.selectOne(
            new EntityWrapper<UMCUserDO>().where("mobile={0}", mobile));
  }

  public UMCUserTokenCreateDto createUserToken(UMCUserTokenDO target) {
    userTokenRepository.insert(target);
    return
        UMCUserTokenCreateDto.builder()
            .id(target.getId())
            .build();
  }
}
