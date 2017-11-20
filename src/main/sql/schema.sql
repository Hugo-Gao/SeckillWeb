

USE seckill;

CREATE TABLE  seckill(
  `seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `name` VARCHAR(120) NOT NULL COMMENT '商品名称',
  `number` INT NOT NULL COMMENT '库存',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)

)ENGINE =innoDB AUTO_INCREMENT=1000 DEFAULT CHARSET =utf8 COMMENT ='秒杀库存表';

INSERT INTO
  seckill (name, number, start_time, end_time)
VALUES
  ('1000元秒杀iPhone7', 100, '2017-11-01 00:00:00', '2017-11-02 00:00:00'),
  ('500元秒杀小米MIX2', 200, '2017-11-01 00:00:00', '2017-11-02 00:00:00'),
  ('200元秒杀坚果Pro2', 300, '2017-11-01 00:00:00', '2017-11-02 00:00:00'),
  ('100元秒杀三星S8', 50, '2017-11-01 00:00:00', '2017-11-02 00:00:00');

CREATE TABLE success_killed(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品id',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态标识：-1:无效 0:成功 1:已收货',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY(seckill_id,user_phone),
  KEY idx_create_time(create_time)
)ENGINE =innoDB DEFAULT CHARSET =utf8 COMMENT ='秒杀成功明细表';