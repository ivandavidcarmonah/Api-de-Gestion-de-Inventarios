CREATE DATABASE  IF NOT EXISTS `desa_daviddev` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `desa_daviddev`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: desa_daviddev
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bar_tables`
--

DROP TABLE IF EXISTS `bar_tables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bar_tables` (
  `id_bar_table` bigint NOT NULL AUTO_INCREMENT,
  `codeqr` varchar(255) NOT NULL,
  `crea_date` date NOT NULL,
  `crea_user` bigint NOT NULL,
  `mod_date` date DEFAULT NULL,
  `mod_user` bigint DEFAULT NULL,
  `num_table` bigint NOT NULL,
  `place` varchar(255) NOT NULL,
  `id_company` bigint DEFAULT NULL,
  PRIMARY KEY (`id_bar_table`),
  KEY `FKqau3vih28wxr9umhh2eyqhmwi` (`id_company`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bar_tables`
--

LOCK TABLES `bar_tables` WRITE;
/*!40000 ALTER TABLE `bar_tables` DISABLE KEYS */;
/*!40000 ALTER TABLE `bar_tables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coments_publication`
--

DROP TABLE IF EXISTS `coments_publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coments_publication` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `body` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `publication_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoq0vv8nea252infxe093lkidj` (`publication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coments_publication`
--

LOCK TABLES `coments_publication` WRITE;
/*!40000 ALTER TABLE `coments_publication` DISABLE KEYS */;
/*!40000 ALTER TABLE `coments_publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id_company` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cif` varchar(255) DEFAULT NULL,
  `crea_date` date DEFAULT NULL,
  `license_date` date DEFAULT NULL,
  `mail_company` varchar(255) DEFAULT NULL,
  `mail_owner` varchar(255) DEFAULT NULL,
  `mod_date` date DEFAULT NULL,
  `mod_user` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `name_owner` varchar(255) DEFAULT NULL,
  `other_data` varchar(255) DEFAULT NULL,
  `phone_company` varchar(255) DEFAULT NULL,
  `phone_owner` varchar(255) DEFAULT NULL,
  `picture_logo` varchar(255) DEFAULT NULL,
  `schedule` varchar(255) DEFAULT NULL,
  `id_type_license` bigint DEFAULT NULL,
  PRIMARY KEY (`id_company`),
  KEY `FK360nf06t5lb6nk4x8t3of70oo` (`id_type_license`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(60) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKjdyxf8c9k9656frmqjb67cgo3` (`name`),
  UNIQUE KEY `UKmxvfcsf1euhi5hsw1uecvke7b` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'FEMALE','Female'),(2,'MALE','Male'),(3,'OTHER','Other');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(60) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKg8hr207ijpxlwu10pewyo65gv` (`name`),
  UNIQUE KEY `UK5h2eb4yggd9jjo1x9kd594t02` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'ESP','Espanol'),(2,'CATALAN','Catalan'),(3,'EUSKERA','Euskera');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id_product` bigint NOT NULL AUTO_INCREMENT,
  `allergies` varchar(255) DEFAULT NULL,
  `crea_date` date DEFAULT NULL,
  `crea_user` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_spent` bit(1) NOT NULL,
  `is_valid` bit(1) NOT NULL,
  `mod_date` date DEFAULT NULL,
  `mod_user` bigint DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `preparesin` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `id_company` bigint DEFAULT NULL,
  `id_types_products` bigint DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  KEY `FKfnnww0qeerpruunjakntgnn4p` (`id_company`),
  KEY `FKt2qbe0gp8fnpugruwll45mmj` (`id_types_products`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKnrkcidigvkemps7kkfn25nvg1` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication`
--

LOCK TABLES `publication` WRITE;
/*!40000 ALTER TABLE `publication` DISABLE KEYS */;
/*!40000 ALTER TABLE `publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_EMPLEADO'),(3,'ROLE_SUPER_ROOT'),(4,'ROLE_EDITOR'),(5,'ROLE_VISITANTE');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types_license`
--

DROP TABLE IF EXISTS `types_license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types_license` (
  `id_type_license` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type_license`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types_license`
--

LOCK TABLES `types_license` WRITE;
/*!40000 ALTER TABLE `types_license` DISABLE KEYS */;
/*!40000 ALTER TABLE `types_license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types_products`
--

DROP TABLE IF EXISTS `types_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types_products` (
  `id_types_products` bigint NOT NULL AUTO_INCREMENT,
  `crea_date` date DEFAULT NULL,
  `crea_user` bigint DEFAULT NULL,
  `mod_date` date DEFAULT NULL,
  `mod_user` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_company` bigint DEFAULT NULL,
  PRIMARY KEY (`id_types_products`),
  KEY `FKfuws03wc0634qjbdldyxh95bi` (`id_company`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types_products`
--

LOCK TABLES `types_products` WRITE;
/*!40000 ALTER TABLE `types_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `types_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `deleted_by` varchar(255) DEFAULT NULL,
  `deleted_date` timestamp NULL DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `number_phone` bigint DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `picture_user` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `gender_id` bigint DEFAULT NULL,
  `language_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  KEY `FKld9x6vyo1xd6shjgkojm0fqmt` (`language_id`),
  KEY `FKo0h29eo9e4y4wvd5yh0sn03rp` (`gender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ROOT','2022-04-25 20:58:07',NULL,NULL,NULL,'ROOT','2022-04-25 20:58:07','1994-02-02','admin@mail.com','Admin Root',688739755,'$2a$10$sajlsoQF6JMCedzI1jRzGOqImu.XBfkzUgZkP6Kr5VpTLoneD9Elq',NULL,'admin',1,1),(2,'ROOT','2022-04-25 20:58:07',NULL,NULL,NULL,'ROOT','2022-04-25 20:58:07','1994-02-02','ivan.d-carmona@otra-ronda.com','Ivan David',688739755,'$2a$10$sajlsoQF6JMCedzI1jRzGOqImu.XBfkzUgZkP6Kr5VpTLoneD9Elq',NULL,'ivancarmona',1,1),(3,'ROOT','2022-04-25 20:58:07',NULL,NULL,NULL,'ROOT','2022-04-25 20:58:07','1994-02-02','ivandavidscarmonah@otraronda.com','Ivan David',688739755,'$2a$10$noJ6WZYa.kRAm49F8Ocp9.uD9c89FHBMweeqhqz2m00bVmL7iMNiC',NULL,'ivan.carmona',1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_roles`
--

DROP TABLE IF EXISTS `usuarios_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_roles` (
  `usuario_id` bigint NOT NULL AUTO_INCREMENT,
  `rol_id` bigint NOT NULL,
  PRIMARY KEY (`usuario_id`,`rol_id`),
  KEY `FK5338ehgluufgc8bpj08nrq970` (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_roles`
--
LOCK TABLES `usuarios_roles` WRITE;
/*!40000 ALTER TABLE `usuarios_roles` DISABLE KEYS */;
INSERT INTO `usuarios_roles` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `usuarios_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-08 13:13:40
