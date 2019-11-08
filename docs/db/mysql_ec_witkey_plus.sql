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
create database if not exists ec_witkey_plus character set utf8mb4 COLLATE utf8mb4_general_ci;

use ec_witkey_plus;

-- ----------------------------
-- Table structure for ip
-- ----------------------------
DROP TABLE IF EXISTS `ip`;
CREATE TABLE `ip`
(
    `ip_start`     varchar(15)  NOT NULL,
    `ip_end`       varchar(15)  NOT NULL,
    `area`         varchar(100) NOT NULL,
    `operator`     varchar(200) NOT NULL,
    `id`           bigint(20)   NOT NULL AUTO_INCREMENT,
    `ip_start_num` bigint(20)   NOT NULL,
    `ip_end_num`   bigint(20)   NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 526718
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = 'IP地址';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `log_id`      bigint(18)   NOT NULL COMMENT '主键',
    `type`        tinyint(1)   NULL DEFAULT NULL COMMENT '类型',
    `content`     varchar(255) NULL DEFAULT NULL COMMENT '内容',
    `create_id`   bigint(18)   NULL DEFAULT NULL COMMENT '创建人ID',
    `create_time` datetime(0)  NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1060438746056376321, 0, 'A', 100000, '2018-11-08 15:41:58');
INSERT INTO `sys_log` VALUES (1060438788502732802, 0, 'B', 100000, '2018-11-08 15:42:08');
INSERT INTO `sys_log` VALUES (1060438799600861185, 0, 'C', 100000, '2018-11-08 15:42:10');
INSERT INTO `sys_log` VALUES (1060438809495224322, 0, 'D', 100000, '2018-11-08 15:42:13');


-- ----------------------------
-- Table structure for foo_bar
-- ----------------------------
DROP TABLE IF EXISTS `foo_bar`;
CREATE TABLE `foo_bar`
(
    `id`            bigint(20)  NOT NULL COMMENT '主键',
    `name`          varchar(20) NOT NULL COMMENT '名称',
    `foo`           varchar(20)          DEFAULT NULL COMMENT 'Foo',
    `bar`           varchar(20) NOT NULL COMMENT 'Bar',
    `remark`        varchar(200)         DEFAULT NULL COMMENT '备注',
    `state`         int(11)     NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `version`       int(11)     NOT NULL DEFAULT '0' COMMENT '版本',
    `create_time`   timestamp   NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp   NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='FooBar';

-- ----------------------------
-- Records of foo_bar
-- ----------------------------
INSERT INTO foo_bar (id, name, foo, bar, remark, state, version, create_time, update_time)
VALUES (1, 'FooBar', 'foo', 'bar', 'remark...', 1, 0, '2019-11-01 14:05:14', null);
INSERT INTO foo_bar (id, name, foo, bar, remark, state, version, create_time, update_time)
VALUES (2, 'HelloWorld', 'hello', 'world', null, 1, 0, '2019-11-01 14:05:14', null);


-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department`
(
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `name`        varchar(32) NOT NULL COMMENT '部门名称',
    `parent_id`   bigint(20)           DEFAULT NULL COMMENT '父id',
    `level`       int         NULL COMMENT '部门层级',
    `state`       int(11)     NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `sort`        int(11)     NOT NULL DEFAULT '0' COMMENT '排序',
    `remark`      varchar(200)         DEFAULT NULL COMMENT '备注',
    `version`     int(11)     NOT NULL DEFAULT '0' COMMENT '版本',
    `create_time` timestamp   NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_department_name_uindex` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='部门';

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (1, '管理部', null, 1, 1, 0, null, 0, '2019-10-25 09:46:49', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (2, '技术部', null, 1, 1, 0, null, 0, '2019-11-01 20:45:43', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (20, '前端开发部', 2, 2, 1, 0, null, 0, '2019-11-01 20:48:38', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (21, '后台开发部', 2, 2, 1, 0, null, 0, '2019-11-01 20:48:38', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (22, '测试部', 2, 2, 1, 0, null, 0, '2019-11-01 20:48:38', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (201, '前端一组', 20, 3, 1, 0, null, 0, '2019-11-01 20:48:38', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (202, '前端二组', 20, 3, 1, 0, null, 0, '2019-11-01 20:48:38', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (203, '后台一组', 21, 3, 1, 0, null, 0, '2019-11-01 20:48:38', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (204, '后台二组', 21, 3, 1, 0, null, 0, '2019-11-01 20:48:38', null);
INSERT INTO sys_department (id, name, parent_id, level, state, sort, remark, version, create_time, update_time) VALUES (205, '测试一组', 22, 3, 1, 0, null, 0, '2019-11-01 20:48:38', null);


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
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `name`        varchar(32) NOT NULL COMMENT '角色名称',
    `code`        varchar(100)         DEFAULT NULL COMMENT '角色唯一编码',
    `type`        int(11)              DEFAULT NULL COMMENT '角色类型',
    `state`       int(11)     NOT NULL DEFAULT '1' COMMENT '角色状态，0：禁用，1：启用',
    `remark`      varchar(200)         DEFAULT NULL COMMENT '备注',
    `version`     int(11)     NOT NULL DEFAULT '0' COMMENT '版本',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_role_name_uindex` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role (id, name, code, type, state, remark, version, create_time, update_time) VALUES (1, '管理员', 'admin', null, 1, null, 0, '2019-10-25 09:47:21', null);
INSERT INTO sys_role (id, name, code, type, state, remark, version, create_time, update_time) VALUES (2, 'test', 'test', null, 1, null, 0, '2019-10-25 09:48:02', null);


-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`
(
    `id`          bigint(20)   NOT NULL COMMENT '主键',
    `name`        varchar(32)           DEFAULT NULL COMMENT '权限名称',
    `parent_id`   bigint(20)            DEFAULT NULL COMMENT '父id',
    `url`         varchar(200)          DEFAULT NULL COMMENT '路径',
    `code`        varchar(100) NOT NULL COMMENT '唯一编码',
    `icon`        varchar(100)          DEFAULT NULL COMMENT '图标',
    `type`        int(11)      NOT NULL COMMENT '类型，1：菜单，2：按钮',
    `level`       int(11)      NOT NULL COMMENT '层级，1：第一级，2：第二级，N：第N级',
    `state`       int(11)      NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `sort`        int(11)      NOT NULL DEFAULT '0' COMMENT '排序',
    `remark`      varchar(200)          DEFAULT NULL COMMENT '备注',
    `version`     int(11)      NOT NULL DEFAULT '0' COMMENT '版本',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_permission_code_uindex` (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统权限';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1, '系统管理', null, null, 'system:management', null, 1, 1, 1, 0, null, 0, '2019-10-26 11:12:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (100, '用户管理', 1, null, 'sys:user:management', null, 1, 2, 1, 0, null, 0, '2019-10-26 11:15:48', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (200, '角色管理', 1, null, 'sys:role:management', null, 1, 2, 1, 0, null, 0, '2019-10-26 11:15:48', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (300, '权限管理', 1, null, 'sys:permission:management', null, 1, 2, 1, 0, null, 0, '2019-10-26 11:15:48', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (400, '部门管理', 1, null, 'sys:department:management', null, 1, 2, 1, 0, null, 0, '2019-10-26 11:15:48', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1000, '用户新增', 100, null, 'sys:user:add', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1001, '用户修改', 100, null, 'sys:user:update', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1002, '用户删除', 100, null, 'sys:user:delete', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1003, '用户详情', 100, null, 'sys:user:info', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1004, '用户分页列表', 100, null, 'sys:user:page', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1005, '用户修改密码', 100, null, 'sys:user:update:password', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (1006, '用户修改头像', 100, null, 'sys:user:update:head', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (2000, '角色新增', 200, null, 'sys:role:add', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (2001, '角色修改', 200, null, 'sys:role:update', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (2002, '角色删除', 200, null, 'sys:role:delete', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (2003, '角色详情', 200, null, 'sys:role:info', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (2004, '角色分页列表', 200, null, 'sys:role:page', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3000, '权限新增', 300, null, 'sys:permission:add', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3001, '权限修改', 300, null, 'sys:permission:update', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3002, '权限删除', 300, null, 'sys:permission:delete', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3003, '权限详情', 300, null, 'sys:permission:info', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3004, '权限分页列表', 300, null, 'sys:permission:page', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3005, '权限所有列表', 300, null, 'sys:permission:all:menu:list', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3006, '权限所有树形列表', 300, null, 'sys:permission:all:menu:tree', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3007, '权限用户列表', 300, null, 'sys:permission:menu:list', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3008, '权限用户树形列表', 300, null, 'sys:permission:menu:tree', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (3009, '权限用户代码列表', 300, null, 'sys:permission:codes', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (4000, '部门新增', 400, null, 'sys:department:add', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (4001, '部门修改', 400, null, 'sys:department:update', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (4002, '部门删除', 400, null, 'sys:department:delete', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (4003, '部门详情', 400, null, 'sys:department:info', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);
INSERT INTO sys_permission (id, name, parent_id, url, code, icon, type, level, state, sort, remark, version, create_time, update_time) VALUES (4004, '部门分页列表', 400, null, 'sys:department:page', null, 2, 3, 1, 0, null, 0, '2019-10-26 11:18:40', null);


-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`
(
    `id`            bigint(20) NOT NULL COMMENT '主键',
    `role_id`       bigint(20) NOT NULL COMMENT '角色id',
    `permission_id` bigint(20) NOT NULL COMMENT '权限id',
    `state`         int(11)    NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `remark`        varchar(200)        DEFAULT NULL COMMENT '备注',
    `version`       int(11)    NOT NULL DEFAULT '0' COMMENT '版本',
    `create_time`   timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp  NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色权限关系';

-- ------------------------------
-- Records of sys_role_permission
-- ------------------------------
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (1, 1, 1, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (2, 1, 100, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (3, 1, 200, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (4, 1, 300, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (5, 1, 400, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (6, 1, 1000, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (7, 1, 1001, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (8, 1, 1002, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (9, 1, 1003, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (10, 1, 1004, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (11, 1, 1005, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (12, 1, 1006, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (13, 1, 2000, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (14, 1, 2001, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (15, 1, 2002, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (16, 1, 2003, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (17, 1, 2004, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (18, 1, 3000, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (19, 1, 3001, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (20, 1, 3002, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (21, 1, 3003, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (22, 1, 3004, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (23, 1, 3005, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (24, 1, 3006, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (25, 1, 3007, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (26, 1, 3008, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (27, 1, 3009, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (28, 1, 4001, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (29, 1, 4002, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (30, 1, 4003, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (31, 1, 4004, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (100, 1, 1, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (101, 1, 100, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (102, 1, 1000, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (103, 1, 1001, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (104, 1, 1002, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (105, 1, 1003, 1, null, 0, '2019-10-26 22:16:19', null);
INSERT INTO sys_role_permission (id, role_id, permission_id, state, remark, version, create_time, update_time) VALUES (106, 1, 1004, 1, null, 0, '2019-10-26 22:16:19', null);



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
