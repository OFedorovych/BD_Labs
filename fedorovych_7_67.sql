use fedorovych_7_67;

DROP TABLE IF EXISTS Passwords;
CREATE TABLE Passwords(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Pass varchar(50) NOT NULL
);

DROP TABLE IF EXISTS Users;
CREATE TABLE Users(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Login varchar(50) NOT NULL,
    FirstName varchar(50) NOT NULL,
    SecondName varchar(50) NOT NULL,
    DOB date,
    POB varchar(50),
    Adress varchar(50),
    Comments varchar(50),
    Rating int
);

DROP TABLE IF EXISTS Books;
CREATE TABLE Books(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Name varchar(50) NOT NULL,
    Autors varchar(50),
    UDK float NOT NUll,
    Rating int NOT NULL
);

DROP TABLE IF EXISTS Link;
CREATE TABLE Link(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	E_Book_Adress varchar(60)
);

DROP TABLE IF EXISTS Category;
CREATE TABLE Category(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Name varchar(40)
);

-------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS fill_passwords//
CREATE PROCEDURE fill_passwords()
begin
	declare i int default 1;
    SET i = 1;
    
    WHILE i <= 10 DO
		insert into `Fedorovych_7_67`.`Passwords` (`pass`) values (concat("Noname", CAST(RAND() * 10 AS UNSIGNED) + 1));
		SET i = i + 1;
	END WHILE;
end //

DROP TRIGGER IF EXISTS tg_passwords_insert//
CREATE TRIGGER tg_passwords_insert
BEFORE INSERT
ON Passwords FOR EACH ROW
BEGIN
	IF(EXISTS(SELECT pass from passwords where pass = NEW.pass)) THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "PASSWORD ALREADY EXISTS";
	END IF;
END //

DELIMITER ;

CALL fill_passwords();
SELECT pass from passwords;