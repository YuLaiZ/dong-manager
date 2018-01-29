/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1-root
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : dong

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 29/01/2018 14:54:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_book_update_time
-- ----------------------------
DROP TABLE IF EXISTS `d_book_update_time`;
CREATE TABLE `d_book_update_time`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `update_time` datetime(0) NOT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `d_book_update_time_idx`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '更新时间记录' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
