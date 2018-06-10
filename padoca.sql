-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: padaria-java
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `Fornecedor_Id` int(11) NOT NULL AUTO_INCREMENT,
  `CNPJ` varchar(255) DEFAULT NULL,
  `TELEFONE` varchar(255) DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `NOMEFANTASIA` varchar(255) DEFAULT NULL,
  `RAZAOSOCIAL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Fornecedor_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'47.232.097/0001-21','(11)1111-1111','Rua Pao de batata 4532','Vilma','Vilma Massas SA'),(2,'84.586.176/0001-67','(12)2222-2222','Rua Abpilio Machado 454','Avivar','Granja Avivar SA'),(3,'51.205.639/0001-44','(33)3333-3333','Rua Francisco Neves 5345','Cemil','Cemil SA'),(4,'56.033.227/0001-98','(44)4444-4444','Rua E 278','Farinha','Farinha SA'),(5,'70.436.091/0001-98','(23)2323-1412','Rua Governador 3452','Coca-Cola','Coca-Cola SA'),(6,'07.108.554/0001-56','(23)1231-2141','Br 354 km6','Fazendinha Queijos','Fazendinha SA');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(31) DEFAULT NULL,
  `IDADE` int(11) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  `DATAADMISSÃO` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Adm',29,'Vitor','vitor','123',NULL),(2,'Vendedor',30,'Carlos','carlos','123','2018-01-05'),(3,'Vendedor',20,'Joao','jao','1234','2018-05-08'),(4,'Vendedor',20,'Pedro','Pedroza','123456','2018-05-08'),(6,'Vendedor',28,'Joaquim','joaquim','123','2018-05-16'),(7,'Adm',25,'Maria','mariazoia','Paodebatata',NULL),(8,'Adm',60,'Dono Da padoca','joseph','GOD',NULL);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemproducao`
--

DROP TABLE IF EXISTS `itemproducao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemproducao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QTDE` int(11) NOT NULL,
  `codProduto` int(11) DEFAULT NULL,
  `Cod_producao` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ITEMPRODUCAO_Cod_producao` (`Cod_producao`),
  KEY `FK_ITEMPRODUCAO_codProduto` (`codProduto`),
  CONSTRAINT `FK_ITEMPRODUCAO_Cod_producao` FOREIGN KEY (`Cod_producao`) REFERENCES `producao` (`Producao_Id`),
  CONSTRAINT `FK_ITEMPRODUCAO_codProduto` FOREIGN KEY (`codProduto`) REFERENCES `produto` (`Prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemproducao`
--

LOCK TABLES `itemproducao` WRITE;
/*!40000 ALTER TABLE `itemproducao` DISABLE KEYS */;
INSERT INTO `itemproducao` VALUES (1,2,2,1),(2,1,1,1),(3,10,1,2),(4,5,2,2),(5,5,1,3),(6,15,2,3),(7,10,1,4),(8,5,1,5),(9,50,1,6),(10,6,7,7),(11,5,1,7),(14,100,7,10),(15,100,7,11);
/*!40000 ALTER TABLE `itemproducao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens`
--

DROP TABLE IF EXISTS `itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QTDE` int(11) NOT NULL,
  `codMateria` int(11) DEFAULT NULL,
  `codProduto` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ITENS_codProduto` (`codProduto`),
  KEY `FK_ITENS_codMateria` (`codMateria`),
  CONSTRAINT `FK_ITENS_codMateria` FOREIGN KEY (`codMateria`) REFERENCES `materia_prima` (`Materia_Id`),
  CONSTRAINT `FK_ITENS_codProduto` FOREIGN KEY (`codProduto`) REFERENCES `produto` (`Prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens`
--

LOCK TABLES `itens` WRITE;
/*!40000 ALTER TABLE `itens` DISABLE KEYS */;
INSERT INTO `itens` VALUES (1,1,1,1),(2,1,4,1),(3,1,3,1),(4,1,2,1),(5,1,6,2),(6,1,3,2),(7,1,4,2),(8,1,1,2),(9,1,4,7),(10,1,3,7),(11,3,1,7),(12,1,5,7);
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia_prima`
--

DROP TABLE IF EXISTS `materia_prima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia_prima` (
  `Materia_Id` int(11) NOT NULL AUTO_INCREMENT,
  `ESTOQUE` float DEFAULT NULL,
  `ESTOQUE_MIN` float DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PRECO` float DEFAULT NULL,
  `codFornecedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`Materia_Id`),
  KEY `FK_MATERIA_PRIMA_codFornecedor` (`codFornecedor`),
  CONSTRAINT `FK_MATERIA_PRIMA_codFornecedor` FOREIGN KEY (`codFornecedor`) REFERENCES `fornecedor` (`Fornecedor_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia_prima`
--

LOCK TABLES `materia_prima` WRITE;
/*!40000 ALTER TABLE `materia_prima` DISABLE KEYS */;
INSERT INTO `materia_prima` VALUES (1,1200,12,'Ovos',3.5,2),(2,150,25,'Massa Pronta p/ Bolos - Abacaxi',2.3,1),(3,120,10,'Farinha',5,4),(4,1500,100,'Leite Desnatado 1L',2.5,3),(5,150,120,'Queijo Minas',5,6),(6,200,30,'Massa Pronta P/ Bola - Limão',5,1);
/*!40000 ALTER TABLE `materia_prima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producao`
--

DROP TABLE IF EXISTS `producao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producao` (
  `Producao_Id` int(11) NOT NULL AUTO_INCREMENT,
  `DATAPRODUCAO` date DEFAULT NULL,
  PRIMARY KEY (`Producao_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producao`
--

LOCK TABLES `producao` WRITE;
/*!40000 ALTER TABLE `producao` DISABLE KEYS */;
INSERT INTO `producao` VALUES (1,'0018-05-18'),(2,'0018-05-18'),(3,'0018-05-18'),(4,'0018-05-20'),(5,'0018-06-09'),(6,'0018-06-09'),(7,'0018-06-09'),(10,'0018-06-10'),(11,'2018-06-10');
/*!40000 ALTER TABLE `producao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `Prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(31) DEFAULT NULL,
  `ESTOQUE` int(11) DEFAULT NULL,
  `ESTOQUEMIN` int(11) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PRECOCUSTO` float DEFAULT NULL,
  `PRECOVENDA` float DEFAULT NULL,
  PRIMARY KEY (`Prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Produto_Produzido',45,10,'bolo abacaxi',13.3,10),(2,'Produto_Produzido',0,10,'bolo de limao',16,10),(3,'Produtos_Terceiros',247,120,'Coca-Cola 3L',5,7.8),(4,'Produtos_Terceiros',290,100,'Coca-Cola 1,5L',2,5.3),(5,'Produtos_Terceiros',990,100,'Queijo Trançado',2.5,4.75),(6,'Produtos_Terceiros',300,100,'Leite Desnatado 1L',1,2.69),(7,'Produto_Produzido',186,100,'Pão de queijo',23,25);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoproduzido`
--

DROP TABLE IF EXISTS `produtoproduzido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtoproduzido` (
  `Prod_id` int(11) NOT NULL,
  PRIMARY KEY (`Prod_id`),
  CONSTRAINT `FK_PRODUTOPRODUZIDO_Prod_id` FOREIGN KEY (`Prod_id`) REFERENCES `produto` (`Prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoproduzido`
--

LOCK TABLES `produtoproduzido` WRITE;
/*!40000 ALTER TABLE `produtoproduzido` DISABLE KEYS */;
INSERT INTO `produtoproduzido` VALUES (1),(2),(7);
/*!40000 ALTER TABLE `produtoproduzido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoterceiros`
--

DROP TABLE IF EXISTS `produtoterceiros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtoterceiros` (
  `Prod_id` int(11) NOT NULL,
  `Fornecedor_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Prod_id`),
  KEY `FK_PRODUTOTERCEIROS_Fornecedor_Id` (`Fornecedor_Id`),
  CONSTRAINT `FK_PRODUTOTERCEIROS_Fornecedor_Id` FOREIGN KEY (`Fornecedor_Id`) REFERENCES `fornecedor` (`Fornecedor_Id`),
  CONSTRAINT `FK_PRODUTOTERCEIROS_Prod_id` FOREIGN KEY (`Prod_id`) REFERENCES `produto` (`Prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoterceiros`
--

LOCK TABLES `produtoterceiros` WRITE;
/*!40000 ALTER TABLE `produtoterceiros` DISABLE KEYS */;
INSERT INTO `produtoterceiros` VALUES (6,3),(3,5),(4,5),(5,6);
/*!40000 ALTER TABLE `produtoterceiros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `Venda_Id` int(11) NOT NULL AUTO_INCREMENT,
  `DATAVENDA` date DEFAULT NULL,
  `PRECOVENDA` float DEFAULT NULL,
  `codVendedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`Venda_Id`),
  KEY `FK_VENDA_codVendedor` (`codVendedor`),
  CONSTRAINT `FK_VENDA_codVendedor` FOREIGN KEY (`codVendedor`) REFERENCES `funcionario` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,'2018-05-17',17.99,1),(2,'2018-05-20',15.6,1),(11,'2018-05-21',78,1),(12,'2018-05-21',53,1),(13,'2018-05-21',78,1),(14,'2018-05-21',78,1),(15,'2018-05-21',23.75,1),(16,'2018-05-21',13.45,1),(17,'2018-05-21',39,1),(18,'2018-05-21',78,1),(19,'2018-05-21',78,1),(20,'2018-05-21',95,1),(21,'2018-05-21',39,1),(22,'2018-05-21',39,1),(23,'2018-05-22',39,1),(25,'2018-05-22',26.5,1),(26,'2018-05-22',269,1),(27,'2018-05-22',134.5,1),(28,'2018-05-22',47.5,1),(29,'2018-05-22',53,1),(30,'2018-05-22',23.75,1),(31,'2018-05-22',26.5,1),(32,'2018-05-22',390,1),(33,'2018-05-22',265,1),(34,'2018-05-22',237.5,1),(35,'2018-06-08',39,1),(36,'2018-06-08',151.4,1),(37,'2018-06-09',0,1),(38,'2018-06-09',23.4,1),(39,'2018-06-09',53,1),(40,'2018-06-09',47.5,1),(41,'2018-06-09',257.8,1),(42,'2018-06-09',234,3),(43,'2018-06-09',307.8,1);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendaproduto`
--

DROP TABLE IF EXISTS `vendaproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendaproduto` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `QTDE` int(11) NOT NULL,
  `VALOR` float DEFAULT NULL,
  `codProduto` int(11) DEFAULT NULL,
  `codVenda` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  KEY `FK_VENDAPRODUTO_codVenda` (`codVenda`),
  KEY `FK_VENDAPRODUTO_codProduto` (`codProduto`),
  CONSTRAINT `FK_VENDAPRODUTO_codProduto` FOREIGN KEY (`codProduto`) REFERENCES `produto` (`Prod_id`),
  CONSTRAINT `FK_VENDAPRODUTO_codVenda` FOREIGN KEY (`codVenda`) REFERENCES `venda` (`Venda_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendaproduto`
--

LOCK TABLES `vendaproduto` WRITE;
/*!40000 ALTER TABLE `vendaproduto` DISABLE KEYS */;
INSERT INTO `vendaproduto` VALUES (1,1,10,1,1),(2,1,5.3,4,1),(3,1,2.69,6,1),(4,2,7.8,3,2),(13,10,7.8,3,11),(14,10,5.3,4,12),(15,10,7.8,3,13),(16,10,7.8,3,14),(17,5,4.75,5,15),(18,5,2.69,6,16),(19,5,7.8,3,17),(20,10,7.8,3,18),(21,10,7.8,3,19),(22,20,4.75,5,20),(23,5,7.8,3,21),(24,5,7.8,3,22),(25,5,7.8,3,23),(26,5,5.3,4,25),(27,100,2.69,6,26),(28,50,2.69,6,27),(29,10,4.75,5,28),(30,10,5.3,4,29),(31,5,4.75,5,30),(32,5,5.3,4,31),(33,50,7.8,3,32),(34,50,5.3,4,33),(35,50,4.75,5,34),(36,5,7.8,3,35),(37,5,10,1,36),(38,13,7.8,3,36),(39,3,7.8,3,38),(40,10,5.3,4,39),(41,10,4.75,5,40),(42,1,7.8,3,41),(43,10,25,7,41),(44,30,7.8,3,42),(45,10,25,7,43),(46,5,10,1,43),(47,1,7.8,3,43);
/*!40000 ALTER TABLE `vendaproduto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-10 11:00:17
