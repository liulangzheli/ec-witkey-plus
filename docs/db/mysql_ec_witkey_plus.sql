/*
 Navicat Premium Data Transfer

 Source Server         : ec-witkey-plus
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3307
 Source Schema         : ec_witkey_plus

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 05/01/2020 12:00:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章内容',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '发布人',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `category_type` int(11) NULL DEFAULT NULL COMMENT '类别性质 0：项目用途 1：需求分类 2：项目类型 3：项目专业 4：文章分类',
  `cate_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `cate_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级分类ID',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `intro` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类介绍',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类别管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 1, '按图算量组价', 21, 1, '按图算量组价', '2019-12-17 00:11:40', '');
INSERT INTO `category` VALUES (2, 1, '简图模拟清单', 21, 2, '简图模拟清单', '2019-12-17 21:51:27', '');
INSERT INTO `category` VALUES (3, 1, '无图功能清单', 21, 3, '无图功能清单', '2019-12-17 21:59:29', '');
INSERT INTO `category` VALUES (4, 1, '算量', 22, 1, '算量', '2019-12-17 22:34:04', '');
INSERT INTO `category` VALUES (5, 1, '算量+编清单+组价', 22, 2, '算量+编清单+组价', '2019-12-17 22:52:25', '');
INSERT INTO `category` VALUES (6, 1, '组价', 23, 1, '组价', '2019-12-18 21:12:32', NULL);
INSERT INTO `category` VALUES (7, 1, '编清单', 24, 3, '编清单', '2019-12-18 21:13:48', NULL);
INSERT INTO `category` VALUES (8, 1, '算量+组价', 24, 4, '算量+组价', '2019-12-18 21:14:26', NULL);
INSERT INTO `category` VALUES (9, 1, '算量+编清单', 24, 5, '算量+编清单', '2019-12-18 21:14:47', NULL);
INSERT INTO `category` VALUES (10, 1, '编清单+组价', 24, 6, '编清单+组价', '2019-12-18 21:15:06', NULL);
INSERT INTO `category` VALUES (11, 1, '建模', 24, 8, '建模', '2019-12-18 21:16:04', NULL);
INSERT INTO `category` VALUES (12, 2, '住宅', 0, 1, '住宅', '2019-12-18 21:18:27', NULL);
INSERT INTO `category` VALUES (13, 2, '公寓', 0, 2, '公寓', '2019-12-18 21:18:55', NULL);
INSERT INTO `category` VALUES (14, 2, '别墅', 0, 3, '别墅', '2019-12-18 21:19:14', NULL);
INSERT INTO `category` VALUES (15, 2, '办公建筑', 0, 4, '办公建筑', '2019-12-18 21:19:38', NULL);
INSERT INTO `category` VALUES (16, 3, '土建', 0, 1, '土建', '2019-12-18 21:20:15', NULL);
INSERT INTO `category` VALUES (17, 3, '钢构', 0, 2, '钢构', '2019-12-18 21:20:30', NULL);
INSERT INTO `category` VALUES (18, 3, '外墙装修', 0, 3, '外墙装修', '2019-12-18 21:20:50', NULL);
INSERT INTO `category` VALUES (19, 3, '室内装修', 0, 4, '室内装修', '2019-12-18 21:21:10', NULL);
INSERT INTO `category` VALUES (20, 3, '钢筋', 0, 5, '钢筋', '2019-12-18 21:21:23', NULL);
INSERT INTO `category` VALUES (21, 0, '做算/预算', 0, 1, '做算/预算', '2019-12-18 21:28:13', NULL);
INSERT INTO `category` VALUES (22, 0, '标度', 0, 2, '标度', '2019-12-18 21:30:46', NULL);
INSERT INTO `category` VALUES (23, 0, '投标', 0, 3, '投标', '2019-12-18 21:32:08', NULL);
INSERT INTO `category` VALUES (24, 0, '施工图预算', 0, 4, '施工图预算', '2019-12-18 21:32:30', NULL);
INSERT INTO `category` VALUES (25, 0, '结算', 0, 5, '结算', '2019-12-18 21:37:01', NULL);
INSERT INTO `category` VALUES (26, 1, '算量+编清单+组价', 23, 2, '算量+编清单+组价', '2019-12-17 22:52:25', '');
INSERT INTO `category` VALUES (27, 5, '多层住宅（7层以下）', 12, 1, '多层住宅（7层以下）', '2019-12-19 22:53:49', NULL);
INSERT INTO `category` VALUES (28, 5, '中层住宅（18层及以下）', 12, 2, '中层住宅（18层及以下）', '2019-12-19 22:54:34', NULL);
INSERT INTO `category` VALUES (29, 5, '高层住宅', 12, 3, '高层住宅', '2019-12-19 22:55:01', NULL);
INSERT INTO `category` VALUES (30, 5, '售楼中心', 12, 4, '售楼中心', '2019-12-19 22:55:48', NULL);
INSERT INTO `category` VALUES (31, 6, '多层住宅（7层以下）', 13, 1, '多层住宅（7层以下）', '2019-12-19 22:56:45', NULL);
INSERT INTO `category` VALUES (32, 6, '中层住宅（18层及以下）', 13, 2, '中层住宅（18层及以下）', '2019-12-19 23:01:23', NULL);
INSERT INTO `category` VALUES (33, 6, '高层住宅', 13, 3, '高层住宅', '2019-12-19 23:01:45', NULL);
INSERT INTO `category` VALUES (34, 7, '独栋别墅', 14, 1, '独栋别墅', '2019-12-19 23:02:18', NULL);
INSERT INTO `category` VALUES (35, 7, '双拼/联排/叠拼', 14, 2, '双拼/联排/叠拼', '2019-12-19 23:03:08', NULL);
INSERT INTO `category` VALUES (36, 8, '四级办公楼', 15, 1, '四级办公楼', '2019-12-19 23:03:44', NULL);
INSERT INTO `category` VALUES (37, 8, '自用办公楼', 15, 2, '自用办公楼', '2019-12-19 23:04:20', NULL);
INSERT INTO `category` VALUES (38, 8, '派出所/消防站', 15, 3, '派出所/消防站', '2019-12-19 23:04:57', NULL);
INSERT INTO `category` VALUES (39, 1, '组价', 24, 1, '组价', '2019-12-19 23:08:16', NULL);
INSERT INTO `category` VALUES (40, 1, '算量', 24, 2, '算量', '2019-12-19 23:10:23', NULL);
INSERT INTO `category` VALUES (41, 1, '算量+编清单+组价', 24, 7, '算量+编清单+组价', '2019-12-19 23:11:12', NULL);
INSERT INTO `category` VALUES (42, 1, '编清单', 25, 3, '编清单', '2019-12-18 21:13:48', NULL);
INSERT INTO `category` VALUES (43, 1, '算量+组价', 25, 4, '算量+组价', '2019-12-18 21:14:26', NULL);
INSERT INTO `category` VALUES (44, 1, '算量+编清单', 25, 5, '算量+编清单', '2019-12-18 21:14:47', NULL);
INSERT INTO `category` VALUES (45, 1, '编清单+组价', 25, 6, '编清单+组价', '2019-12-18 21:15:06', NULL);
INSERT INTO `category` VALUES (46, 1, '建模', 25, 8, '建模', '2019-12-18 21:16:04', NULL);
INSERT INTO `category` VALUES (47, 1, '组价', 25, 1, '组价', '2019-12-19 23:08:16', NULL);
INSERT INTO `category` VALUES (48, 1, '算量', 25, 2, '算量', '2019-12-19 23:10:23', NULL);
INSERT INTO `category` VALUES (49, 1, '算量+编清单+组价', 25, 7, '算量+编清单+组价', '2019-12-19 23:11:12', NULL);
INSERT INTO `category` VALUES (50, 2, '交通建筑', 0, 5, '交通建筑', '2019-12-25 10:56:18', NULL);
INSERT INTO `category` VALUES (51, 2, '宾馆酒店', 0, 6, '宾馆酒店', '2019-12-25 10:56:44', NULL);
INSERT INTO `category` VALUES (52, 2, '商业建筑', 0, 7, '商业建筑', '2019-12-25 10:57:11', NULL);
INSERT INTO `category` VALUES (53, 2, '地下部分', 0, 8, '地下部分', '2019-12-25 11:02:35', NULL);
INSERT INTO `category` VALUES (54, 2, '工业建筑', 0, 9, '工业建筑', '2019-12-25 11:02:55', NULL);
INSERT INTO `category` VALUES (55, 2, '卫生建筑', 0, 10, '卫生建筑', '2019-12-25 11:03:14', NULL);
INSERT INTO `category` VALUES (56, 2, '教育建筑', 0, 11, '教育建筑', '2019-12-25 11:04:00', NULL);
INSERT INTO `category` VALUES (57, 2, '文体建筑', 0, 12, '文体建筑', '2019-12-25 11:04:21', NULL);
INSERT INTO `category` VALUES (58, 2, '工业配套', 0, 13, '工业配套', '2019-12-25 11:04:41', NULL);
INSERT INTO `category` VALUES (59, 2, '公共绿化', 0, 14, '公共绿化', '2019-12-25 11:05:08', NULL);
INSERT INTO `category` VALUES (60, 2, '市政交通', 0, 15, '市政交通', '2019-12-25 11:05:38', NULL);
INSERT INTO `category` VALUES (61, 2, '市政工程', 0, 16, '市政工程', '2019-12-25 11:06:12', NULL);
INSERT INTO `category` VALUES (62, 2, '特殊行业', 0, 17, '特殊行业', '2019-12-25 11:54:43', NULL);
INSERT INTO `category` VALUES (63, 2, '其他', 0, 18, '其他', '2019-12-25 11:55:10', NULL);
INSERT INTO `category` VALUES (64, 9, '机场建筑', 50, 1, '机场建筑', '2019-12-25 12:29:53', NULL);
INSERT INTO `category` VALUES (65, 9, '铁路客运站', 50, 2, '铁路客运站', '2019-12-25 12:31:27', NULL);
INSERT INTO `category` VALUES (66, 9, '地铁/轨道交通站', 50, 3, '地铁/轨道交通站', '2019-12-25 12:42:27', NULL);
INSERT INTO `category` VALUES (67, 9, '航运楼/码头', 50, 4, '航运楼/码头', '2019-12-25 12:42:56', NULL);
INSERT INTO `category` VALUES (68, 10, '三星级酒店', 51, 1, '三星级酒店', '2019-12-25 12:43:25', NULL);
INSERT INTO `category` VALUES (69, 10, '经济型/快捷酒店', 51, 2, '经济型/快捷酒店', '2019-12-25 12:43:58', NULL);
INSERT INTO `category` VALUES (70, 10, '饭店', 51, 3, '饭店', '2019-12-25 12:44:16', NULL);
INSERT INTO `category` VALUES (71, 11, '大型购物中心', 52, 1, '大型购物中心', '2019-12-25 12:44:37', NULL);
INSERT INTO `category` VALUES (72, 11, '大小型百货', 52, 2, '大小型百货', '2019-12-25 12:45:13', NULL);
INSERT INTO `category` VALUES (73, 12, '车库', 53, 1, '车库', '2019-12-25 12:49:00', NULL);
INSERT INTO `category` VALUES (74, 13, '厂房', 54, 1, '厂房', '2019-12-25 12:49:28', NULL);
INSERT INTO `category` VALUES (75, 13, '物流仓库', 54, 2, '物流仓库', '2019-12-25 14:39:04', NULL);
INSERT INTO `category` VALUES (76, 14, '门急诊/医技/综合楼', 55, 1, '门急诊/医技/综合楼', '2019-12-25 14:43:05', NULL);
INSERT INTO `category` VALUES (77, 14, '病房楼', 55, 2, '病房楼', '2019-12-25 14:43:26', NULL);
INSERT INTO `category` VALUES (78, 14, '社区医疗', 55, 3, '社区医疗', '2019-12-25 14:43:43', NULL);
INSERT INTO `category` VALUES (79, 15, '大学/职业学校教学楼群', 56, 1, '大学/职业学校教学楼群', '2019-12-25 14:44:33', NULL);
INSERT INTO `category` VALUES (80, 15, '中小学教学楼', 56, 2, '中小学教学楼', '2019-12-25 14:45:00', NULL);
INSERT INTO `category` VALUES (81, 15, '食堂', 56, 3, '食堂', '2019-12-25 14:45:19', NULL);
INSERT INTO `category` VALUES (82, 15, '操场/网球场/篮球场', 56, 4, '操场/网球场/篮球场', '2019-12-25 14:47:11', NULL);
INSERT INTO `category` VALUES (83, 15, '幼儿园/托儿所', 56, 5, '幼儿园/托儿所', '2019-12-25 14:47:43', NULL);
INSERT INTO `category` VALUES (84, 16, '博物馆', 57, 1, '博物馆', '2019-12-25 14:48:30', NULL);
INSERT INTO `category` VALUES (85, 16, '图书馆', 57, 2, '图书馆', '2019-12-25 14:48:49', NULL);
INSERT INTO `category` VALUES (86, 16, '电影院', 57, 3, '电影院', '2019-12-25 14:49:06', NULL);
INSERT INTO `category` VALUES (87, 16, '体育场', 57, 4, '体育场', '2019-12-25 14:49:45', NULL);
INSERT INTO `category` VALUES (88, 17, '锅炉房/汞房', 58, 1, '锅炉房/汞房', '2019-12-25 14:57:06', NULL);
INSERT INTO `category` VALUES (89, 17, '变电站', 58, 2, '变电站', '2019-12-25 14:57:42', NULL);
INSERT INTO `category` VALUES (90, 17, '加油/加气站', 58, 3, '加油/加气站', '2019-12-25 14:58:40', NULL);
INSERT INTO `category` VALUES (91, 17, '垃圾站', 58, 4, '垃圾站', '2019-12-25 14:59:00', NULL);
INSERT INTO `category` VALUES (92, 17, '污水处理厂', 58, 5, '污水处理厂', '2019-12-25 14:59:20', NULL);
INSERT INTO `category` VALUES (93, 18, '配套绿化', 59, 1, '配套绿化', '2019-12-25 15:00:14', NULL);
INSERT INTO `category` VALUES (94, 18, '道路、市政公共绿化', 59, 2, '道路、市政公共绿化', '2019-12-25 15:00:37', NULL);
INSERT INTO `category` VALUES (95, 18, '防护绿化', 59, 3, '防护绿化', '2019-12-25 15:01:36', NULL);
INSERT INTO `category` VALUES (96, 18, '景观绿化', 59, 4, '景观绿化', '2019-12-25 15:02:11', NULL);
INSERT INTO `category` VALUES (97, 19, '公路', 60, 1, '公路', '2019-12-25 15:03:06', NULL);
INSERT INTO `category` VALUES (98, 19, '铁路', 60, 2, '铁路', '2019-12-25 15:03:33', NULL);
INSERT INTO `category` VALUES (99, 19, '桥梁', 60, 3, '桥梁', '2019-12-25 15:03:55', NULL);
INSERT INTO `category` VALUES (100, 19, '隧道', 60, 4, '隧道', '2019-12-25 15:04:13', NULL);
INSERT INTO `category` VALUES (101, 20, '市政管网', 61, 1, '市政管网', '2019-12-25 15:04:39', NULL);
INSERT INTO `category` VALUES (102, 21, '水利水电石油电力等', 62, 1, '水利水电石油电力等', '2019-12-25 15:05:18', NULL);
INSERT INTO `category` VALUES (103, 22, '公共厕所', 63, 1, '公共厕所', '2019-12-25 15:05:47', NULL);
INSERT INTO `category` VALUES (104, 22, '其他', 63, 2, '其他', '2019-12-25 15:06:06', NULL);
INSERT INTO `category` VALUES (105, 3, '给水排水', 0, 6, '给水排水', '2019-12-28 23:09:54', NULL);
INSERT INTO `category` VALUES (106, 3, '暖通燃气', 0, 7, '暖通燃气', '2019-12-28 23:10:19', NULL);
INSERT INTO `category` VALUES (107, 3, '电气消防', 0, 8, '电气消防', '2019-12-28 23:10:53', NULL);

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `supplier_id` bigint(20) NULL DEFAULT NULL COMMENT '服务商ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `tag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务商标签',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏的服务商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for foo_bar
-- ----------------------------
DROP TABLE IF EXISTS `foo_bar`;
CREATE TABLE `foo_bar`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `foo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Foo',
  `bar` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Bar',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `state` int(11) NOT NULL DEFAULT 1 COMMENT '状态，0：禁用，1：启用',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '版本',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'FooBar' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of foo_bar
-- ----------------------------
INSERT INTO `foo_bar` VALUES (1, 'FooBar', 'foo', 'bar', 'remark...', 1, 0, '2019-11-01 14:05:14', NULL);
INSERT INTO `foo_bar` VALUES (2, 'HelloWorld', 'hello', 'world', NULL, 1, 0, '2019-11-01 14:05:14', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'IP地址' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_bidding
-- ----------------------------
DROP TABLE IF EXISTS `order_bidding`;
CREATE TABLE `order_bidding`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投标时间',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '中标状态，0：等待选标 1：超时 2：选中 3、未中标',
  `message` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单竞标信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_bidding
-- ----------------------------
INSERT INTO `order_bidding` VALUES (1211686585054035970, 1208593539768836097, 1209370776210362370, '2019-12-31 00:32:47', 2, '', '');
INSERT INTO `order_bidding` VALUES (1211687515191279617, 1208594230834946049, 1209370776210362370, '2019-12-31 00:36:30', 0, '', '');
INSERT INTO `order_bidding` VALUES (1212770938714607617, 1208595126922829825, 1209370776210362370, '2020-01-03 00:21:38', 0, '', '');
INSERT INTO `order_bidding` VALUES (1213167568479604738, 1212938102897729537, 1209370776210362370, '2020-01-04 02:37:42', 2, '', '');
INSERT INTO `order_bidding` VALUES (1213534481089048578, 1208578902834864129, 1213534310267629570, '2020-01-05 02:55:41', 0, '', '');
INSERT INTO `order_bidding` VALUES (1213534901798711297, 1208578902834864129, 1209370776210362370, '2020-01-05 02:57:21', 0, '', '');

-- ----------------------------
-- Table structure for order_check
-- ----------------------------
DROP TABLE IF EXISTS `order_check`;
CREATE TABLE `order_check`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `creat_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `file_nsame` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果文件名',
  `format` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果文件格式',
  `size` int(11) NULL DEFAULT NULL COMMENT '成果文件大小',
  `intro` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成果描述',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '验收时间',
  `state` int(11) NULL DEFAULT NULL COMMENT '验收状态 0：待审核 1：审核通过 2：驳回',
  `suggest` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验收意见',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单验收信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_comment
-- ----------------------------
DROP TABLE IF EXISTS `order_comment`;
CREATE TABLE `order_comment`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `content` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `technical_grade` int(11) NULL DEFAULT NULL COMMENT '技能评分',
  `server_grade` int(11) NULL DEFAULT NULL COMMENT '服务评分',
  `multi_grade` int(11) NULL DEFAULT NULL COMMENT '综合评分',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `comment_tag` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价标签',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_pay
-- ----------------------------
DROP TABLE IF EXISTS `order_pay`;
CREATE TABLE `order_pay`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `amount` int(11) NULL DEFAULT NULL COMMENT '订单总额',
  `discount` int(11) NULL DEFAULT NULL COMMENT '优惠金额',
  `actual_amount` int(11) NULL DEFAULT NULL COMMENT '实际付款',
  `flow_num` int(11) NULL DEFAULT NULL COMMENT '流水号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `pay_method` int(11) NOT NULL DEFAULT 0 COMMENT '支付方式,1、银行卡 2、支付宝 3、微信',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '交易状态，0:待付款 1：交易成功 2：交易失败 3、付款超时 4、退款',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单付款信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_progress
-- ----------------------------
DROP TABLE IF EXISTS `order_progress`;
CREATE TABLE `order_progress`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `intro` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进度说明',
  `source_id` bigint(20) NULL DEFAULT NULL COMMENT '资料图纸信息ID',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单项目进度信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_rights
-- ----------------------------
DROP TABLE IF EXISTS `order_rights`;
CREATE TABLE `order_rights`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `rights_type` int(11) NULL DEFAULT NULL COMMENT '维权类型',
  `intro` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `source1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维权证明1',
  `source2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维权证明2',
  `source3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维权证明3',
  `source4` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维权证明4',
  `source5` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维权证明5',
  `source6` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维权证明6',
  `creat_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发起时间',
  `state` int(11) NULL DEFAULT NULL COMMENT '验收状态 0：待审核 1：审核通过 2：驳回',
  `protect_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '审核人',
  `suggest` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核意见',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单维权' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_examine
-- ----------------------------
DROP TABLE IF EXISTS `project_examine`;
CREATE TABLE `project_examine`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '审核状态，0：待审核 1：审核通过 2:  驳回 3：审核超时',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '审核人',
  `examine_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目审核' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_order
-- ----------------------------
DROP TABLE IF EXISTS `project_order`;
CREATE TABLE `project_order`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户/雇主id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款完成时间',
  `examine_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `pick_time` datetime(0) NULL DEFAULT NULL COMMENT '选标完成时间',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '验收完成时间',
  `use_type` bigint(20) NULL DEFAULT NULL COMMENT '项目用途',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类id',
  `major` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业要求,用|隔开',
  `province` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目所在地（省）',
  `city` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目所在地（市）',
  `zone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目所在地（区）',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '截止报名时间',
  `amount` float(50, 0) NULL DEFAULT NULL COMMENT '预算费用',
  `period` int(11) NULL DEFAULT NULL COMMENT '交付周期 单位天',
  `soft_supplier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '软件供应商',
  `soft_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '软件名称',
  `intro` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细描述',
  `state` int(11) NULL DEFAULT NULL COMMENT '订单状态 0：待审核  1：发布 2：进行中 3：完成 4：关闭',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_order
-- ----------------------------
INSERT INTO `project_order` VALUES (1208578902834864129, 1204778824307318785, '2019-12-22 10:43:59', '2020-01-05 02:34:46', NULL, NULL, NULL, 22, 5, '土建：砌体结构|土建：挖土方|钢构：挖土方|外墙装修：外墙保湿|外墙装修：外墙面装修|室内装修：初装（做到基层）|室内装修：精装（做到面层）|钢筋：预算钢筋#主体结构钢筋|钢筋：预算钢筋#砌体钢筋|钢筋：下料钢筋#主体结构钢筋|钢筋：下料钢筋#砌体钢筋|', '福建省', '福州市', '鼓楼区', '2019-12-27 00:00:00', 1300, 5, '软件供应商', '海迈计价软件', '详细描述', 1, '');
INSERT INTO `project_order` VALUES (1208589532056838146, 1204778824307318785, '2019-12-22 11:26:13', NULL, NULL, NULL, NULL, 24, 7, '土建：主体结构|土建：砌体结构|土建：边坡支护|土建：挖土方|土建：回填土|钢构：挖土方|外墙装修：外墙保湿|外墙装修：外墙面装修|室内装修：初装（做到基层）|室内装修：精装（做到面层）|钢筋：预算钢筋#主体结构钢筋|钢筋：预算钢筋#砌体钢筋|钢筋：下料钢筋#主体结构钢筋|钢筋：下料钢筋#砌体钢筋|', '福建省', '厦门市', '思明区', '2019-12-27 00:00:00', 1800, 3, '软件供应商', '海迈计价软件', '详细描述', 0, '');
INSERT INTO `project_order` VALUES (1208592128247128065, 1204778824307318785, '2019-12-22 11:36:32', '2020-01-04 21:03:10', NULL, NULL, NULL, 22, 5, '土建：主体结构|土建：边坡支护|土建：回填土|外墙装修：外墙面装修|室内装修：精装（做到面层）|钢筋：预算钢筋#砌体钢筋|钢筋：下料钢筋#砌体钢筋|', '福建省', '厦门市', '湖里区', '2020-01-13 20:49:06', 1200, 3, '软件供应商', '海迈计价软件', '详细描述', 0, '');
INSERT INTO `project_order` VALUES (1208593082602283010, 1204778824307318785, '2019-12-22 11:40:20', '2020-01-04 21:03:02', NULL, NULL, NULL, 22, 5, '土建：主体结构|土建：边坡支护|土建：回填土|外墙装修：外墙面装修|室内装修：精装（做到面层）|钢筋：预算钢筋#砌体钢筋|钢筋：下料钢筋#砌体钢筋|', '福建省', '厦门市', '集美区', '2020-01-31 20:49:11', 1500, 3, '软件供应商', '海迈计价软件', '详细描述', 0, '');
INSERT INTO `project_order` VALUES (1208593539768836097, 1204778824307318785, '2019-12-22 11:42:09', '2019-12-29 14:13:56', NULL, NULL, NULL, 22, 5, '土建：主体结构|土建：边坡支护|土建：回填土|外墙装修：外墙面装修|室内装修：精装（做到面层）|钢筋：预算钢筋#砌体钢筋|钢筋：下料钢筋#砌体钢筋|', '福建省', '厦门市', '海沧区', '2020-01-22 20:49:17', 200, 3, '软件供应商', '海迈计价软件', '详细描述', 2, '');
INSERT INTO `project_order` VALUES (1208594230834946049, 1204778824307318785, '2019-12-22 11:44:53', NULL, NULL, NULL, NULL, 22, 5, '土建：主体结构|土建：边坡支护|土建：回填土|外墙装修：外墙面装修|室内装修：精装（做到面层）|钢筋：预算钢筋#砌体钢筋|钢筋：下料钢筋#砌体钢筋|', '福建省', '厦门市', '同安区', '2020-02-08 20:49:20', 400, 3, '软件供应商', '海迈计价软件', '详细描述', 2, '');
INSERT INTO `project_order` VALUES (1208595126922829825, 1204778824307318785, '2019-12-22 11:48:27', NULL, NULL, NULL, NULL, 25, 49, '土建：主体结构|土建：回填土|钢构：挖土方|外墙装修：外墙面装修|室内装修：初装（做到基层）|室内装修：精装（做到面层）|钢筋：预算钢筋#主体结构钢筋|钢筋：下料钢筋#砌体钢筋|', '福建省', '厦门市', '翔安区', '2019-12-28 00:00:00', 300, 3, '软件供应商', '海迈计价软件', '详细描述', 2, '');
INSERT INTO `project_order` VALUES (1209769125379883009, 1204778824307318785, '2019-12-25 17:33:30', '2019-12-27 14:59:59', NULL, NULL, NULL, 21, 2, '土建：主体结构|土建：砌体结构|土建：防水工程|土建：边坡支护|土建：挖土方|土建：回填土|钢构：挖土方|外墙装修：外墙保湿|外墙装修：外墙面装修|室内装修：初装（做到基层）|室内装修：精装（做到面层）|钢筋：预算钢筋#主体结构钢筋|钢筋：预算钢筋#砌体钢筋|钢筋：下料钢筋#主体结构钢筋|钢筋：下料钢筋#砌体钢筋|给水排水：给水|管线预留预埋|给水排水：给水|终端安装|给水排水：排水|管线预留预埋|给水排水：排水|终端安装|暖通燃气：采暖系统|管线预留预埋|暖通燃气：采暖系统|终端安装|暖通燃气：通风系统|管线预留预埋|暖通燃气：通风系统|终端安装|暖通燃气：空调水|管线预留预埋|暖通燃气：空调水|终端安装|暖通燃气：空调电|管线预留预埋|暖通燃气：空调电|终端安装|暖通燃气：燃气系统|管线预留预埋|暖通燃气：燃气系统|终端安装|电气消防：强电系统|管线预留预埋|电气消防：强电系统|终端安装|电气消防：弱电系统|管线预留预埋|电气消防：弱电系统|终端安装|电气消防：消防水|管线预留预埋|电气消防：消防水|终端安装|电气消防：消防电|管线预留预埋|电气消防：消防电|终端安装|', '福建省', '厦门市', '思明区', '2019-12-27 00:00:00', 200, 3, '软件供应商', '海迈计价软件', '详细描述', 4, '');
INSERT INTO `project_order` VALUES (1212938102897729537, 1204778824307318785, '2020-01-03 11:25:53', '2020-01-03 11:26:41', NULL, NULL, NULL, 24, 7, '土建：砌体结构|土建：边坡支护|钢构：挖土方|外墙装修：外墙保湿|外墙装修：外墙面装修|钢筋：预算钢筋#主体结构钢筋|钢筋：下料钢筋#砌体钢筋|给水排水：给水|终端安装|给水排水：排水|管线预留预埋|暖通燃气：通风系统|管线预留预埋|暖通燃气：空调电|终端安装|暖通燃气：燃气系统|终端安装|电气消防：强电系统|管线预留预埋|电气消防：弱电系统|管线预留预埋|电气消防：消防水|终端安装|电气消防：消防电|管线预留预埋|', '福建省', '厦门市', '思明区', '2020-01-31 00:00:00', 3000, 4, '软件供应商', '海迈计价软件', '1、本工程为民用住宅计划投资金额为20万（不含基础。\r\n 2、-层层高为3300，二层层高3000，三层3000（均含板厚），板厚120（可调整）\r\n 3、使用斜屋面，露合部分考虑使用透明玻璃 需要考虑防水做法防止平层漏水）\r\n 4、一层考虑使用24墙二层考虑使用18墙，三层考虑12墙。\r\n 5、注意楼梯位置，考虑使用直角楼梯此位置需要通透。\r\n 6、房屋朝向为正东方向。\r\n 7、正北方邻邻居住房间距为500.\r\n 8、二层、三层地面考虑使用瓷砖块料。一层不做考虑\r\n 需要出：结构图', 2, '');

-- ----------------------------
-- Table structure for project_requirement
-- ----------------------------
DROP TABLE IF EXISTS `project_requirement`;
CREATE TABLE `project_requirement`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `category_id0` bigint(20) NULL DEFAULT NULL COMMENT '项目类型ID-0',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '项目类型ID',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `qty` int(11) NULL DEFAULT NULL COMMENT '单体数量',
  `count_type` int(11) NULL DEFAULT 0 COMMENT '计入方式,默认为0，0:表示以地上总建筑面积计入 1:表示以总投资金额计入',
  `area` float NULL DEFAULT NULL COMMENT '地上总建筑面积,单位平米',
  `amount` float NULL DEFAULT NULL COMMENT '总投资金额,单位万元',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目类型要求' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_requirement
-- ----------------------------
INSERT INTO `project_requirement` VALUES (1208571002183802882, 12, 27, 1208571001344942081, 1, 0, 11, 0, '');
INSERT INTO `project_requirement` VALUES (1208571002578067458, 12, 29, 1208571001344942081, 1, 0, 13, 0, '');
INSERT INTO `project_requirement` VALUES (1208571003001692162, 13, 32, 1208571001344942081, 1, 0, 22, 0, '');
INSERT INTO `project_requirement` VALUES (1208571003253350402, 14, 34, 1208571001344942081, 1, 0, 31, 0, '');
INSERT INTO `project_requirement` VALUES (1208571003488231425, 14, 35, 1208571001344942081, 1, 0, 32, 0, '');
INSERT INTO `project_requirement` VALUES (1208571003723112449, 15, 37, 1208571001344942081, 1, 0, 42, 0, '');
INSERT INTO `project_requirement` VALUES (1208578903526924290, 12, 27, 1208578902834864129, 1, 0, 11, 0, '');
INSERT INTO `project_requirement` VALUES (1208578903749222401, 12, 30, 1208578902834864129, 1, 0, 14, 0, '');
INSERT INTO `project_requirement` VALUES (1208578904051212289, 13, 32, 1208578902834864129, 1, 0, 22, 0, '');
INSERT INTO `project_requirement` VALUES (1208578904432893953, 14, 35, 1208578902834864129, 1, 0, 32, 0, '');
INSERT INTO `project_requirement` VALUES (1208578904692940801, 15, 36, 1208578902834864129, 1, 0, 41, 0, '');
INSERT INTO `project_requirement` VALUES (1208578904927821826, 15, 38, 1208578902834864129, 1, 0, 44, 0, '');
INSERT INTO `project_requirement` VALUES (1208589532618874881, 12, 27, 1208589532056838146, 1, 0, 11, 0, '');
INSERT INTO `project_requirement` VALUES (1208589532870533122, 12, 29, 1208589532056838146, 1, 0, 13, 0, '');
INSERT INTO `project_requirement` VALUES (1208589533164134401, 13, 31, 1208589532056838146, 1, 0, 21, 0, '');
INSERT INTO `project_requirement` VALUES (1208589533902331905, 13, 33, 1208589532056838146, 1, 0, 23, 0, '');
INSERT INTO `project_requirement` VALUES (1208589534300790786, 14, 35, 1208589532056838146, 1, 0, 32, 0, '');
INSERT INTO `project_requirement` VALUES (1208589534573420546, 15, 37, 1208589532056838146, 1, 0, 42, 0, '');
INSERT INTO `project_requirement` VALUES (1208592178859794433, 12, 27, 1208592128247128065, 1, 0, 11, 0, '');
INSERT INTO `project_requirement` VALUES (1208593188168720386, 12, 27, 1208593082602283010, 1, 0, 11, 0, '');
INSERT INTO `project_requirement` VALUES (1208593562367746050, 12, 27, 1208593539768836097, 1, 0, 11, 0, '');
INSERT INTO `project_requirement` VALUES (1208594709870600194, 12, 27, 1208594230834946049, 1, 0, 11, 0, '');
INSERT INTO `project_requirement` VALUES (1208595177732628481, 12, 28, 1208595126922829825, 1, 0, 12, 0, '');
INSERT INTO `project_requirement` VALUES (1208595178416300034, 13, 31, 1208595126922829825, 1, 0, 21, 0, '');
INSERT INTO `project_requirement` VALUES (1208595178646986754, 13, 33, 1208595126922829825, 1, 0, 23, 0, '');
INSERT INTO `project_requirement` VALUES (1209769126252298242, 12, 28, 1209769125379883009, 1, 0, 12, 0, '');
INSERT INTO `project_requirement` VALUES (1209769126495567873, 12, 30, 1209769125379883009, 1, 0, 14, 0, '');
INSERT INTO `project_requirement` VALUES (1209769126734643202, 58, 90, 1209769125379883009, 1, 0, 131, 0, '');
INSERT INTO `project_requirement` VALUES (1209769126914998274, 63, 103, 1209769125379883009, 1, 0, 181, 0, '');
INSERT INTO `project_requirement` VALUES (1212938106521608194, 12, 28, 1212938102897729537, 1, 0, 12, 0, '');
INSERT INTO `project_requirement` VALUES (1212938106962010114, 14, 35, 1212938102897729537, 1, 0, 32, 0, '');

-- ----------------------------
-- Table structure for project_source
-- ----------------------------
DROP TABLE IF EXISTS `project_source`;
CREATE TABLE `project_source`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `original_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料原名称',
  `source_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料现名称',
  `format` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件格式',
  `size` int(11) NULL DEFAULT NULL COMMENT '资料大小',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目资料' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_source
-- ----------------------------
INSERT INTO `project_source` VALUES (1208438943184388097, '智慧城市建设参考模型.jpg', 'http://localhost:8888//resource/201912220127445.jpg', '.jpg', 29938, 1208438916097572866, '');
INSERT INTO `project_source` VALUES (1208571020965896193, '新建文本文档.txt', 'http://localhost:8888//resource/201912221012362.txt', '.txt', 1255, 1208571001344942081, '');
INSERT INTO `project_source` VALUES (1208579069592002561, '设备分布界面.png', 'http://localhost:8888//resource/201912221044000.png', '.png', 564052, 1208578902834864129, '');
INSERT INTO `project_source` VALUES (1208589676512862209, '审批状态.png', 'http://localhost:8888//resource/201912221126143.png', '.png', 9575, 1208589532056838146, '');
INSERT INTO `project_source` VALUES (1208592372175265793, 'form.2.zip', 'http://localhost:8888//resource/201912221137111.zip', '.zip', 748, 1208592128247128065, '');
INSERT INTO `project_source` VALUES (1208593355164934145, 'form.2.zip', 'http://localhost:8888//resource/201912221141065.zip', '.zip', 748, 1208593082602283010, '');
INSERT INTO `project_source` VALUES (1208593858426888193, 'form.2.zip', 'http://localhost:8888//resource/201912221143039.zip', '.zip', 748, 1208593539768836097, '');
INSERT INTO `project_source` VALUES (1208595252122804225, '智慧城市建设参考模型.jpg', 'http://localhost:8888//resource/201912221148573.jpg', '.jpg', 29938, 1208595126922829825, '');
INSERT INTO `project_source` VALUES (1209769128949235713, 'B栋.jpg', 'http://localhost:8888//resource/201912251733312.jpg', '.jpg', 127222, 1209769125379883009, '');
INSERT INTO `project_source` VALUES (1212938112259416065, 'B栋.jpg', 'http://localhost:8888//resource/202001031125554.jpg', '.jpg', 127222, 1212938102897729537, '');

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父id',
  `level` int(11) NULL DEFAULT NULL COMMENT '部门层级',
  `state` int(11) NOT NULL DEFAULT 1 COMMENT '状态，0：禁用，1：启用',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '版本',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_department_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES (1, '管理部', NULL, 1, 1, 0, NULL, 0, '2019-10-25 09:46:49', NULL);
INSERT INTO `sys_department` VALUES (2, '技术部', NULL, 1, 1, 0, NULL, 0, '2019-11-01 20:45:43', NULL);
INSERT INTO `sys_department` VALUES (20, '前端开发部', 2, 2, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);
INSERT INTO `sys_department` VALUES (21, '后台开发部', 2, 2, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);
INSERT INTO `sys_department` VALUES (22, '测试部', 2, 2, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);
INSERT INTO `sys_department` VALUES (201, '前端一组', 20, 3, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);
INSERT INTO `sys_department` VALUES (202, '前端二组', 20, 3, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);
INSERT INTO `sys_department` VALUES (203, '后台一组', 21, 3, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);
INSERT INTO `sys_department` VALUES (204, '后台二组', 21, 3, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);
INSERT INTO `sys_department` VALUES (205, '测试一组', 22, 3, 1, 0, NULL, 0, '2019-11-01 20:48:38', NULL);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `log_id` bigint(18) NOT NULL COMMENT '主键',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '类型',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_id` bigint(18) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1060438746056376321, 0, 'A', 100000, '2018-11-08 15:41:58');
INSERT INTO `sys_log` VALUES (1060438788502732802, 0, 'B', 100000, '2018-11-08 15:42:08');
INSERT INTO `sys_log` VALUES (1060438799600861185, 0, 'C', 100000, '2018-11-08 15:42:10');
INSERT INTO `sys_log` VALUES (1060438809495224322, 0, 'D', 100000, '2018-11-08 15:42:13');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父id',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '唯一编码',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` int(11) NOT NULL COMMENT '类型，1：菜单，2：按钮',
  `level` int(11) NOT NULL COMMENT '层级，1：第一级，2：第二级，N：第N级',
  `state` int(11) NOT NULL DEFAULT 1 COMMENT '状态，0：禁用，1：启用',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '版本',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_permission_code_uindex`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '系统管理', NULL, NULL, 'system:management', NULL, 1, 1, 1, 0, NULL, 0, '2019-10-26 11:12:40', NULL);
INSERT INTO `sys_permission` VALUES (100, '用户管理', 1, NULL, 'sys:user:management', NULL, 1, 2, 1, 0, NULL, 0, '2019-10-26 11:15:48', NULL);
INSERT INTO `sys_permission` VALUES (200, '角色管理', 1, NULL, 'sys:role:management', NULL, 1, 2, 1, 0, NULL, 0, '2019-10-26 11:15:48', NULL);
INSERT INTO `sys_permission` VALUES (300, '权限管理', 1, NULL, 'sys:permission:management', NULL, 1, 2, 1, 0, NULL, 0, '2019-10-26 11:15:48', NULL);
INSERT INTO `sys_permission` VALUES (400, '部门管理', 1, NULL, 'sys:department:management', NULL, 1, 2, 1, 0, NULL, 0, '2019-10-26 11:15:48', NULL);
INSERT INTO `sys_permission` VALUES (1000, '用户新增', 100, NULL, 'sys:user:add', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (1001, '用户修改', 100, NULL, 'sys:user:update', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (1002, '用户删除', 100, NULL, 'sys:user:delete', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (1003, '用户详情', 100, NULL, 'sys:user:info', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (1004, '用户分页列表', 100, NULL, 'sys:user:page', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (1005, '用户修改密码', 100, NULL, 'sys:user:update:password', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (1006, '用户修改头像', 100, NULL, 'sys:user:update:head', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (2000, '角色新增', 200, NULL, 'sys:role:add', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (2001, '角色修改', 200, NULL, 'sys:role:update', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (2002, '角色删除', 200, NULL, 'sys:role:delete', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (2003, '角色详情', 200, NULL, 'sys:role:info', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (2004, '角色分页列表', 200, NULL, 'sys:role:page', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3000, '权限新增', 300, NULL, 'sys:permission:add', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3001, '权限修改', 300, NULL, 'sys:permission:update', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3002, '权限删除', 300, NULL, 'sys:permission:delete', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3003, '权限详情', 300, NULL, 'sys:permission:info', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3004, '权限分页列表', 300, NULL, 'sys:permission:page', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3005, '权限所有列表', 300, NULL, 'sys:permission:all:menu:list', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3006, '权限所有树形列表', 300, NULL, 'sys:permission:all:menu:tree', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3007, '权限用户列表', 300, NULL, 'sys:permission:menu:list', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3008, '权限用户树形列表', 300, NULL, 'sys:permission:menu:tree', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (3009, '权限用户代码列表', 300, NULL, 'sys:permission:codes', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (4000, '部门新增', 400, NULL, 'sys:department:add', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (4001, '部门修改', 400, NULL, 'sys:department:update', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (4002, '部门删除', 400, NULL, 'sys:department:delete', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (4003, '部门详情', 400, NULL, 'sys:department:info', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);
INSERT INTO `sys_permission` VALUES (4004, '部门分页列表', 400, NULL, 'sys:department:page', NULL, 2, 3, 1, 0, NULL, 0, '2019-10-26 11:18:40', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色唯一编码',
  `type` int(11) NULL DEFAULT NULL COMMENT '角色类型',
  `state` int(11) NOT NULL DEFAULT 1 COMMENT '角色状态，0：禁用，1：启用',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '版本',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_role_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', NULL, 1, NULL, 0, '2019-10-25 09:47:21', NULL);
INSERT INTO `sys_role` VALUES (2, '雇主', 'employer', NULL, 1, NULL, 0, '2019-10-25 09:48:02', NULL);
INSERT INTO `sys_role` VALUES (3, '服务商', 'ServiceProvider', NULL, 1, NULL, 0, '2019-12-11 22:56:16', NULL);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `state` int(11) NOT NULL DEFAULT 1 COMMENT '状态，0：禁用，1：启用',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '版本',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1, 1, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (2, 1, 100, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (3, 1, 200, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (4, 1, 300, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (5, 1, 400, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (6, 1, 1000, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (7, 1, 1001, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (8, 1, 1002, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (9, 1, 1003, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (10, 1, 1004, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (11, 1, 1005, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (12, 1, 1006, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (13, 1, 2000, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (14, 1, 2001, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (15, 1, 2002, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (16, 1, 2003, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (17, 1, 2004, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (18, 1, 3000, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (19, 1, 3001, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (20, 1, 3002, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (21, 1, 3003, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (22, 1, 3004, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (23, 1, 3005, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (24, 1, 3006, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (25, 1, 3007, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (26, 1, 3008, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (27, 1, 3009, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (28, 1, 4001, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (29, 1, 4002, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (30, 1, 4003, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (31, 1, 4004, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (100, 1, 1, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (101, 1, 100, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (102, 1, 1000, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (103, 1, 1001, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (104, 1, 1002, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (105, 1, 1003, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (106, 1, 1004, 1, NULL, 0, '2019-10-26 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (107, 2, 1, 1, NULL, 0, '2019-12-24 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (108, 2, 100, 1, NULL, 0, '2019-12-24 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (109, 2, 1000, 1, NULL, 0, '2019-12-24 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (110, 3, 1, 1, NULL, 0, '2019-12-24 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (111, 3, 100, 1, NULL, 0, '2019-12-24 22:16:19', NULL);
INSERT INTO `sys_role_permission` VALUES (112, 3, 1000, 1, NULL, 0, '2019-12-24 22:16:19', NULL);

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `soft_supplier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '软件供应商',
  `company_type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司类型',
  `estate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合作地产',
  `hot_key` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热搜关键词',
  `protect_type` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维权类型',
  `hot_tag` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热门评价标签',
  `b_limit` int(11) NULL DEFAULT NULL COMMENT '选标时间限制',
  `e_limit` int(11) NULL DEFAULT NULL COMMENT '审核时间限制',
  `p_limit` int(11) NULL DEFAULT NULL COMMENT '付款时间限制',
  `website` int(11) NULL DEFAULT NULL COMMENT '域名',
  `record_num` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备案号',
  `company_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `tel` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `ser_num` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客服QQ',
  `role_type` int(11) NULL DEFAULT NULL COMMENT '管理员角色类型',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `gender` int(11) NULL DEFAULT 1 COMMENT '性别，0：女，1：男，默认1',
  `head` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'remark',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '状态，0：禁用，1：启用，2：锁定',
  `department_id` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `deleted` int(11) NOT NULL DEFAULT 0 COMMENT '逻辑删除，0：未删除，1：已删除',
  `version` int(11) NULL DEFAULT 0 COMMENT '版本',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `user_type` int(11) NOT NULL DEFAULT 0 COMMENT '用户类型，0：个人/团队，1：企业',
  `is_service` int(11) NOT NULL DEFAULT 0 COMMENT '是否为服务商，0：否,1：是',
  `province` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `zone` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区/县',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `tax` int(11) NULL DEFAULT NULL COMMENT '传真',
  `scale` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规模',
  `intro` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `wechat` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `pro_type` int(10) NULL DEFAULT NULL COMMENT '承接项目类型',
  `id_num` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `id_front` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证正面',
  `id_back` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证背面',
  `id_validity` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证有效期',
  `birthday` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `constellation` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '星座',
  `major` int(10) NULL DEFAULT NULL COMMENT '专业',
  `team_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '团队名称',
  `company_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `license_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业组织机构代码',
  `license_pic` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '营业执照',
  `website` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网址',
  `company_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司类型',
  `service_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '管理员', '11a254dab80d52bc4a347e030e54d861a9d2cdb2af2185a9ca4a7318e830d04d', '666', '', 1, 'http://localhost:8888//resource/201910281559227.jpg', 'Administrator Account', 1, 1, 1, 0, 1, '2019-08-26 00:52:01', '2019-10-27 23:32:29', 0, 0, '福建省', '厦门市', '思明区', NULL, '79363508@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1204778824307318785, 'g-test1', NULL, '20c0f710d5d50d1a9272d59b7ac6f76de93351ffb8e35893c625656a53090bb8', 'fb583bd2575f196db85ec6740443813f', '15343434343', 1, NULL, NULL, 1, 1, 2, 0, 0, '2019-12-11 23:03:50', NULL, 0, 1, '福建省', '福州市', '鼓楼区', NULL, '122622537@qq.com', NULL, NULL, '技能描述', 'wx12', NULL, '350345454656565656', 'http://localhost:8888//resource/201912112303500d28e3ceb-771d-4880-8c62-08cbf07471f1.jpg', 'http://localhost:8888//resource/201912112303500a193b711-6cf6-40da-ade6-fe065086ab16.jpg', NULL, '2019-12-20', '天蝎座', NULL, '一起努力队', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1209370776210362370, 'f-test1', NULL, '20c0f710d5d50d1a9272d59b7ac6f76de93351ffb8e35893c625656a53090bb8', 'fb583bd2575f196db85ec6740443813f', '15343434343', 1, NULL, NULL, 1, 1, 3, 0, 0, '2019-12-24 15:10:36', '2019-12-27 17:16:10', 0, 1, '福建省', '厦门市', '海沧区', NULL, '122622537@qq.com', NULL, NULL, '技能描述', 'wx1', NULL, '350345454656565657', 'http://localhost:8888//resource/20191224151036499906545-f5b1-49c4-a9f9-4ba826d4e364.jpg', 'http://localhost:8888//resource/201912241510365736f411e-572e-46bf-a09d-171982c55e3d.jpg', NULL, '2019-12-27', '', NULL, '一起努力队', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1213534310267629570, 'f-test2', NULL, '8e538dcbf9ef9ed8ef99d30579fbf8b9c861350739c8b972d070c8006364c062', '983381211c382a5b44e5be3f2fd2dcdf', '15343434343', 1, NULL, NULL, 1, 1, 3, 0, 0, '2020-01-05 02:55:00', '2020-01-05 02:55:14', 0, 1, '福建省', '厦门市', '思明区', NULL, '122622537@qq.com', NULL, NULL, '擅长算量和讨价，算过超大型工程', 'wx1', NULL, '350345454656565687', 'http://localhost:8888//resource/20200105025458636ac6da7-99d3-4a5b-92ca-9d0f5465e2db.jpg', 'http://localhost:8888//resource/202001050254587cc1109e2-437d-41d3-9e90-f82f51cf29f9.jpg', NULL, '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `tname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `jobtime` datetime(0) NULL DEFAULT NULL COMMENT '加入工作时间',
  `entrytime` datetime(0) NULL DEFAULT NULL COMMENT '入职时间',
  `major` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `province` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '团队成员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for under_case
-- ----------------------------
DROP TABLE IF EXISTS `under_case`;
CREATE TABLE `under_case`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `case_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '项目类型ID',
  `major` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `province` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `soft_supplier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '软件',
  `intro` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '线下案例' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
