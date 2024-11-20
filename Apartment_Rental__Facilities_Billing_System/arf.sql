-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2024 at 03:24 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

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
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL,
  `adminName` varchar(20) NOT NULL,
  `adminPass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `adminName`, `adminPass`) VALUES
(1, 'charlie', 'magyaya'),
(2, 'michelle', 'vivas');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `Room ID` int(5) NOT NULL,
  `Room Type` varchar(20) NOT NULL,
  `Room Size` int(5) NOT NULL,
  `Room Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`Room ID`, `Room Type`, `Room Size`, `Room Price`) VALUES
(1, 'Single', 1, 1000),
(2, 'Single', 1, 1000),
(3, 'Single', 1, 1000),
(4, 'Single', 1, 1000),
(5, 'Single', 1, 1000),
(6, 'Double', 2, 2500),
(7, 'Double', 2, 2500),
(8, 'Double', 2, 2500),
(9, 'Double', 2, 2500),
(10, 'Double', 2, 2500),
(11, 'Barkada', 5, 3000),
(12, 'Barkada', 5, 3000),
(13, 'Barkada', 5, 3000),
(14, 'Barkada', 5, 3000),
(15, 'Barkada', 5, 3000),
(16, 'Family Size', 8, 4000),
(17, 'Family Size', 8, 4000),
(18, 'Family Size', 8, 4000),
(19, 'Family Size', 8, 4000),
(20, 'Family Size', 8, 4000);

-- --------------------------------------------------------

--
-- Table structure for table `tenants`
--

CREATE TABLE `tenants` (
  `Tenant ID` int(11) NOT NULL,
  `Tenant Name` varchar(20) NOT NULL,
  `Room ID` int(11) NOT NULL,
  `Check In Date` date NOT NULL,
  `Check Out Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tenants`
--

INSERT INTO `tenants` (`Tenant ID`, `Tenant Name`, `Room ID`, `Check In Date`, `Check Out Date`) VALUES
(3, 'Michelle', 2, '2024-11-20', '2024-11-25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`Room ID`);

--
-- Indexes for table `tenants`
--
ALTER TABLE `tenants`
  ADD PRIMARY KEY (`Tenant ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `Room ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tenants`
--
ALTER TABLE `tenants`
  MODIFY `Tenant ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
