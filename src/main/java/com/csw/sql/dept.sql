/*
Navicat MySQL Data Transfer

Source Server         : 106.13.236.137
Source Server Version : 50642
Source Host           : 106.13.236.137:3306
Source Database       : empdeptpink

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-11-12 09:50:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` varchar(99) DEFAULT NULL,
  `name` varchar(99) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('3f870339-c51f-4d34-b291-5c582e447b82', '小白');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` varchar(99) DEFAULT NULL,
  `name` varchar(99) DEFAULT NULL,
  `salary` varchar(99) DEFAULT NULL,
  `age` varchar(99) DEFAULT NULL,
  `bir` date DEFAULT NULL,
  `did` varchar(99) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('158916ef-9985-403e-8ba4-8a41eb65cd28', 'a1', 'a', 'a', '1996-02-04', '3f870339-c51f-4d34-b291-5c582e447b82');
INSERT INTO `emp` VALUES ('bf992cfd-2471-40ed-ab88-1d41aa4adb91', 's3', 'ss', 'ss', '1996-03-05', '3f870339-c51f-4d34-b291-5c582e447b82');
INSERT INTO `emp` VALUES ('1f27c7af-89b3-447a-80ac-da7ac3995fc3', 'aaa', '532523', '12', '1992-02-02', '3f870339-c51f-4d34-b291-5c582e447b82');
INSERT INTO `emp` VALUES ('df5b6852-f9f3-4499-88cc-3c394e0430c2', 'ccc2', '45662', '22', '1998-03-03', '3f870339-c51f-4d34-b291-5c582e447b82');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(99) DEFAULT NULL,
  `truename` varchar(99) DEFAULT NULL,
  `password` varchar(99) DEFAULT NULL,
  `salt` varchar(99) DEFAULT NULL,
  `sex` varchar(99) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('qqq', 'qqq', '9b2b4e1742608bf7f728a3bf44b251d9', 'WrliRwJT', '男');
INSERT INTO `user` VALUES ('www', 'ww', '9959988d30fe30a30f859721a02c7c23', 'A4AOAHqy', '女');
INSERT INTO `user` VALUES ('sss', 'sss', '0e8cd06019e970eb3dd9ec3cc1bb0960', 'UW7i1uSV', '男');
INSERT INTO `user` VALUES ('zz', 'zz', 'c9c809bc2c6a3a52a6ad70b0d1cdf341', 'F26LKZfT', '女');
