-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 15, 2015 at 06:51 AM
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
  `title` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeid`, `firstname`, `lastname`, `title`) VALUES
(1, 'k', 'k', 1),
(2, 'j', 'j', 2);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoiceid` int(11) NOT NULL,
  `timerented` varchar(25) NOT NULL,
  `rentalpayment` decimal(8,2) NOT NULL,
  `balance` decimal(8,2) NOT NULL,
  `rentalid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`username`, `password`, `email`, `firstname`, `lastname`, `PhoneNumber`, `DPNumber`, `memberid`) VALUES
('testmember', 'testpassword', 'test@mail.com', '', '', 0, '', 1),
('testmember2', 'testpassword2', 'test2@mail.com', '', '', 0, '', 2),
('opp', 'opp', 'opp@o.com', '', '', 0, '', 11);

-- --------------------------------------------------------

--
-- Table structure for table `rentalcar`
--

CREATE TABLE IF NOT EXISTS `rentalcar` (
  `carid` int(11) NOT NULL,
  `manufacturer` varchar(25) NOT NULL,
  `model` varchar(25) NOT NULL,
  `availability` varchar(25) NOT NULL,
  `rentalcost` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rentalcar`
--

INSERT INTO `rentalcar` (`carid`, `manufacturer`, `model`, `availability`, `rentalcost`) VALUES
(1, 'Toyota', 'Yaris', 'Available', '300.00'),
(2, 'BMW', '325i', 'Available', '1000.00'),
(3, 'Ferarri', '360 Spider', 'Available', '10000.00'),
(4, 'Bugatti', 'Veyron', 'Available', '100000.00');

-- --------------------------------------------------------

--
-- Table structure for table `rentaldetails`
--

CREATE TABLE IF NOT EXISTS `rentaldetails` (
  `rentalid` int(11) NOT NULL,
  `daterented` date NOT NULL,
  `datereturned` date NOT NULL,
  `memberid` int(11) NOT NULL,
  `carid` int(11) NOT NULL,
  `employeeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reserved`
--

CREATE TABLE IF NOT EXISTS `reserved` (
`rid` int(3) NOT NULL,
  `memberid` int(3) NOT NULL,
  `carid` int(3) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
 ADD PRIMARY KEY (`employeeid`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
 ADD PRIMARY KEY (`invoiceid`), ADD UNIQUE KEY `foreign key` (`rentalid`);

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
 ADD PRIMARY KEY (`rentalid`), ADD UNIQUE KEY `foreignkey` (`memberid`,`carid`,`employeeid`), ADD KEY `fk1` (`carid`), ADD KEY `fk2` (`employeeid`);

--
-- Indexes for table `reserved`
--
ALTER TABLE `reserved`
 ADD PRIMARY KEY (`rid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
MODIFY `memberid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `reserved`
--
ALTER TABLE `reserved`
MODIFY `rid` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
ADD CONSTRAINT `fk3` FOREIGN KEY (`rentalid`) REFERENCES `rentaldetails` (`rentalid`);

--
-- Constraints for table `rentaldetails`
--
ALTER TABLE `rentaldetails`
ADD CONSTRAINT `fk` FOREIGN KEY (`memberid`) REFERENCES `member` (`memberid`),
ADD CONSTRAINT `fk1` FOREIGN KEY (`carid`) REFERENCES `rentalcar` (`carid`),
ADD CONSTRAINT `fk2` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`employeeid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
