CREATE DATABASE  IF NOT EXISTS `ltadcrm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ltadcrm`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ltadcrm
-- ------------------------------------------------------
-- Server version	8.0.39
-- Dump completed on 2024-11-18 14:13:58


DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `account_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `account` VALUES (1,'erik','$2a$10$mjmojsrZbVQxo/2bANGXFOwHfCveT8scWL0PJZ8xoExeKYgU5fw9a',0),(2,'Carol@ltad','$2a$10$wplc0bjJTlZuVV.8Ozt.DuXrXT54iG4VUuGCAfvCUL0uS0Yhg9euu',0),(3,'Caroll@ltad','$2a$10$qqrFAcPXNLinsr6vChfAfequUNBW9ciXuSX19TZZSP7bRjEiUY0Lm',0),(4,'Caroll','$2a$10$NrkVf86tn4DYl8SyPyjJYuf2Sc/Qgzp9ltqDZVJneyc9BkSnbYqPq',0),(5,'matheus@heitor','$2a$10$jmTrUv5gDMmv7UKcFrY6meSkVljpS0F8Fao8qMrgphSaOS541vC7S',0);


DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `id_users` bigint NOT NULL AUTO_INCREMENT,
  `last_modify` varchar(255) DEFAULT NULL,
  `name_users` varchar(255) DEFAULT NULL,
  `type_users` varchar(255) DEFAULT NULL,
  `update_in` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_users`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `tb_users` VALUES (1,NULL,'Erik','Estagiario','2024-11-14 14:06:15.395663'),(2,NULL,'testeasd','professorasdsa','2024-11-18 13:57:08.725780');


DROP TABLE IF EXISTS `audit_log`;
CREATE TABLE `audit_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_item` bigint DEFAULT NULL,
  `name_item_old` varchar(255) DEFAULT NULL,
  `name_item_new` varchar(255) DEFAULT NULL,
  `email_user` varchar(255) DEFAULT NULL,
  `create_in` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_in` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type_action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `audit_log` VALUES (1,18,'PAINEL DE CONTROLE','PAINEL DE CONTROLEsdasd','email@teste','2024-11-14 18:05:39','2024-11-14 18:05:39','UPDATE'),(2,18,'PAINEL DE CONTROLEsdasd','NOTBOOK','email@teste','2024-11-14 18:08:58','2024-11-14 18:08:58','UPDATE'),(3,18,'NOTBOOK','CPU','email@teste','2024-11-14 18:10:18','2024-11-14 18:10:18','UPDATE'),(4,17,'CPU','TESTE','email@teste','2024-11-14 18:10:25','2024-11-14 18:10:25','UPDATE'),(5,18,'CPU','CPUl','email@teste','2024-11-14 18:35:14','2024-11-14 18:35:14','UPDATE'),(6,17,'TESTE','TESTEl','email@teste','2024-11-14 18:35:18','2024-11-14 18:35:18','UPDATE'),(7,17,'TESTEl','asdasd','email@teste','2024-11-14 19:00:38','2024-11-14 19:00:38','UPDATE'),(8,17,'asdasd','cpu','email@teste','2024-11-14 19:03:12','2024-11-14 19:03:12','UPDATE'),(9,17,'cpu','cpuasdas','email@teste','2024-11-18 16:58:24','2024-11-18 16:58:24','UPDATE');


DROP TABLE IF EXISTS `tb_contact`;
CREATE TABLE `tb_contact` (
  `id_contact` bigint NOT NULL AUTO_INCREMENT,
  `email_contact` varchar(255) DEFAULT NULL,
  `last_modify` varchar(255) DEFAULT NULL,
  `occupation_contact` varchar(255) DEFAULT NULL,
  `phone_contact` varchar(255) DEFAULT NULL,
  `update_in` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_contact`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `tb_contact` VALUES (1,'joao.silva@example.com',NULL,'Analista de TI','11987654321',NULL),(2,'maria.oliveira@example.com',NULL,'Assistente de RH','21987654322',NULL),(3,'carlos.souza@example.com',NULL,'Gerente Financeiro','31987654323',NULL),(4,'joao.silva@example.com',NULL,'Analista de TI','11987654321',NULL),(5,'maria.oliveira@example.com',NULL,'Assistente de RH','21987654322',NULL),(6,'carlos.souza@example.com',NULL,'Gerente Financeiro','31987654323',NULL),(7,'joao.silva@example.com',NULL,'Analista de TI','11987654321',NULL),(8,'maria.oliveira@example.com',NULL,'Assistente de RH','21987654322',NULL),(9,'carlos.souza@example.com',NULL,'Gerente Financeiro','31987654323',NULL);


DROP TABLE IF EXISTS `tb_cost_center`;
CREATE TABLE `tb_cost_center` (
  `id_cost_center` bigint NOT NULL AUTO_INCREMENT,
  `end_date_cost_center` date DEFAULT NULL,
  `identification_cost_center` varchar(255) DEFAULT NULL,
  `initial_date_cost_center` date DEFAULT NULL,
  `name_cost_center` varchar(255) DEFAULT NULL,
  `last_modify` varchar(255) DEFAULT NULL,
  `update_in` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_cost_center`)
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `tb_cost_center` VALUES (1,'2025-12-27','CC001','2019-12-28','TI - Suport',NULL,'2024-11-14 10:17:31.292740'),(2,'2025-11-29','CC002','2021-04-30','RH - Recrutamentods',NULL,'2024-11-18 14:07:33.240880'),(3,'2025-12-07','CC001','2019-12-08','Tsdsa',NULL,'2024-11-14 15:35:14.760035'),(4,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(5,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(6,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(7,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(8,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(9,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(10,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(11,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(12,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(13,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(14,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(15,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(16,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(17,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(18,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(19,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(20,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(21,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(22,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(23,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(24,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(25,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(26,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(27,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(28,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(29,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(30,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(31,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(32,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(33,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(34,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(35,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(36,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(37,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(38,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(39,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(40,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(41,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(42,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(43,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(44,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(45,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(46,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(47,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(48,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(49,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(50,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(51,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(52,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(53,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(54,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(55,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(56,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(57,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(58,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(59,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(60,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(61,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(62,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(63,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(64,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(65,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(66,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(67,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(68,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(69,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(70,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(71,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(72,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(73,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(74,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(75,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(76,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(77,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(78,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(79,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(80,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(81,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(82,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(83,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(84,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(85,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(86,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(87,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(88,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(89,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(90,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(91,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(92,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(93,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(94,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(95,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(96,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(97,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(98,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(99,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(100,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(101,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(102,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(103,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(104,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(105,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(106,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(107,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(108,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(109,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(110,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(111,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(112,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(113,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(114,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(115,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(116,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(117,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(118,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(119,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(120,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(121,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(122,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(123,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(124,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(125,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(126,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(127,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(128,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(129,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(130,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(131,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(132,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(133,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(134,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(135,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(136,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(137,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(138,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(139,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(140,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(141,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(142,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(143,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(144,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(145,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(146,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(147,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(148,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(149,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(150,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(151,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(152,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(153,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(154,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(155,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(156,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(157,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(158,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(159,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(160,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(161,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(162,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(163,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL),(164,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(165,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(166,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(167,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(168,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(169,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(170,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(171,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(172,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(173,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(174,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(175,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(176,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(177,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(178,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(179,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(180,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(181,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(182,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(183,'2025-12-31','CC001','2020-01-01','TI - Suporte',NULL,NULL),(184,'2025-12-31','CC002','2021-06-01','RH - Recrutamento',NULL,NULL),(185,'2025-12-31','CC003','2022-02-01','Financeiro - Contabilidade',NULL,NULL);


DROP TABLE IF EXISTS `tb_description`;
CREATE TABLE `tb_description` (
  `id_description` bigint NOT NULL AUTO_INCREMENT,
  `brand_description` varchar(255) DEFAULT NULL,
  `description_description` varchar(255) DEFAULT NULL,
  `last_modify` varchar(255) DEFAULT NULL,
  `local_description` varchar(255) DEFAULT NULL,
  `model_description` varchar(255) DEFAULT NULL,
  `serie_description` varchar(255) DEFAULT NULL,
  `update_in` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_description`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `tb_description` VALUES (1,'Dell','Notebook Dell Inspiron',NULL,'Escritório','Inspiron 5000','SN123456',NULL),
(2,'HP','Desktop HP Elite',NULL,'Fábrica','lll','SN987654','2024-11-18 14:07:33.229880'),
(3,'Apple','MacBook Prof',NULL,'Home Office','ll','SN111222','2024-11-14 15:32:12.027135'),
(4,'Dell','Notebook Dell Inspiron',NULL,'Escritório','Inspiron 5000','SN123456',NULL),
(5,'HP','Desktop HP Elite',NULL,'Fábrica','HP ProDesk 400','SN987654',NULL),
(6,'Apple','MacBook Pro',NULL,'Home Office','MacBook 2020','SN111222',NULL),
(7,'Dell','Notebook Dell Inspiron',NULL,'Escritório','Inspiron 5000','SN123456',NULL),
(8,'HP','Desktop HP Elite',NULL,'Fábrica','HP ProDesk 400','SN987654',NULL),
(9,'Apple','MacBook Pro',NULL,'Home Office','MacBook 2020','SN111222',NULL);


DROP TABLE IF EXISTS `tb_items`;
CREATE TABLE `tb_items` (
  `id_items` bigint NOT NULL AUTO_INCREMENT,
  `last_modify` varchar(255) DEFAULT NULL,
  `nf_invoice_item` varchar(255) DEFAULT NULL,
  `code_item` varchar(255) DEFAULT NULL,
  `observation_item` varchar(255) DEFAULT NULL,
  `order_origin_item` varchar(255) DEFAULT NULL,
  `path_image_item` varchar(255) DEFAULT NULL,
  `sde_item` bigint DEFAULT NULL,
  `status_item` varchar(255) DEFAULT NULL,
  `update_in` datetime(6) DEFAULT NULL,
  `value_item` double DEFAULT NULL,
  `id_cost_center` bigint DEFAULT NULL,
  `id_description` bigint DEFAULT NULL,
  `id_users` bigint DEFAULT NULL,
  PRIMARY KEY (`id_items`),
  KEY `FKom8si4n7bdprwnevv1ke2xov2` (`id_cost_center`),
  KEY `FKjs91yr38i1cdej2lbboc4g0rj` (`id_description`),
  KEY `FKj2k19khybjpypv2wme3et5gdp` (`id_users`),
  CONSTRAINT `FKj2k19khybjpypv2wme3et5gdp` FOREIGN KEY (`id_users`) REFERENCES `tb_users` (`id_users`),
  CONSTRAINT `FKjs91yr38i1cdej2lbboc4g0rj` FOREIGN KEY (`id_description`) REFERENCES `tb_description` (`id_description`),
  CONSTRAINT `FKom8si4n7bdprwnevv1ke2xov2` FOREIGN KEY (`id_cost_center`) REFERENCES `tb_cost_center` (`id_cost_center`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `tb_items` VALUES (16,NULL,'NF12345','ITEM001','Notebook Dell Inspiron','Pedido001','/images/items/item001.jpg',10,'Ativo',NULL,2500.5,1,1,1),
(17,NULL,'NF12346','ITEM001','cpuasdas','Pedido002','/images/items/item002.jpg',5,'Inativo','2024-11-18 13:58:24.492959',3000,2,2,2),
(18,NULL,'NF12347','ITEM003','CPUl','Pedido003','/images/items/item003.jpg',8,'Ativo','2024-11-14 15:35:14.735991',8000,3,3,1);

-- --> Tools routines
-- --> Procedures()
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllItems`()
BEGIN
SELECT 
    u.id_users AS id_usuario,
    u.name_users AS nome_usuario,
    u.type_users AS tipo_usuario,

    i.id_items AS id_item,
    i.nf_invoice_item AS nf_invoice_item,
    i.code_item AS codigo_item,
    i.observation_item AS observacao_item,
    i.path_image_item AS caminho_imagem_item,
    i.order_origin_item AS pedido_origem,
    i.sde_item AS sde_item,
    i.status_item AS status_item,
    i.value_item AS valor_item,
    i.last_modify AS lastModify,
    i.update_in AS updateIn,

    d.id_description AS id_descricao,
    d.brand_description AS marca_descricao,
    d.description_description AS descricao_item,
    d.local_description AS localizacao_descricao,
    d.model_description AS modelo_descricao,
    d.serie_description AS serie_descricao,

    c.id_cost_center AS id_centro_custo,
    c.end_date_cost_center AS data_fim_centro_custo,
    c.identification_cost_center AS identificacao_centro_custo,
    c.initial_date_cost_center AS data_inicio_centro_custo,
    c.name_cost_center AS nome_centro_custo,

    co.id_contact AS id_contato,
    co.email_contact AS email_contato,
    co.occupation_contact AS ocupacao_contato,
    co.phone_contact AS telefone_contato

FROM 
    tb_items i
JOIN 
    tb_users u ON i.id_users = u.id_users
JOIN 
    tb_description d ON i.id_description = d.id_description
JOIN 
    tb_cost_center c ON i.id_cost_center = c.id_cost_center
JOIN 
    tb_contact co ON co.id_contact = i.id_users;

END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertDemoValues`()
BEGIN

INSERT INTO `tb_cost_center` (`end_date_cost_center`, `identification_cost_center`, `initial_date_cost_center`, `name_cost_center`) 
VALUES
    ('2025-12-31', 'CC001', '2020-01-01', 'TI - Suporte'),
    ('2025-12-31', 'CC002', '2021-06-01', 'RH - Recrutamento'),
    ('2025-12-31', 'CC003', '2022-02-01', 'Financeiro - Contabilidade');

INSERT INTO `tb_contact` (`email_contact`, `occupation_contact`, `phone_contact`) 
VALUES
    ('joao.silva@example.com', 'Analista de TI', '11987654321'),
    ('maria.oliveira@example.com', 'Assistente de RH', '21987654322'),
    ('carlos.souza@example.com', 'Gerente Financeiro', '31987654323');
INSERT INTO `tb_description` (`brand_description`, `description_description`, `local_description`, `model_description`, `serie_description`) 
VALUES
    ('Dell', 'Notebook Dell Inspiron', 'Escritório', 'Inspiron 5000', 'SN123456'),
    ('HP', 'Desktop HP Elite', 'Fábrica', 'HP ProDesk 400', 'SN987654'),
    ('Apple', 'MacBook Pro', 'Home Office', 'MacBook 2020', 'SN111222');
INSERT INTO `tb_items` 
(`nf_invoice_item`, `code_item`, `observation_item`, `path_image_item`, `order_origin_item`, `sde_item`, `status_item`, `value_item`, `id_cost_center`, `id_description`, `id_users`) 
VALUES
    ('NF12345', 'ITEM001', 'Notebook Dell Inspiron', '/images/items/item001.jpg', 'Pedido001', 10, 'Ativo', 2500.50, 1, 1, 1),  -- Item relacionado ao usuário 'João Silva'
    ('NF12346', 'ITEM002', 'Desktop HP Elite', '/images/items/item002.jpg', 'Pedido002', 5, 'Inativo', 3000.00, 2, 2, 2),  -- Item relacionado ao usuário 'Maria Oliveira'
    ('NF12347', 'ITEM003', 'MacBook Pro', '/images/items/item003.jpg', 'Pedido003', 8, 'Ativo', 8000.00, 3, 3, 3);  -- Item relacionado ao usuário 'Carlos Souza'
END ;;
DELIMITER ;

-- --> Triggers()

