CREATE TABLE `booking` (
  `booking_no` int NOT NULL AUTO_INCREMENT,
  `customer_no` int NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `product_no` int DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `travel_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `adult_count` int DEFAULT '1',
  `child_count` int DEFAULT '0',
  `infant_count` int DEFAULT '0',
  `total_amount` int DEFAULT NULL,
  `discount_amount` int DEFAULT NULL,
  `payment_amount` int DEFAULT NULL,
  `booking_status` varchar(30) DEFAULT NULL,
  `payment_method` varchar(30) DEFAULT NULL,
  `booking_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `payment_date` datetime DEFAULT NULL,
  `user_no` int DEFAULT NULL,
  PRIMARY KEY (`booking_no`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `claim` (
  `claim_no` int NOT NULL AUTO_INCREMENT,
  `claim_type` varchar(50) DEFAULT NULL,
  `customer_no` int DEFAULT NULL,
  `customer_name` varchar(50) NOT NULL,
  `product_no` int DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `comment` text,
  `claim_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `claim_status` varchar(20) DEFAULT NULL,
  `checked_date` datetime DEFAULT NULL,
  `user_no` int DEFAULT NULL,
  PRIMARY KEY (`claim_no`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `customer_no` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `passport_no` varchar(20) DEFAULT NULL,
  `grade` varchar(20) DEFAULT '신규',
  `used_amount` int DEFAULT '0',
  `user_no` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_no`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `itinerary_plan` (
  `itinerary_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `transportation` varchar(100) DEFAULT NULL,
  `note` text,
  PRIMARY KEY (`itinerary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product` (
  `PRODUCT_SEQ` int NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(100) NOT NULL,
  `PRODUCT_NO` int NOT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `product_structure` varchar(50) DEFAULT NULL,
  `currency` varchar(10) DEFAULT NULL,
  `PRICE_ADULT` int DEFAULT NULL,
  `PRICE_CHILD` int DEFAULT NULL,
  `PRICE_INFANT` int DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `leader` text,
  `guide` text,
  `min_people` int DEFAULT NULL,
  `max_people` int DEFAULT NULL,
  `short_Desc` text,
  `main_image` varchar(255) DEFAULT NULL,
  `detail_image` varchar(255) DEFAULT NULL,
  `detail_Desc` text,
  `admin_memo` text,
  `CREATE_USER_ID` int DEFAULT NULL,
  `CREATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_USER_ID` varchar(30) DEFAULT NULL,
  `UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `PROJECT_ID` int DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_SEQ`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product_planning` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL,
  `project_type` varchar(50) DEFAULT NULL,
  `status` varchar(30) DEFAULT '기획중',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `project_detail` text COMMENT '프로젝트 상세 설명',
  PRIMARY KEY (`project_id`),
  CONSTRAINT `project_chk_1` CHECK ((`project_type` in (_utf8mb4'자유여행',_utf8mb4'패키지'))),
  CONSTRAINT `project_chk_2` CHECK ((`status` in (_utf8mb4'기획중',_utf8mb4'진행중',_utf8mb4'완료')))
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project_expense` (
  `expense_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `paid_to` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project_feedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `source` varchar(50) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `comment` text,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project_member` (
  `project_id` int NOT NULL,
  `user_no` int NOT NULL,
  `part` varchar(50) DEFAULT NULL,
  `join_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project_risk` (
  `risk_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `risk_description` text,
  `impact_level` varchar(20) DEFAULT NULL,
  `mitigation_plan` text,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`risk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project_task` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `task_name` varchar(100) DEFAULT NULL,
  `assigned_to` int DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `priority` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `schedule` (
  `SCHEDULE_NO` int NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) NOT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `END_DATE` datetime DEFAULT NULL,
  `LOCATION` varchar(100) DEFAULT NULL,
  `SCHEDULE_TYPE` varchar(30) DEFAULT NULL,
  `USER_NO` int DEFAULT NULL,
  PRIMARY KEY (`SCHEDULE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_info` (
  `USER_NO` int NOT NULL AUTO_INCREMENT,
  `ID` varchar(50) NOT NULL,
  `PASSWORD` varchar(300) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `PHONE` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `DEPT_NAME` varchar(50) DEFAULT NULL,
  `POSITION` varchar(50) DEFAULT NULL,
  `ROLE` varchar(50) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`USER_NO`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
