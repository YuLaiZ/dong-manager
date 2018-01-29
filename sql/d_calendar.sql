/*
 Navicat Premium Data Transfer

 Source Server         : YuLaisCloud
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 123.207.125.170:3306
 Source Schema         : dong

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 29/01/2018 11:22:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_calendar
-- ----------------------------
DROP TABLE IF EXISTS `d_calendar`;
CREATE TABLE `d_calendar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `days` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` tinyint(4) NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `d_calendar_idx_id`(`id`) USING BTREE,
  INDEX `d_calendar_idx_flag`(`flag`) USING BTREE,
  INDEX `d_calendar_idx_days`(`days`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '主日历' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
