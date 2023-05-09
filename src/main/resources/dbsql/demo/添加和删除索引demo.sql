-- 向表 flyway_demo 一次增加多个索引, 给 status 和age 字段增加普通索引
ALTER TABLE flyway_demo ADD INDEX idx_status(status),ADD INDEX idx_age(age);

-- 向表 flyway_demo的status 普通索引
ALTER TABLE flyway_demo ADD INDEX idx_status(status);

-- 删除表 flyway_demo 的 idx_status索引
ALTER TABLE flyway_demo DROP INDEX idx_status;

-- 增加唯一索引
ALTER TABLE flyway_demo ADD UNIQUE KEY `uk_status` (`status`,`power`);

-- 增加联合索引
ALTER TABLE flyway_demo ADD UNIQUE KEY `uk_status_power` (`status`,`power`);