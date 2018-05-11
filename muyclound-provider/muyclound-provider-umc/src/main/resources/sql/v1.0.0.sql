DROP TABLE IF EXISTS `my_umc_user`;
CREATE TABLE `my_umc_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(32) DEFAULT '' COMMENT '用户名',
  `password` varchar(128) DEFAULT '' COMMENT '用户密码',
  `salt` varchar(64) DEFAULT '' COMMENT '盐',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `email` varchar(32) DEFAULT '' COMMENT '邮箱',
  `nick_name` varchar(32) DEFAULT '' COMMENT '昵称',
  `birthday` varchar(10) DEFAULT '' COMMENT '生日(yyyy-MM-dd)',
  `signature` varchar(50) DEFAULT '' COMMENT '个性签名',
  `sex` char(1) DEFAULT '' COMMENT '性别(F-女,M-男)',
  `avater` varchar(64) DEFAULT '' COMMENT '头像',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态(0-可用、1-禁用、2-冻结)',
  `user_source` varchar(4) DEFAULT '' COMMENT '用户来源',
  `last_login_ip` varchar(15) DEFAULT '' COMMENT '最后登录IP',
  `last_login_location` varchar(64) DEFAULT '{}' COMMENT '最后登录位置{''lat'':xxx.xxx,''lnt'':xxx.xxx}',
  `last_login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `is_changed_pwd_flg` bit(1) DEFAULT b'0' COMMENT '是否修改过密码',
  `pwd_error_count` tinyint(1) DEFAULT '0' COMMENT '连续输错密码次数',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `my_umc_user_token`;
CREATE TABLE `my_umc_user_token` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `user_id` int(11) DEFAULT '0' COMMENT '用户编号',
  `user_name` varchar(32) DEFAULT '' COMMENT '用户名',
  `login_ip` varchar(15) DEFAULT '' COMMENT '登录IP',
  `login_location` varchar(20) DEFAULT '' COMMENT '登录位置',
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `os` varchar(10) DEFAULT '' COMMENT '系统',
  `browser` varchar(24) DEFAULT '' COMMENT '浏览器',
  `access_token` varchar(128) DEFAULT '' COMMENT '授权令牌',
  `refresh_token` varchar(128) DEFAULT '' COMMENT '刷新令牌',
  `access_token_validity` int(11) DEFAULT '0' COMMENT '授权令牌生效时间',
  `refresh_token_validity` int(11) DEFAULT '0' COMMENT '刷新令牌生效时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '令牌状态(0-在线、1-已刷新、2-离线)',
  `expired` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户授权令牌表';
