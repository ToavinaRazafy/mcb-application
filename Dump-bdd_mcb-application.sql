-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mcb
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `business_activity`
--

DROP TABLE IF EXISTS `business_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `business_activity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business_activity`
--

LOCK TABLES `business_activity` WRITE;
/*!40000 ALTER TABLE `business_activity` DISABLE KEYS */;
INSERT INTO `business_activity` VALUES (1,'Banking'),(2,'Fishing'),(3,'Manufacturing');
/*!40000 ALTER TABLE `business_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Madagascar'),(2,'Mauritus'),(3,'France');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `purpose_id` int DEFAULT NULL,
  `company_name` varchar(250) DEFAULT NULL,
  `type_entity_id` int DEFAULT NULL,
  `business_id` int DEFAULT NULL,
  `system_banking` text,
  `country_id` int DEFAULT NULL,
  `registration_number` varchar(250) DEFAULT NULL,
  `date_incorporation` timestamp NULL DEFAULT NULL,
  `director_name` varchar(250) DEFAULT NULL,
  `passport_number` varchar(250) DEFAULT NULL,
  `designated_name` varchar(250) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `customer_business_activity_id_fk` (`business_id`),
  KEY `customer_country_id_fk` (`country_id`),
  KEY `customer_purpose_id_fk` (`purpose_id`),
  KEY `customer_status_id_fk` (`status_id`),
  KEY `customer_type_entity_id_fk` (`type_entity_id`),
  CONSTRAINT `customer_business_activity_id_fk` FOREIGN KEY (`business_id`) REFERENCES `business_activity` (`id`),
  CONSTRAINT `customer_country_id_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `customer_purpose_id_fk` FOREIGN KEY (`purpose_id`) REFERENCES `purpose` (`id`),
  CONSTRAINT `customer_status_id_fk` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `customer_type_entity_id_fk` FOREIGN KEY (`type_entity_id`) REFERENCES `type_entity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,1,'company',1,1,NULL,1,'MCB0001','2024-07-02 17:49:36','director','passport','designated','email@gmail.com',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_file`
--

DROP TABLE IF EXISTS `customer_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_file` (
  `file_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint DEFAULT NULL,
  `file_name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_file`
--

LOCK TABLES `customer_file` WRITE;
/*!40000 ALTER TABLE `customer_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dashboard_vue`
--

DROP TABLE IF EXISTS `dashboard_vue`;
/*!50001 DROP VIEW IF EXISTS `dashboard_vue`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `dashboard_vue` AS SELECT 
 1 AS `customer_id`,
 1 AS `company_name`,
 1 AS `type_entity`,
 1 AS `business_activity`,
 1 AS `country`,
 1 AS `registration_number`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `purpose`
--

DROP TABLE IF EXISTS `purpose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purpose` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purpose`
--

LOCK TABLES `purpose` WRITE;
/*!40000 ALTER TABLE `purpose` DISABLE KEYS */;
INSERT INTO `purpose` VALUES (1,'Investment portfolio'),(2,'Account to operate locally'),(3,'Account to operate overseas'),(4,'Energy & commodiƟes financing');
/*!40000 ALTER TABLE `purpose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Open');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_entity`
--

DROP TABLE IF EXISTS `type_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_entity`
--

LOCK TABLES `type_entity` WRITE;
/*!40000 ALTER TABLE `type_entity` DISABLE KEYS */;
INSERT INTO `type_entity` VALUES (1,'Trust'),(2,'Associaton'),(3,'Private Company');
/*!40000 ALTER TABLE `type_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'toavina','$2a$10$KO/vK.1/q0.oOypFG1xa2eqRcqwL7vutmVmZXpK9IH6k1Pa5uQrZ6','ROLE_CUSTOMER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `dashboard_vue`
--

/*!50001 DROP VIEW IF EXISTS `dashboard_vue`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dashboard_vue` AS select `c`.`customer_id` AS `customer_id`,`c`.`company_name` AS `company_name`,`te`.`designation` AS `type_entity`,`ba`.`designation` AS `business_activity`,`c2`.`designation` AS `country`,`c`.`registration_number` AS `registration_number`,`s`.`designation` AS `status` from ((((`customer` `c` join `type_entity` `te` on((`c`.`type_entity_id` = `te`.`id`))) join `business_activity` `ba` on((`ba`.`id` = `c`.`business_id`))) join `country` `c2` on((`c`.`country_id` = `c2`.`id`))) join `status` `s` on((`c`.`status_id` = `s`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-03 16:50:02
