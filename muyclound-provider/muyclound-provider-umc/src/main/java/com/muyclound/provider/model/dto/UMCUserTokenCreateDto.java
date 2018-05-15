package com.muyclound.provider.model.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/14.
 */
@Data
@Builder
public class UMCUserTokenCreateDto implements Serializable {
  private Long id;
}
