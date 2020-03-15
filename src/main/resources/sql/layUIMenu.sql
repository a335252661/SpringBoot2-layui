/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : maventest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-03-15 22:54:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for layuimenu
-- ----------------------------
DROP TABLE IF EXISTS `layuimenu`;
CREATE TABLE `layuimenu` (
  `menuId` int(11) NOT NULL,
  `level` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `fatherMenuId` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of layuimenu
-- ----------------------------
INSERT INTO `layuimenu` VALUES ('9003', '1', '基础功能', null, null);
INSERT INTO `layuimenu` VALUES ('9004', '1', '解决方案', null, null);
INSERT INTO `layuimenu` VALUES ('9005', '1', '系统管理', null, null);
INSERT INTO `layuimenu` VALUES ('90031', '2', '用户查询', 'layUiBaseQuery', '9003');
INSERT INTO `layuimenu` VALUES ('90032', '2', '作业日志', 'layUiLogQuery', '9003');
INSERT INTO `layuimenu` VALUES ('90041', '2', '列表一', 'baseQuery', '9004');
INSERT INTO `layuimenu` VALUES ('90051', '2', '菜单管理', 'menuManagement', '9005');
