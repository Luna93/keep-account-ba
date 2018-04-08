CREATE TABLE `keep_daliy_flow` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `type` int(2) DEFAULT NULL COMMENT '类型：1收入 2支出',
  `sub_type` int(2) DEFAULT NULL COMMENT '子类型',
  `sub_type_name` varchar(255) DEFAULT NULL COMMENT '子类型备注',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `account_time` varchar(10) DEFAULT NULL COMMENT '消费时间:YYYY-MM-dd',
  `is_deleted` int(2) NOT NULL DEFAULT '0' COMMENT '0未删除 1已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'source id',
  `appid` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '小程序appid(区分小程序)',
  `openid` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户的openid',
  `unionid` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户的unionid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_appid` (`appid`),
  KEY `idx_openid_unionid` (`openid`,`unionid`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='小程序用户表';
