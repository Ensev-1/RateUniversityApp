-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 13, 2024 at 08:56 AM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
CREATE TABLE IF NOT EXISTS `courses` (
  `CourseID` int NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(40) NOT NULL,
  `CourseDescription` varchar(255) NOT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`CourseID`, `CourseName`, `CourseDescription`) VALUES
(1, 'Elemente Elektronike', 'Kjo lende ka te beje me qarqe te ndryshme elektronike, dhe bazat mbi elektroniken. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(2, 'Elementet e Informatikes', 'Kjo lende ka te beje me njohurite baze mbi informatiken. Nje hyrje mbi algoritmat dhe bllokskemat. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(3, 'Inxhinieri Softi', 'Kjo lende ka te beje me rregullat qe cdo programues duhet te ndjek per te shkruar nje kod te mire, sidomos kur punohet me software te medhenj. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(4, 'Anglisht', 'Kjo lende ka te beje me gjuhen angleze. Termat baze te perdorur ne inxhinierine e software ne anglisht. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(5, 'Programim Web', 'Kjo lende ka te beje me bazat mbi programimin e programeve web. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(6, 'Databaze', 'Kjo lende ka te beje me logjiken e punimit ne databaza relacionale dhe jorelacionale. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(7, 'Sistemet Operative', 'Kjo lende ka te beje me bazat e sistemeve operative. Cfare ato duhet te ofrojne dhe si na ofrojne sherbime te ndryshme. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(8, 'Probabilitet', 'Kjo lende ka te beje me nje hyrje ne statistike dhe ligjet probabilitare. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(9, 'Analize Matematike', 'Kjo lende ka te beje me bazat e matematikes. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.'),
(10, 'Algoritmike', 'Kjo lende ka te beje me studimin e algoritmeve, strukturave te ndryshme te te dhenave dhe kompleksiteteve te tyre. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.');

-- --------------------------------------------------------

--
-- Table structure for table `coursesforusers`
--

DROP TABLE IF EXISTS `coursesforusers`;
CREATE TABLE IF NOT EXISTS `coursesforusers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserID` int NOT NULL,
  `CourseID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `coursesforusers`
--

INSERT INTO `coursesforusers` (`ID`, `UserID`, `CourseID`) VALUES
(1, 1, 4),
(10, 1, 6),
(3, 2, 6),
(4, 2, 7),
(5, 1, 10),
(13, 1, 3),
(7, 1, 8),
(9, 1, 7),
(11, 3, 9),
(12, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE IF NOT EXISTS `feedbacks` (
  `FeedbackID` int NOT NULL AUTO_INCREMENT,
  `FeedbackDescription` varchar(255) NOT NULL,
  `FeedbackRating` int NOT NULL,
  `CourseID` int NOT NULL,
  `UserID` int NOT NULL,
  PRIMARY KEY (`FeedbackID`),
  KEY `CourseID` (`CourseID`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks` (`FeedbackID`, `FeedbackDescription`, `FeedbackRating`, `CourseID`, `UserID`) VALUES
(1, 'Nje lende jashtezakonisht e bukur dhe interesante. Nuk eshte nje lende e veshtire dhe merr shume informacione te reja!', 5, 2, 1),
(2, 'Ja vlen te ndjekesh si kurs! Jashtezakonisht i bukur.', 5, 2, 2),
(3, 'Nje nder lendet qe me ka mesuar me shume dhe me ka pergatitur per te programuar!', 5, 3, 1),
(4, 'Lende e bukur dhe e domosdoshme!', 4, 3, 2),
(5, 'Kush ka pasion qarqet duhet ta ndjek kete kurs.', 4, 1, 1),
(6, 'Shume lende e veshtire!', 2, 6, 1),
(7, 'Lende qe te zhvillon shume inteligjencen.', 4, 8, 1),
(8, 'Lenda ime e preferuar!', 5, 2, 3),
(9, 'Lende e ngarkuar por shume e bukur!', 4, 10, 1),
(10, 'Lende interesante.', 5, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `PersonID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`PersonID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`PersonID`, `FirstName`, `LastName`, `Email`, `Password`) VALUES
(1, 'Ensev', 'Miraka', 'ensev.miraka@fti.edu.al', 'test1'),
(2, 'Xheni', 'Muhaj', 'xheni.muhaj@gmail.com', 'test2'),
(3, 'ina', 'musta', 'ina.musta@fti.edu.al', 'test3');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
