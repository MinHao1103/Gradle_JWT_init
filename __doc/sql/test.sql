--
-- 選擇數據庫： `testdb`
--
USE testdb;

-- --------------------------------------------------------

--
-- 資料表結構 `testTable`
--
CREATE TABLE `testTable` (
  `id` bigint(20) AUTO_INCREMENT PRIMARY KEY,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `createdDate` timestamp DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='測試';
