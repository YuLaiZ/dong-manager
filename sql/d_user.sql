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

 Date: 30/01/2018 00:18:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role` enum('ADMIN','NORMAL') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'NORMAL',
  `register_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `d_user_idx`(`user_name`, `password`) USING BTREE,
  INDEX `d_user_idx_uuid`(`uuid`) USING BTREE,
  INDEX `d_user_idx_role`(`role`) USING BTREE,
  INDEX `d_user_idx_token`(`register_token`) USING BTREE,
  INDEX `d_user_flag`(`flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
