package com.muyclound.provider.model.enums;

/**
 * Created by yanglikai on 2018/5/14.
 */
public enum RedisKey {
  UMC_USER_INFO("umc:user:info:%s", "用户信息", 60 * 60 * 24 * 30),  // 30天
  ;

  public final String key;
  public final String desc;
  public final int expired;

  RedisKey(String key, String desc, int expired) {
    this.key = key;
    this.desc = desc;
    this.expired = expired;
  }
}
