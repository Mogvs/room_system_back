-- 创建一张名为 楼层信息 的表

DROP TABLE IF EXISTS `hotel_floor`;
CREATE TABLE IF NOT EXISTS `hotel_floor`(
     `id` int NOT NULL AUTO_INCREMENT,
    `FLOOR_NAME` varchar(64) default NULL COMMENT '楼层名称',
    `FLOOR_SORT` varchar(64) default NULL COMMENT '楼层号',
    `CREATE_BY` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
    `CREATE_DT` datetime DEFAULT NULL COMMENT '创建日期',
    `MODIFY_BY` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
    `MODIFY_DT` datetime DEFAULT NULL COMMENT '修改日期',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='楼层表';