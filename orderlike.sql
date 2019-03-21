/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost:3306
 Source Schema         : orderlike

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 21/03/2019 16:48:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_like
-- ----------------------------
DROP TABLE IF EXISTS `order_like`;
CREATE TABLE `order_like`  (
  `like_id` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '点赞id',
  `like_menuid` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '点赞菜品id',
  `like_count` int(255) NOT NULL DEFAULT 0 COMMENT '点赞次数',
  `like_userid` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '点赞人id',
  `like_createtime` datetime(0) NULL DEFAULT NULL COMMENT '点赞时间',
  `like_updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `like_updateby` varchar(0) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '更新人id',
  `like_state` int(1) NULL DEFAULT NULL COMMENT '1启用 0 禁用',
  `like_other1` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '点赞备用字段1',
  `like_other2` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '点赞备用字段2',
  `like_other3` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '点赞备用字段3',
  `like_other4` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '点赞备用字段4',
  PRIMARY KEY (`like_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_like
-- ----------------------------
INSERT INTO `order_like` VALUES ('DZc7f498a0-971d-4669-bff5-3decf032c85d', NULL, 7, '123', '2019-03-21 14:43:16', '2019-03-21 14:43:16', NULL, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order_menu
-- ----------------------------
DROP TABLE IF EXISTS `order_menu`;
CREATE TABLE `order_menu`  (
  `menu_id` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '菜品id',
  `menu_name` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '菜品名称',
  `menu_src` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '菜品图片',
  `menu_info` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '菜品介绍',
  `menu_createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `menu_createbyid` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '创建人id',
  `menu_updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `menu_updatebyid` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '更新人id',
  `menu_state` int(1) NULL DEFAULT NULL COMMENT '1  启用  0   禁用',
  `menu_other1` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '菜品备用字段1',
  `menu_other2` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '菜品备用字段2',
  `menu_other3` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '菜品备用字段3',
  `menu_other4` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '菜品备用字段4',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_menu
-- ----------------------------
INSERT INTO `order_menu` VALUES ('ME57083fe6-31b7-4466-8209-d88e965baeca', '宫保鸡丁', NULL, NULL, '2019-03-21 11:58:54', NULL, '2019-03-21 11:58:54', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `order_menu` VALUES ('ME5d9e38fb-5bbb-4a3a-92ab-e4de20092110', '宫保鸡丁', NULL, NULL, '2019-03-21 11:42:01', NULL, '2019-03-21 11:42:01', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `order_menu` VALUES ('ME45938d0b-8801-4002-a142-7d317420a611', '波波鱼', NULL, NULL, '2019-03-21 11:38:29', NULL, '2019-03-21 11:59:00', NULL, 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order_todayeat
-- ----------------------------
DROP TABLE IF EXISTS `order_todayeat`;
CREATE TABLE `order_todayeat`  (
  `eat_id` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT 'today-eatid',
  `eat_menuid` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT 'today-eatmenuid',
  `eat_userid` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT 'today-userid',
  `eat_createtime` datetime(0) NULL DEFAULT NULL COMMENT 'today-user-createtime',
  `eat_updatetime` datetime(0) NULL DEFAULT NULL COMMENT 'today-user-updatetime',
  `eat_updatebyid` varchar(55) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT 'today-updatebyid',
  `eat_state` int(1) NULL DEFAULT NULL COMMENT '1启用   0  禁用',
  `eat_other1` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT 'today-eat 备用字段1',
  `eat_other2` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT 'today-eat 备用字段2',
  `eat_other3` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT 'today-eat 备用字段3',
  `eat_other4` varchar(100) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT 'today-eat 备用字段4',
  PRIMARY KEY (`eat_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_todayeat
-- ----------------------------
INSERT INTO `order_todayeat` VALUES ('TODAY91e232be-2031-45e2-82bd-267eb5e86f2b', 'ME45938d0b-8801-4002-a142-7d317420a611', '123', '2019-03-21 16:17:49', '2019-03-21 16:17:49', NULL, 1, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
