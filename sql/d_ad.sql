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

 Date: 25/01/2018 15:25:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_ad
-- ----------------------------
DROP TABLE IF EXISTS `d_ad`;
CREATE TABLE `d_ad`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` tinyint(4) NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `modify_user_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `d_ad_idx_id`(`id`) USING BTREE,
  INDEX `d_ad_idx_flag`(`flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
