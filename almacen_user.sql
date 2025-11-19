-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: almacen
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `no` varchar(20) DEFAULT NULL COMMENT 'cuenta',
  `name` varchar(100) NOT NULL COMMENT 'nombre',
  `password` varchar(20) NOT NULL COMMENT 'contraseña',
  `age` int DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT 'sexo',
  `phone` varchar(20) DEFAULT NULL COMMENT 'movil',
  `role_id` int DEFAULT NULL COMMENT 'role0SuperAdmin，1Admin，2Usuario',
  `isValid` varchar(4) DEFAULT 'Y' COMMENT 'esValido，Y Valido，Los demas no validos',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sa','yifei',' 123',16,1,'12345',0,'Y'),(2,'adaf','yifei2','21421321',17,1,'12345678',1,'Y'),(3,'weqdsa','eada','21314131',19,2,'21341321',2,'Y'),(4,'U001','Carlos García','pass123',28,1,'612345678',0,'Y'),(5,'U002','María López','pass456',32,2,'623456789',1,'Y'),(6,'U003','Juan Martínez','pass789',25,1,'634567890',2,'Y'),(7,'U004','Ana Rodríguez','abc123',29,2,'645678901',2,'Y'),(8,'U005','Pedro Sánchez','qwerty',35,1,'656789012',1,'Y'),(9,'U006','Laura Fernández','password1',27,2,'667890123',2,'Y'),(10,'U007','Miguel Torres','secure123',31,1,'678901234',2,'Y'),(11,'U008','Carmen Ruiz','mypass',26,2,'689012345',2,'N'),(12,'U009','David González','pass2023',33,1,'690123456',1,'Y'),(13,'U010','Isabel Díaz','letmein',30,2,'601234567',2,'Y'),(14,'U011','José Pérez','admin123',40,1,'612345679',0,'Y'),(15,'U012','Lucía Moreno','lucia2023',24,2,'623456780',2,'Y'),(16,'U013','Antonio Jiménez','antonio99',38,1,'634567891',2,'Y'),(17,'U014','Rosa Álvarez','rosa456',28,2,'645678902',2,'N'),(18,'U015','Francisco Romero','paco123',36,1,'656789013',1,'Y'),(19,'U016','Elena Navarro','elena789',29,2,'667890124',2,'Y'),(20,'U017','Manuel Serrano','manuel01',34,1,'678901235',2,'Y'),(21,'U018','Patricia Blanco','patri123',27,2,'689012346',2,'Y'),(22,'U019','Javier Castro','javi2023',31,1,'690123457',2,'N'),(23,'U020','Marta Ortiz','marta456',25,2,'601234568',2,'Y'),(24,'asdad','asdafa','2131421321',12,0,'231141312',0,'Y'),(25,'adaf','adasf','2341321',12,0,'2312413213',0,'Y'),(26,'fff','fff123','2131413',12,0,'21314123123',1,'Y');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-19 20:56:39
