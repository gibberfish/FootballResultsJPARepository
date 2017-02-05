CREATE DATABASE  IF NOT EXISTS `football` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `football`;

--
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season` (
  `ssn_num` int(4) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ssn_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2017 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `division` (
  `div_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `div_name` varchar(255) NOT NULL,
  PRIMARY KEY (`div_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Table structure for table `season_division`
--

DROP TABLE IF EXISTS `season_division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `season_division` (
  `ssn_num` int(4) unsigned NOT NULL,
  `div_id` int(10) unsigned NOT NULL,
  `div_pos` tinyint(2) unsigned NOT NULL,
  PRIMARY KEY (`ssn_num`,`div_id`),
  KEY `fk_ssndiv_div_idx` (`div_id`),
  KEY `fk_ssndiv_ssn_idx` (`ssn_num`),
  CONSTRAINT `fk_ssndiv_ssn` FOREIGN KEY (`ssn_num`) REFERENCES `season` (`ssn_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ssndiv_div` FOREIGN KEY (`div_id`) REFERENCES `division` (`div_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
