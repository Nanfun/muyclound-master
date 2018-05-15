package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.UMCUserTokenMapper;
import com.muyclound.provider.model.domain.UMCUserTokenDO;
import com.muyclound.provider.repository.UMCUserTokenRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/5/14.
 */
@Service
public class UMCUserTokenRepositoryImpl
    extends ServiceImpl<UMCUserTokenMapper, UMCUserTokenDO>
    implements UMCUserTokenRepository {
  @Resource
  private UMCUserTokenMapper userTokenMapper;
}
