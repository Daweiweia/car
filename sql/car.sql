/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.28 : Database - car
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`car` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `car`;

/*Table structure for table `aftersales` */

DROP TABLE IF EXISTS `aftersales`;

CREATE TABLE `aftersales` (
  `aftersale_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '服务序号',
  `maintenance_date` date NOT NULL COMMENT '保养如日期',
  `client_id` int(11) NOT NULL COMMENT '客户编号',
  `staff_id` int(11) NOT NULL COMMENT '保养人编号',
  `records` varchar(50) NOT NULL COMMENT '业务记录',
  PRIMARY KEY (`aftersale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20102 DEFAULT CHARSET=utf8;

/*Data for the table `aftersales` */

insert  into `aftersales`(`aftersale_id`,`maintenance_date`,`client_id`,`staff_id`,`records`) values (20101,'2020-03-04',50011,10101,'日常保养');

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆编号',
  `car_type` varchar(11) NOT NULL COMMENT '型号',
  `car_name` varchar(11) NOT NULL COMMENT '车名称',
  `car_color` varchar(10) NOT NULL COMMENT '颜色',
  `car_stock` int(10) NOT NULL COMMENT '库存',
  `manufactor_name` varchar(20) NOT NULL COMMENT '出产厂家',
  `manufactor_date` date NOT NULL COMMENT '出产日期',
  `manufactor_price` varchar(8) NOT NULL COMMENT '出厂价格',
  `car_image` varchar(20) DEFAULT NULL COMMENT '车辆图样',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30012 DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`car_id`,`car_type`,`car_name`,`car_color`,`car_stock`,`manufactor_name`,`manufactor_date`,`manufactor_price`,`car_image`) values (3002,'suv2','奥迪A4Ld','黑色',121,'重庆某厂商','2020-06-05','324000','1594785246984.jpg'),(3003,'suv','奥迪A6L','黑色',10,'重庆某厂商','2020-03-05','430040','1594785641256.jpg'),(3004,'轿车','大众','红色',22,'日产','2020-07-09','111111','1596705587793.jpg'),(3005,'轿车','大众','红色',22,'日产','2020-07-09','111111','1595385500087.jpg'),(3006,'轿车','大众','红色',22,'日产','2020-07-09','111111','1595385742106.jpg'),(3007,'大货车','风驰天下','白色',3,'成都造车行','2020-07-01','222222.3','1595385734699.jpg'),(30010,'suv','上汽大众','白色',23,'成都制造车','2020-07-01','210004.5','1597548474069.jpg'),(30011,'sdf','哈哈哈','sdf',12,'sdfawefwef','2020-10-06','12112121','1601697715490.jpg');

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `client_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `client_name` varchar(10) NOT NULL COMMENT '姓名',
  `client_grade` char(5) NOT NULL COMMENT '客户等级',
  `client_phone` int(11) NOT NULL COMMENT '电话',
  `client_addr` varchar(30) NOT NULL COMMENT '地址',
  `staff_id` int(10) NOT NULL COMMENT '客户负责人',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50012 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`client_id`,`client_name`,`client_grade`,`client_phone`,`client_addr`,`staff_id`) values (50011,'张三','C',121213232,'重庆市渝中区某某某小区',10101);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_id` int(20) NOT NULL,
  `department_name` varchar(50) NOT NULL,
  `manager_name` varchar(50) NOT NULL,
  `staff_num` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `department` */

insert  into `department`(`id`,`department_id`,`department_name`,`manager_name`,`staff_num`) values (1,6010,'销售部','韩韩1',12),(2,6020,'维修部','旺旺1',33);

/*Table structure for table `department_repair` */

DROP TABLE IF EXISTS `department_repair`;

CREATE TABLE `department_repair` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `department_name` varchar(11) NOT NULL COMMENT '部门名',
  `manager_name` varchar(11) NOT NULL COMMENT '经理',
  `staff_num` int(11) NOT NULL COMMENT '员工数量',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6011 DEFAULT CHARSET=utf8;

/*Data for the table `department_repair` */

insert  into `department_repair`(`department_id`,`department_name`,`manager_name`,`staff_num`) values (6010,'维修部门','韩韩1',12);

/*Table structure for table `department_sale` */

DROP TABLE IF EXISTS `department_sale`;

CREATE TABLE `department_sale` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `department_name` varchar(11) NOT NULL COMMENT '部门名称',
  `manager_name` varchar(10) NOT NULL COMMENT '经理名',
  `staff_num` int(11) NOT NULL COMMENT '员工数量',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6021 DEFAULT CHARSET=utf8;

/*Data for the table `department_sale` */

insert  into `department_sale`(`department_id`,`department_name`,`manager_name`,`staff_num`) values (6020,'销售部门','李四',23);

/*Table structure for table `manufactor` */

DROP TABLE IF EXISTS `manufactor`;

CREATE TABLE `manufactor` (
  `manufactor_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '厂商编号',
  `manufactor_addr` varchar(20) NOT NULL COMMENT '厂商地址',
  `manufactor_charge` varchar(10) NOT NULL COMMENT '厂商负责人',
  `manufactor_phone_` int(11) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`manufactor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40012 DEFAULT CHARSET=utf8;

/*Data for the table `manufactor` */

insert  into `manufactor`(`manufactor_id`,`manufactor_addr`,`manufactor_charge`,`manufactor_phone_`) values (40011,'成都市','韩韩',1212121212);

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售编号',
  `sale_date` date NOT NULL COMMENT '销售日期',
  `client_id` int(11) NOT NULL COMMENT '客户编号',
  `car_type` varchar(11) NOT NULL COMMENT '轿车型号',
  `car_color` char(5) NOT NULL COMMENT '轿车颜色',
  `sale_num` int(6) NOT NULL COMMENT '销售数量',
  `sale_price` varchar(10) NOT NULL COMMENT '实际售价',
  `staff_id` int(11) NOT NULL COMMENT '负责人',
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20202 DEFAULT CHARSET=utf8;

/*Data for the table `sale` */

insert  into `sale`(`sale_id`,`sale_date`,`client_id`,`car_type`,`car_color`,`sale_num`,`sale_price`,`staff_id`) values (20201,'2020-06-03',50011,'suv','白色',1,'203000',10102);

/*Table structure for table `sh_perm` */

DROP TABLE IF EXISTS `sh_perm`;

CREATE TABLE `sh_perm` (
  `perms` varchar(100) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `url` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='存放角色对应的权限';

/*Data for the table `sh_perm` */

insert  into `sh_perm`(`perms`,`id`,`url`) values ('staff:add',1,'staff/add'),('staff:update',2,'staff/update'),('staff:delete',3,'staff/delete'),('staff:insert',4,'staff/insert'),('role:changePerm',5,'role/changePerm'),('car:update',6,'car/update'),('car:delete',7,'car/delete'),('car:upload',8,'car/upload');

/*Table structure for table `sh_role` */

DROP TABLE IF EXISTS `sh_role`;

CREATE TABLE `sh_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表，存放用户对应的角色名';

/*Data for the table `sh_role` */

insert  into `sh_role`(`id`,`role_name`) values (1,'admin'),(2,'user');

/*Table structure for table `sh_role_perm` */

DROP TABLE IF EXISTS `sh_role_perm`;

CREATE TABLE `sh_role_perm` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) DEFAULT NULL,
  `perm_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='角色权限中间表，将角色id和权限id对应';

/*Data for the table `sh_role_perm` */

insert  into `sh_role_perm`(`id`,`role_id`,`perm_id`) values (1,1,1),(3,1,2),(4,1,3),(5,1,4),(7,2,2),(8,1,5),(9,1,6),(10,1,7),(11,1,8);

/*Table structure for table `sh_user_role` */

DROP TABLE IF EXISTS `sh_user_role`;

CREATE TABLE `sh_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='管理员角色表';

/*Data for the table `sh_user_role` */

insert  into `sh_user_role`(`id`,`user_id`,`role_id`) values (1,10001,1),(2,20001,2),(3,20002,2);

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `staff_id` int(10) NOT NULL COMMENT '员工编号',
  `department_name` varchar(11) NOT NULL COMMENT '所属部门',
  `staff_name` varchar(11) NOT NULL COMMENT '姓名',
  `staff_phone` int(11) NOT NULL COMMENT '电话',
  `staff_addr` varchar(30) NOT NULL COMMENT '住址',
  `jointime` date NOT NULL,
  `staff_bankCard` varchar(20) DEFAULT NULL COMMENT '未录入',
  `staff_idCard` varchar(20) DEFAULT NULL COMMENT '未录入',
  PRIMARY KEY (`staff_id`),
  UNIQUE KEY `staff_id` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`staff_id`,`department_name`,`staff_name`,`staff_phone`,`staff_addr`,`jointime`,`staff_bankCard`,`staff_idCard`) values (10111,'维修部','韩大帅',1145678901,'重庆市巴南区','2020-07-02','1212121212','111111111111'),(10112,'维修部','孙笑天',12121313,'重庆市巴南区','2020-07-15','2112121','12131313'),(10113,'销售部','韩韩',12121313,'重庆市巴南区','2020-07-15','211212121212','12131313'),(10114,'销售部','张三',12121313,'重庆市巴南区','2020-07-15','211212121212','12131313'),(10115,'销售部','哈',12121313,'重庆市巴南区','2020-07-15','211212121212','12131313'),(10116,'销售部','哈',12121313,'重庆市巴南区','2020-07-15','211212121212','12131313'),(10117,'销售部','11',11,'成都市','2020-07-02','11','11'),(10118,'销售部','11',11,'重庆市巫山县','2020-07-15','11','11'),(10119,'销售部','哈',12121313,'重庆市巴南区','2020-07-15','211212121212','12131313'),(10120,'销售部','哈',12121313,'重庆市巴南区','2020-07-15','211212121212','12131313');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(10) NOT NULL COMMENT '用户姓名',
  `user_password` varchar(100) NOT NULL COMMENT '用户密码',
  `user_phone` varchar(20) NOT NULL COMMENT '用户电话',
  `salt` varchar(10) DEFAULT NULL COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_id`,`user_name`,`user_password`,`user_phone`,`salt`) values (1,10001,'admin','be729a37775d53d2c642da426a2b8310','131234567','f12121'),(2,20001,'韩韩','b0aa21296c6694367526a64c7cee2438','18923456621','761948'),(3,20002,'韩某','1072d2b04affb398f6a186904c266d03','11111111111','661845');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
