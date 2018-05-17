package com.muyclound.consumer.web;

import com.muyclound.consumer.service.ConsumerService;
import com.muyclound.dc.enums.EventEnum;
import com.muyclound.dc.wrapper.LogWrapper;
import com.muyclound.provider.service.OMCOrderFeignApi;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/16.
 */
@Slf4j
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SimpleController {
  @Resource
  private OMCOrderFeignApi omcOrderFeignApi;
  @Resource
  private ConsumerService consumerService;

  @GetMapping("/consumer")
  @ResponseBody
  Wrapper<String> consumer() {
    Wrapper<String> omcResult = omcOrderFeignApi.loadOrderCode();

    return WrapMapper.ok("OMCResult:" + omcResult.getResult());
  }

  @GetMapping("/log")
  @ResponseBody
  public Wrapper<String> log(HttpServletRequest request) {
    LogWrapper.collection(EventEnum.CLICK, request);
    return WrapMapper.ok();
  }

  @GetMapping("/error")
  @ResponseBody
  public Wrapper<String> error() {
    return WrapMapper.ok(consumerService.error());
  }

  @GetMapping("/info")
  @ResponseBody
  public Wrapper<String> info() {
    log.info("业务日志:" + "info");
    log.error("业务日志:" + "info");
    return WrapMapper.ok();
  }

  @GetMapping("/info/log")
  @ResponseBody
  public Wrapper<String> log() {
    consumerService.info();
    return WrapMapper.ok();
  }
}
