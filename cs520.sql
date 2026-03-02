-- MySQL dump 10.13  Distrib 9.0.1, for macos14.7 (arm64)
--
-- Host: localhost    Database: cs520_project
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `tb_answer`
--

DROP TABLE IF EXISTS `tb_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT 'author',
  `question_analysis` varchar(2480) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` tinyint(1) NOT NULL COMMENT 'Question type 1 single choice 2 multiple choice 3 fill in the blank 4 text 5 drop down 6 cascade 7 scoring 8 upload',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL COMMENT 'question mode 1questionnaire 2quiz',
  `possible_answers` varchar(2550) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `correct_answers` varchar(2550) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_answer`
--

LOCK TABLES `tb_answer` WRITE;
/*!40000 ALTER TABLE `tb_answer` DISABLE KEYS */;
INSERT INTO `tb_answer` VALUES (1,1,NULL,1,0,1,'[\"yes\", \"no\", \"not sure\"]',NULL,'2024-11-16 09:37:33',NULL),(2,1,'The choice b is wrong because something is wrong.',2,0,2,'[\"a\", \"b\", \"c\", \"d\"]','[\"a\", \"c\", \"d\"]','2024-11-16 09:40:54',NULL),(3,1,'According to question, we know Lisa is at least 2m.',3,0,2,NULL,'[\"200\"]','2024-11-16 10:56:42',NULL),(4,1,NULL,5,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]',NULL,'2024-11-16 11:01:51',NULL),(5,1,NULL,1,0,2,'[&quot;&lt;p&gt;333&lt;br /&gt;555&lt;br /&gt;66&lt;br /&gt;&lt;img src=\'0f980d1c4cc50fc37c59a8c1d1f1a97f.jpg\'alt=\'2622c8bc87c5130202f7267d091c47c2733e2b8a5b1834SNvF6_fw1200.jpg\' /&gt;&lt;/p&gt;&quot;, &quot;&lt;p&gt;444&lt;br /&gt;555&lt;br /&gt;66&lt;br /&gt;&lt;img src=\'0f980d1c4cc50fc37c59a8c1d1f1a97f.jpg\'alt=\'2622c8bc87c5130202f7267d091c47c2733e2b8a5b1834SNvF6_fw1200.jpg\' /&gt;&lt;/p&gt;&quot;]','[&quot;&lt;p&gt;333&lt;br /&gt;555&lt;br /&gt;66&lt;br /&gt;&lt;img src=\'0f980d1c4cc50fc37c59a8c1d1f1a97f.jpg\'alt=\'2622c8bc87c5130202f7267d091c47c2733e2b8a5b1834SNvF6_fw1200.jpg\' /&gt;&lt;/p&gt;&quot;]','2024-11-17 11:23:38','2024-11-17 16:18:12'),(6,1,NULL,1,0,1,'[\"within a week\", \"1 to 2 weeks\", \"2 weeks to a month\", \"a month to half a year\", \"more than half a year\"]',NULL,'2024-11-18 09:22:59',NULL),(82,1,'',8,0,1,'null','[&quot;af111a7201d0374012130b99f0b7478a.docx&quot;]','2024-11-18 14:22:56','2024-11-18 16:14:27'),(94,1,'Reason for this is that...',1,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice1&quot;]','2024-11-18 16:11:16','2024-11-19 10:12:56'),(95,1,'',2,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice1&quot;]','2024-11-18 16:11:19','2024-11-18 17:35:25'),(96,1,'',1,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice1&quot;]','2024-11-18 16:11:19','2024-11-18 17:35:03'),(97,1,'',2,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice1&quot;]','2024-11-18 16:11:25','2024-11-18 17:35:31'),(98,1,'',3,0,1,NULL,'[&quot;correct answer&quot;]','2024-11-18 16:11:25','2024-11-18 17:35:46'),(99,1,'',8,0,1,NULL,'[&quot;af111a7201d0374012130b99f0b7478a.docx&quot;]','2024-11-18 16:11:27','2024-11-18 17:36:20'),(100,1,'',3,0,1,NULL,'[&quot;correct answer.&quot;]','2024-11-18 16:11:27','2024-11-18 17:36:29'),(101,1,'',3,0,1,NULL,'[&quot;correct answer..&quot;]','2024-11-18 16:11:28','2024-11-18 17:36:34'),(102,1,'',4,0,1,NULL,'[&quot;correct answer...&quot;]','2024-11-18 16:11:28','2024-11-18 17:06:49'),(103,1,'',4,0,1,NULL,'[&quot;correct answer....&quot;]','2024-11-18 16:11:44','2024-11-18 17:36:46'),(104,1,'',7,0,1,NULL,'[&quot;&quot;]','2024-11-18 16:11:44',NULL),(105,1,'',2,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice2&quot;]','2024-11-18 16:19:17','2024-11-18 17:36:51'),(107,1,'',4,0,1,NULL,'[&quot;answer&quot;]','2024-11-18 16:31:09','2024-11-19 13:58:14'),(112,1,'',5,0,2,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice1&quot;]','2024-11-18 17:07:21','2024-11-18 17:37:00'),(113,1,'',5,0,2,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice2&quot;]','2024-11-18 17:11:28','2024-11-18 17:37:04'),(115,1,'',1,0,2,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;choice1&quot;]','2024-11-19 15:18:15','2024-11-19 15:40:36'),(116,1,'',8,0,2,NULL,'[&quot;&quot;]','2024-11-19 15:58:43',NULL),(162,1,'',8,0,2,NULL,'[&quot;&quot;]','2024-11-20 09:07:49',NULL),(220,1,'',1,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;&quot;]','2024-11-20 14:41:49',NULL),(243,1,'',3,0,1,NULL,'[&quot;&quot;]','2024-11-20 14:55:14',NULL),(244,1,'',1,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;&quot;]','2024-11-20 14:55:17',NULL),(245,1,'',7,0,1,NULL,'[&quot;&quot;]','2024-11-20 14:56:13',NULL),(246,1,'',5,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;]','[&quot;&quot;]','2024-11-20 14:56:16',NULL),(247,1,'',2,0,1,'[&quot;choice1&quot;,&quot;choice2&quot;,&quot;choice3&quot;]','[]','2024-11-20 17:28:16','2024-11-20 17:29:22'),(254,1023,'Explain the concept of Big O notation and give an example.',3,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-06 01:32:22',NULL),(255,1023,'How many letters?',2,0,2,'[&quot;20&quot;,&quot;24&quot;,&quot;26&quot;,&quot;28&quot;]','[&quot;26&quot;]','2024-12-06 01:32:22',NULL),(256,1023,'What is the full name of USA',3,0,2,NULL,'[&quot;The United States of America&quot;]','2024-12-06 01:32:22',NULL),(257,1023,'Explain the concept of Big O notation and give an example.',3,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-06 23:21:32',NULL),(258,1023,'Is today Friday?',1,0,2,'[&quot;Yes&quot;,&quot;False&quot;]','[&quot;Yes&quot;]','2024-12-06 23:21:32',NULL),(259,1023,'How many days we have for Dec',2,0,2,'[&quot;10&quot;,&quot;20&quot;,&quot;31&quot;,&quot;30&quot;]','[]','2024-12-06 23:21:32',NULL),(260,1023,'Explain the concept of Big O notation and give an example.',3,0,2,NULL,'[&quot;aaaaaa&quot;]','2024-12-07 23:10:02',NULL),(261,1023,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;aaaaaa&quot;]','2024-12-07 23:38:49',NULL),(262,1026,'1+1',1,0,2,'[&quot;2&quot;]','[&quot;2&quot;]','2024-12-08 01:59:35',NULL),(263,1025,'2+2=',1,0,2,'[&quot;3&quot;]','[]','2024-12-08 02:00:06',NULL),(264,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;b&quot;]','2024-12-08 02:15:56',NULL),(265,1025,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-08 14:13:53',NULL),(266,1025,'2+2=4',1,0,2,'[&quot;True&quot;,&quot;False&quot;]','[&quot;True&quot;]','2024-12-08 14:13:53',NULL),(267,1025,'how many days we have for dec',2,0,2,'[&quot;10&quot;,&quot;20&quot;,&quot;30&quot;,&quot;31&quot;]','[]','2024-12-08 14:13:53',NULL),(268,1025,'Explain the concept of Big O notation and give an example.',1,0,2,'[&quot;True&quot;,&quot;False&quot;]','[&quot;True&quot;]','2024-12-08 14:37:37',NULL),(269,1025,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-08 14:46:20',NULL),(270,1025,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 02:44:24',NULL),(271,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 16:17:57',NULL),(272,1026,'asdad',1,0,2,'[&quot;ddd&quot;,&quot;ssss&quot;]','[&quot;ssss&quot;]','2024-12-09 16:17:57',NULL),(273,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 17:24:39',NULL),(274,1026,'ddd',1,0,2,'[&quot;dd&quot;,&quot;ddd&quot;]','[&quot;ddd&quot;]','2024-12-09 17:24:39',NULL),(281,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 18:04:41',NULL),(282,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 19:28:33',NULL),(283,1026,'1+1 =3',1,0,2,'[&quot;True&quot;,&quot;False&quot;]','[&quot;True&quot;]','2024-12-09 19:28:33',NULL),(284,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 19:39:30',NULL),(285,1026,'www',2,0,2,'[&quot;www&quot;]','[]','2024-12-09 19:39:30',NULL),(286,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 20:20:25',NULL),(287,1026,'333',1,0,2,'[&quot;333&quot;,&quot;333&quot;]','[&quot;333&quot;]','2024-12-09 20:20:25',NULL),(288,1026,'Explain the concept of Big O notation and give an example.',4,0,2,NULL,'[&quot;Big O notation is used to describe the performance or complexity of an algorithm. It gives an upper bound on the time or space complexity in terms of the input size. For example, if an algorithm has a time complexity of O(n), it means the runtime grows linearly with the input size.&quot;]','2024-12-09 21:45:01',NULL),(289,1026,'1+1=3',1,0,2,'[&quot;False&quot;,&quot;True&quot;]','[&quot;True&quot;]','2024-12-09 21:45:01',NULL),(290,1026,'How many days in December?',2,0,2,'[&quot;10&quot;,&quot;20&quot;,&quot;30&quot;,&quot;31&quot;]','[]','2024-12-09 21:45:01',NULL),(291,1026,'Explain the concept of Big O notation and give an example.',2,0,2,'[&quot;1&quot;,&quot;2&quot;,&quot;3&quot;,&quot;4&quot;]','[&quot;4&quot;]','2024-12-09 21:54:34',NULL),(292,1026,'111',1,0,2,'[&quot;1&quot;,&quot;2&quot;]','[&quot;1&quot;]','2024-12-09 21:54:34',NULL),(293,1028,'What this the big O for merge sort',4,0,2,NULL,'[&quot;O(nlogn)&quot;]','2024-12-10 01:04:15',NULL),(294,1028,'Rust is a programming language',1,0,2,'[&quot;True&quot;,&quot;False&quot;]','[&quot;True&quot;]','2024-12-10 01:04:15',NULL),(295,1028,'Which of the following best describes the concept of an algorithm? ',2,0,2,'[&quot;A set of instructions to solve a specific problem&quot;,&quot;A programming language&quot;,&quot;A type of data structure&quot;,&quot;A graphical user interface&quot;]','[&quot;A set of instructions to solve a specific problem&quot;]','2024-12-10 01:04:15',NULL),(296,1028,'What is the primary difference between a variable and a constant in programming? ',2,0,2,'[&quot;A variable can be changed during program execution, while a constant cannot &quot;,&quot;A constant is always a numeric value, while a variable can be any data type &quot;,&quot;A variable is used to store data, while a constant is used for calculations&quot;,&quot;There is no difference between them&quot;]','[&quot;A variable can be changed during program execution, while a constant cannot &quot;]','2024-12-10 01:04:15',NULL),(297,1028,'What is the primary function of a compiler in computer science?',4,0,2,NULL,'[&quot;Translate high-level language into machine code&quot;]','2024-12-10 01:04:15',NULL),(298,1028,'how do you like your mother?',4,0,2,NULL,'[&quot;mother is great&quot;]','2024-12-10 02:24:37',NULL),(299,1028,'1+1=3',1,0,2,'[&quot;False&quot;,&quot;True&quot;]','[&quot;False&quot;]','2024-12-10 02:24:37',NULL),(300,1028,'31+10',2,0,2,'[&quot;10&quot;,&quot;20&quot;,&quot;30&quot;,&quot;41&quot;]','[&quot;41&quot;]','2024-12-10 02:24:37',NULL),(301,1028,'1+1=3',1,0,2,'[&quot;False&quot;,&quot;True&quot;]','[&quot;False&quot;]','2024-12-10 02:51:26',NULL),(302,1028,'Talk about yourself!',4,0,2,NULL,'[&quot;ABCD&quot;]','2024-12-10 02:51:26',NULL),(303,1028,'1+1 =3',1,0,2,'[&quot;true&quot;,&quot;false&quot;]','[]','2024-12-10 10:50:32',NULL),(304,1028,'bog o notation',4,0,2,NULL,'[&quot;o(logn)&quot;]','2024-12-10 10:50:32',NULL),(305,1028,'1+1=3',1,0,2,'[&quot;True&quot;,&quot;False&quot;]','[&quot;False&quot;]','2024-12-10 23:10:30',NULL),(306,1028,'Describe your city!',4,0,2,NULL,'[&quot;beautiful!&quot;]','2024-12-10 23:10:30',NULL);
/*!40000 ALTER TABLE `tb_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `order_num` tinyint(1) NOT NULL,
  `parent_id` int DEFAULT NULL,
  `is_hidden` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0F1T',
  `is_disable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0F1T',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'setup','/setup','iconfont icon-shezhi','2024-11-15 13:12:51','2024-11-15 13:14:59',1,NULL,0,0),(2,'menu','/setup/menu','iconfont icon-caidan','2024-11-15 13:13:11','2024-11-15 13:15:21',1,1,0,0),(3,'users','/setup/users','iconfont icon-tuandui','2024-11-15 13:13:31','2024-11-15 13:15:31',1,1,0,0),(4,'permission','/permission','iconfont icon-suoping','2024-11-15 13:14:10','2024-11-15 13:15:52',1,NULL,0,0),(5,'role','/permission/role','iconfont icon-laoban','2024-11-15 13:14:15',NULL,1,4,0,0);
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_message`
--

DROP TABLE IF EXISTS `tb_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message_content` varchar(2280) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ip_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ip_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `from_id` int NOT NULL COMMENT 'sender',
  `to_id` int NOT NULL COMMENT 'receiver',
  `status` tinyint(1) DEFAULT '0' COMMENT '1read 0not read',
  `conversation_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `is_top` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8951 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_message`
--

LOCK TABLES `tb_message` WRITE;
/*!40000 ALTER TABLE `tb_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_post`
--

DROP TABLE IF EXISTS `tb_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `project_id` int NOT NULL,
  `answer` varchar(2480) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '{}',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `has_graded` int NOT NULL DEFAULT '0',
  `scores` varchar(2480) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `comments` varchar(2480) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_post`
--

LOCK TABLES `tb_post` WRITE;
/*!40000 ALTER TABLE `tb_post` DISABLE KEYS */;
INSERT INTO `tb_post` VALUES (1,1,3,'{&quot;82&quot;:[&quot;1dc47835a7d45e2e806e5f166717f1f7.docx&quot;],&quot;94&quot;:[&quot;choice1&quot;],&quot;96&quot;:[&quot;choice2&quot;],&quot;97&quot;:[&quot;choice2&quot;],&quot;100&quot;:[&quot;100&quot;],&quot;101&quot;:[&quot;101&quot;],&quot;103&quot;:[&quot;123&quot;],&quot;104&quot;:[&quot;4&quot;],&quot;105&quot;:[&quot;choice2&quot;],&quot;112&quot;:[&quot;choice1&quot;]}',0,'2024-11-20 16:15:00',NULL,0,NULL,NULL),(2,1,1,'{&quot;1&quot;:[&quot;yes&quot;],&quot;4&quot;:[&quot;choice2&quot;],&quot;247&quot;:[&quot;choice1&quot;,&quot;choice2&quot;]}',0,'2024-11-20 17:28:43',NULL,0,NULL,NULL),(93,1022,16,'{&quot;257&quot;:[&quot;ttt&quot;],&quot;258&quot;:[&quot;Yes&quot;],&quot;259&quot;:[&quot;20&quot;]}',0,'2024-12-07 22:23:28','2024-12-07 22:23:28',1,'{\"total\":1,\"257\":0,\"258\":1,\"259\":0}',NULL),(94,1022,15,'{&quot;254&quot;:[&quot;1111&quot;],&quot;255&quot;:[&quot;24&quot;],&quot;256&quot;:[&quot;wwww&quot;]}',0,'2024-12-07 22:33:59','2024-12-07 22:33:59',1,'{\"254\":0,\"255\":0,\"total\":0,\"256\":0}',NULL),(95,1023,17,'{&quot;260&quot;:[&quot;edeeeee&quot;]}',0,'2024-12-07 23:10:23','2024-12-07 23:10:23',1,'{\"total\":0,\"260\":0}',NULL),(103,1023,18,'{&quot;261&quot;:[&quot;sss&quot;]}',0,'2024-12-07 23:41:00','2024-12-07 23:41:01',1,'{\"total\":0,\"261\":0}',NULL),(104,1022,18,'{&quot;261&quot;:[&quot;aaaa&quot;]}',1,'2024-12-07 23:42:01','2024-12-07 23:42:01',1,'{\"total\":0,\"261\":0}',NULL),(106,1022,18,'{&quot;261&quot;:&quot;aaaaaaa&quot;}',1,'2024-12-07 23:49:36','2024-12-08 01:41:28',1,'100','xxxxxxx'),(107,1022,18,'{&quot;261&quot;:[&quot;nnnnnnnn&quot;]}',0,'2024-12-08 01:41:28','2024-12-08 01:41:28',1,'{\"total\":0,\"261\":0}',NULL),(111,1024,19,'{&quot;262&quot;:[&quot;2&quot;]}',0,'2024-12-08 02:03:35','2024-12-08 02:03:35',1,'{\"total\":1,\"262\":1}',NULL),(112,1024,20,'{&quot;263&quot;:[&quot;3&quot;]}',1,'2024-12-08 02:03:57','2024-12-08 02:03:57',1,'{\"total\":0,\"263\":0}',NULL),(113,1024,21,'{&quot;264&quot;:[&quot;ssss&quot;]}',0,'2024-12-08 02:16:13','2024-12-08 02:16:13',1,'{\"264\":0,\"total\":0}',NULL),(114,1025,20,'{&quot;263&quot;:[&quot;3&quot;]}',0,'2024-12-08 14:11:43',NULL,1,'0','very bad'),(117,1024,22,'{&quot;265&quot;:[&quot;ssss&quot;],&quot;266&quot;:[&quot;True&quot;],&quot;267&quot;:[true]}',1,'2024-12-08 14:16:11','2024-12-08 14:17:39',0,NULL,NULL),(118,1025,22,'{&quot;265&quot;:[&quot;ssss&quot;],&quot;266&quot;:[&quot;True&quot;],&quot;267&quot;:[true]}',0,'2024-12-08 14:17:39',NULL,1,'1','okay'),(119,1024,22,'{&quot;265&quot;:[&quot;ssss&quot;],&quot;266&quot;:[&quot;True&quot;],&quot;267&quot;:[&quot;20&quot;,&quot;30&quot;]}',1,'2024-12-08 14:18:21','2024-12-08 14:30:42',0,NULL,NULL),(120,1025,22,'{&quot;265&quot;:[&quot;ssss&quot;],&quot;266&quot;:[&quot;True&quot;],&quot;267&quot;:[&quot;20&quot;,&quot;30&quot;]}',0,'2024-12-08 14:30:42',NULL,1,'1','so bad'),(121,1024,23,'{&quot;268&quot;:[&quot;True&quot;]}',1,'2024-12-08 14:37:56','2024-12-08 14:37:56',1,'{\"total\":1,\"268\":1}',NULL),(122,1025,23,'{&quot;268&quot;:[&quot;True&quot;]}',0,'2024-12-08 14:44:02',NULL,1,'1','Great!'),(123,1024,24,'{&quot;269&quot;:[&quot;sssssffvfvfv&quot;]}',1,'2024-12-08 14:46:35','2024-12-08 14:47:20',0,NULL,NULL),(124,1025,24,'{&quot;269&quot;:[&quot;sssssffvfvfv&quot;]}',0,'2024-12-08 14:47:20',NULL,1,'0','bad'),(125,1024,23,'{&quot;268&quot;:[&quot;False&quot;]}',0,'2024-12-08 14:49:16','2024-12-08 14:49:16',1,'{\"total\":0,\"268\":0}',NULL),(126,1024,24,'{&quot;269&quot;:[&quot;绕他&quot;]}',1,'2024-12-08 14:49:43','2024-12-08 14:50:26',0,NULL,NULL),(127,1025,24,'{&quot;269&quot;:[&quot;绕他&quot;]}',0,'2024-12-08 14:50:26',NULL,1,'4','eesss'),(128,1024,26,'{&quot;271&quot;:[&quot;rrrrr&quot;],&quot;272&quot;:[&quot;ddd&quot;]}',1,'2024-12-09 16:18:30','2024-12-09 16:23:35',0,NULL,NULL),(129,1026,26,'{&quot;271&quot;:[&quot;rrrrr&quot;],&quot;272&quot;:[&quot;ddd&quot;]}',0,'2024-12-09 16:23:35',NULL,1,'2','bad!!!!!'),(130,1024,26,'{&quot;271&quot;:[&quot;eeeee4e&quot;],&quot;272&quot;:[&quot;ddd&quot;]}',1,'2024-12-09 17:18:15','2024-12-09 17:20:33',0,NULL,NULL),(131,1026,26,'{}',0,'2024-12-09 17:20:33',NULL,1,'2','great'),(132,1024,26,'{&quot;271&quot;:[&quot;12qw345&quot;],&quot;272&quot;:[&quot;ddd&quot;]}',1,'2024-12-09 17:21:57','2024-12-09 17:22:25',0,NULL,NULL),(133,1026,26,'{}',0,'2024-12-09 17:22:25',NULL,1,'0','32456789'),(134,1024,27,'{&quot;273&quot;:[&quot;eeeee&quot;],&quot;274&quot;:[&quot;dd&quot;]}',0,'2024-12-09 17:29:27','2024-12-09 17:48:46',1,'0','123456'),(135,1024,28,'{&quot;281&quot;:[&quot;qw4er56y47ut5y&quot;]}',0,'2024-12-09 18:05:22','2024-12-09 18:05:52',1,'0',''),(136,1027,29,'{&quot;282&quot;:[&quot;great&quot;],&quot;283&quot;:[&quot;True&quot;]}',0,'2024-12-09 19:29:20','2024-12-09 19:30:02',1,'2',''),(137,1024,29,'{&quot;282&quot;:[&quot;dddddd&quot;],&quot;283&quot;:[&quot;False&quot;]}',0,'2024-12-09 19:29:43','2024-12-09 19:30:10',1,'1',''),(138,1027,30,'{&quot;284&quot;:[&quot;dddd&quot;],&quot;285&quot;:[&quot;www&quot;]}',0,'2024-12-09 19:40:02','2024-12-09 19:40:29',1,'{\"284\":1,\"285\":0}','not bad'),(139,1027,31,'{&quot;286&quot;:[&quot;33333&quot;],&quot;287&quot;:[&quot;333&quot;]}',0,'2024-12-09 20:20:52','2024-12-09 20:21:22',1,'{\"286\":0,\"287\":1,\"total\":1}','okjay'),(140,1027,32,'{&quot;288&quot;:[&quot;I don\'t know&quot;],&quot;289&quot;:[&quot;True&quot;],&quot;290&quot;:[&quot;31&quot;]}',0,'2024-12-09 21:46:09','2024-12-09 21:47:00',1,'{\"288\":0,\"289\":1,\"290\":1,\"total\":2}','Great job'),(141,1024,32,'{&quot;288&quot;:[&quot;sssss&quot;],&quot;289&quot;:[&quot;False&quot;],&quot;290&quot;:[&quot;31&quot;]}',0,'2024-12-09 21:48:12','2024-12-09 21:48:56',1,'{\"288\":1,\"289\":1,\"290\":1,\"total\":3}','woow!'),(142,1022,32,'{&quot;288&quot;:[&quot;1234123&quot;],&quot;289&quot;:[&quot;True&quot;],&quot;290&quot;:[&quot;31&quot;]}',0,'2024-12-09 21:51:04','2024-12-09 21:51:41',1,'{\"288\":0,\"289\":1,\"290\":1,\"total\":2}','gggg'),(143,1024,33,'{&quot;291&quot;:[&quot;1&quot;],&quot;292&quot;:[&quot;1&quot;]}',0,'2024-12-09 21:55:40','2024-12-09 21:55:40',1,'{\"total\":1,\"291\":0,\"292\":1}',NULL),(144,1027,33,'{&quot;291&quot;:[&quot;4&quot;],&quot;292&quot;:[&quot;1&quot;]}',0,'2024-12-09 21:57:31','2024-12-09 21:57:31',1,'{\"total\":2,\"291\":1,\"292\":1}',NULL),(145,1030,34,'{&quot;293&quot;:[&quot;O(n^2)&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A set of instructions to solve a specific problem&quot;],&quot;296&quot;:[&quot;There is no difference between them&quot;],&quot;297&quot;:[&quot;I dont know&quot;]}',0,'2024-12-10 01:07:48','2024-12-10 01:13:23',1,'{\"293\":0,\"294\":0,\"295\":1,\"296\":1,\"297\":0,\"total\":2}','You need more study!'),(146,1029,34,'{&quot;293&quot;:[&quot;O(NLOGN)&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A set of instructions to solve a specific problem&quot;],&quot;296&quot;:[&quot;A variable can be changed during program execution, while a constant cannot &quot;],&quot;297&quot;:[&quot;Translate high-level language into machine code&quot;]}',0,'2024-12-10 01:08:51','2024-12-10 01:13:41',1,'{\"293\":1,\"294\":1,\"295\":1,\"296\":1,\"297\":1,\"total\":5}','Great Job!'),(147,1031,34,'{&quot;293&quot;:[&quot;i dont know&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A set of instructions to solve a specific problem&quot;],&quot;296&quot;:[&quot;A variable can be changed during program execution, while a constant cannot &quot;],&quot;297&quot;:[&quot;i dont know&quot;]}',0,'2024-12-10 01:09:25','2024-12-10 01:14:28',1,'{\"293\":0,\"294\":0,\"295\":1,\"296\":1,\"297\":1,\"total\":3}','Not too bad!'),(148,1033,34,'{&quot;293&quot;:[&quot;o(nlogn)&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A programming language&quot;],&quot;296&quot;:[&quot;A variable can be changed during program execution, while a constant cannot &quot;],&quot;297&quot;:[&quot;Translate high-level language into machine code&quot;]}',0,'2024-12-10 01:09:59','2024-12-10 01:15:00',1,'{\"293\":1,\"294\":1,\"295\":1,\"296\":0,\"297\":1,\"total\":4}','almost!!!'),(149,1035,34,'{&quot;293&quot;:[&quot;O(nlogn)&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A set of instructions to solve a specific problem&quot;],&quot;296&quot;:[&quot;A variable can be changed during program execution, while a constant cannot &quot;],&quot;297&quot;:[&quot;compile our code?&quot;]}',0,'2024-12-10 01:35:42','2024-12-10 01:40:45',1,'{\"293\":0,\"294\":1,\"295\":1,\"296\":1,\"297\":1,\"total\":4}','not bad'),(150,1034,34,'{&quot;293&quot;:[&quot;o(nlogn)&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A set of instructions to solve a specific problem&quot;],&quot;296&quot;:[&quot;A variable can be changed during program execution, while a constant cannot &quot;],&quot;297&quot;:[&quot;compile high level code&quot;]}',0,'2024-12-10 02:26:40','2024-12-10 02:27:45',1,'{\"293\":1,\"294\":1,\"295\":1,\"296\":1,\"297\":1,\"total\":5}',''),(151,1037,34,'{&quot;293&quot;:[&quot;o(n^2)&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A set of instructions to solve a specific problem&quot;],&quot;296&quot;:[&quot;A variable can be changed during program execution, while a constant cannot &quot;],&quot;297&quot;:[&quot;i do not know&quot;]}',0,'2024-12-10 02:53:04','2024-12-10 02:54:32',1,'{\"293\":0,\"294\":0,\"295\":1,\"296\":1,\"297\":1,\"total\":3}',''),(165,1030,35,'{&quot;298&quot;:[&quot;sss&quot;],&quot;299&quot;:[&quot;False&quot;],&quot;300&quot;:[&quot;20&quot;]}',0,'2024-12-10 11:06:08',NULL,0,NULL,NULL),(166,1033,35,'{&quot;298&quot;:[&quot;rrr&quot;],&quot;299&quot;:[&quot;False&quot;],&quot;300&quot;:[&quot;20&quot;]}',0,'2024-12-10 11:15:39',NULL,0,NULL,NULL),(167,1034,35,'{&quot;298&quot;:[&quot;eee&quot;],&quot;299&quot;:[&quot;False&quot;],&quot;300&quot;:[&quot;20&quot;]}',0,'2024-12-10 11:17:46',NULL,0,NULL,NULL),(168,1034,33,'{&quot;291&quot;:[&quot;2&quot;],&quot;292&quot;:[&quot;1&quot;]}',0,'2024-12-10 11:21:44','2024-12-10 11:21:44',1,'{\"total\":2,\"291\":1,\"292\":1}',NULL),(169,1031,35,'{&quot;298&quot;:[&quot;ddd&quot;],&quot;299&quot;:[&quot;False&quot;],&quot;300&quot;:[&quot;20&quot;]}',0,'2024-12-10 11:22:06',NULL,0,NULL,NULL),(170,1040,34,'{&quot;293&quot;:[&quot;O(n^2)&quot;],&quot;294&quot;:[&quot;True&quot;],&quot;295&quot;:[&quot;A set of instructions to solve a specific problem&quot;],&quot;296&quot;:[&quot;A variable can be changed during program execution, while a constant cannot &quot;],&quot;297&quot;:[&quot;compile high level code to machine code&quot;]}',0,'2024-12-10 23:11:48','2024-12-10 23:13:24',1,'{\"293\":1,\"294\":0,\"295\":1,\"296\":1,\"297\":1,\"total\":4}','');
/*!40000 ALTER TABLE `tb_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_project`
--

DROP TABLE IF EXISTS `tb_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `questions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cascades` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '1questionnaire 2quiz',
  `is_active` tinyint(1) NOT NULL DEFAULT '0',
  `is_random` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_password` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'need password?',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `question_number` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'display question number or not',
  `progress_bar` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'progress bar visible',
  `auto_save` tinyint(1) NOT NULL DEFAULT '0',
  `answer_sheet_visible` tinyint(1) NOT NULL DEFAULT '0',
  `copy_enabled` tinyint(1) NOT NULL DEFAULT '1',
  `enable_update` tinyint(1) NOT NULL DEFAULT '0',
  `answer_analysis` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'display answer and analysis or not',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `question_num` int NOT NULL DEFAULT '0' COMMENT 'number of random questions',
  `tag_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'random question tags',
  `types` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'random question types',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `user_id` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_project`
--

LOCK TABLES `tb_project` WRITE;
/*!40000 ALTER TABLE `tb_project` DISABLE KEYS */;
INSERT INTO `tb_project` VALUES (1,'questionnaire1','[4,1,247]','null',1,1,0,'2024-11-20 15:22:20','2024-11-20 17:28:16',0,'$2a$10$drpLVPRFIbXZTDJ3goWndOXdYn.hy0KM6j5rSTrmLm6ZigmkilP96',0,0,0,0,1,0,1,NULL,NULL,0,'','','For info collection',NULL,0,1),(2,'random_quiz1','[3]',NULL,2,0,1,'2024-11-18 14:23:40',NULL,0,'',0,1,1,0,0,1,1,'2024-11-20 16:00:00','2024-11-20 16:00:00',4,'[35,34,32]','[3,4,5]','444444','',0,1),(3,'quiz1','[94,96,95,97,98,99,100,101,102,104,103,105,107,82,112,113,115,116,162]','{\"82\":{},\"94\":{\"0\":96,\"1\":98},\"95\":{},\"96\":{\"0\":95},\"97\":{\"1\":99},\"98\":{},\"99\":{},\"100\":{},\"101\":{},\"102\":{},\"103\":{},\"104\":{},\"105\":{},\"107\":{},\"112\":{},\"113\":{}}',2,1,0,'2024-11-20 16:44:39','2024-11-21 10:13:23',0,'$2a$10$aB/xXfJqBFk/l9vfXcUNK.JCpCgNpjFDtqHvPZCACjYzjA5BAkHCu',0,0,0,0,1,1,1,'2024-11-18 16:00:00','2024-11-19 08:00:00',0,'','',NULL,'',0,1),(4,'random_questionnaire1','[220,243,244,245,246]','null',1,1,0,'2024-11-21 13:57:51','2024-11-21 14:56:16',0,'$2a$10$f2Gy58fckyWPJaOuB1dN4Oy9tDu0GsI.x5VL57cg1jfpqP9tGI87m',0,0,0,0,0,1,0,NULL,NULL,0,'','',NULL,NULL,0,1),(15,'New Quiz','[254,255,256]',NULL,2,1,0,'2024-12-06 01:32:22',NULL,0,'$2a$10$jOSTh5sBswWpMCpXMtGrX.0cujavZbfUbJCDKMacQA61u1SKCKl62',1,1,1,1,0,1,1,NULL,'2025-12-20 16:00:00',3,'','2','t','',0,1023),(16,'Temp','[257,258,259]',NULL,2,1,0,'2024-12-06 23:21:32',NULL,0,'$2a$10$6vjCtarp/ePx0NCig7MvrOIVMD2fn7miEz3OvMBmumDU5CJtDhncC',1,1,1,1,0,1,1,NULL,'2025-12-20 16:00:00',3,'','[1,2,3]','Random','',0,1023),(17,'xxx','[260]',NULL,2,1,0,'2024-12-07 23:10:02',NULL,0,'$2a$10$hHd5D79AyyLSh.hTAu2XR.zq8SP0VKlUmFi..d9zh9EcN7/FcOUUm',1,1,1,1,0,1,1,NULL,NULL,1,'','[3]','','',0,1023),(18,'a','[261]',NULL,2,1,0,'2024-12-07 23:38:49',NULL,0,'$2a$10$s71/B8fBwKFigU1mlwQVGeg8Ma4L0Dum.ueESkiv.jDKMhwJS9zSW',1,1,1,1,0,1,1,NULL,NULL,1,'','[4]','s','',0,1023),(19,'teacher2','[262]',NULL,2,1,0,'2024-12-08 01:59:35',NULL,0,'$2a$10$EoH1ECu98yu9EZVxXX3esOK/1Ur28tnbRcR2ScSIMvI.SafF3Pa/q',1,1,1,1,0,1,1,NULL,NULL,1,'','[1]','qwerty','',0,1026),(20,'teacher1','[263]',NULL,2,1,0,'2024-12-08 02:00:06',NULL,0,'$2a$10$JaiUtLHz81f.GnJZCQzdWev6egZFFm4/JdAsGQDKHsih8HlME.6CC',1,1,1,1,0,1,1,NULL,NULL,1,'','[1]','1111','',0,1025),(21,'test1','[264]',NULL,2,1,0,'2024-12-08 02:15:56',NULL,0,'$2a$10$NfvTWuWtdeTJIqngDXzeIeLonAmxrsVsTwJHqBKafY8OMc7v7me6i',1,1,1,1,0,1,1,NULL,NULL,1,'','[4]','','',0,1026),(22,'1234','[265,266,267]',NULL,2,1,0,'2024-12-08 14:13:53',NULL,0,'$2a$10$t/UHQaX/RqD3xITWBDBx5.8uSFBh1X0oPsonuowOzgPlMKM31q2mK',1,1,1,1,0,1,1,NULL,NULL,3,'','[1,2,4]','idk','',0,1025),(23,'vvvv','[268]',NULL,2,1,0,'2024-12-08 14:37:37',NULL,0,'$2a$10$kOsPJ8y1WVxo9fM4BWnUYeP36Y3tPO5anmQxmuzb59jS3Qazwxz56',1,1,1,1,0,1,1,NULL,NULL,1,'','[1]','vgvvvv','',0,1025),(24,'New Quiz','[269]',NULL,2,1,0,'2024-12-08 14:46:21',NULL,0,'$2a$10$nj.8pO9gXUg2h1DfwEQgaOnEA7MEJvLlWtkxq1BmN6XllOnrKvaz.',1,1,1,1,0,1,1,NULL,NULL,1,'','[4]','','',0,1025),(25,'1257','[270]',NULL,2,1,0,'2024-12-09 02:44:24',NULL,0,'$2a$10$V7Z.B/pv8C/R89e3OZsZX.hGcsOLomkITN1wdmAH8K7b1Yn62Dr3K',1,1,1,1,0,1,1,NULL,NULL,1,'','[4]','234324234','',0,1025),(26,'abc','[271,272]',NULL,2,1,0,'2024-12-09 16:17:57',NULL,0,'$2a$10$TqVAfcUgA21fNGKhR63KAerPxHsnAP.gIgy/.hmsnnJlpXiHp2iYK',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,4]','abc','',0,1026),(27,'fff','[273,274]',NULL,2,1,0,'2024-12-09 17:24:39',NULL,0,'$2a$10$Kq0L4vQdUqZx7OXtm/xON.j9gjREwHwtRCpQZCbBkz/nNT/Z2Jy9.',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,4]','ff','',0,1026),(28,'AS','[281]',NULL,2,1,0,'2024-12-09 18:04:41',NULL,0,'$2a$10$xWcVOByCpB8am2hmbuQegOmfOUtAoM1D2BfVlCyynCpBqPSUGJ16q',1,1,1,1,0,1,1,NULL,NULL,1,'','[4]','asS','',0,1026),(29,'final','[282,283]',NULL,2,1,0,'2024-12-09 19:28:33',NULL,0,'$2a$10$Y2ppH3Tx5e1gwpKPoRpVYOGPk5nojWoSg9dxJZdP9ZZPeydpGJ.NK',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,4]','123','',0,1026),(30,'eeee','[284,285]',NULL,2,1,0,'2024-12-09 19:39:30',NULL,0,'$2a$10$886kK6KO9HlOouGDI1.XSO/CkyFNbTnP45Dm/ig0027aFSYJJePMC',1,1,1,1,0,1,1,NULL,NULL,2,'','[2,4]','eee','',0,1026),(31,'ppp','[286,287]',NULL,2,1,0,'2024-12-09 20:20:25',NULL,0,'$2a$10$htkIiy2DxmVibH02qQPNveHb4LhGhR/pQFIej.vTDtETt2piFaVFS',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,4]','33333','',0,1026),(32,'TestSTATS','[288,289,290]',NULL,2,1,0,'2024-12-09 21:45:01',NULL,0,'$2a$10$BwT/qy1L8ftcER9CbpSs0ODM/tbcRSTV0UbWVhNJMeZhl2G35zvq.',1,1,1,1,0,1,1,NULL,NULL,3,'','[1,2,4]','','',0,1026),(33,'New Quiz','[291,292]',NULL,2,1,0,'2024-12-09 21:54:34',NULL,0,'$2a$10$QLE5wfTyicOb0lHzlT/Ip.qfM0IvVOvb31MwiFa0W1gmPUy/9nNiC',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,2]','','',0,1026),(34,'Midterm Preparation','[293,294,295,296,297]',NULL,2,1,0,'2024-12-10 01:04:15',NULL,0,'$2a$10$G.1rhCx4L23..0qAaCdk3ehp12PMzRbOZwbPRg2dNNNukkugL4M.6',1,1,1,1,0,1,1,NULL,NULL,5,'','[1,2,4]','This preparation is designed to help to brush out your memory of what we learnt from the first half of the semester','',0,1028),(35,'demo','[298,299,300]',NULL,2,1,0,'2024-12-10 02:24:37',NULL,0,'$2a$10$tC2.wYK.XTSiU3TY6IGwHOksi/3G4cKJ9YQqi3PPeaCEjVeQA8mrK',1,1,1,1,0,1,1,NULL,NULL,3,'','[1,2,4]','hello demo','',0,1028),(36,'demo1','[301,302]',NULL,2,1,0,'2024-12-10 02:51:26',NULL,0,'$2a$10$54ILZACwOoAJtGpkjLojY.eCkTI3rgKfbE.CUo.l.tUtam5cIgcUi',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,4]','demo hello','',0,1028),(37,'my quiz','[303,304]',NULL,2,1,0,'2024-12-10 10:50:32',NULL,0,'$2a$10$vFtALE4o6bI8LZXJcDN42uWt1egYck3/bn3tgRVALggGidZgDxWEO',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,4]','qwerty','',0,1028),(38,'demo quiz','[305,306]',NULL,2,1,0,'2024-12-10 23:10:30',NULL,0,'$2a$10$Op3wD4hRiYbOQQF0UixoyO2sLQXGlprlKtsD4Dqr49XoRZqTFGuQO',1,1,1,1,0,1,1,NULL,NULL,2,'','[1,4]','quiz for demo video','',0,1028);
/*!40000 ALTER TABLE `tb_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_question`
--

DROP TABLE IF EXISTS `tb_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL COMMENT 'author_id',
  `question_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `question_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` int NOT NULL COMMENT 'Question type 1 single choice 2 multiple choice 3 fill in the blank 4 text 5 drop down 6 cascade 7 scoring 8 upload',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL COMMENT 'question mode 1questionnaire 2quiz',
  `questions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'relative questions',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_question`
--

LOCK TABLES `tb_question` WRITE;
/*!40000 ALTER TABLE `tb_question` DISABLE KEYS */;
INSERT INTO `tb_question` VALUES (1,1,'Do you find instructor note helpful for your study?','This question helps instructor know more about students',1,0,1,NULL,'2024-11-16 16:12:20',NULL),(2,1,'multiple choice sample question','This is a multiple choice.',2,0,1,NULL,'2024-11-16 16:14:12','2024-11-16 17:29:22'),(3,1,'Lisa is at least _____ feet.','Enter an integer in the space',3,0,2,NULL,'2024-11-17 10:54:59',NULL),(4,1,'Write the proof for the equation.',NULL,5,0,1,NULL,'2024-11-17 10:59:32',NULL),(5,1,'Select your gender.',NULL,1,0,2,NULL,'2024-11-17 11:22:17',NULL),(6,1,'What is the time complexity of the code?',NULL,1,0,1,NULL,'2024-11-18 09:22:59',NULL),(82,1,'upload sample question','This is a upload question.',8,0,1,NULL,'2024-11-18 14:22:56','2024-11-18 16:14:27'),(94,1,'single choice sample question','This is a single choice.',1,0,1,NULL,'2024-11-18 16:11:15','2024-11-19 10:12:55'),(95,1,'multiple choice sample question2',NULL,2,0,1,NULL,'2024-11-18 16:11:19','2024-11-18 17:35:25'),(96,1,'single choice sample question2',NULL,1,0,1,NULL,'2024-11-18 16:11:19','2024-11-18 17:35:03'),(97,1,'multiple choice sample question3',NULL,2,0,1,NULL,'2024-11-18 16:11:24','2024-11-18 17:35:30'),(98,1,'fill in the blanks sample question','This is a fill in the blanks question.',3,0,1,NULL,'2024-11-18 16:11:24','2024-11-18 17:35:45'),(99,1,'upload sample question2',NULL,8,0,1,NULL,'2024-11-18 16:11:26','2024-11-18 17:36:19'),(100,1,'fill in the blanks sample question2',NULL,3,0,1,NULL,'2024-11-18 16:11:26','2024-11-18 17:36:28'),(101,1,'fill in the blanks sample question3',NULL,3,0,1,NULL,'2024-11-18 16:11:28','2024-11-18 17:36:34'),(102,1,'text sample quetsion','This is a text question.',4,0,1,NULL,'2024-11-18 16:11:28','2024-11-18 17:06:49'),(103,1,'text sample quetsion2',NULL,4,0,1,NULL,'2024-11-18 16:11:44','2024-11-18 17:36:45'),(104,1,'scoring sample question','This is a scoring question.',7,0,1,NULL,'2024-11-18 16:11:44',NULL),(105,1,'multiple choice sample question4',NULL,2,0,1,NULL,'2024-11-18 16:19:17','2024-11-18 17:36:51'),(107,1,'name','Enter your name.',4,0,1,NULL,'2024-11-18 16:31:08','2024-11-19 13:58:13'),(112,1,'drop down sample question','This is a drop down question',5,0,2,NULL,'2024-11-18 17:07:20','2024-11-18 17:36:59'),(113,1,'drop down sample question2',NULL,5,0,2,NULL,'2024-11-18 17:11:27','2024-11-18 17:37:04'),(115,1,'single choice sample question3',NULL,1,0,2,NULL,'2024-11-19 15:18:15','2024-11-19 15:40:36'),(116,1,'upload sample question3',NULL,8,0,2,NULL,'2024-11-19 15:58:42',NULL),(162,1,'upload sample question4',NULL,8,0,2,NULL,'2024-11-20 09:07:48',NULL),(220,1,'single choice sample question4',NULL,1,0,1,NULL,'2024-11-20 14:41:49',NULL),(243,1,'fill in the blanks sample question4',NULL,3,0,1,NULL,'2024-11-20 14:55:13',NULL),(244,1,'single choice sample question5',NULL,1,0,1,NULL,'2024-11-20 14:55:17',NULL),(245,1,'scoring sample question2',NULL,7,0,1,NULL,'2024-11-20 14:56:13',NULL),(246,1,'drop down sample question3',NULL,5,0,1,NULL,'2024-11-20 14:56:15',NULL),(247,1,'multiple choice sample question5',NULL,2,0,1,NULL,'2024-11-20 17:28:16',NULL),(253,1023,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',3,0,2,NULL,'2024-12-04 23:38:56',NULL),(254,1023,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',3,0,2,NULL,'2024-12-06 01:32:22',NULL),(255,1023,'How many letters?','How many letters?',2,0,2,NULL,'2024-12-06 01:32:22',NULL),(256,1023,'What is the full name of USA','What is the full name of USA',3,0,2,NULL,'2024-12-06 01:32:22',NULL),(257,1023,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',3,0,2,NULL,'2024-12-06 23:21:32',NULL),(258,1023,'Is today Friday?','Is today Friday?',1,0,2,NULL,'2024-12-06 23:21:32',NULL),(259,1023,'How many days we have for Dec','How many days we have for Dec',2,0,2,NULL,'2024-12-06 23:21:32',NULL),(260,1023,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',3,0,2,NULL,'2024-12-07 23:10:02',NULL),(261,1023,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-07 23:38:49',NULL),(262,1026,'1+1','1+1',1,0,2,NULL,'2024-12-08 01:59:35',NULL),(263,1025,'2+2=','2+2=',1,0,2,NULL,'2024-12-08 02:00:06',NULL),(264,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-08 02:15:56',NULL),(265,1025,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-08 14:13:53',NULL),(266,1025,'2+2=4','2+2=4',1,0,2,NULL,'2024-12-08 14:13:53',NULL),(267,1025,'how many days we have for dec','how many days we have for dec',2,0,2,NULL,'2024-12-08 14:13:53',NULL),(268,1025,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',1,0,2,NULL,'2024-12-08 14:37:37',NULL),(269,1025,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-08 14:46:20',NULL),(270,1025,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 02:44:24',NULL),(271,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 16:17:57',NULL),(272,1026,'asdad','asdad',1,0,2,NULL,'2024-12-09 16:17:57',NULL),(273,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 17:24:39',NULL),(274,1026,'ddd','ddd',1,0,2,NULL,'2024-12-09 17:24:39',NULL),(275,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 17:50:43',NULL),(276,1026,'222','222',1,0,2,NULL,'2024-12-09 17:50:43',NULL),(277,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 17:51:26',NULL),(278,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 17:54:15',NULL),(279,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 17:56:35',NULL),(280,1026,'sdf','sdf',1,0,2,NULL,'2024-12-09 17:56:36',NULL),(281,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 18:04:41',NULL),(282,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 19:28:33',NULL),(283,1026,'1+1 =3','1+1 =3',1,0,2,NULL,'2024-12-09 19:28:33',NULL),(284,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 19:39:30',NULL),(285,1026,'www','www',2,0,2,NULL,'2024-12-09 19:39:30',NULL),(286,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 20:20:25',NULL),(287,1026,'333','333',1,0,2,NULL,'2024-12-09 20:20:25',NULL),(288,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',4,0,2,NULL,'2024-12-09 21:45:01',NULL),(289,1026,'1+1=3','1+1=3',1,0,2,NULL,'2024-12-09 21:45:01',NULL),(290,1026,'How many days in December?','How many days in December?',2,0,2,NULL,'2024-12-09 21:45:01',NULL),(291,1026,'Explain the concept of Big O notation and give an example.','Explain the concept of Big O notation and give an example.',2,0,2,NULL,'2024-12-09 21:54:34',NULL),(292,1026,'111','111',1,0,2,NULL,'2024-12-09 21:54:34',NULL),(293,1028,'What this the big O for merge sort','What this the big O for merge sort',4,0,2,NULL,'2024-12-10 01:04:14',NULL),(294,1028,'Rust is a programming language','Rust is a programming language',1,0,2,NULL,'2024-12-10 01:04:14',NULL),(295,1028,'Which of the following best describes the concept of an algorithm? ','Which of the following best describes the concept of an algorithm? ',2,0,2,NULL,'2024-12-10 01:04:15',NULL),(296,1028,'What is the primary difference between a variable and a constant in programming? ','What is the primary difference between a variable and a constant in programming? ',2,0,2,NULL,'2024-12-10 01:04:15',NULL),(297,1028,'What is the primary function of a compiler in computer science?','What is the primary function of a compiler in computer science?',4,0,2,NULL,'2024-12-10 01:04:15',NULL),(298,1028,'how do you like your mother?','how do you like your mother?',4,0,2,NULL,'2024-12-10 02:24:37',NULL),(299,1028,'1+1=3','1+1=3',1,0,2,NULL,'2024-12-10 02:24:37',NULL),(300,1028,'31+10','31+10',2,0,2,NULL,'2024-12-10 02:24:37',NULL),(301,1028,'1+1=3','1+1=3',1,0,2,NULL,'2024-12-10 02:51:26',NULL),(302,1028,'Talk about yourself!','Talk about yourself!',4,0,2,NULL,'2024-12-10 02:51:26',NULL),(303,1028,'1+1 =3','1+1 =3',1,0,2,NULL,'2024-12-10 10:50:32',NULL),(304,1028,'bog o notation','bog o notation',4,0,2,NULL,'2024-12-10 10:50:32',NULL),(305,1028,'1+1=3','1+1=3',1,0,2,NULL,'2024-12-10 23:10:29',NULL),(306,1028,'Describe your city!','Describe your city!',4,0,2,NULL,'2024-12-10 23:10:29',NULL);
/*!40000 ALTER TABLE `tb_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_question_tag`
--

DROP TABLE IF EXISTS `tb_question_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_question_tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_question_tag`
--

LOCK TABLES `tb_question_tag` WRITE;
/*!40000 ALTER TABLE `tb_question_tag` DISABLE KEYS */;
INSERT INTO `tb_question_tag` VALUES (1,1,34),(2,5,29),(3,3,35),(4,4,29),(5,104,1),(6,107,36),(7,102,1),(8,96,1),(9,95,1),(10,97,1),(11,98,1),(12,99,1),(13,100,1),(14,101,1),(15,103,1),(16,105,1),(17,112,1),(18,113,1),(19,115,1),(20,162,1),(21,220,1),(22,243,1),(23,244,1),(24,245,1),(25,246,1),(36,247,1),(37,2,1);
/*!40000 ALTER TABLE `tb_question_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_resource`
--

DROP TABLE IF EXISTS `tb_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_resource` (
  `id` int NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `is_anonymous` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'anonymous acces 0F 1T',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=380 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resource`
--

LOCK TABLES `tb_resource` WRITE;
/*!40000 ALTER TABLE `tb_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_label` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_disable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0F 1T',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES (1,'admin','admin',0,'2024-11-15 13:02:21','2024-11-15 13:03:12'),(2,'professor','prof',0,'2024-11-15 13:02:25','2024-11-15 13:03:24'),(3,'student','stu',0,'2024-11-15 13:03:23','2024-11-15 13:03:44'),(4,'test','test',1,'2024-11-15 13:04:46','2024-11-15 13:05:37');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_menu`
--

DROP TABLE IF EXISTS `tb_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3920 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_menu`
--

LOCK TABLES `tb_role_menu` WRITE;
/*!40000 ALTER TABLE `tb_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_resource`
--

DROP TABLE IF EXISTS `tb_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role_resource` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `resource_id` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_resource`
--

LOCK TABLES `tb_role_resource` WRITE;
/*!40000 ALTER TABLE `tb_role_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tag`
--

DROP TABLE IF EXISTS `tb_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tag`
--

LOCK TABLES `tb_tag` WRITE;
/*!40000 ALTER TABLE `tb_tag` DISABLE KEYS */;
INSERT INTO `tb_tag` VALUES (1,'tag1','2024-11-18 16:01:46',NULL),(29,'tag2','2024-11-18 23:33:57',NULL),(34,'tag3','2024-11-19 16:17:29',NULL),(35,'tag4','2024-11-19 16:18:01','2024-11-20 14:25:31'),(36,'tag5','2024-11-20 14:15:31',NULL);
/*!40000 ALTER TABLE `tb_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_auth`
--

DROP TABLE IF EXISTS `tb_user_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_auth` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_info_id` int NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `login_type` tinyint(1) NOT NULL,
  `ip_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ip_source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1031 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_auth`
--

LOCK TABLES `tb_user_auth` WRITE;
/*!40000 ALTER TABLE `tb_user_auth` DISABLE KEYS */;
INSERT INTO `tb_user_auth` VALUES (1,1,'admin','$2a$10$dcZw8qRctvXv/U1WKSiB.uevrbR1ye4pFoy00ms3PhwGvF1jApihe',1,'','','2024-11-15 13:43:18','2024-11-15 13:44:01','2024-11-15 13:44:01'),(1012,1022,'a@a.com','$2a$10$EgupmXpRqQE89uh08cp.KeOb7H0ZcEGh.vyokgaiVkIow/TZCBsfm',1,'0:0:0:0:0:0:0:1','','2024-11-29 23:05:46','2024-12-09 21:50:43','2024-12-09 21:50:43'),(1013,1023,'b@b.com','$2a$10$2sE/97D3FjNdMjhG2z157OrNPcnG1NgsgbeS5OFICqmEQMEr9l8wa',1,'0:0:0:0:0:0:0:1','','2024-11-29 23:07:06','2024-12-08 01:16:46','2024-12-08 01:16:46'),(1014,1024,'student1','$2a$10$8tsqgXWL9.cRLO6TgBCeauyWFRzG0yYXoIH726Ua4UceQaJi4zAEG',1,'0:0:0:0:0:0:0:1','','2024-12-08 01:55:35','2024-12-10 00:54:16','2024-12-10 00:54:16'),(1015,1025,'teacher1','$2a$10$ji8ONSKeVIrv3Oln8fNLVOJ7SWHHPD8jDxc82elsjhx0zsERM8b7m',1,'0:0:0:0:0:0:0:1','','2024-12-08 01:56:21','2024-12-09 02:44:15','2024-12-09 02:44:15'),(1016,1026,'instructor2','$2a$10$/rK3.rJ79drSwriLXCtjNehsSu42MQuO3Apv5DS8H45FSljLSYyIO',1,'0:0:0:0:0:0:0:1','','2024-12-08 01:57:50','2024-12-10 00:52:51','2024-12-10 00:52:51'),(1017,1027,'student2','$2a$10$0YaSuqbKi2unBqSsQSfLyOWe.ZfUB38PcV2Uv/p5cefXF7uHpFd52',1,'0:0:0:0:0:0:0:1','','2024-12-09 19:28:57','2024-12-10 00:51:13','2024-12-10 00:51:13'),(1018,1028,'demo_instructor','$2a$10$ExNFZZszkA9m6aSI6sQYo.Z1XFN2qJfTHnOlgv7UT6XK7rh0anj1e',1,'0:0:0:0:0:0:0:1','','2024-12-10 00:54:59','2024-12-10 23:12:05','2024-12-10 23:12:05'),(1019,1029,'demo_student1','$2a$10$i.igr22vt5gJPASxZy/A6u2YlUiH0agWqqTMe/EfNgwNzuEIL7uf2',1,'0:0:0:0:0:0:0:1','','2024-12-10 01:04:44','2024-12-10 17:12:20','2024-12-10 17:12:20'),(1020,1030,'demo_student2','$2a$10$NyC3LfEYjSTgPOZuUMrvreZwHip5uZNVLDLLFMsv4ifTWNKRrQDBG',1,'0:0:0:0:0:0:0:1','','2024-12-10 01:05:23','2024-12-10 11:03:25','2024-12-10 11:03:25'),(1021,1031,'demo_student3','$2a$10$NU7KS2dLxwOio/Z6C9Pan.rwBPo89qfaHqQWLQg/XRsLnlpCp8BuS',1,'0:0:0:0:0:0:0:1','','2024-12-10 01:05:53','2024-12-10 11:21:58','2024-12-10 11:21:58'),(1022,1032,'demo_student4','$2a$10$.hECjIQqVwtMAg0h0zbzxePeuzRFt6.g3P1Sd7SBpc3fr21bEr5ZW',1,NULL,NULL,'2024-12-10 01:06:12',NULL,NULL),(1023,1033,'demo_student5','$2a$10$nkccdW1C44q8HInCm7vY3OYSFmjAIjgF0dONWZqffM0fGZkNiJQwC',1,'0:0:0:0:0:0:0:1','','2024-12-10 01:06:29','2024-12-10 11:15:27','2024-12-10 11:15:27'),(1024,1034,'demo_student9','$2a$10$ajVzPp4xIKJIlFZruAZUK.wGCOWmuxFZ19A5evGGye/KBkQ3RcZk2',1,'0:0:0:0:0:0:0:1','','2024-12-10 01:11:48','2024-12-10 11:17:38','2024-12-10 11:17:38'),(1025,1035,'demo_student10','$2a$10$ieUdkVsQpc4fmKxePZD.SOwjPDrGRUOteGACl1PDJIPM6iD1GY8yG',1,'0:0:0:0:0:0:0:1','','2024-12-10 01:31:01','2024-12-10 17:12:51','2024-12-10 17:12:51'),(1026,1036,'demo_student11','$2a$10$wyZnGUq4pGX2NINGDzpjmOjJEd4FZ5FP/qJUv/rpln.JNtUIGJOXu',1,'0:0:0:0:0:0:0:1','','2024-12-10 02:20:36','2024-12-10 02:21:42','2024-12-10 02:20:50'),(1027,1037,'demo_student12','$2a$10$xN8Oh1xnRB2RGVheR7omy.73IqYl6nVwPCjVOr44KRP1IBXJ2WlRW',1,'0:0:0:0:0:0:0:1','','2024-12-10 02:47:33','2024-12-10 02:58:12','2024-12-10 02:58:12'),(1028,1038,'xxx','$2a$10$6cSyYv2FwOUo1fVO8MLfVO/ws/lA0DrmfzwZxfZEOVNYzKrzvyxl2',1,'0:0:0:0:0:0:0:1','','2024-12-10 10:33:29','2024-12-10 10:33:35','2024-12-10 10:33:35'),(1029,1039,'demo_student20','$2a$10$3l8tf/QO1T49UEHEP00cJuCDMS4ALSIlI60sfEGUZU0XLmnb9Z8GO',1,'0:0:0:0:0:0:0:1','','2024-12-10 23:02:07','2024-12-10 23:02:20','2024-12-10 23:02:19'),(1030,1040,'demo_student21','$2a$10$LNpSElf5eJNxqp8kVSO31O1CC6KmhEl7WYicu5ziVmF6aZUPqxYVW',1,'0:0:0:0:0:0:0:1','','2024-12-10 23:06:17','2024-12-10 23:17:05','2024-12-10 23:17:04');
/*!40000 ALTER TABLE `tb_user_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_info`
--

DROP TABLE IF EXISTS `tb_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `avatar` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_disable` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1041 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_info`
--

LOCK TABLES `tb_user_info` WRITE;
/*!40000 ALTER TABLE `tb_user_info` DISABLE KEYS */;
INSERT INTO `tb_user_info` VALUES (1,'admin','admin','','','12345678910',0,'2024-11-15 13:23:17','2024-11-15 13:23:57'),(1022,'a@a.com','USER1862709578139975682','',NULL,NULL,0,'2024-11-29 23:05:46',NULL),(1023,'b@b.com','USER1862709916993601538','',NULL,NULL,0,'2024-11-29 23:07:06',NULL),(1024,'student1','USER1865651419227398146','',NULL,NULL,0,'2024-12-08 01:55:35',NULL),(1025,'teacher1','USER1865651612345737217','',NULL,NULL,0,'2024-12-08 01:56:21',NULL),(1026,'instructor2','name','',NULL,NULL,0,'2024-12-08 01:57:50','2024-12-10 00:53:03'),(1027,'student2','USER1866278896461455362','',NULL,NULL,0,'2024-12-09 19:28:57',NULL),(1028,'demo_instructor','Teacher','',NULL,NULL,0,'2024-12-10 00:54:59','2024-12-10 23:08:46'),(1029,'demo_student1','USER1866363398959198209','',NULL,NULL,0,'2024-12-10 01:04:44',NULL),(1030,'demo_student2','USER1866363560880304130','',NULL,NULL,0,'2024-12-10 01:05:23',NULL),(1031,'demo_student3','USER1866363688202596354','',NULL,NULL,0,'2024-12-10 01:05:53',NULL),(1032,'demo_student4','USER1866363764656369666','',NULL,NULL,0,'2024-12-10 01:06:12',NULL),(1033,'demo_student5','USER1866363838828441602','',NULL,NULL,0,'2024-12-10 01:06:29',NULL),(1034,'demo_student9','jack','',NULL,NULL,0,'2024-12-10 01:11:48','2024-12-10 10:48:18'),(1035,'demo_student10','Cassie','',NULL,NULL,0,'2024-12-10 01:31:01','2024-12-10 01:32:48'),(1036,'demo_student11','Jack','',NULL,NULL,0,'2024-12-10 02:20:36','2024-12-10 02:21:28'),(1037,'demo_student12','Mike','',NULL,NULL,0,'2024-12-10 02:47:33','2024-12-10 02:48:52'),(1038,'xxx','USER1866506528872497154','',NULL,NULL,0,'2024-12-10 10:33:29',NULL),(1039,'demo_student20','USER1866694925639344129','',NULL,NULL,0,'2024-12-10 23:02:06',NULL),(1040,'demo_student21','Tom','',NULL,NULL,0,'2024-12-10 23:06:17','2024-12-10 23:07:19');
/*!40000 ALTER TABLE `tb_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role`
--

DROP TABLE IF EXISTS `tb_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1045 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role`
--

LOCK TABLES `tb_user_role` WRITE;
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;
INSERT INTO `tb_user_role` VALUES (1,1,1),(1026,1022,3),(1027,1023,2),(1028,1024,3),(1029,1025,2),(1030,1026,2),(1031,1027,3),(1032,1028,2),(1033,1029,3),(1034,1030,3),(1035,1031,3),(1036,1032,3),(1037,1033,3),(1038,1034,3),(1039,1035,3),(1040,1036,3),(1041,1037,3),(1042,1038,3),(1043,1039,3),(1044,1040,3);
/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-10 23:25:13
