-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2024 at 05:20 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arf`
--

-- --------------------------------------------------------

--
-- Table structure for table `apartmentadmin`
--

CREATE TABLE `apartmentadmin` (
  `AdminID` int(11) NOT NULL,
  `AdminUser` varchar(20) NOT NULL,
  `AdminPass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `apartmentadmin`
--

INSERT INTO `apartmentadmin` (`AdminID`, `AdminUser`, `AdminPass`) VALUES
(1, 'admin', 'admin123'),
(2, 'admin', 'admin123'),
(3, 'admin', 'admin123'),
(4, 'admin', 'admin123'),
(5, 'admin', 'admin123'),
(6, 'admin', 'admin123'),
(7, 'admin', 'admin123'),
(8, 'admin', 'admin123'),
(9, 'admin', 'admin123'),
(10, 'admin', 'admin123'),
(11, 'admin', 'admin123'),
(12, 'admin', 'admin123'),
(13, 'admin', 'admin123'),
(14, 'admin', 'admin123'),
(15, 'admin', 'admin123'),
(16, 'admin', 'admin123'),
(17, 'admin', 'admin123'),
(18, 'admin', 'admin123'),
(19, 'admin', 'admin123'),
(20, 'admin', 'admin123'),
(21, 'admin', 'admin123'),
(22, 'admin', 'admin123'),
(23, 'admin', 'admin123'),
(24, 'admin', 'admin123'),
(25, 'admin', 'admin123'),
(26, 'admin', 'admin123'),
(27, 'admin', 'admin123'),
(28, 'admin', 'admin123'),
(29, 'admin', 'admin123'),
(30, 'admin', 'admin123'),
(31, 'admin', 'admin123'),
(32, 'admin', 'admin123'),
(33, 'admin', 'admin123'),
(34, 'admin', 'admin123'),
(35, 'admin', 'admin123'),
(36, 'admin', 'admin123'),
(37, 'admin', 'admin123'),
(38, 'admin', 'admin123'),
(39, 'admin', 'admin123'),
(40, 'admin', 'admin123'),
(41, 'admin', 'admin123'),
(42, 'admin', 'admin123'),
(43, 'admin', 'admin123'),
(44, 'admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `customertenants`
--

CREATE TABLE `customertenants` (
  `TenantID` int(15) NOT NULL,
  `TenantName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Bed` varchar(50) NOT NULL,
  `NoofPax` int(15) NOT NULL,
  `ContactNumber` varchar(50) NOT NULL,
  `RoomID` varchar(11) NOT NULL,
  `CheckInDate` date NOT NULL,
  `CheckOutDate` date NOT NULL,
  `RoomType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customertenants`
--

INSERT INTO `customertenants` (`TenantID`, `TenantName`, `LastName`, `Gender`, `Bed`, `NoofPax`, `ContactNumber`, `RoomID`, `CheckInDate`, `CheckOutDate`, `RoomType`) VALUES
(1, 'Michelle', 'Vivas', '0', '', 0, '09652987765', '1', '2024-11-23', '2024-12-23', ''),
(2, 'Michelle', 'Guevarra', '0', '', 0, '09652987765', '3', '2024-11-23', '2024-12-23', ''),
(3, 'Eva', 'Vivas', '0', '', 0, '09219447962', '4', '2024-11-23', '2024-11-25', ''),
(4, 'Mark', 'Vivas', 'Male', 'Single', 1, '09652987765', '5', '2024-11-24', '2024-11-26', 'AC'),
(7, 'njajsjx', 'jnasd', 'Female ', 'Single', 1, '1234566789', '8', '2024-11-11', '2024-12-11', 'AC'),
(8, 'wsdns', 'ajsndja', 'Female ', 'Single', 1, '1234560987', '9', '2025-04-23', '2025-05-23', 'AC'),
(9, 'erox asher', 'asuelo', 'Male', 'Barkada', 5, '2345678', '10', '2024-03-12', '2024-04-12', 'Non-AC'),
(25, 'chapls', 'samomnbb', 'Male', 'Single', 1, '09687585544', '3', '2024-11-25', '2024-11-27', 'AC'),
(26, 'fdfdf', 'fdfdfdf', 'Male', 'Single', 1, '9087867867', '13', '2024-11-24', '2024-11-26', 'AC'),
(27, 'chakss', 'sasas', 'Male', 'Single', 1, '08966564', '2', '2024-11-24', '2024-11-27', 'AC'),
(28, 'fgfgfg', 'grfgfg', 'Male', 'Single', 1, '0978687677', '4', '2024-11-25', '2024-11-30', 'AC');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `PaymentID` int(11) NOT NULL,
  `TenantID` int(11) NOT NULL,
  `RoomID` int(11) NOT NULL,
  `CheckInDate` date NOT NULL,
  `CheckOutDate` date NOT NULL,
  `RoomPrice` decimal(10,2) NOT NULL,
  `WaterBill` decimal(10,2) NOT NULL,
  `ElectricityBill` decimal(10,2) NOT NULL,
  `TotalAmount` decimal(10,2) NOT NULL,
  `PaymentAmount` decimal(10,2) NOT NULL,
  `ChangeAmount` decimal(10,2) NOT NULL,
  `PaymentDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`PaymentID`, `TenantID`, `RoomID`, `CheckInDate`, `CheckOutDate`, `RoomPrice`, `WaterBill`, `ElectricityBill`, `TotalAmount`, `PaymentAmount`, `ChangeAmount`, `PaymentDate`) VALUES
(1, 28, 4, '2024-11-25', '2024-11-30', 5000.00, 75.00, 200.00, 5275.00, 87000.00, 81725.00, '2024-11-24 16:00:00'),
(2, 28, 4, '2024-11-25', '2024-11-30', 5000.00, 75.00, 200.00, 5275.00, 87000.00, 81725.00, '2024-11-24 16:00:00'),
(3, 27, 2, '2024-11-24', '2024-11-27', 3000.00, 45.00, 120.00, 3165.00, 70000.00, 66835.00, '2024-11-24 16:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `RoomID` int(5) NOT NULL,
  `RoomType` varchar(20) NOT NULL,
  `RoomSize` int(5) NOT NULL,
  `RoomPrice` double NOT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'Available'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`RoomID`, `RoomType`, `RoomSize`, `RoomPrice`, `Status`) VALUES
(1, 'Single', 1, 1000, 'Available'),
(2, 'Single', 1, 1000, 'Occupied'),
(3, 'Single', 1, 1000, 'Occupied'),
(4, 'Single', 1, 1000, 'Occupied'),
(5, 'Single', 1, 1000, 'Available'),
(6, 'Double', 2, 2500, 'Available'),
(7, 'Double', 2, 2500, 'Available'),
(8, 'Double', 2, 2500, 'Available'),
(9, 'Double', 2, 2500, 'Available'),
(10, 'Double', 2, 2500, 'Available'),
(11, 'Barkada', 5, 3000, 'Available'),
(12, 'Barkada', 5, 3000, 'Available'),
(13, 'Barkada', 5, 3000, 'Occupied'),
(14, 'Barkada', 5, 3000, 'Available'),
(15, 'Barkada', 5, 3000, 'Available'),
(16, 'Family Size', 8, 4000, 'Available'),
(17, 'Family Size', 8, 4000, 'Available'),
(18, 'Family Size', 8, 4000, 'Available'),
(19, 'Family Size', 8, 4000, 'Available'),
(20, 'Family Size', 8, 4000, 'Available');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apartmentadmin`
--
ALTER TABLE `apartmentadmin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `customertenants`
--
ALTER TABLE `customertenants`
  ADD PRIMARY KEY (`TenantID`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PaymentID`),
  ADD KEY `TenantID` (`TenantID`),
  ADD KEY `RoomID` (`RoomID`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`RoomID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apartmentadmin`
--
ALTER TABLE `apartmentadmin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `customertenants`
--
ALTER TABLE `customertenants`
  MODIFY `TenantID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `RoomID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`TenantID`) REFERENCES `customertenants` (`TenantID`),
  ADD CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`RoomID`) REFERENCES `rooms` (`RoomID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
