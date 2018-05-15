package com.muyclound.core.service;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/5/14.
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {
  @Resource
  private StringRedisTemplate rt;

  /**
   * Gets key.
   *
   * @param key the key
   * @return the key
   */
  @Override
  public String getKey(String key) {
    String value = null;
    ValueOperations<String, String> ops = rt.opsForValue();
    if (rt.hasKey(key)) {
      value = ops.get(key);
    }

    log.info("getKey. [OK] key={}, value={}", key, value);
    return value;
  }

  /**
   * Delete key.
   *
   * @param key the key
   */
  @Override
  public void deleteKey(String key) {
    rt.delete(key);

    log.info("deleteKey. [OK] key={}", key);
  }

  /**
   * Sets key.
   *
   * @param key   the key
   * @param value the value
   */
  @Override
  public void setKey(String key, String value) {
    Preconditions.checkArgument(StringUtils.isNotEmpty(key), "Redis key is not null");

    ValueOperations<String, String> ops = rt.opsForValue();
    ops.set(key, value);
    rt.expire(key, 60L, TimeUnit.MILLISECONDS);

    log.info("setKey. [OK] key={}, value={}, expire=默认超时时间", key, value);
  }

  /**
   * Sets key.
   *
   * @param key     the key
   * @param value   the value
   * @param timeout the timeout
   */
  @Override
  public void setKey(String key, String value, long timeout) {
    Preconditions.checkArgument(StringUtils.isNotEmpty(key), "Redis key is not null");

    ValueOperations<String, String> ops = rt.opsForValue();
    ops.set(key, value);
    rt.expire(key, timeout, TimeUnit.MILLISECONDS);

    log.info("setKey. [OK] key={}, value={}, timeout={}", key, value, timeout);
  }

  /**
   * Sets key.
   *
   * @param key     the key
   * @param value   the value
   * @param timeout the timeout
   * @param unit    the unit
   */
  @Override
  public void setKey(String key, String value, long timeout, TimeUnit unit) {
    Preconditions.checkArgument(StringUtils.isNotEmpty(key), "Redis key is not null");
    Preconditions.checkArgument(unit != null, "TimeUnit is not null");

    ValueOperations<String, String> ops = rt.opsForValue();
    ops.set(key, value);
    rt.expire(key, timeout, unit);

    log.info("setKey. [OK] key={}, value={}, timeout={}, unit={}", key, value, timeout, unit);
  }
}
