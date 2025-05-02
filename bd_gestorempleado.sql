CREATE DATABASE  IF NOT EXISTS `bd_gestorempleado` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_gestorempleado`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_gestorempleado
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `areId` int NOT NULL AUTO_INCREMENT,
  `areNombre` varchar(100) DEFAULT NULL,
  `areSalario` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`areId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'CAJERO',1300.00),(2,'REPONEDOR',1600.00),(3,'VENDEDOR',1900.00),(4,'SUPERVISOR',2200.00),(5,'GERENTE',2500.00);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boleta`
--

DROP TABLE IF EXISTS `boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boleta` (
  `bolId` int NOT NULL AUTO_INCREMENT,
  `bolFechaEmision` date DEFAULT NULL,
  `bolMesPago` varchar(20) DEFAULT NULL,
  `bolImporteTotal` decimal(10,2) DEFAULT NULL,
  `bolempId` int DEFAULT NULL,
  `bolempreId` int DEFAULT NULL,
  PRIMARY KEY (`bolId`),
  KEY `bol_emp_idx` (`bolempId`),
  KEY `bol_empresa_idx` (`bolempreId`),
  CONSTRAINT `bol_empleado` FOREIGN KEY (`bolempId`) REFERENCES `empleado` (`empId`),
  CONSTRAINT `bol_empresa` FOREIGN KEY (`bolempreId`) REFERENCES `empresa` (`emprId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boleta`
--

LOCK TABLES `boleta` WRITE;
/*!40000 ALTER TABLE `boleta` DISABLE KEYS */;
/*!40000 ALTER TABLE `boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `conId` int NOT NULL AUTO_INCREMENT,
  `conEmpId` int NOT NULL,
  `conModContId` int NOT NULL,
  `conAreaId` int NOT NULL,
  `conJornId` int NOT NULL,
  `conFechaInicio` date DEFAULT NULL,
  `conFechaFin` date DEFAULT NULL,
  `conDiasTrabajo` int DEFAULT NULL,
  `conEstado` tinyint DEFAULT NULL,
  PRIMARY KEY (`conId`),
  KEY `cont_mod_idx` (`conModContId`),
  KEY `cont_area_idx` (`conAreaId`),
  KEY `cont_jornda_idx` (`conJornId`),
  KEY `cont_emplea_idx` (`conEmpId`),
  CONSTRAINT `cont_area` FOREIGN KEY (`conAreaId`) REFERENCES `area` (`areId`),
  CONSTRAINT `cont_emplea` FOREIGN KEY (`conEmpId`) REFERENCES `empleado` (`empId`),
  CONSTRAINT `cont_jornda` FOREIGN KEY (`conJornId`) REFERENCES `jornada` (`jornId`),
  CONSTRAINT `cont_mod` FOREIGN KEY (`conModContId`) REFERENCES `mod_contrato` (`modconId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_boleta`
--

DROP TABLE IF EXISTS `detalle_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_boleta` (
  `detId` int NOT NULL AUTO_INCREMENT,
  `detboId` int DEFAULT NULL,
  `detTipoMonto` varchar(50) DEFAULT NULL,
  `detDescrip` varchar(65) DEFAULT NULL,
  `detMonto` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`detId`),
  KEY `detbol_idbol_idx` (`detboId`),
  CONSTRAINT `detbol_idbol` FOREIGN KEY (`detboId`) REFERENCES `boleta` (`bolId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_boleta`
--

LOCK TABLES `detalle_boleta` WRITE;
/*!40000 ALTER TABLE `detalle_boleta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `empId` int NOT NULL AUTO_INCREMENT,
  `empDni` varchar(8) NOT NULL,
  `empApellPaterno` varchar(50) DEFAULT NULL,
  `empApellMaterno` varchar(50) DEFAULT NULL,
  `empNombres` varchar(100) DEFAULT NULL,
  `empGenero` enum('F','M') DEFAULT NULL,
  `empCorreo` varchar(100) DEFAULT NULL,
  `empFechaNacimiento` date DEFAULT NULL,
  `empEstado` tinyint DEFAULT NULL,
  PRIMARY KEY (`empId`),
  UNIQUE KEY `empDni_UNIQUE` (`empDni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'72276974','JARA','CARDENAS','JHON ERICK','M','jaracardenasj74@gmail.com','2003-08-03',1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `emprId` int NOT NULL AUTO_INCREMENT,
  `emprRuc` varchar(20) DEFAULT NULL,
  `emprNombre` varchar(60) DEFAULT NULL,
  `emprDireccion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`emprId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jornada`
--

DROP TABLE IF EXISTS `jornada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jornada` (
  `jornId` int NOT NULL AUTO_INCREMENT,
  `jornTipo` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`jornId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jornada`
--

LOCK TABLES `jornada` WRITE;
/*!40000 ALTER TABLE `jornada` DISABLE KEYS */;
/*!40000 ALTER TABLE `jornada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mod_contrato`
--

DROP TABLE IF EXISTS `mod_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mod_contrato` (
  `modconId` int NOT NULL AUTO_INCREMENT,
  `modcontipo` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`modconId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mod_contrato`
--

LOCK TABLES `mod_contrato` WRITE;
/*!40000 ALTER TABLE `mod_contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `mod_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `usuCod` varchar(8) NOT NULL,
  `usuPass` varchar(45) NOT NULL,
  `usuEmpId` int DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `usuCod_UNIQUE` (`usuCod`),
  KEY `usu_emp_idx` (`usuEmpId`),
  CONSTRAINT `usu_emp` FOREIGN KEY (`usuEmpId`) REFERENCES `empleado` (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_gestorempleado'
--

--
-- Dumping routines for database 'bd_gestorempleado'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-02 12:35:21
