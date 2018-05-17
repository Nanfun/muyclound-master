package com.muyclound.consumer.service;

import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/4/16.
 */
@Service
@Slf4j
public class ConsumerService {
  public String loadMessage(String key) {
    return "";
  }

  public String error() {
    throw new RuntimeException("异常错误请求");
  }

  public String info() {
    log.info("consumer-service:" + "info");
    log.error("consumer-service:" + "error");
    return "";
  }
}
