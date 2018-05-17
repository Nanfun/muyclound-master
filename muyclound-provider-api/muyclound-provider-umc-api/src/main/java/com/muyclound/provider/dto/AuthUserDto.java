package com.muyclound.provider.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/4/18.
 */
@Data
@Builder
public class AuthUserDto implements Serializable {
  private Long userId;
  private String userName;
  private String mobile;
  private List<String> role;
}
