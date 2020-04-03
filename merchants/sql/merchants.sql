create table `merchants`(
`id` int(10) unsigned not  null  auto_increment,
`name` varchar(64) collate utf8_bin not null comment '用户名称',
`logo_url` varchar(256)  collate utf8_bin not null comment '商户 logo',
`business_license_url` varchar(256) collate utf8_bin not null comment '商户营业执照',
`phone` varchar(64) collate utf8_bin not null comment '商户电话',
`address` varchar(64) collate utf8_bin not null comment '用户地址',
`is_audit` boolean not null comment '是否通过审核',
primary  key (`id`)
) engine = InnoDB AUTO_INCREMENT=17 default charset=utf8;
