package com.muyclound.provider.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/14.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UMCUserCreateVO implements Serializable {
  private Long userId;
}
