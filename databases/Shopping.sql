/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 8.0.11 : Database - shopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shopping`;

/*Table structure for table `categoryone` */

DROP TABLE IF EXISTS `categoryone`;

CREATE TABLE `categoryone` (
  `categoryOneId` int(11) NOT NULL AUTO_INCREMENT COMMENT '一级菜单编号',
  `categoryOneName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '一级菜单名称',
  PRIMARY KEY (`categoryOneId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `categoryone` */

insert  into `categoryone`(`categoryOneId`,`categoryOneName`) values 
(1,'数码');

/*Table structure for table `categorythree` */

DROP TABLE IF EXISTS `categorythree`;

CREATE TABLE `categorythree` (
  `categoryThreeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '三级菜单编号',
  `categoryTwoId` int(11) NOT NULL COMMENT '二级菜单编号，外键',
  `categoryThreeName` varchar(20) NOT NULL COMMENT '三级菜单名称',
  PRIMARY KEY (`categoryThreeId`),
  KEY `fk_categoryThree_categoryTwo` (`categoryTwoId`),
  CONSTRAINT `fk_categoryThree_categoryTwo` FOREIGN KEY (`categoryTwoId`) REFERENCES `categorytwo` (`categorytwoid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `categorythree` */

insert  into `categorythree`(`categoryThreeId`,`categoryTwoId`,`categoryThreeName`) values 
(1,1,'努比亚');

/*Table structure for table `categorytwo` */

DROP TABLE IF EXISTS `categorytwo`;

CREATE TABLE `categorytwo` (
  `categoryTwoId` int(11) NOT NULL AUTO_INCREMENT COMMENT '二级菜单编号',
  `categoryOneId` int(11) NOT NULL COMMENT '一级菜单编号，外键',
  `categoryTwoName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二级菜单名称',
  PRIMARY KEY (`categoryTwoId`),
  KEY `fk_categoryTwo_categoryOne` (`categoryOneId`),
  CONSTRAINT `fk_categoryTwo_categoryOne` FOREIGN KEY (`categoryOneId`) REFERENCES `categoryone` (`categoryoneid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `categorytwo` */

insert  into `categorytwo`(`categoryTwoId`,`categoryOneId`,`categoryTwoName`) values 
(1,1,'手机');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `orderId` bigint(20) NOT NULL COMMENT '订单编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号，外键',
  `orderCreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  PRIMARY KEY (`orderId`),
  KEY `fk_order_user` (`userId`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`orderId`,`userId`,`orderCreateDate`) values 
(175953195766517835,1,'2018-07-08 23:17:11'),
(175953195766517836,1,'2018-07-08 23:28:36');

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `orderItemId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项编号',
  `productTypeId` bigint(20) NOT NULL COMMENT '产品类型编号，外键',
  `orderId` bigint(20) NOT NULL COMMENT '订单编号，外键',
  `quantity` int(11) NOT NULL COMMENT '数量',
  `remark` varchar(50) NOT NULL COMMENT '备注',
  `status` int(11) NOT NULL COMMENT '订单项状态',
  PRIMARY KEY (`orderItemId`),
  KEY `fk_orderItem_productType` (`productTypeId`),
  KEY `fk_orderItem_order` (`orderId`),
  CONSTRAINT `fk_orderItem_order` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderid`),
  CONSTRAINT `fk_orderItem_productType` FOREIGN KEY (`productTypeId`) REFERENCES `producttype` (`producttypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`orderItemId`,`productTypeId`,`orderId`,`quantity`,`remark`,`status`) values 
(1,3,175953195766517835,10,'送快一点哟',0),
(2,1,175953195766517835,2,'不要弄坏哟',5);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `productId` bigint(20) NOT NULL COMMENT '产品编号',
  `categoryThreeId` int(11) NOT NULL COMMENT '三级分类编号，外键',
  `productName` varchar(50) NOT NULL COMMENT '产品名称',
  `productCreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '产品上架日期',
  PRIMARY KEY (`productId`),
  KEY `fk_product_categoryThree` (`categoryThreeId`),
  CONSTRAINT `fk_product_categoryThree` FOREIGN KEY (`categoryThreeId`) REFERENCES `categorythree` (`categorythreeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`productId`,`categoryThreeId`,`productName`,`productCreateDate`) values 
(175911065413095521,1,'【限时直降200】nubia/努比亚 z17s全面屏无边框四摄全网通智能官方旗舰手机','2018-07-08 22:05:12'),
(175911065413095522,1,'【特惠200 低至1299】nubia/努比亚 Z17minis四摄6+64g大内存手机','2018-07-08 22:23:03');

/*Table structure for table `productdetailimage` */

DROP TABLE IF EXISTS `productdetailimage`;

CREATE TABLE `productdetailimage` (
  `productDetailImageId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品详情图片编号',
  `productId` bigint(20) NOT NULL COMMENT '产品编号，外键',
  `productDetailImagePath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品详情图片路径',
  PRIMARY KEY (`productDetailImageId`),
  KEY `fk_productDetailImage_product` (`productId`),
  CONSTRAINT `fk_productDetailImage_product` FOREIGN KEY (`productId`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `productdetailimage` */

insert  into `productdetailimage`(`productDetailImageId`,`productId`,`productDetailImagePath`) values 
(1,175911065413095521,'/images/productDetailImage/175951229736849408.jpg'),
(2,175911065413095521,'/images/productDetailImage/175951229736849409.jpg'),
(3,175911065413095521,'/images/productDetailImage/175951229736849410.jpg'),
(4,175911065413095521,'/images/productDetailImage/175951229736849411.jpg'),
(5,175911065413095521,'/images/productDetailImage/175951229736849412.jpg'),
(6,175911065413095521,'/images/productDetailImage/175951229736849413.jpg'),
(7,175911065413095521,'/images/productDetailImage/175951229736849414.jpg'),
(8,175911065413095521,'/images/productDetailImage/175951229736849415.jpg'),
(9,175911065413095521,'/images/productDetailImage/175951229736849416.jpg'),
(10,175911065413095521,'/images/productDetailImage/175951229736849417.jpg'),
(11,175911065413095521,'/images/productDetailImage/175951229736849418.jpg'),
(12,175911065413095521,'/images/productDetailImage/175951229736849419.jpg'),
(13,175911065413095521,'/images/productDetailImage/175951229736849420.jpg'),
(14,175911065413095521,'/images/productDetailImage/175951229736849421.jpg'),
(15,175911065413095521,'/images/productDetailImage/175951229736849422.jpg'),
(16,175911065413095522,'/images/productDetailImage/175953195762323461.jpg'),
(17,175911065413095522,'/images/productDetailImage/175953195762323462.jpg'),
(18,175911065413095522,'/images/productDetailImage/175953195762323463.jpg'),
(19,175911065413095522,'/images/productDetailImage/175953195762323464.jpg'),
(20,175911065413095522,'/images/productDetailImage/175953195762323465.jpg'),
(21,175911065413095522,'/images/productDetailImage/175953195762323466.jpg'),
(22,175911065413095522,'/images/productDetailImage/175953195762323467.jpg'),
(23,175911065413095522,'/images/productDetailImage/175953195762323468.jpg'),
(24,175911065413095522,'/images/productDetailImage/175953195762323469.jpg'),
(25,175911065413095522,'/images/productDetailImage/175953195762323470.jpg'),
(26,175911065413095522,'/images/productDetailImage/175953195762323471.jpg'),
(27,175911065413095522,'/images/productDetailImage/175953195762323472.png'),
(28,175911065413095522,'/images/productDetailImage/175953195762323473.jpg'),
(29,175911065413095522,'/images/productDetailImage/175953195762323474.jpg');

/*Table structure for table `productimage` */

DROP TABLE IF EXISTS `productimage`;

CREATE TABLE `productimage` (
  `productImageId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品图片编号',
  `productId` bigint(20) NOT NULL COMMENT '产品编号，外键',
  `productImagePath` varchar(100) NOT NULL COMMENT '产品图片路径',
  PRIMARY KEY (`productImageId`),
  KEY `fk_productImage_proiduct` (`productId`),
  CONSTRAINT `fk_productImage_proiduct` FOREIGN KEY (`productId`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `productimage` */

insert  into `productimage`(`productImageId`,`productId`,`productImagePath`) values 
(1,175911065413095521,'/images/productImage/175949939988369499.jpg'),
(2,175911065413095521,'/images/productImage/175949939988369500.jpg'),
(3,175911065413095521,'/images/productImage/175949939988369501.jpg'),
(4,175911065413095521,'/images/productImage/175949939988369502.jpg'),
(5,175911065413095521,'/images/productImage/175949939988369503.jpg'),
(6,175911065413095522,'/images/productImage/175953195766517781.jpg'),
(7,175911065413095522,'/images/productImage/175953195766517782.jpg'),
(8,175911065413095522,'/images/productImage/175953195766517783.jpg'),
(9,175911065413095522,'/images/productImage/175953195766517784.jpg'),
(10,175911065413095522,'/images/productImage/175953195766517785.jpg');

/*Table structure for table `productproperty` */

DROP TABLE IF EXISTS `productproperty`;

CREATE TABLE `productproperty` (
  `productPropertyId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品属性编号',
  `categoryTwoId` int(11) NOT NULL COMMENT '二级菜单编号，外键',
  `productPropertyName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品属性名称',
  PRIMARY KEY (`productPropertyId`),
  KEY `fk_ProductProperty_CategoryTow` (`categoryTwoId`),
  CONSTRAINT `fk_ProductProperty_CategoryTow` FOREIGN KEY (`categoryTwoId`) REFERENCES `categorytwo` (`categorytwoid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `productproperty` */

insert  into `productproperty`(`productPropertyId`,`categoryTwoId`,`productPropertyName`) values 
(1,1,'证书编号'),
(2,1,'证书状态'),
(3,1,'产品名称'),
(4,1,'3C规格型号'),
(5,1,'CPU型号'),
(6,1,'型号'),
(7,1,'机身颜色'),
(8,1,'运行内存RAM'),
(9,1,'存储容量'),
(10,1,'网络模式');

/*Table structure for table `productpropertyvalue` */

DROP TABLE IF EXISTS `productpropertyvalue`;

CREATE TABLE `productpropertyvalue` (
  `productPropertyValueId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品属性值编号',
  `productPropertyId` bigint(20) NOT NULL COMMENT '产品属性编号,外键',
  `productId` bigint(20) NOT NULL COMMENT '产品编号，外键',
  `productPropertyValueName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品属性值名称',
  PRIMARY KEY (`productPropertyValueId`),
  KEY `fk_productPropertyValue_productProperty` (`productPropertyId`),
  KEY `fk_productPropertyValue_product` (`productId`),
  CONSTRAINT `fk_productPropertyValue_product` FOREIGN KEY (`productId`) REFERENCES `product` (`productid`),
  CONSTRAINT `fk_productPropertyValue_productProperty` FOREIGN KEY (`productPropertyId`) REFERENCES `productproperty` (`productPropertyId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `productpropertyvalue` */

insert  into `productpropertyvalue`(`productPropertyValueId`,`productPropertyId`,`productId`,`productPropertyValueName`) values 
(1,1,175911065413095521,'2017011606991560'),
(2,2,175911065413095521,'有效'),
(3,3,175911065413095521,'TD-LTE数字移动电话机'),
(4,4,175911065413095521,'NX595J（电源适配器：NB-A550A USBA-1 输出：5V 5.2A）'),
(5,3,175911065413095521,'nubia/努比亚 z17s'),
(7,5,175911065413095521,'骁龙835'),
(8,6,175911065413095521,'z17s'),
(9,7,175911065413095521,'黑金'),
(10,8,175911065413095521,'6G'),
(11,9,175911065413095521,'64GB'),
(14,10,175911065413095521,'双卡双待'),
(15,1,175911065413095522,'2017011606995091'),
(17,2,175911065413095522,'有效'),
(18,3,175911065413095522,'TD-LTE数字移动电话机'),
(19,4,175911065413095522,'NX589J（电源适配器：NB-A520A USBA-1 输出：5.0VDC 2000mA）'),
(20,3,175911065413095522,'nubia/努比亚 Z17minis'),
(21,5,175911065413095522,'MSM8976 Pro'),
(22,6,175911065413095522,'Z17minis'),
(23,7,175911065413095522,'黑金 深海蓝 爱琴海蓝'),
(24,8,175911065413095522,'6GB'),
(25,9,175911065413095522,'64GB'),
(26,10,175911065413095522,'双卡双待');

/*Table structure for table `producttype` */

DROP TABLE IF EXISTS `producttype`;

CREATE TABLE `producttype` (
  `productTypeId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品类型编号',
  `productId` bigint(20) NOT NULL COMMENT '产品编号，外键',
  `productTypeName` varchar(50) NOT NULL COMMENT '产品类型名称',
  `price` float NOT NULL COMMENT '价格',
  `salePrice` float NOT NULL COMMENT '优惠价格',
  `restQuantity` int(11) NOT NULL COMMENT '剩余数量',
  `productTypeImagePath` varchar(100) NOT NULL COMMENT '产品类型图片路径',
  `productTypeCreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
  PRIMARY KEY (`productTypeId`),
  KEY `fk_productType_product` (`productId`),
  CONSTRAINT `fk_productType_product` FOREIGN KEY (`productId`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `producttype` */

insert  into `producttype`(`productTypeId`,`productId`,`productTypeName`,`price`,`salePrice`,`restQuantity`,`productTypeImagePath`,`productTypeCreateDate`) values 
(1,175911065413095521,'Z17S黑金',2999,2699,330,'/images/productDetailImage/175970777135452231.jpg','2018-07-08 23:21:40'),
(2,175911065413095522,'Z17minis黑金',1499,1299,33,'/images/productDetailImage/175970777135452232.jpg','2018-07-08 23:26:33'),
(3,175911065413095522,'Z17minis深海蓝',1499,1299,19,'/images/productDetailImage/175970777135452233.jpg','2018-07-08 23:27:25');

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `reviewId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号，外键',
  `orderItemId` bigint(20) DEFAULT NULL COMMENT '订单项编号，外键',
  `content` varchar(100) NOT NULL COMMENT '评论内容',
  `reviewCreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论日期',
  PRIMARY KEY (`reviewId`),
  KEY `fk_review_user` (`userId`),
  KEY `fk_review_orderItem` (`orderItemId`),
  CONSTRAINT `fk_review_orderItem` FOREIGN KEY (`orderItemId`) REFERENCES `orderitem` (`orderitemid`),
  CONSTRAINT `fk_review_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `review` */

insert  into `review`(`reviewId`,`userId`,`orderItemId`,`content`,`reviewCreateDate`) values 
(2,1,1,'很漂亮的手机','2018-07-08 23:39:42'),
(3,1,2,'this is the phone of pretty cool','2018-07-08 23:40:53');

/*Table structure for table `shoppingcart` */

DROP TABLE IF EXISTS `shoppingcart`;

CREATE TABLE `shoppingcart` (
  `shoppingCartId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `productTypeId` bigint(20) NOT NULL COMMENT '产品类型编号，外键',
  `userId` bigint(20) NOT NULL COMMENT '用户编号，外键',
  `quantity` int(11) NOT NULL COMMENT '数量',
  `shoppingCartCreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`shoppingCartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shoppingcart` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `userPwd` varchar(50) NOT NULL COMMENT '用户密码',
  `role` int(11) NOT NULL COMMENT '用户角色',
  `userCreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `index_user_userName_unique` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`userPwd`,`role`,`userCreateDate`) values 
(1,'BetaCat','123',0,'2018-07-08 21:41:31'),
(2,'ThatYears','32123',1,'2018-07-09 21:54:15');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
