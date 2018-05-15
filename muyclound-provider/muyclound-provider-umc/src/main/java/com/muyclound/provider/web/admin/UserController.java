package com.muyclound.provider.web.admin;

import com.muyclound.provider.model.domain.UMCUserDO;
import com.muyclound.provider.model.dto.UMCUserCreateDto;
import com.muyclound.provider.model.query.UMCUserCreateQuery;
import com.muyclound.provider.model.vo.UMCUserCreateVO;
import com.muyclound.provider.service.UMCUserService;
import com.muyclound.util.mapper.MapperUtil;
import com.muyclound.wrapper.WrapMapper;
import com.muyclound.wrapper.Wrapper;
import javax.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/4/16.
 */
@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
  @Resource
  private UMCUserService userService;

  @GetMapping(value = "/umc/user/username/load")
  @ResponseBody
  public Wrapper<UMCUserDO> loadByUsername(String username) {
    UMCUserDO user = userService.loadByUsername(username);
    return WrapMapper.ok(user);
  }

  @GetMapping(value = "/umc/user/mobile/load")
  @ResponseBody
  public Wrapper<UMCUserDO> loadByMobile(String mobile) {
    UMCUserDO user = userService.loadByMobile(mobile);
    return WrapMapper.ok(user);
  }

  @PostMapping(value = "/umc/user/create")
  @ResponseBody
  public Wrapper<UMCUserCreateVO> createUser(@RequestBody UMCUserCreateQuery query) {
    UMCUserDO user = MapperUtil.map(query, UMCUserDO.class);
    UMCUserCreateDto dto = userService.createUser(user);
    return WrapMapper.ok(MapperUtil.map(dto, UMCUserCreateVO.class));
  }
}
