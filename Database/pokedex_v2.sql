-- Tabella utenti
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Tabella collezioni
CREATE TABLE collections (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    pokemon_id INT NOT NULL,
    status ENUM('owned', 'wishlist') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon_data(national_number) ON DELETE CASCADE
);

-- Tabella pokemon_data
CREATE TABLE `pokemon_data` (
  `national_number` int NOT NULL,
  `gen` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `english_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `primary_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `secondary_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `classification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `percent_male` decimal(5,2) DEFAULT NULL,
  `percent_female` decimal(5,2) DEFAULT NULL,
  `height_m` decimal(4,1) DEFAULT NULL,
  `weight_kg` decimal(5,1) DEFAULT NULL,
  `capture_rate` int DEFAULT NULL,
  `hp` int DEFAULT NULL,
  `attack` int DEFAULT NULL,
  `defense` int DEFAULT NULL,
  `speed` int DEFAULT NULL,
  `abilities_0` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `abilities_1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `abilities_special` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_legendary` tinyint(1) DEFAULT NULL,
  `is_mythical` tinyint(1) DEFAULT NULL,
  `evochain_0` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `evochain_2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `evochain_4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `evo1_id` int DEFAULT NULL,
  `evo2_id` int DEFAULT NULL,
  `evo3_id` int DEFAULT NULL,
  `evochain_6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `evochain_8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `evochain_10` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `evo4_id` int DEFAULT NULL,
  `evo5_id` int DEFAULT NULL,
  `evo6_id` int DEFAULT NULL,
  PRIMARY KEY (`national_number`)
);