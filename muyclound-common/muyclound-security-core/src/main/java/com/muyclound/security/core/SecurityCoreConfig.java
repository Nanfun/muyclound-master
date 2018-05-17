package com.muyclound.security.core;

import com.muyclound.security.core.properties.MuySecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 安全核心配置
 * Created by yanglikai on 2018/4/18.
 */
@Configuration
@EnableConfigurationProperties(MuySecurityProperties.class)
public class SecurityCoreConfig {
}
