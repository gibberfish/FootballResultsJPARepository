CREATE DATABASE  IF NOT EXISTS `football` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `football`;
-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: football
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `division` (
  `div_id` int(2) NOT NULL AUTO_INCREMENT,
  `div_name` varchar(50) COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`div_id`),
  UNIQUE KEY `div_name` (`div_name`)
) ENGINE=InnoDB AUTO_INCREMENT=754 DEFAULT CHARSET=latin1 COLLATE=latin1_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `division_mapping`
--

DROP TABLE IF EXISTS `division_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `division_mapping` (
  `dialect` varchar(10) NOT NULL,
  `source_id` int(11) NOT NULL,
  `fra_id` int(11) NOT NULL,
  PRIMARY KEY (`dialect`,`source_id`,`fra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `eos_league_table`
--

DROP TABLE IF EXISTS `eos_league_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eos_league_table` (
  `ssn_num` int(11) NOT NULL,
  `div_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `played` int(11) DEFAULT NULL,
  `wh` int(11) DEFAULT NULL,
  `dh` int(11) DEFAULT NULL,
  `lh` int(11) DEFAULT NULL,
  `fh` int(11) DEFAULT NULL,
  `ah` int(11) DEFAULT NULL,
  `wa` int(11) DEFAULT NULL,
  `da` int(11) DEFAULT NULL,
  `la` int(11) DEFAULT NULL,
  `fa` int(11) DEFAULT NULL,
  `aa` int(11) DEFAULT NULL,
  `gd` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `eos_league_tablecol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ssn_num`,`div_id`,`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fixture`
--

DROP TABLE IF EXISTS `fixture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fixture` (
  `fixture_id` int(10) NOT NULL AUTO_INCREMENT,
  `ssn_num` int(10) NOT NULL,
  `home_team_id` int(10) NOT NULL,
  `away_team_id` int(10) NOT NULL,
  `fixture_date` date DEFAULT NULL,
  `div_id` int(10) DEFAULT NULL,
  `home_goals` tinyint(2) DEFAULT NULL,
  `away_goals` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`fixture_id`),
  UNIQUE KEY `ssn_num_home_team_id_away_team_id_fixture_date` (`ssn_num`,`home_team_id`,`away_team_id`,`fixture_date`),
  KEY `fixture_h_tm_fk` (`home_team_id`),
  KEY `fixture_a_tm_fk` (`away_team_id`),
  KEY `fixture_div_fk` (`div_id`),
  CONSTRAINT `fixture_a_tm_fk` FOREIGN KEY (`away_team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `fixture_div_fk` FOREIGN KEY (`div_id`) REFERENCES `division` (`div_id`),
  CONSTRAINT `fixture_h_tm_fk` FOREIGN KEY (`home_team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `fixture_ssn_fk` FOREIGN KEY (`ssn_num`) REFERENCES `season` (`ssn_num`)
) ENGINE=InnoDB AUTO_INCREMENT=412529 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season` (
  `ssn_num` int(4) NOT NULL,
  PRIMARY KEY (`ssn_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `season_division`
--

DROP TABLE IF EXISTS `season_division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season_division` (
  `ssn_num` int(10) NOT NULL,
  `div_id` int(10) NOT NULL,
  `div_pos` tinyint(2) NOT NULL,
  PRIMARY KEY (`ssn_num`,`div_id`),
  KEY `ssn_div_div_fk` (`div_id`),
  CONSTRAINT `ssn_div_div_fk` FOREIGN KEY (`div_id`) REFERENCES `division` (`div_id`),
  CONSTRAINT `ssn_div_ssn_fk` FOREIGN KEY (`ssn_num`) REFERENCES `season` (`ssn_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `season_division_team`
--

DROP TABLE IF EXISTS `season_division_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season_division_team` (
  `ssn_num` int(10) NOT NULL,
  `div_id` int(10) NOT NULL,
  `team_id` int(10) NOT NULL,
  PRIMARY KEY (`ssn_num`,`div_id`,`team_id`),
  KEY `ssn_div_tm_tm_fk` (`team_id`),
  CONSTRAINT `ssn_div_tm_ssn_div_fk` FOREIGN KEY (`ssn_num`, `div_id`) REFERENCES `season_division` (`ssn_num`, `div_id`),
  CONSTRAINT `ssn_div_tm_tm_fk` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `team_id` int(10) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `team_short_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE KEY `team_name` (`team_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1302 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_mapping`
--

DROP TABLE IF EXISTS `team_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_mapping` (
  `dialect` varchar(10) NOT NULL,
  `source_id` int(11) NOT NULL,
  `fra_id` int(11) NOT NULL,
  PRIMARY KEY (`dialect`,`source_id`,`fra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_statistic`
--

DROP TABLE IF EXISTS `team_statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_statistic` (
  `ssn_num` int(10) NOT NULL,
  `div_id` int(10) NOT NULL,
  `team_id` int(10) NOT NULL,
  `fixture_date` date NOT NULL,
  `statistic` varchar(30) NOT NULL,
  `value` int(10) NOT NULL,
  PRIMARY KEY (`ssn_num`,`div_id`,`team_id`,`fixture_date`,`statistic`),
  KEY `team_statistic_ssn_div_tm_fk` (`ssn_num`,`div_id`,`team_id`),
  CONSTRAINT `team_statistic_ssn_div_tm_fk` FOREIGN KEY (`ssn_num`, `div_id`, `team_id`) REFERENCES `season_division_team` (`ssn_num`, `div_id`, `team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tracked_division`
--

DROP TABLE IF EXISTS `tracked_division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tracked_division` (
  `dialect` varchar(10) NOT NULL,
  `source_id` int(11) NOT NULL,
  PRIMARY KEY (`dialect`,`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04  3:51:06
