/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : coredecomposition

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001


 Date: 03/01/2019 01:54:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for intedge
-- ----------------------------
DROP TABLE IF EXISTS `intedge`;
CREATE TABLE `intedge`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `datasetId` int(11) NULL DEFAULT NULL,
  `headNo` int(11) NULL DEFAULT NULL,
  `tailNo` int(11) NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
