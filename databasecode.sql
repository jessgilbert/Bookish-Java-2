CREATE TABLE `bookcopies` (
  `CopyID` int(11) NOT NULL,
  `BookID` int(11) DEFAULT NULL,
  `CheckedOutBy` int(11) DEFAULT NULL,
  `ReturnDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CopyID`),
  KEY `bookcopies_bookid_booklist_idx` (`BookID`),
  KEY `bookcopies_personid_people_idx` (`CheckedOutBy`),
  CONSTRAINT `bookcopies_bookid_booklist` FOREIGN KEY (`BookID`) REFERENCES `booklist` (`bookid`),
  CONSTRAINT `bookcopies_personid_people` FOREIGN KEY (`CheckedOutBy`) REFERENCES `people` (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `booklist` (
  `BookId` int(11) NOT NULL AUTO_INCREMENT,
  `BookName` varchar(45) NOT NULL,
  `Author` varchar(45) NOT NULL,
  PRIMARY KEY (`BookId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `people` (
  `PersonID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `Surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PersonID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
