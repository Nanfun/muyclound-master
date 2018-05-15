package com.muyclound.core.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/5/15.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RedisUtil {

  public static String format(String key, String value) {
    return String.format(key, value);
  }
}
