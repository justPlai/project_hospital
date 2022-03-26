-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 26, 2022 at 06:52 PM
-- Server version: 5.7.33-0ubuntu0.16.04.1
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SOA65_01`
--
CREATE DATABASE IF NOT EXISTS `SOA65_01` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `SOA65_01`;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL,
  `doctor_firstname` varchar(50) CHARACTER SET tis620 NOT NULL,
  `doctor_lastname` varchar(50) CHARACTER SET tis620 NOT NULL,
  `doctor_phonenumber` varchar(10) DEFAULT NULL,
  `hospital_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctor_id`, `doctor_firstname`, `doctor_lastname`, `doctor_phonenumber`, `hospital_id`) VALUES
(1, 'อาทฤต', 'เย็นเปรม', NULL, 1),
(2, 'HelloHibernate', 'HelloHibernate', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hospital_id` int(5) NOT NULL,
  `hospital_name` varchar(80) CHARACTER SET tis620 NOT NULL,
  `hospital_location` varchar(255) DEFAULT NULL,
  `hospital_phonenumber` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`hospital_id`, `hospital_name`, `hospital_location`, `hospital_phonenumber`) VALUES
(1, 'โรงพยาบาลมหาวิทยาลัยธรรมศาสตร์', NULL, NULL),
(2, 'โรงพยาบาลปทุมธานี', NULL, NULL),
(3, 'hospitalName', 'hospitalLocation', '0891234567');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `medicine_id` int(11) NOT NULL,
  `medicine_english` varchar(50) NOT NULL,
  `medicine_thai` varchar(50) CHARACTER SET tis620 NOT NULL,
  `medicine_price` float DEFAULT NULL,
  `medicine_description` varchar(255) CHARACTER SET tis620 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`medicine_id`, `medicine_english`, `medicine_thai`, `medicine_price`, `medicine_description`) VALUES
(1, 'Piroxicam', 'ไพร็อกซิแคม', NULL, 'ยาแก้ปวดในกลุ่มเอ็นเสด'),
(2, 'Tylenol', 'ไทลินอล', NULL, 'ยาแก้ปวดในกลุ่มอะเซตามีโนเฟน');

-- --------------------------------------------------------

--
-- Table structure for table `medicinedetail`
--

CREATE TABLE `medicinedetail` (
  `medicineDetail_id` int(11) NOT NULL,
  `medicine_amount` int(11) NOT NULL,
  `medicine_totalPrice` double DEFAULT NULL,
  `doctor_id` int(11) NOT NULL,
  `medicine_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicinedetail`
--

INSERT INTO `medicinedetail` (`medicineDetail_id`, `medicine_amount`, `medicine_totalPrice`, `doctor_id`, `medicine_id`) VALUES
(1, 30, NULL, 1, 2),
(2, 20, NULL, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctor_id`),
  ADD KEY `hospital_id` (`hospital_id`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hospital_id`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`medicine_id`);

--
-- Indexes for table `medicinedetail`
--
ALTER TABLE `medicinedetail`
  ADD PRIMARY KEY (`medicineDetail_id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `medecine_id` (`medicine_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hospital_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `medicine_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `medicinedetail`
--
ALTER TABLE `medicinedetail`
  MODIFY `medicineDetail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hospital_id`);

--
-- Constraints for table `medicinedetail`
--
ALTER TABLE `medicinedetail`
  ADD CONSTRAINT `medicinedetail_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  ADD CONSTRAINT `medicinedetail_ibfk_2` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`medicine_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
