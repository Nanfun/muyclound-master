package com.muyclound.provider.service.impl;

import com.muyclound.provider.service.SimpleService;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/4/17.
 */
@Service
@Slf4j
public class SimpleServiceImpl implements SimpleService {

  @Override
  public String loadMessage(String key) {
    return "";
  }
}
