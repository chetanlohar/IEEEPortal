/*
SQLyog Community v10.51 
MySQL - 5.5.11 : Database - db_ieee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_ieee` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_ieee`;

/*Table structure for table `tbl_chqdet` */

DROP TABLE IF EXISTS `tbl_chqdet`;

CREATE TABLE `tbl_chqdet` (
  `CLM_CHQID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_BANKNM` varchar(30) NOT NULL,
  `CLM_CHQTYPE` varchar(20) NOT NULL,
  `CLM_CHQNO` varchar(15) NOT NULL,
  `CLM_ISUDATE` date NOT NULL,
  `CLM_AMT` varchar(20) NOT NULL,
  `CLM_GRPID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_CHQID`),
  KEY `CONS_CHQDET_GRPID_FK` (`CLM_GRPID`),
  CONSTRAINT `CONS_CHQDET_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_chqdet` */

/*Table structure for table `tbl_citymst` */

DROP TABLE IF EXISTS `tbl_citymst`;

CREATE TABLE `tbl_citymst` (
  `CLM_CITYID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_CITYNM` varchar(20) NOT NULL DEFAULT 'OTHER',
  PRIMARY KEY (`CLM_CITYID`),
  UNIQUE KEY `UNIQUE` (`CLM_CITYNM`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_citymst` */

insert  into `tbl_citymst`(`CLM_CITYID`,`CLM_CITYNM`) values (5,'AHMADNAGAR '),(25,'AKOLA'),(14,'AMRAVATI'),(10,'AURANGABAD'),(36,'BARAMATI'),(19,'BEED'),(37,'BELGAUM'),(31,'BHANDARA'),(18,'BULDANA'),(21,'CHANDRAPUR'),(22,'DHULE'),(34,'GADCHIROLI '),(29,'GONDIYA '),(33,'HINGOLI '),(8,'JALGAON'),(23,'JALNA '),(9,'KOLHAPUR '),(20,'LATUR '),(12,'MUMBAI CITY'),(2,'MUMBAI SUBURBAN'),(4,'NAGPUR '),(11,'NANDED'),(27,'NANDURBAR '),(3,'NASHIK'),(26,'OSMANABAD'),(24,'PARBHANI'),(1,'PUNE'),(17,'RAIGARH '),(28,'RATNAGIRI'),(15,'SANGLI '),(13,'SATARA '),(35,'SINDHUDURG '),(6,'SOLAPUR'),(7,'THANE'),(30,'WARDHA '),(32,'WASHIM '),(16,'YAVATMAL ');

/*Table structure for table `tbl_clgmst` */

DROP TABLE IF EXISTS `tbl_clgmst`;

CREATE TABLE `tbl_clgmst` (
  `CLM_CLGID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_CLGNM` varchar(200) NOT NULL DEFAULT 'OTHER',
  `CLM_CLGADD` varchar(100) NOT NULL,
  PRIMARY KEY (`CLM_CLGID`),
  UNIQUE KEY `UNIQUE` (`CLM_CLGNM`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_clgmst` */

insert  into `tbl_clgmst`(`CLM_CLGID`,`CLM_CLGNM`,`CLM_CLGADD`) values (1,'BHARATI VIDYAPEETH UNIVERSITY COLLEGE OF ENGINEERING','PUNE'),(2,'MAAER\'S MAHARASHTRA INSTITUTE OF TECHNOLOGY (MIT) ','PUNE'),(3,'VIT - VISHWAKARMA INSTITUTE OF TECHNOLOGY','PUNE'),(4,'PUNE INSTITUTE OF COMPUTER TECHNOLOGY (PICT)','PUNE'),(5,'D.Y. PATIL COLLEGE OF ENGINEERING','AKURDI'),(6,'SMT. KASHIBAI NAVALE COLLEGE OF ENGINEERING','PUNE'),(7,'CUMMINS COLLEGE OF ENGINEERING FOR WOMEN','PUNE'),(8,'MIT COLLEGE OF ENGINEERING','PUNE'),(9,'PUNE VIDHYARTHI GRIHA\'S COLLEGE OF ENGINEERING AND TECHNOLOGY','PUNE (PVG COET)'),(10,'BHARATI VIDYAPEETH\'S COLLEGE OF ENGINEERING FOR WOMEN','PUNE'),(11,'ALL INDIA SHRI SHIVAJI MEMORIAL SOCIETY’S INSTITUTE OF INFORMATION TECHNOLOGY','PUNE'),(12,'INDIRA COLLEGE OF ENGINEERING & MANAGEMENT','PARANDWADI, PUNE'),(13,'P.E.S. MODERN COLLEGE OF ENGINEERING','PUNE'),(14,'SYMBIOSIS INSTITUTE OF TECHNOLOGY ( SIT )','LAVALE, PUNE'),(15,'PIMPRI CHINCHWAD EDUCATION TRUST\'S PIMPRI CHINCHWAD COLLEGE OF ENGINEERING','PIMPRI-CHINCHWAD, PUNE'),(16,'DR. D. Y. PATIL VIDYA PRATISHTHAN SOCIETY\'S PADMASHREE DR. D.Y. PATIL INSTITUTE OF ENGINEERING & TECHNOLOGY','PIMPRI, PUNE'),(17,'JSPM\'S JAYAWANTRAO SAWANT COLLEGE OF ENGINEERING','PUNE'),(18,'GENBA SOPANRAO MOZE COLLEGE OF ENGINEERING','PUNE'),(19,'PARVATIBAI GENBA MOZE COLLEGE OF ENGINEERING','PUNE'),(20,'G.H. RAISONI COLLEGE OF ENGINEERING & MANAGEMENT (GHRCE&M)','WAGHOLI, PUNE'),(21,'MAE - MAHARASHTRA ACADEMY OF ENGINEERING','PUNE'),(22,'RAJARSHI SHAHU COLLEGE OF ENGINEERING (RSCOE)','PUNE'),(23,'SINHGAD ACADEMY OF ENGINEERING','KONDHWA, PUNE'),(24,'SINHGAD COLLEGE OF ENGINEERING','PUNE'),(25,'PUNE DISTRICT EDUCATION ASSOCIATION’S COLLEGE OF ENGINEERING','PUNE'),(26,'MAEER’S MAHARASHTRA ACADEMY OF ENGINEERING (MAE)','PUNE'),(27,'MODERN EDUCATION SOCIETY’S COLLEGE OF ENGINEERING','PUNE'),(28,'MAEER’S WOMENS ENGINEERING COLLEGE','PUNE'),(29,'VISHWAKARMA INSTITUTE OF INFORMATION TECHNOLOGY','PUNE'),(30,'MARATHWADA MITRA MANDAL\'S COLLEGE OF ENGINEERING','PUNE'),(31,'THE SHETKARI SHIKSHAN MANDAL\'S PADMABHOOSHAN VASANTDADA PATIL INSTITUTE OF TECHNOLOGY','PUNE'),(32,'JSPM\'S IMPERIAL COLLEGE OF ENGINEERING AND RESERARCH ','WAGHOLI, PUNE'),(33,'ZEAL EDUCATION SOCIETY\'S DNYANGANGA COLLEGE OF ENGINEERING & RESEARCH','NARHE, PUNE'),(34,'G.H. RAISONI INSTITUTE OF ENGINEERING & TECHNOLOGY','PUNE'),(35,'NUTAN MAHARASHTRA INSTITUTE OF ENGINEERING & TECHNOLOGY','TALEGAON DABHADE, PUNE'),(36,'STES’S SINHGED INSTITUTE OF TECHNOLOGY AND SCIENCE','NARHE, PUNE'),(37,'MARATHWADA MITRA MANDAL’S INSTITUTE OF TECHNOLOGY','PUNE'),(38,'DHOLE PATIL EDUCATION SOCIETY’S DHOLE PATIL COLLEGE OF ENGINEERING','PUNE'),(39,'TRINITY COLLEGE OF ENGINEERING AND RESEARCH','PUNE'),(40,'DR. D. Y. PATIL COLLEGE OF ENGINEERING','AMBI TALEGAON, PUNE'),(41,'TSSM\'S BHIVARABAI SAWANT COLLEGE OF ENGINEERING & RESEARCH','NARHE, PUNE'),(42,'BHIVARABAI SAWANT INSTITUTE OF TECHNOLOGY & RESEARCH (FOR WOMEN)','PUNE'),(43,'KJ COLLEGE OF ENGINEERING & MANAGEMENT RESEARCH','PUNE'),(44,'ALARD COLLEGE OF ENGINEERING & MANAGEMENT','PUNE');

/*Table structure for table `tbl_contmst` */

DROP TABLE IF EXISTS `tbl_contmst`;

CREATE TABLE `tbl_contmst` (
  `CLM_CONTID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_PHNO` varchar(15) NOT NULL,
  `CLM_EMLID` varchar(30) NOT NULL,
  PRIMARY KEY (`CLM_CONTID`),
  UNIQUE KEY `UNIQUE` (`CLM_PHNO`,`CLM_EMLID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_contmst` */

/*Table structure for table `tbl_docdet` */

DROP TABLE IF EXISTS `tbl_docdet`;

CREATE TABLE `tbl_docdet` (
  `CLM_DOCID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_DOC` varchar(200) NOT NULL COMMENT 'CONTAINS PATH',
  `CLM_DOCDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CLM_DOCTYPEID` int(11) NOT NULL,
  `CLM_PROJSUBID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_DOCID`),
  KEY `CONS_DOCDET_DOCJTYPEID_FK` (`CLM_DOCTYPEID`),
  KEY `CONS_DOCDET_PROJSUBID_FK` (`CLM_PROJSUBID`),
  CONSTRAINT `CONS_DOCDET_DOCJTYPEID_FK` FOREIGN KEY (`CLM_DOCTYPEID`) REFERENCES `tbl_doctypemst` (`CLM_DOCTYPEID`),
  CONSTRAINT `CONS_DOCDET_PROJSUBID_FK` FOREIGN KEY (`CLM_PROJSUBID`) REFERENCES `tbl_projsubdet` (`CLM_PROJSUBID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_docdet` */

/*Table structure for table `tbl_docsnddet` */

DROP TABLE IF EXISTS `tbl_docsnddet`;

CREATE TABLE `tbl_docsnddet` (
  `CLM_DOCID` int(11) NOT NULL DEFAULT '0',
  `CLM_GRPID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`CLM_DOCID`,`CLM_GRPID`),
  KEY `CONS_DOCSNDDET_GRPID_FK` (`CLM_GRPID`),
  CONSTRAINT `CONS_DOCSNDDET_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_docsnddet` */

/*Table structure for table `tbl_doctypemst` */

DROP TABLE IF EXISTS `tbl_doctypemst`;

CREATE TABLE `tbl_doctypemst` (
  `CLM_DOCTYPEID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_DOCTYPENM` varchar(30) NOT NULL DEFAULT 'OTHER',
  PRIMARY KEY (`CLM_DOCTYPEID`),
  UNIQUE KEY `UNIQUE` (`CLM_DOCTYPENM`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_doctypemst` */

insert  into `tbl_doctypemst`(`CLM_DOCTYPEID`,`CLM_DOCTYPENM`) values (1,'ABSTRACT'),(3,'PAPER'),(7,'REPORT'),(6,'SRS'),(2,'SYNOPSIS'),(5,'TEST CASES'),(4,'UML DIAGRAMS');

/*Table structure for table `tbl_dommst` */

DROP TABLE IF EXISTS `tbl_dommst`;

CREATE TABLE `tbl_dommst` (
  `CLM_DOMID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_DOMNM` varchar(50) NOT NULL DEFAULT 'OTHER',
  PRIMARY KEY (`CLM_DOMID`),
  UNIQUE KEY `UNIQUE` (`CLM_DOMNM`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_dommst` */

insert  into `tbl_dommst`(`CLM_DOMID`,`CLM_DOMNM`) values (1,'ANDROID'),(2,'CLOUD COMPUTING'),(8,'DATA COMPRESSION'),(3,'DATA MINING'),(4,'DIGITAL IMAGE PROCESSING'),(5,'HADOOP AND BIG DATA'),(6,'NETWORKING AND NETWORK SECURITY'),(7,'PARALLEL AND DISTRIBUTED SYSTEM');

/*Table structure for table `tbl_empattnmst` */

DROP TABLE IF EXISTS `tbl_empattnmst`;

CREATE TABLE `tbl_empattnmst` (
  `CLM_EMPLOGINID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_DATE` date NOT NULL,
  `CLM_LOGINTM` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CLM_LOGOUTTM` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`CLM_EMPLOGINID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_empattnmst` */

/*Table structure for table `tbl_empcontdet` */

DROP TABLE IF EXISTS `tbl_empcontdet`;

CREATE TABLE `tbl_empcontdet` (
  `CLM_CONTID` int(11) NOT NULL,
  `CLM_EMPID` int(11) NOT NULL,
  KEY `CONS_EMPCONTDET_CONTID_FK` (`CLM_CONTID`),
  KEY `CONS_EMPCONTDET_EMPID_FK` (`CLM_EMPID`),
  CONSTRAINT `CONS_EMPCONTDET_CONTID_FK` FOREIGN KEY (`CLM_CONTID`) REFERENCES `tbl_contmst` (`CLM_CONTID`),
  CONSTRAINT `CONS_EMPCONTDET_EMPID_FK` FOREIGN KEY (`CLM_EMPID`) REFERENCES `tbl_empdet` (`CLM_EMPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_empcontdet` */

/*Table structure for table `tbl_empdet` */

DROP TABLE IF EXISTS `tbl_empdet`;

CREATE TABLE `tbl_empdet` (
  `CLM_EMPID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_EMPNM` varchar(50) NOT NULL,
  `CLM_DESG` varchar(20) NOT NULL,
  `CLM_DOJ` date NOT NULL,
  `CLM_GENDER` char(1) NOT NULL,
  `CLM_USRID` int(11) NOT NULL,
  `CLM_MGRID` int(11) DEFAULT NULL,
  `CLM_EMPLOGINID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_EMPID`),
  UNIQUE KEY `CLM_USRID` (`CLM_USRID`),
  UNIQUE KEY `CLM_EMPLOGINID` (`CLM_EMPLOGINID`),
  UNIQUE KEY `CLM_MGRID` (`CLM_MGRID`),
  CONSTRAINT `CONS_EMPDET_EMPLOGINID_FK` FOREIGN KEY (`CLM_EMPLOGINID`) REFERENCES `tbl_empattnmst` (`CLM_EMPLOGINID`),
  CONSTRAINT `CONS_EMPDET_USRID_FK` FOREIGN KEY (`CLM_USRID`) REFERENCES `tbl_loginmst` (`CLM_USRID`),
  CONSTRAINT `SELFKEY` FOREIGN KEY (`CLM_MGRID`) REFERENCES `tbl_empdet` (`CLM_EMPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_empdet` */

/*Table structure for table `tbl_enqcontdet` */

DROP TABLE IF EXISTS `tbl_enqcontdet`;

CREATE TABLE `tbl_enqcontdet` (
  `CLM_CONTID` int(11) NOT NULL,
  `CLM_ENQNM` varchar(30) NOT NULL,
  `CLM_GENDR` char(1) NOT NULL COMMENT 'M/F',
  `CLM_ENQID` int(11) NOT NULL,
  KEY `CONS_ENQCONTDET_ENQID_FK` (`CLM_ENQID`),
  KEY `CONS_ENQCONTDET_CONTID_FK` (`CLM_CONTID`),
  CONSTRAINT `CONS_ENQCONTDET_CONTID_FK` FOREIGN KEY (`CLM_CONTID`) REFERENCES `tbl_contmst` (`CLM_CONTID`),
  CONSTRAINT `CONS_ENQCONTDET_ENQID_FK` FOREIGN KEY (`CLM_ENQID`) REFERENCES `tbl_enqdet` (`CLM_ENQID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_enqcontdet` */

/*Table structure for table `tbl_enqdet` */

DROP TABLE IF EXISTS `tbl_enqdet`;

CREATE TABLE `tbl_enqdet` (
  `CLM_ENQID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_ENQDATE` date NOT NULL,
  `CLM_TECH` varchar(15) NOT NULL,
  `CLM_REFID` int(11) NOT NULL,
  `CLM_TEAMSZ` int(11) NOT NULL,
  `CLM_CLGID` int(11) NOT NULL,
  `CLM_DOMID` int(11) NOT NULL,
  `CLM_CITYID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_ENQID`),
  KEY `CONS_ENQDET_CLGID_FK` (`CLM_CLGID`),
  KEY `CONS_ENQDET_DOMID_FK` (`CLM_DOMID`),
  KEY `CONS_ENQDET_CITYID_FK` (`CLM_CITYID`),
  KEY `CONS_ENQDET_REFID_FK` (`CLM_REFID`),
  CONSTRAINT `CONS_ENQDET_CITYID_FK` FOREIGN KEY (`CLM_CITYID`) REFERENCES `tbl_citymst` (`CLM_CITYID`),
  CONSTRAINT `CONS_ENQDET_CLGID_FK` FOREIGN KEY (`CLM_CLGID`) REFERENCES `tbl_clgmst` (`CLM_CLGID`),
  CONSTRAINT `CONS_ENQDET_DOMID_FK` FOREIGN KEY (`CLM_DOMID`) REFERENCES `tbl_dommst` (`CLM_DOMID`),
  CONSTRAINT `CONS_ENQDET_REFID_FK` FOREIGN KEY (`CLM_REFID`) REFERENCES `tbl_refmst` (`CLM_REFID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_enqdet` */

/*Table structure for table `tbl_enqprojdet` */

DROP TABLE IF EXISTS `tbl_enqprojdet`;

CREATE TABLE `tbl_enqprojdet` (
  `CLM_PROJSUBID` int(11) NOT NULL,
  `CLM_ENQID` int(11) NOT NULL,
  KEY `CONS_ENQPROJDET_PROJSUBID_FK` (`CLM_PROJSUBID`),
  KEY `CONS_ENQPROJDET_ENQID_FK` (`CLM_ENQID`),
  CONSTRAINT `CONS_ENQPROJDET_ENQID_FK` FOREIGN KEY (`CLM_ENQID`) REFERENCES `tbl_enqdet` (`CLM_ENQID`),
  CONSTRAINT `CONS_ENQPROJDET_PROJSUBID_FK` FOREIGN KEY (`CLM_PROJSUBID`) REFERENCES `tbl_projsubdet` (`CLM_PROJSUBID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_enqprojdet` */

/*Table structure for table `tbl_loginmst` */

DROP TABLE IF EXISTS `tbl_loginmst`;

CREATE TABLE `tbl_loginmst` (
  `CLM_USRID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_EMLID` varchar(30) NOT NULL,
  `CLM_USRPASS` varchar(15) NOT NULL,
  `CLM_USRROLE` varchar(10) NOT NULL,
  PRIMARY KEY (`CLM_USRID`),
  UNIQUE KEY `UNIQUE` (`CLM_EMLID`,`CLM_USRPASS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_loginmst` */

/*Table structure for table `tbl_projasgndet` */

DROP TABLE IF EXISTS `tbl_projasgndet`;

CREATE TABLE `tbl_projasgndet` (
  `CLM_PROJASGNID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_EMPID` int(11) NOT NULL,
  `CLM_DOASSN` date NOT NULL COMMENT 'DATE OF ASSIGN',
  `CLM_PROJSUBID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_PROJASGNID`),
  KEY `CONS_PROJASGNDET_EMPID_FK` (`CLM_EMPID`),
  KEY `CONS_PROJASSGNDET_PROJSUBID_FK` (`CLM_PROJSUBID`),
  CONSTRAINT `CONS_PROJASGNDET_EMPID_FK` FOREIGN KEY (`CLM_EMPID`) REFERENCES `tbl_empdet` (`CLM_EMPID`),
  CONSTRAINT `CONS_PROJASSGNDET_PROJSUBID_FK` FOREIGN KEY (`CLM_PROJSUBID`) REFERENCES `tbl_projsubdet` (`CLM_PROJSUBID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_projasgndet` */

/*Table structure for table `tbl_projdet` */

DROP TABLE IF EXISTS `tbl_projdet`;

CREATE TABLE `tbl_projdet` (
  `CLM_PROJID` int(5) NOT NULL AUTO_INCREMENT,
  `CLM_PROJSTAT` varchar(255) NOT NULL,
  `CLM_PROJPPRYEAR` date NOT NULL,
  `CLM_PROJTLE` varchar(100) NOT NULL,
  `CLM_PROJTYPEID` int(11) NOT NULL,
  `CLM_DOMID` int(11) NOT NULL,
  `CLM_PROJPPR` varchar(50) NOT NULL COMMENT 'CONTAINS FILE PATH',
  PRIMARY KEY (`CLM_PROJID`),
  UNIQUE KEY `CLM_PROJTYPEID` (`CLM_PROJTYPEID`),
  KEY `CONS_PROJDET_DOMID_FK` (`CLM_DOMID`),
  CONSTRAINT `CONS_PROJDET_DOMID_FK` FOREIGN KEY (`CLM_DOMID`) REFERENCES `tbl_dommst` (`CLM_DOMID`),
  CONSTRAINT `CONS_PROJDET_PROJTYPEID_FK` FOREIGN KEY (`CLM_PROJTYPEID`) REFERENCES `tbl_projtypemst` (`CLM_PROJTYPEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_projdet` */

/*Table structure for table `tbl_projsubdet` */

DROP TABLE IF EXISTS `tbl_projsubdet`;

CREATE TABLE `tbl_projsubdet` (
  `CLM_PROJSUBID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_PROJTITLE` varchar(100) NOT NULL,
  `CLM_PROJID` int(11) NOT NULL,
  `CLM_GRPID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_PROJSUBID`),
  KEY `CONS_PROJSUBDET_GRPID_FK` (`CLM_GRPID`),
  KEY `CONS_PROJSUBDET_PROJID_FK` (`CLM_PROJID`),
  CONSTRAINT `CONS_PROJSUBDET_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`),
  CONSTRAINT `CONS_PROJSUBDET_PROJID_FK` FOREIGN KEY (`CLM_PROJID`) REFERENCES `tbl_projdet` (`CLM_PROJID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_projsubdet` */

/*Table structure for table `tbl_projtypemst` */

DROP TABLE IF EXISTS `tbl_projtypemst`;

CREATE TABLE `tbl_projtypemst` (
  `CLM_PROJTYPEID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_PROJTYPENM` varchar(30) NOT NULL,
  PRIMARY KEY (`CLM_PROJTYPEID`),
  UNIQUE KEY `UNIQUE` (`CLM_PROJTYPENM`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_projtypemst` */

insert  into `tbl_projtypemst`(`CLM_PROJTYPEID`,`CLM_PROJTYPENM`) values (6,'CMS'),(4,'E-COMMERCE'),(5,'ERP'),(1,'IEEE PROJECT'),(2,'LIVE PROJECT'),(3,'WEBSITE DESIGNING');

/*Table structure for table `tbl_rcptdet` */

DROP TABLE IF EXISTS `tbl_rcptdet`;

CREATE TABLE `tbl_rcptdet` (
  `CLM_RCPTID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_RCPTDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CLM_PAID` double(6,2) NOT NULL,
  `CLM_MODPAY` varchar(15) NOT NULL,
  `CLM_EMPID` int(11) NOT NULL,
  `CLM_GRPID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_RCPTID`),
  KEY `CONS_RCPTDET_GRPID_FK` (`CLM_GRPID`),
  KEY `CONS_RCPTDET_EMPID_FK` (`CLM_EMPID`),
  CONSTRAINT `CONS_RCPTDET_EMPID_FK` FOREIGN KEY (`CLM_EMPID`) REFERENCES `tbl_empdet` (`CLM_EMPID`),
  CONSTRAINT `CONS_RCPTDET_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_rcptdet` */

/*Table structure for table `tbl_refmst` */

DROP TABLE IF EXISTS `tbl_refmst`;

CREATE TABLE `tbl_refmst` (
  `CLM_REFID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_REFNM` varchar(100) NOT NULL,
  `CLM_REFDES` varchar(100) NOT NULL DEFAULT 'OTHER' COMMENT 'DESCRIPTION',
  PRIMARY KEY (`CLM_REFID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_refmst` */

insert  into `tbl_refmst`(`CLM_REFID`,`CLM_REFNM`,`CLM_REFDES`) values (1,'SENIORS RECOMMENDED','COLLEGE MATE'),(2,'MATES RECOMMENDATION','FRIEND'),(3,'PROFESSOR RECOMMENDATION','COLLEGE SEMINAR'),(4,'ONLINE ADVT','ONLINE WEBSITE'),(5,'NEWSPAPER ADVT','ADVERTISE'),(6,'BANNER','EVENTS'),(7,'POSTER','EVENTS'),(8,'OTHERS','OTHER');

/*Table structure for table `tbl_reqhistdet` */

DROP TABLE IF EXISTS `tbl_reqhistdet`;

CREATE TABLE `tbl_reqhistdet` (
  `CLM_REQHISTID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_LSTVIST` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CLM_REQMT` varchar(200) NOT NULL,
  `CLM_GRPID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_REQHISTID`),
  KEY `CONS_REQHISTDET_GRPID_FK` (`CLM_GRPID`),
  CONSTRAINT `CONS_REQHISTDET_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_reqhistdet` */

/*Table structure for table `tbl_schmeetdet` */

DROP TABLE IF EXISTS `tbl_schmeetdet`;

CREATE TABLE `tbl_schmeetdet` (
  `CLM_SCHMEETID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_DATE` varchar(20) NOT NULL,
  `CLM_TIME` varchar(15) NOT NULL,
  `CLM_MSG` varchar(100) DEFAULT NULL,
  `CLM_GRPID` int(11) NOT NULL,
  `CLM_EMPID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_SCHMEETID`),
  KEY `CONS_SCHMEETDET_EMPID_FK` (`CLM_EMPID`),
  KEY `CONS_SCHMEETDET_GRPID_FK` (`CLM_GRPID`),
  CONSTRAINT `CONS_SCHMEETDET_EMPID_FK` FOREIGN KEY (`CLM_EMPID`) REFERENCES `tbl_empdet` (`CLM_EMPID`),
  CONSTRAINT `CONS_SCHMEETDET_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_schmeetdet` */

/*Table structure for table `tbl_studcontdet` */

DROP TABLE IF EXISTS `tbl_studcontdet`;

CREATE TABLE `tbl_studcontdet` (
  `CLM_CONTID` int(11) NOT NULL,
  `CLM_GRPID` int(11) NOT NULL,
  UNIQUE KEY `CLM_CONTID` (`CLM_CONTID`),
  KEY `CONS_STUDCONTDET_GRPID_FK` (`CLM_GRPID`),
  CONSTRAINT `CONS_STUDCONTDET_CONTID_FK` FOREIGN KEY (`CLM_CONTID`) REFERENCES `tbl_contmst` (`CLM_CONTID`),
  CONSTRAINT `CONS_STUDCONTDET_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_studcontdet` */

/*Table structure for table `tbl_studinfodet` */

DROP TABLE IF EXISTS `tbl_studinfodet`;

CREATE TABLE `tbl_studinfodet` (
  `CLM_STUDCONTID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_STUDNM` varchar(60) NOT NULL,
  `CLM_GENDER` char(1) NOT NULL,
  `CLM_GRPID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_STUDCONTID`),
  KEY `CONS_STUDINFO_GRPID_FK` (`CLM_GRPID`),
  CONSTRAINT `CONS_STUDINFO_GRPID_FK` FOREIGN KEY (`CLM_GRPID`) REFERENCES `tbl_studregdet` (`CLM_GRPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_studinfodet` */

/*Table structure for table `tbl_studregdet` */

DROP TABLE IF EXISTS `tbl_studregdet`;

CREATE TABLE `tbl_studregdet` (
  `CLM_GRPID` int(11) NOT NULL AUTO_INCREMENT,
  `CLM_TECH` varchar(15) NOT NULL,
  `CLM_TEAMSZ` int(5) NOT NULL,
  `CLM_DEPT` varchar(30) NOT NULL,
  `CLM_REFID` int(11) NOT NULL,
  `CLM_STUDSTAT` varchar(10) NOT NULL,
  `CLM_CLGID` int(11) NOT NULL,
  `CLM_PROJSUBID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_GRPID`),
  KEY `CONS_STUDREG_CLGID_FK` (`CLM_CLGID`),
  KEY `CONS_STUDREG_PROJSUBID_FK` (`CLM_PROJSUBID`),
  KEY `CONS_STUDREGDET_REFID_FK` (`CLM_REFID`),
  CONSTRAINT `CONS_STUDREGDET_CLGID_FK` FOREIGN KEY (`CLM_CLGID`) REFERENCES `tbl_clgmst` (`CLM_CLGID`),
  CONSTRAINT `CONS_STUDREGDET_PROJSUBID_FK` FOREIGN KEY (`CLM_PROJSUBID`) REFERENCES `tbl_projsubdet` (`CLM_PROJSUBID`),
  CONSTRAINT `CONS_STUDREGDET_REFID_FK` FOREIGN KEY (`CLM_REFID`) REFERENCES `tbl_refmst` (`CLM_REFID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_studregdet` */

/*Table structure for table `tbl_usrdailytaskdet` */

DROP TABLE IF EXISTS `tbl_usrdailytaskdet`;

CREATE TABLE `tbl_usrdailytaskdet` (
  `CLM_USRACTID` int(11) NOT NULL,
  `CLM_TASKSHEET` varchar(100) NOT NULL COMMENT 'CONTAINS PATH',
  `CLM_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CLM_EMPID` int(11) NOT NULL,
  PRIMARY KEY (`CLM_USRACTID`),
  KEY `CONS_USRDAILYTASKDET_EMPID_FK` (`CLM_EMPID`),
  CONSTRAINT `CONS_USRDAILYTASKDET_EMPID_FK` FOREIGN KEY (`CLM_EMPID`) REFERENCES `tbl_empdet` (`CLM_EMPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_usrdailytaskdet` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
