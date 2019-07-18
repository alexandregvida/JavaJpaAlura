-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: financas
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Movimentacao_Categoria`
--

DROP TABLE IF EXISTS `Movimentacao_Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movimentacao_Categoria` (
  `Movimentacao_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  KEY `FK9qjlgh7a96gx1ks359va1na9a` (`categoria_id`),
  KEY `FK8c4hm7qt4jdk4xcglplf5dyy7` (`Movimentacao_id`),
  CONSTRAINT `FK8c4hm7qt4jdk4xcglplf5dyy7` FOREIGN KEY (`Movimentacao_id`) REFERENCES `Movimentacao` (`id`),
  CONSTRAINT `FK9qjlgh7a96gx1ks359va1na9a` FOREIGN KEY (`categoria_id`) REFERENCES `Categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movimentacao_Categoria`
--

LOCK TABLES `Movimentacao_Categoria` WRITE;
/*!40000 ALTER TABLE `Movimentacao_Categoria` DISABLE KEYS */;
INSERT INTO `Movimentacao_Categoria` VALUES (1,1),(1,2),(2,1),(2,2),(3,3),(3,4),(4,3),(4,4),(5,5),(5,6),(6,5),(6,6),(7,7),(7,8),(8,7),(8,8);
/*!40000 ALTER TABLE `Movimentacao_Categoria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-18 17:28:30
