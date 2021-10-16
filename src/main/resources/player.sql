CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '玩家ID',
  `name` varchar(32) DEFAULT NULL COMMENT '玩家名',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  `utime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='玩家信息表';