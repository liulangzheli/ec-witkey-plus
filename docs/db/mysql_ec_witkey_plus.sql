/*
 * Copyright 2019-2029 liulangzheli(https://github.com/liulangzheli)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

-- ----------------------------
-- Create Database for ec_witkey_plus
-- ----------------------------
create database if not exists ec_witkey_plus character set utf8mb4;

-- ----------------------------
-- Table structure for ip
-- ----------------------------
DROP TABLE IF EXISTS `ip`;
CREATE TABLE `ip`  (
  `ip_start` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ip_end` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `operator` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip_start_num` bigint(20) NOT NULL,
  `ip_end_num` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 526718 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'IP地址'  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `log_id` bigint(18) NOT NULL COMMENT '主键',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '类型',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_id` bigint(18) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1060438746056376321, 0, 'A', 100000, '2018-11-08 15:41:58');
INSERT INTO `sys_log` VALUES (1060438788502732802, 0, 'B', 100000, '2018-11-08 15:42:08');
INSERT INTO `sys_log` VALUES (1060438799600861185, 0, 'C', 100000, '2018-11-08 15:42:10');
INSERT INTO `sys_log` VALUES (1060438809495224322, 0, 'D', 100000, '2018-11-08 15:42:13');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
drop table if exists `sys_user`;
create table sys_user
(
    id          bigint                              not null comment '主键'
        primary key,
    username    varchar(20)                         not null comment '用户名',
    nickname    varchar(20)                         null comment '昵称',
    password    varchar(64)                         not null comment '密码',
    salt        varchar(32)                         null comment '盐值',
    remark      varchar(200)                        null comment 'remark',
    status      int       default 1                 not null comment '状态，0：禁用，1：启用',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp                           null comment '修改时间',
    constraint sys_user_username_uindex
        unique (username)
)
    comment 'SystemUser';


-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO ec_witkey_plus.sys_user (id, username, nickname, password, salt, remark, status, create_time, update_time)
    VALUES (1, 'admin', '管理员', '751ade2f90ceb660cb2460f12cc6fe08268e628e4607bdb88a00605b3d66973c', 'e4cc3292e3ebc483998adb2c0e4e640e', 'Administrator Account', 1, '2019-08-26 00:52:01', null);
INSERT INTO ec_witkey_plus.sys_user (id, username, nickname, password, salt, remark, status, create_time, update_time)
    VALUES (2, 'test', '测试人员', '751ade2f90ceb660cb2460f12cc6fe08268e628e4607bdb88a00605b3d66973c', '99952b31c18156169a26bec80fd211f6', 'Tester Account', 1, '2019-10-05 14:04:27', null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
drop table if exists `category`;
create table category
(
    category_id     bigint                         	not null comment '主键' primary key,
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
    order_id     bigint                         	not null comment '主键' primary key,
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
    requirement_id     	bigint                         	not null comment '主键' primary key,
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
    source_id     	bigint                         	not null comment '主键' primary key,
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
    examine_id     	bigint                         	not null comment '主键' primary key,
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
    pay_id     	bigint                         	not null comment '主键' primary key,
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
    bidding_id     	bigint                         	not null comment '主键' primary key,
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
    progress_id     	bigint                         	not null comment '主键' primary key,
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
    check_id     	bigint                         	not null comment '主键' primary key,
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
    rights_id     	bigint                         	not null comment '主键' primary key,
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
    comment_id     	bigint                         	not null comment '主键' primary key,
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
    collect_id     	bigint                         	not null comment '主键' primary key,
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
    case_id     	bigint                         	not null comment '主键' primary key,
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
    article_id     	bigint                         	not null comment '主键' primary key,
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
    settting_id     	bigint                         	not null comment '主键' primary key,
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