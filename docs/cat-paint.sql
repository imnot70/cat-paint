create table checkpoint(
	id bigint unsigned auto_increment primary key ,
    user_rank int not null default 1 comment '需要的用户等级',
    user_id bigint comment '用户id，预留',
    model_name varchar(128) not null comment '模型名称',
    model_hash varchar(64) comment '模型hash',
    model_title varchar(256) comment '模型的标题',
    model_file_path varchar(512) comment '模型位置',
    preview varchar(256) comment '预览图地址',
    create_time datetime default current_timestamp() comment '创建时间',
    state tinyint(2) not null default 1 comment '模型状态,0禁用，1启用'
) engine=InnoDB default char set=utf8mb4;
