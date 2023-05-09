-- 向表:flyway_demo中添加 status 字段的存储过程示例
ALTER TABLE flyway_demo ADD COLUMN `status` VARCHAR(50) COMMENT '脚本执行状态字段';

-- 向表:flyway_demo的id字段后面添加status 字段的存储过程示例
ALTER TABLE flyway_demo ADD COLUMN `status` VARCHAR(50) COMMENT '脚本执行状态字段' AFTER id;

-- 修改表:flyway_demo 字段 status 为 VARCHAR(200)
ALTER TABLE flyway_demo CHANGE COLUMN status status VARCHAR(200) DEFAULT NULL;

-- 同时修改多个字段
ALTER TABLE flyway_demo CHANGE COLUMN status status VARCHAR(200) DEFAULT NULL,CHANGE COLUMN age age varchar(50) DEFAULT NULL;
