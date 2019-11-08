
-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`            bigint(20)  NOT NULL COMMENT '主键',
    `username`      varchar(20) NOT NULL COMMENT '用户名',
    `nickname`      varchar(20)          DEFAULT NULL COMMENT '昵称',
    `password`      varchar(64) NOT NULL COMMENT '密码',
    `salt`          varchar(32)          DEFAULT NULL COMMENT '盐值',
    `phone`         varchar(20) NOT NULL COMMENT '手机号码',
    `gender`        int(11)     NOT NULL DEFAULT '1' COMMENT '性别，0：女，1：男，默认1',
    `head`          varchar(200) NULL comment '头像',
    `remark`        varchar(200)         DEFAULT NULL COMMENT 'remark',
    `state`         int(11)     NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用，2：锁定',
    `department_id` bigint(20)  NOT NULL COMMENT '部门id',
    `role_id`       bigint(20)  NOT NULL COMMENT '角色id',
    `deleted`       int(11)     NOT NULL DEFAULT '0' COMMENT '逻辑删除，0：未删除，1：已删除',
    `version`       int(11)     NOT NULL DEFAULT '0' COMMENT '版本',
    `create_time`   timestamp   NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp   NULL     DEFAULT NULL COMMENT '修改时间',
	`user_type`			int(11)     NOT NULL COMMENT '用户类型，0：个人/团队，1：企业',
	`is_service`		int(11)     NOT NULL COMMENT '是否为服务商，0：否,1：是',
	`province`			int(6)     	NOT NULL COMMENT '省',
	`city`					int(6)     	NOT NULL COMMENT '市',
	`zone`					int(6)     	NOT NULL COMMENT '区/县',
    `address`       varchar(50) NULL comment '联系地址',
    `email`       	varchar(50) NOT NULL comment '邮箱',
	`tax`						int(11)     NULL COMMENT '传真',
	`scale`					varchar(10)     NULL COMMENT '传真',
	`intro`					varchar(500)     NULL COMMENT '介绍',
	`wechat`				varchar(20)     NULL COMMENT '微信号',
	`pro_type`			int(10)     NULL COMMENT '承接项目类型',
	`id_num`				varchar(18)     NULL COMMENT '身份证号',
	`id_front`			varchar(30)     NULL COMMENT '身份证正面',
	`id_back`			varchar(30)     NULL COMMENT '身份证背面',
	`id_validity`			varchar(8)     NULL COMMENT '身份证有效期',
	`birthday`			varchar(8)     NULL COMMENT '出生日期',
	`constellation`			varchar(6)     NULL COMMENT '星座',
	`major`			int(10)     NULL COMMENT '专业',
	`team_name`			varchar(40)     NULL COMMENT '团队名称',
	`company_name`			varchar(40)     NULL COMMENT '公司名称',
	`license_id`			varchar(30)     NULL COMMENT '企业组织机构代码',
	`website`			varchar(50)     NULL COMMENT '网址',
	`company_type`			varchar(50)     NULL COMMENT '公司类型',
	`service_type`			varchar(50)     NULL COMMENT '业务类型',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_user_username_uindex` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user (id, username, nickname, password, salt, phone, gender, head, remark, state, department_id, role_id, deleted, version, create_time, update_time,user_type,is_service,province,city,zone,email) VALUES (1, 'admin', '管理员', '11a254dab80d52bc4a347e030e54d861a9d2cdb2af2185a9ca4a7318e830d04d', '666', '', 1, 'http://localhost:8888//resource/201910281559227.jpg', 'Administrator Account', 1, 1, 1, 0, 1, '2019-08-26 00:52:01', '2019-10-27 23:32:29',0,0,35,06,22,'79363508@qq.com');
INSERT INTO sys_user (id, username, nickname, password, salt, phone, gender, head, remark, state, department_id, role_id, deleted, version, create_time, update_time,user_type,is_service,province,city,zone,email) VALUES (2, 'test', '测试人员', '34783fb724b259beb71a1279f7cd93bdcfd92a273d566f926419a37825c500df', '087c2e9857f35f1e243367f3b89b81c1', '', 1, null, 'Tester Account', 1, 1, 2, 0, 0, '2019-10-05 14:04:27', null,0,0,35,06,22,'79363508@qq.com');


-- ----------------------------
-- Table structure for category
-- ----------------------------
drop table if exists `category`;
create table category
(
    id     bigint                         	not null comment '主键' primary key,
	category_type	int  		                 	comment '类别性质 0：需求分类 1：项目类型 2：项目专业 3：文章分类',
	cate_name		varchar(64)						not null comment '名称',
    cate_parent_id  bigint                         	comment '父级分类ID',
    sort    		int     default 0               not null comment '排序',
    intro    		varchar(128)                    not null comment '分类介绍',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类别管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_order
-- ----------------------------
drop table if exists `project_order`;
create table project_order
(
    id     bigint                         	not null comment '主键' primary key,
	user_id			bigint								comment '用户/雇主id',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
	pay_time		datetime						comment '付款完成时间',
	examine_time		datetime						comment '审核时间',
	pick_time		datetime						comment '选标完成时间',
	check_time		datetime						comment '验收完成时间',
	category_id			bigint								comment '分类id',
	major			varchar(256)					comment '专业要求,用|隔开',
	province		int								comment '项目所在地（省）',
	city			int								comment '项目所在地（市）',
	end_time		datetime						comment '截止报名时间',
	period			int								comment '交付周期 单位天',
	soft_supplier	varchar(64)						comment '软件供应商',
	soft_name		varchar(64)						comment '软件名称',
	intro			varchar(1024)					comment '详细描述',
	state			int								comment	'订单状态 0：发布 1：进行中 2:  完成 3、关闭',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_requirement
-- ----------------------------
drop table if exists `project_requirement`;
create table project_requirement
(
    id     	bigint                         	not null comment '主键' primary key,
	category_id			bigint  		                 	comment '项目类型ID',
	order_id			bigint								comment '订单ID',
    qty  				int                         	comment '单体数量',
    count_type    		int     default 0               comment '计入方式,默认为0，0:表示以地上总建筑面积计入 1:表示以总投资金额计入',
    area 				float 							comment '地上总建筑面积,单位平米',
    amount 				float 							comment '总投资金额,单位万元',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目类型要求' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_source
-- ----------------------------
drop table if exists `project_source`;
create table project_source
(
    id     	bigint                         	not null comment '主键' primary key,
	original_name			varchar(64)  		                 	comment '资料原名称',
	source_name			varchar(64)  		                 	comment '资料现名称',
    format  			varchar(16)                     comment '文件格式',
    size    			int                    			comment '资料大小',
	order_id			bigint								comment '订单ID',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目资料' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_examine
-- ----------------------------
drop table if exists `project_examine`;
create table project_examine
(
    id     	bigint                         	not null comment '主键' primary key,
	order_id			bigint								comment '订单ID',
    state    			int           default 0         not null comment '审核状态，0：待审核 1：审核通过 2:  驳回 3：审核超时',
	role_id			bigint  		                 	comment '审核人',
	examine_time		datetime  		                 	comment '审核时间',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目审核' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_pay
-- ----------------------------
drop table if exists `order_pay`;
create table order_pay
(
    id     	bigint                         	not null comment '主键' primary key,
	order_id			bigint								comment '订单ID',
	pay_time			datetime						comment '付款时间',
	amount			int									comment '订单总额',
	discount		int									comment '优惠金额',
	actual_amount	int									comment '实际付款',
	flow_num		int 								comment	'流水号',
	user_id			bigint									comment '用户ID',
	pay_method		int 			default 0			not null comment '支付方式,1、银行卡 2、支付宝 3、微信',
    state    		int           	default 0         not null comment '交易状态，0:待付款 1：交易成功 2：交易失败 3、付款超时 4、退款',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单付款信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_bidding
-- ----------------------------
drop table if exists `order_bidding`;
create table order_bidding
(
    id     	bigint                         	not null comment '主键' primary key,
	order_id			bigint								comment '订单ID',
	user_id			bigint  		                 	comment '会员ID',
	create_time		timestamp default CURRENT_TIMESTAMP  	comment '投标时间',
    state    			int           default 0         not null comment '中标状态，0：等待选标 1：超时 2：选中 3、未中标',
    message      	varchar(128)                    null comment '留言',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单竞标信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_progress
-- ----------------------------
drop table if exists `order_progress`;
create table order_progress
(
    id     	bigint                         	not null comment '主键' primary key,
	start_time		datetime							comment '开始时间',
	end_time		datetime							comment '结束时间',
	intro			varchar(512)						comment '进度说明',
	source_id		bigint									comment '资料图纸信息ID',
	order_id			bigint								comment '订单ID',
    remark      	varchar(256)                    null comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单项目进度信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_check
-- ----------------------------
drop table if exists `order_check`;
create table order_check
(
    id     	bigint                         	not null comment '主键' primary key,
	order_id			bigint								comment '订单ID',
	creat_time		timestamp default CURRENT_TIMESTAMP	comment '创建时间',
	file_nsame		varchar(32)							comment '成果文件名',
	format			varchar(16)							comment '成果文件格式',
	size			int									comment '成果文件大小',
	intro			varchar(512)						comment '成果描述',
	check_time		datetime							comment '验收时间',
	state			int									comment '验收状态 0：待审核 1：审核通过 2：驳回',
    suggest      	varchar(256)                    	comment '验收意见',
    remark      	varchar(256)                    	comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单验收信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_rights
-- ----------------------------
drop table if exists `order_rights`;
create table order_rights
(
    id     	bigint                         	not null comment '主键' primary key,
	order_id			bigint								comment '订单ID',
	user_id			bigint								comment '会员ID',
	rights_type		int								comment '维权类型',
	intro			varchar(512)						comment '说明',
	source1			varchar(32)							comment '维权证明1',
	source2			varchar(32)							comment '维权证明2',
	source3			varchar(32)							comment '维权证明3',
	source4			varchar(32)							comment '维权证明4',
	source5			varchar(32)							comment '维权证明5',
	source6			varchar(32)							comment '维权证明6',
	creat_time		timestamp default CURRENT_TIMESTAMP	comment '发起时间',
	state			int									comment '验收状态 0：待审核 1：审核通过 2：驳回',
	protect_time	datetime							comment '审核时间',
	role_id			bigint									comment '审核人',
    suggest      	varchar(256)                    	comment '审核意见',
    remark      	varchar(256)                    	comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单维权' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_comment
-- ----------------------------
drop table if exists `order_comment`;
create table order_comment
(
    id     	bigint                         	not null comment '主键' primary key,
	content			varchar(256)								comment '评价内容',
	technical_grade int									comment '技能评分',
	server_grade	int									comment '服务评分',
	multi_grade		int									comment '综合评分',
	user_id			bigint									comment	'会员ID',
	order_id			bigint								comment '订单ID',
	comment_tag		varchar(16)							comment '评价标签',
	create_time		timestamp default CURRENT_TIMESTAMP	comment '创建时间',
    remark      	varchar(256)                    	comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
drop table if exists `collect`;
create table collect
(
    id     	bigint                         	not null comment '主键' primary key,
	user_id			bigint									comment	'会员ID',
	supplier_id		bigint									comment '服务商ID',
	create_time		timestamp default CURRENT_TIMESTAMP	comment '创建时间',
	tag				varchar(64)							comment '服务商标签',
    remark      	varchar(256)                    	comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏的服务商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for under_case
-- ----------------------------
drop table if exists `under_case`;
create table under_case
(
    id     	bigint                         	not null comment '主键' primary key,
	user_id			bigint									comment	'会员ID',
	case_name		varchar(64)							comment '项目名称',
	category_id		bigint									comment '项目类型ID',
	major			varchar(64)							comment '专业',
	province		int									comment '省',
	city			int									comment '市',
	soft_supplier	varchar(64)							comment '软件',
	intro			varchar(256)						comment '介绍',
	create_time		timestamp default CURRENT_TIMESTAMP	comment '创建时间',
    remark      	varchar(256)                    	comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '线下案例' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
drop table if exists `article`;
create table article
(
    id     	bigint                         	not null comment '主键' primary key,
	title			varchar(64)							comment '标题',
	create_time		timestamp default CURRENT_TIMESTAMP	comment '发布时间',
	content			text								comment '文章内容',
	user_id			bigint									comment	'发布人',
    remark      	varchar(256)                    	comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
drop table if exists `sys_setting`;
create table sys_setting
(
    id     	bigint                         	not null comment '主键' primary key,
	soft_supplier			varchar(64)							comment '软件供应商',
	company_type 			varchar(128)						comment '公司类型',
	estate					varchar(128)						comment '合作地产',
	hot_key					varchar(128)						comment '热搜关键词',
	protect_type			varchar(128)						comment '维权类型',
	hot_tag					varchar(128)						comment	'热门评价标签',
	b_limit					int									comment '选标时间限制',
	e_limit					int									comment '审核时间限制',
	p_limit					int 								comment '付款时间限制',
	website					int									comment '域名',
	record_num				varchar(32)							comment '备案号',
	company_name			varchar(64)							comment '企业名称',
	tel						varchar(16)							comment '联系电话',
	address					varchar(64)							comment '地址',
	email					varchar(64)							comment '邮箱',
	ser_num					varchar(16)							comment '客服QQ',
	role_type				int									comment '管理员角色类型',
    remark      	varchar(256)                    	comment '备注'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统设置' ROW_FORMAT = Dynamic;
