-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2015 at 02:48 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rentawheeldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
`employeeid` int(11) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `title` int(1) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeid`, `firstname`, `lastname`, `title`, `username`, `password`) VALUES
(1, 'bobby', 'pin', 1, 'bp', 'bp'),
(2, 'banh', 'cuon', 2, 'bc', 'bc');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `PhoneNumber` int(10) NOT NULL,
  `DPNumber` varchar(7) NOT NULL,
`memberid` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`username`, `password`, `email`, `firstname`, `lastname`, `PhoneNumber`, `DPNumber`, `memberid`) VALUES
('c', 'c', 'c@c.com', 'c', 'c', 653, '3645', 1),
('chris', 'chris', 'chris@mail.com', 'christopher', 'nunes', 7589573, '0000001', 3);

-- --------------------------------------------------------

--
-- Table structure for table `rentalcar`
--

CREATE TABLE IF NOT EXISTS `rentalcar` (
`carid` int(11) NOT NULL,
  `manufacturer` varchar(25) NOT NULL,
  `model` varchar(25) NOT NULL,
  `rentalcost` decimal(8,2) NOT NULL,
  `rented` tinyint(1) NOT NULL DEFAULT '0',
  `availability` varchar(20) DEFAULT 'Available'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rentalcar`
--

INSERT INTO `rentalcar` (`carid`, `manufacturer`, `model`, `rentalcost`, `rented`, `availability`) VALUES
(1, 'm', 'm', '12.00', 0, 'Available'),
(2, 'BMW', 'Model M', '1200.00', 1, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `rentaldetails`
--

CREATE TABLE IF NOT EXISTS `rentaldetails` (
`rentalid` int(11) NOT NULL,
  `daterented` text NOT NULL,
  `datereturned` text NOT NULL,
  `memberid` int(11) NOT NULL,
  `carid` int(11) NOT NULL,
  `dateDue` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rentaldetails`
--

INSERT INTO `rentaldetails` (`rentalid`, `daterented`, `datereturned`, `memberid`, `carid`, `dateDue`) VALUES
(29, '1', '1', 1, 1, '1'),
(30, 'b', 'a', 3, 1, 'c');

-- --------------------------------------------------------

--
-- Table structure for table `reserved`
--

CREATE TABLE IF NOT EXISTS `reserved` (
`rid` int(3) NOT NULL,
  `memberid` int(3) NOT NULL,
  `carid` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
 ADD PRIMARY KEY (`employeeid`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
 ADD PRIMARY KEY (`memberid`);

--
-- Indexes for table `rentalcar`
--
ALTER TABLE `rentalcar`
 ADD PRIMARY KEY (`carid`);

--
-- Indexes for table `rentaldetails`
--
ALTER TABLE `rentaldetails`
 ADD PRIMARY KEY (`rentalid`), ADD UNIQUE KEY `foreignkey` (`memberid`,`carid`), ADD KEY `fk1` (`carid`);

--
-- Indexes for table `reserved`
--
ALTER TABLE `reserved`
 ADD PRIMARY KEY (`rid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
MODIFY `employeeid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
MODIFY `memberid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `rentalcar`
--
ALTER TABLE `rentalcar`
MODIFY `carid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `rentaldetails`
--
ALTER TABLE `rentaldetails`
MODIFY `rentalid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `reserved`
--
ALTER TABLE `reserved`
MODIFY `rid` int(3) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
