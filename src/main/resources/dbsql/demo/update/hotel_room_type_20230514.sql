-- 同时修改房间类型,房间序号
ALTER TABLE hotel_room_type CHANGE COLUMN TYPE_NAME TYPE_NAME VARCHAR(64) DEFAULT NULL,CHANGE COLUMN TYPE_SORT TYPE_SORT varchar(64) DEFAULT NULL;
