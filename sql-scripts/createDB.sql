CREATE DATABASE  IF NOT EXISTS `uac_db1`;
USE `uac_db1`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `privilege` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `seats`;
CREATE TABLE `seats` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cse` int DEFAULT NULL,
  `it` int DEFAULT NULL,
  `ece` int DEFAULT NULL,
  `me` int DEFAULT NULL,
  `ce` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `seats` VALUES 
	(1,'Amity School of Engineering & Technology',50,50,50,50,50),
	(2,'Blueird Institute of Engineering',40,45,50,60,50),
	(3,'Charles School of Special Students',25,30,40,40,50),
	(4,'Daisytales College of Technology',20,20,30,25,35),
	(5,'Excellence Technological Institute',40,50,65,45,55);



DROP TABLE IF EXISTS `cutoff`;
CREATE TABLE `cutoff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cse` int DEFAULT NULL,
  `it` int DEFAULT NULL,
  `ece` int DEFAULT NULL,
  `me` int DEFAULT NULL,
  `ce` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `cutoff` VALUES 
	(1,'Amity School of Engineering & Technology',2000,3000,4000,5000,8000),
	(2,'Blueird Institute of Engineering',1000,2000,2500,4000,5000),
	(3,'Charles School of Special Students',3500,5500,6000,7500,8000),
	(4,'Daisytales College of Technology',1200,1800,2800,4000,9000),
	(5,'Excellence Technological Institute',4000,6000,7000,8000,9500);