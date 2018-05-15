package com.muyclound.provider.model.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/14.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UMCUserCreateQuery implements Serializable {
  private String userName;          // 用户名
  private String password;          // 用户密码
}
