package com.muyclound.provider.model.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/5/11.
 */
@Data
@TableName(value = "my_umc_user_token")
public class UMCUserTokenDO implements Serializable {
  @TableId
  private Long id;                      // 主键
  private Long userId;                  // 用户编号
  private String userName;              // 用户名
  private String loginIp;               // 登录IP
  private String loginLocation;         // 登录位置
  private Date loginTime;               // 登录时间
  private String os;                    // 系统
  private String browser;               // 浏览器
  private String accessToken;           // 访问令牌
  private String refreshToken;          // 刷新令牌
  private Integer accessTokenValidity;  // 访问令牌生效时间
  private Integer refreshTokenValidity; // 刷新令牌生效时间
  private Integer status;               // 令牌状态(0-在线、1-已刷新、2-离线)
  private Date expired;                 // 过期时间
  private Date createTime;              // 创建时间
  private Date updateTime;              // 更新时间
}
