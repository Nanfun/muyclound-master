package com.muyclound.external.gen.v1_0_0.model.icbc;


import com.muyclound.external.model.APIResult;
import lombok.Data;

/**
 * 工行-获取支付凭证接口返回结果.
 * Created by yanglikai on 2018/3/16.
 */
@Data
public class ICBCPayTicketGetResult implements APIResult {
  private String ticket;
  private String expiredtime;
}
