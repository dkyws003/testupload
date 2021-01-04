/*
 Navicat Premium Data Transfer

 Source Server         : 我的虚拟机MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : 192.168.25.93:3306
 Source Schema         : vip_file_manager

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 09/06/2020 13:51:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_files
-- ----------------------------
DROP TABLE IF EXISTS `tb_files`;
CREATE TABLE `tb_files`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件ID',
  `target_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标对象ID',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件位置',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原始文件名',
  `suffix` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件后缀',
  `created_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `modified_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
