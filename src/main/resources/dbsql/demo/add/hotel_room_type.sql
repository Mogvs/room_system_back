-- 创建一张名为 房间类型表 的表
DROP TABLE IF  EXISTS `hotel_room_type`;
CREATE TABLE IF NOT EXISTS `hotel_room_type` (
     `id` int NOT NULL AUTO_INCREMENT,
     `TYPE_NAME` varchar(30) default NULL COMMENT '房间类型名称',
    `TYPE_SORT` varchar(2) default NULL COMMENT '房间序号',
    `CREATE_BY` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
    `CREATE_DT` datetime DEFAULT NULL COMMENT '创建日期',
    `MODIFY_BY` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
    `MODIFY_DT` datetime DEFAULT NULL COMMENT '修改日期',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='房间类型表';
