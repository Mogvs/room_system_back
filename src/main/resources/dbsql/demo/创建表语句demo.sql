-- 创建一张名为 demo 的表
CREATE TABLE IF NOT EXISTS demo (
  `id` BIGINT(20) NOT NULL auto_increment COMMENT '主键ID',
  `name` varchar(30) default NULL COMMENT '姓名',
  `sex` varchar(2) default NULL COMMENT '性别',
  `age` int(11) default NULL COMMENT '年龄',
  `birthday` date default NULL COMMENT '生日',
  `email` varchar(50) default NULL COMMENT '邮箱',
  `content` varchar(1000) default NULL COMMENT '个人简介',
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;