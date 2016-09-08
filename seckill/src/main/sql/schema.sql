--数据库初始化脚本
---创建数据库
CREATE DATABASE sekill;
---使用数据库
use seckill;
--创建表
CREATE TABLE seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` VARCHAR(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
`end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
PRIMARY KEY (seckill_id),
key inx_start_time(start_time),
key inx_end_time(end_time),
key inx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT charset=utf8 comment="秒杀库存表";

----初始化数据
INSERT into seckill(name, number,start_time,end_time)
VALUES
('1000元秒杀iphone6',100,'2016-05-03 00:00:00','2016-05-04 00:00:00'),
('500元秒杀ipad2',200,'2016-05-03 00:00:00','2016-05-04 00:00:00'),
('300元秒杀小米4',300,'2016-05-03 00:00:00','2016-05-04 00:00:00'),
('100元秒杀红米',400,'2016-05-03 00:00:00','2016-05-04 00:00:00');

---秒杀成功明细表
---用户登录认证相关的信息
create table success_killed(
  `seckill_id` bigint NOT NULL comment '秒杀商品id',
  `user_phone` bigint NOT NULL comment '用户手机号',
  `state` tinyint not NULL DEFAULT -1 comment '状态标示：-1 无效，0 成功， 1 已付款',
  `create_time` TIMESTAMP NOT  NULL comment '创建时间',
  PRIMARY key(seckill_id,user_phone),
  key inx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment="秒杀成功明细表";

