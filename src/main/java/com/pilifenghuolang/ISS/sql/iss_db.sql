/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : iss_db

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 28/03/2023 11:42:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pass_flow
-- ----------------------------
DROP TABLE IF EXISTS `pass_flow`;
CREATE TABLE `pass_flow`  (
  `id` int(32) NOT NULL COMMENT '主键',
  `day_of_week` int(11) NOT NULL COMMENT '星期',
  `pass_flow1` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量1',
  `pass_flow2` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量2',
  `pass_flow3` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量3',
  `pass_flow4` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量4',
  `pass_flow5` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量5',
  `pass_flow6` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量6',
  `pass_flow7` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量7',
  `pass_flow8` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量8',
  `pass_flow9` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量9',
  `pass_flow10` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量10',
  `pass_flow11` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量11',
  `pass_flow12` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量12',
  `pass_flow13` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量13',
  `pass_flow14` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量14',
  `pass_flow15` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量15',
  `pass_flow16` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量16',
  `pass_flow17` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量17',
  `pass_flow18` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量18',
  `pass_flow19` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量19',
  `pass_flow20` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量20',
  `pass_flow21` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量21',
  `pass_flow22` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量22',
  `pass_flow23` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量23',
  `pass_flow24` decimal(5, 1) NULL DEFAULT NULL COMMENT '客流量24',
  PRIMARY KEY (`id`, `day_of_week`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客流量数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pass_flow
-- ----------------------------
INSERT INTO `pass_flow` VALUES (1, 1, 1.2, 5.2, 12.0, 11.7, 11.6, 17.5, 18.3, 25.1, 27.4, 19.3, 19.8, 16.0, 14.0, 15.1, 12.7, 9.1, 6.9, 8.2, 4.7, 5.7, 2.5, 2.2, 0.1, 0.1);
INSERT INTO `pass_flow` VALUES (1, 2, 1.1, 6.7, 11.1, 14.1, 11.9, 19.7, 15.7, 25.6, 28.4, 17.8, 17.7, 20.2, 13.4, 13.4, 9.7, 8.3, 7.9, 6.9, 6.4, 5.8, 2.5, 2.0, 0.1, 0.1);
INSERT INTO `pass_flow` VALUES (1, 3, 1.1, 6.8, 10.7, 14.6, 14.4, 17.2, 15.8, 20.8, 25.1, 18.3, 21.0, 14.3, 15.8, 15.2, 13.9, 9.8, 9.8, 6.3, 5.1, 4.6, 2.3, 2.2, 0.1, 0.1);
INSERT INTO `pass_flow` VALUES (1, 4, 1.3, 6.2, 9.4, 11.6, 14.7, 17.4, 19.0, 25.8, 31.0, 17.8, 21.6, 14.4, 15.8, 13.6, 11.0, 9.7, 8.3, 8.4, 5.8, 5.3, 2.9, 1.9, 0.1, 0.1);
INSERT INTO `pass_flow` VALUES (1, 5, 1.4, 6.7, 9.6, 11.9, 12.5, 18.4, 18.8, 18.3, 29.8, 19.7, 16.1, 14.7, 13.7, 11.6, 9.4, 9.5, 8.2, 7.1, 5.9, 5.7, 2.2, 1.8, 0.1, 0.1);
INSERT INTO `pass_flow` VALUES (1, 6, 2.4, 9.6, 20.8, 26.9, 24.6, 33.8, 39.0, 43.2, 62.4, 43.8, 42.7, 28.0, 32.2, 31.1, 20.7, 15.1, 17.2, 12.3, 12.8, 11.9, 5.4, 4.2, 0.2, 0.2);
INSERT INTO `pass_flow` VALUES (1, 7, 2.3, 9.7, 23.0, 22.2, 26.5, 36.5, 37.8, 49.4, 48.1, 37.6, 38.5, 28.6, 26.7, 29.3, 25.6, 14.8, 14.4, 13.6, 11.5, 12.2, 6.0, 4.0, 0.2, 0.2);

-- ----------------------------
-- Table structure for preference
-- ----------------------------
DROP TABLE IF EXISTS `preference`;
CREATE TABLE `preference`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stuff_id` int(32) NOT NULL COMMENT '所属员工',
  `type` int(11) NULL DEFAULT NULL COMMENT '偏好类型',
  `start_time` decimal(24, 2) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` decimal(24, 2) NULL DEFAULT NULL COMMENT '结束时间',
  `day_of_the_week` int(11) NULL DEFAULT NULL COMMENT '星期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '偏好表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of preference
-- ----------------------------
INSERT INTO `preference` VALUES (1, 1, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (2, 1, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (3, 1, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (4, 1, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (5, 1, 1, 8.00, 12.00, NULL);
INSERT INTO `preference` VALUES (6, 1, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (7, 1, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (8, 2, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (9, 2, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (10, 2, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (11, 2, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (12, 2, 1, 12.00, 16.00, NULL);
INSERT INTO `preference` VALUES (13, 2, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (14, 2, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (15, 3, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (16, 3, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (17, 3, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (18, 3, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (19, 3, 1, 16.00, 20.00, NULL);
INSERT INTO `preference` VALUES (20, 3, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (21, 3, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (22, 4, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (23, 4, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (24, 4, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (25, 4, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (26, 4, 1, 20.00, 24.00, NULL);
INSERT INTO `preference` VALUES (27, 4, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (28, 4, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (29, 5, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (30, 5, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (31, 5, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (32, 5, 1, 8.00, 12.00, NULL);
INSERT INTO `preference` VALUES (33, 5, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (34, 5, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (35, 6, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (36, 6, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (37, 6, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (38, 6, 1, 12.00, 16.00, NULL);
INSERT INTO `preference` VALUES (39, 6, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (40, 6, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (41, 7, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (42, 7, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (43, 7, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (44, 7, 1, 16.00, 20.00, NULL);
INSERT INTO `preference` VALUES (45, 7, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (46, 7, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (47, 8, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (48, 8, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (49, 8, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (50, 8, 1, 20.00, 24.00, NULL);
INSERT INTO `preference` VALUES (51, 8, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (52, 8, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (53, 9, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (54, 9, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (55, 9, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (56, 9, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (57, 9, 1, 8.00, 12.00, NULL);
INSERT INTO `preference` VALUES (58, 9, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (59, 9, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (60, 10, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (61, 10, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (62, 10, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (63, 10, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (64, 10, 1, 12.00, 16.00, NULL);
INSERT INTO `preference` VALUES (65, 10, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (66, 10, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (67, 11, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (68, 11, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (69, 11, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (70, 11, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (71, 11, 1, 16.00, 20.00, NULL);
INSERT INTO `preference` VALUES (72, 11, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (73, 11, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (74, 12, 0, NULL, NULL, 1);
INSERT INTO `preference` VALUES (75, 12, 0, NULL, NULL, 3);
INSERT INTO `preference` VALUES (76, 12, 0, NULL, NULL, 6);
INSERT INTO `preference` VALUES (77, 12, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (78, 12, 1, 20.00, 24.00, NULL);
INSERT INTO `preference` VALUES (79, 12, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (80, 12, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (81, 13, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (82, 13, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (83, 13, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (84, 13, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (85, 13, 1, 8.00, 12.00, NULL);
INSERT INTO `preference` VALUES (86, 13, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (87, 13, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (88, 14, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (89, 14, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (90, 14, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (91, 14, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (92, 14, 1, 12.00, 16.00, NULL);
INSERT INTO `preference` VALUES (93, 14, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (94, 14, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (95, 15, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (96, 15, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (97, 15, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (98, 15, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (99, 15, 1, 16.00, 20.00, NULL);
INSERT INTO `preference` VALUES (100, 15, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (101, 15, 3, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (102, 16, 0, NULL, NULL, 2);
INSERT INTO `preference` VALUES (103, 16, 0, NULL, NULL, 4);
INSERT INTO `preference` VALUES (104, 16, 0, NULL, NULL, 5);
INSERT INTO `preference` VALUES (105, 16, 0, NULL, NULL, 7);
INSERT INTO `preference` VALUES (106, 16, 1, 20.00, 24.00, NULL);
INSERT INTO `preference` VALUES (107, 16, 2, NULL, NULL, NULL);
INSERT INTO `preference` VALUES (108, 16, 3, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店名',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `size` decimal(24, 2) NULL DEFAULT NULL COMMENT '面积',
  `pre_divisor_value` decimal(24, 2) NULL DEFAULT NULL COMMENT '开店前准备除数的权值',
  `free_population_num` int(11) NULL DEFAULT NULL COMMENT '店空闲时需要的人数',
  `aft_divisor_value` decimal(24, 2) NULL DEFAULT NULL COMMENT '关店后准备除数的权值',
  `aft_add_value` int(11) NULL DEFAULT NULL COMMENT '关店后准备加数的权值',
  `pre_prepare_hour_num` int(11) NULL DEFAULT NULL COMMENT '开店之前需要做几小时准备工作',
  `aft_prepare_hour_num` int(11) NULL DEFAULT NULL COMMENT '关门之后需要做几小时准备工作',
  `pass_flow_divisor_value` decimal(24, 2) NULL DEFAULT NULL COMMENT '人流量对应店员数的除数权值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '店铺1', '地球', 200.00, 100.00, 1, 80.00, 1, 1, 2, 3.80);

-- ----------------------------
-- Table structure for stuff
-- ----------------------------
DROP TABLE IF EXISTS `stuff`;
CREATE TABLE `stuff`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工名字',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `stores` int(32) NULL DEFAULT NULL COMMENT '所属门店id',
  `day_working_time_upper_limit` int(32) NULL DEFAULT 8 COMMENT '日偏好工作时间',
  `week_working_time_upper_limit` int(32) NULL DEFAULT 40 COMMENT '周偏好工作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stuff
-- ----------------------------
INSERT INTO `stuff` VALUES (1, '员工1', NULL, NULL, NULL, 1, 6, 30);
INSERT INTO `stuff` VALUES (2, '员工2', NULL, NULL, NULL, 1, 6, 35);
INSERT INTO `stuff` VALUES (3, '员工3', NULL, NULL, NULL, 1, 7, 30);
INSERT INTO `stuff` VALUES (4, '员工4', NULL, NULL, NULL, 1, 7, 35);
INSERT INTO `stuff` VALUES (5, '员工5', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (6, '员工6', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (7, '员工7', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (8, '员工8', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (9, '员工9', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (10, '员工10', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (11, '员工11', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (12, '员工12', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (13, '员工13', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (14, '员工14', NULL, NULL, NULL, 1, 8, 40);
INSERT INTO `stuff` VALUES (15, '员工15', NULL, NULL, NULL, NULL, 8, 40);
INSERT INTO `stuff` VALUES (16, '员工16', NULL, NULL, NULL, NULL, 8, 40);

-- ----------------------------
-- View structure for preference_for_stuff
-- ----------------------------
DROP VIEW IF EXISTS `preference_for_stuff`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `preference_for_stuff` AS select `stuff`.`name` AS `name`,`stuff`.`id` AS `id`,`stuff`.`position` AS `position`,`stuff`.`telephone` AS `telephone`,`stuff`.`mail` AS `mail`,`stuff`.`stores` AS `stores`,`preference`.`type` AS `type`,`preference`.`start_time` AS `start_time`,`preference`.`end_time` AS `end_time`,`preference`.`day_of_week` AS `day_of_week`,`preference`.`time_num` AS `time_num` from (`stuff` join `preference`);

SET FOREIGN_KEY_CHECKS = 1;
