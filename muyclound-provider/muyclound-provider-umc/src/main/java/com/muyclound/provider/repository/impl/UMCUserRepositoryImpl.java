package com.muyclound.provider.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muyclound.provider.mapper.UMCUserMapper;
import com.muyclound.provider.model.domain.UMCUserDO;
import com.muyclound.provider.repository.UMCUserRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/5/14.
 */
@Repository
public class UMCUserRepositoryImpl
    extends ServiceImpl<UMCUserMapper, UMCUserDO>
    implements UMCUserRepository {
  @Resource
  private UMCUserMapper userMapper;
}
