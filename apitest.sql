# Host: localhost  (Version: 5.5.56)
# Date: 2018-07-23 18:55:49
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "addquestion"
#

DROP TABLE IF EXISTS `addquestion`;
CREATE TABLE `addquestion` (
  `id` int(11) DEFAULT NULL,
  `ownerIds` int(11) DEFAULT NULL,
  `ownerNames` varchar(100) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `userToken` varchar(200) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "addquestion"
#

INSERT INTO `addquestion` VALUES (1,NULL,NULL,'海默科技关联板块','rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**',744,545),(2,NULL,NULL,'业绩预增优质成长股','rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**',744,545),(3,NULL,NULL,'连续三年净资产收益高的策略','rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**',744,545),(4,NULL,NULL,'胜率最高策略','rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**',744,545),(5,NULL,NULL,'上升趋势确定策略','rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**',744,545),(6,NULL,NULL,'足球概念龙头','rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**',744,545);

#
# Source for table "getquestionreplybylittle"
#

DROP TABLE IF EXISTS `getquestionreplybylittle`;
CREATE TABLE `getquestionreplybylittle` (
  `id` int(11) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  `userToken` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "getquestionreplybylittle"
#

INSERT INTO `getquestionreplybylittle` VALUES (1,1740714,'rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**');

#
# Source for table "getquicksearch"
#

DROP TABLE IF EXISTS `getquicksearch`;
CREATE TABLE `getquicksearch` (
  `id` int(11) DEFAULT NULL,
  `pageIndex` int(11) DEFAULT NULL,
  `pageSize` int(11) DEFAULT NULL,
  `userToken` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "getquicksearch"
#

INSERT INTO `getquicksearch` VALUES (1,0,0,'rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**'),(2,0,0,'rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**'),(3,0,0,'rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**');

#
# Source for table "getuserstocks"
#

DROP TABLE IF EXISTS `getuserstocks`;
CREATE TABLE `getuserstocks` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `usertoken` varchar(255) DEFAULT NULL,
  `auto` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "getuserstocks"
#

INSERT INTO `getuserstocks` VALUES (1,'rdHRLzQgBQx_CEUM7qx7q6p25xyuMvu493iyb60IBdm-l3lVdrPS0Q**',1);

#
# Source for table "login"
#

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) DEFAULT NULL,
  `username` char(100) DEFAULT NULL,
  `password` char(100) DEFAULT NULL,
  `loginType` int(11) DEFAULT NULL,
  `deviceid` int(11) DEFAULT NULL,
  `company` char(20) DEFAULT NULL,
  `expected` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "login"
#

INSERT INTO `login` VALUES (1,'13311151061','lj123456',1,2,'1','登录成功'),(2,'13231408948','123456',1,2,'1','用户名或密码错误'),(3,'\"\"','\"\"',1,2,'1','未设置密码，请用手机号和验证码登录'),(4,'13311151061',NULL,NULL,NULL,NULL,'参数错误'),(5,'13331111','lJ123456',NULL,NULL,NULL,'用户名或密码错误'),(6,'hebeiliujin','lj123456',1,2,'1','登录成功'),(7,'asdfghjklqwertyuiopasdfghjkllzxcvbnmklhjfdswwwww','1234567890poiuytrewqasdfghjkl',NULL,NULL,NULL,'参数错误');
