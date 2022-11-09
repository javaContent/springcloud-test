CREATE TABLE `user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
`account` varchar(128) NOT NULL COMMENT '账号',
`password` varchar(128) NOT NULL COMMENT '密码',
`real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
`sex` int(1) DEFAULT NULL COMMENT '性别',
`age` int(3) DEFAULT NULL COMMENT '年龄',
`org_id` int(11) NOT NULL COMMENT '机构ID',
`type` int(1) NOT NULL COMMENT '状态：0不可用，1可用',
`remark` varchar(1024) DEFAULT NULL COMMENT '备注',
`create_time` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '创建时间',
`modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_name` varchar(20) DEFAULT NULL COMMENT '创建人',
`modify_name` varchar(20) DEFAULT NULL COMMENT '修改人',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

INSERT INTO `test`.`user` (`id`, `account`, `password`, `real_name`, `sex`, `age`, `org_id`, `type`, `remark`, `create_time`, `modify_time`, `create_name`, `modify_name`) VALUES (1, 'test', '123456', '测试账号', '1', '10', 0, 1, NULL, '1971-01-01 00:00:00', '2021-08-24 19:05:57', NULL, NULL);
