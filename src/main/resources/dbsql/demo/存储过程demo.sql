-- 向库:fts,表:flyway_demo中添加 status 字段的存储过程示例
DROP PROCEDURE IF EXISTS `add_column`;
DELIMITER //
CREATE PROCEDURE add_column()
BEGIN
	IF NOT EXISTS( SELECT column_name FROM  information_schema.columns WHERE TABLE_SCHEMA=DATABASE() AND table_name='flyway_demo' AND column_name='status')
	THEN
	ALTER TABLE `flyway_demo` ADD COLUMN `status` smallint(2) DEFAULT NULL comment '状态';
	END IF;
END //
DELIMITER ;
-- 调用存储过程
CALL add_column;
-- 调用完毕后删除
DROP PROCEDURE IF EXISTS `add_column`;

-- 判断存在
DROP PROCEDURE IF EXISTS `add_column_exists`;
DELIMITER //
CREATE PROCEDURE add_column_exists()
BEGIN
	IF EXISTS( SELECT column_name FROM  information_schema.columns WHERE TABLE_SCHEMA=DATABASE() AND table_name='flyway_demo' AND column_name='status')
	THEN
	ALTER TABLE `flyway_demo` ADD COLUMN `status` smallint(2) DEFAULT NULL comment '状态';
	END IF;
END //
DELIMITER ;
-- 调用存储过程
CALL add_column_exists;
-- 调用完毕后删除
DROP PROCEDURE IF EXISTS `add_column_exists`;

-- 多层判断
DROP PROCEDURE IF EXISTS `add_column_exists_multi`;
DELIMITER //
CREATE PROCEDURE add_column_exists_multi()
BEGIN
	IF EXISTS( SELECT column_name FROM  information_schema.columns WHERE TABLE_SCHEMA=DATABASE() AND table_name='flyway_demo' AND column_name='status')
	THEN
	ALTER TABLE `flyway_demo` ADD COLUMN `status` smallint(2) DEFAULT NULL comment '状态';
	END IF;
	IF EXISTS( SELECT column_name FROM  information_schema.columns WHERE TABLE_SCHEMA=DATABASE() AND table_name='flyway_demo' AND column_name='status')
    THEN
    ALTER TABLE `flyway_demo` ADD COLUMN `status` smallint(2) DEFAULT NULL comment '状态';
    END IF;
END //
DELIMITER ;
-- 调用存储过程
CALL add_column_exists_multi;
-- 调用完毕后删除
DROP PROCEDURE IF EXISTS `add_column_exists_multi`;