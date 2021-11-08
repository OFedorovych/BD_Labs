CREATE DATABASE IF NOT EXISTS lab3;
USE lab3;

DROP TABLE IF EXISTS TValues;
DROP TABLE IF EXISTS TRating;
DROP TABLE IF EXISTS TCharacteristics;
DROP TABLE IF EXISTS TGoods;
DROP TABLE IF EXISTS TWarehouse;
DROP TABLE IF EXISTS TProducer;
DROP TABLE IF EXISTS TCountry;
DROP TABLE IF EXISTS TCategories;

CREATE TABLE TValues(
	GoodID int NOT NULL,
	CharacterID int NOT NULL,
	Value float,
	PRIMARY KEY (GoodID, CharacterID),
	CONSTRAINT CHECK_Value  
      CHECK (Value > 0 )
) ;

CREATE TABLE TRating(
	GoodID int NOT NULL,
	FiveStars int,
	FourStars int,
	ThreeStars int,
	TwoStars int,
	OneStar int,
	CONSTRAINT PK_Rating PRIMARY KEY (GoodID)
) ;

CREATE TABLE TCharacteristics(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Name varchar(50) NOT NULL
	);


CREATE TABLE TGoods(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Name varchar(50) NOT NULL,
	CategoryID int NOT NULL,
	ProducerID int NOT NULL,
	WarehouseID int NOT NULL
);

CREATE TABLE TWarehouse(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Warehouse varchar(50) NOT NULL,
	Employees int NOT NULL
);


CREATE TABLE TProducer(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Name varchar(50) NOT NULL,
	CountryID int NOT NULL
);

CREATE TABLE TCountry(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Country varchar(50) NOT NULL
);

CREATE TABLE TCategories(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Name varchar(50) NOT NULL
) ;

/*----------------------------------------------------------------------------------------*/

ALTER TABLE TGoods ADD  CONSTRAINT FK_TGoods_TCategories FOREIGN KEY(CategoryID)
	REFERENCES TCategories (ID)
	ON UPDATE CASCADE
	ON DELETE CASCADE;


ALTER TABLE TProducer ADD  CONSTRAINT FK_TProducer_TCountry FOREIGN KEY(CountryID)
	REFERENCES TCountry (ID)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE TGoods ADD  CONSTRAINT FK_TGoods_TProducer FOREIGN KEY(ProducerID)
	REFERENCES TProducer (ID)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE TGoods ADD  CONSTRAINT FK_TGoods_TWarehouse FOREIGN KEY(WarehouseID)
	REFERENCES TWarehouse (ID)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE TValues ADD  CONSTRAINT FK_TValues_TGoods FOREIGN KEY(GoodID)
	REFERENCES TGoods (ID)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE TValues ADD  CONSTRAINT FK_TValues_TCharacteristics FOREIGN KEY(CharacterID)
	REFERENCES TCharacteristics (ID)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

ALTER TABLE TRating ADD  CONSTRAINT FK_TRating_TGoods FOREIGN KEY(GoodID)
	REFERENCES TGoods (ID)
	ON UPDATE CASCADE
	ON DELETE CASCADE;

/*----------------------------------------------------------------------------------------*/

CREATE INDEX ICategories_Name ON TCategories
(
	Name ASC
);

CREATE INDEX IGoods_categoryID ON TGoods
(
	categoryID ASC
);

CREATE INDEX IValues_goodID ON tValues
(
	goodID ASC
);

CREATE INDEX UICharacteristics_ID ON tCharacteristics
(
	ID ASC
);

/*----------------------------------------------------------------------------------------*/

INSERT INTO TCategories (Name)   VALUES  ('Холодильники');      
INSERT INTO TCategories (Name)   VALUES  ('Пральні машини');   
INSERT INTO TCategories (Name)   VALUES  ('Мікрохвильова піч');  
INSERT INTO TCategories (Name)   VALUES  ('Морозильні камери');
INSERT INTO TCategories (Name)   VALUES  ('Кухонні плити');     
INSERT INTO TCategories (Name)   VALUES  ('Пусодомийні машини');
INSERT INTO TCategories (Name)   VALUES  ('Кавомашини'); 
INSERT INTO TCategories (Name)   VALUES  ('Мультиварки');
INSERT INTO TCategories (Name)   VALUES  ('Блендери'); 
INSERT INTO TCategories (Name)   VALUES  ('Грилі');         

INSERT INTO TCountry(Country)   VALUES  ('USA');        
INSERT INTO TCountry(Country)   VALUES  ('Canada');     
INSERT INTO TCountry(Country)   VALUES  ('France');     
INSERT INTO TCountry(Country)   VALUES  ('Germany');    
INSERT INTO TCountry(Country)   VALUES  ('Australia');  
INSERT INTO TCountry(Country)   VALUES  ('Korea');      
INSERT INTO TCountry(Country)   VALUES  ('China');      
INSERT INTO TCountry(Country)   VALUES  ('New Zealand');
INSERT INTO TCountry(Country)   VALUES  ('Mexico');     
INSERT INTO TCountry(Country)   VALUES  ('Ukraine');    

INSERT INTO TProducer (Name, CountryID)   VALUES ('LG',1);         
INSERT INTO TProducer (Name, CountryID)   VALUES ('SAMSUNG', 6);
INSERT INTO TProducer (Name, CountryID)   VALUES ('TEFAL', 1);  
INSERT INTO TProducer (Name, CountryID)   VALUES ('PHILIPS', 5);   
INSERT INTO TProducer (Name, CountryID)   VALUES ('APPLE', 2);  
INSERT INTO TProducer (Name, CountryID)   VALUES ('SIEMENS', 4);   
INSERT INTO TProducer (Name, CountryID)   VALUES ('BOSCH', 8);     
INSERT INTO TProducer (Name, CountryID)   VALUES ('PANASONIC', 9); 
INSERT INTO TProducer (Name, CountryID)   VALUES ('DELONGHI', 10); 
INSERT INTO TProducer (Name, CountryID)   VALUES ('KRUPS', 7);     

INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse1', 20);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse2', 38);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse3', 12);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse4', 116);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse5', 8);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse6', 78);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse7', 54);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse8', 19);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse9', 224);
INSERT INTO TWarehouse (Warehouse, Employees)   VALUES ('Warehouse10', 44);


INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('LG GA-B509SLSM', 1, 1, 6);            
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('INDESIT XIT8 T2E X', 1, 5, 8);        
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('TOSHIBA GR-RB360WE', 1, 6, 9);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('BOSCH WAJ20180UA', 2, 7, 7);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('PANASONIC NN-ST25HBZPE', 3, 8, 10);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('GORENJE K 5341 XF', 5, 10, 5);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('Greta 1470-00-17 C АА', 5, 3, 3);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('SIEMENS SR61IX05KE', 6, 6, 4);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('DELONGHI PrimaDonna', 7, 9, 2);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('KRUPS Evidence One', 7, 10, 1);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('PHILIPS Viva Collection', 8, 4, 6);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('TEFAL HB656838', 9, 3, 7);
INSERT INTO TGoods (Name, CategoryID, ProducerID, WarehouseID)  VALUES ('TEFAL PaniniGrill', 10, 4, 7);

-- INSERT INTO TGoods (Name, CategoryID)  VALUES ('g6',100);
-- DELETE FROM TGoods WHERE CategoryID=100;

INSERT INTO TCharacteristics (Name) VALUES ('Потужність, Вт');                    
INSERT INTO TCharacteristics (Name) VALUES ('Вага, кг');                           
INSERT INTO TCharacteristics (Name) VALUES ('Ціна, грн');                          
INSERT INTO TCharacteristics (Name) VALUES ('Гарантія, м');                        
INSERT INTO TCharacteristics (Name) VALUES ('Обєм резервуара для води, л');        
INSERT INTO TCharacteristics (Name) VALUES ('Місткість контейнера для зерен, г');  
INSERT INTO TCharacteristics (Name) VALUES ('Кількість насадок');                  
INSERT INTO TCharacteristics (Name) VALUES ('Кількість температурних режимів');    
INSERT INTO TCharacteristics (Name) VALUES ('Рівень шуму, дБ');                    
INSERT INTO TCharacteristics (Name) VALUES ('Корисний обєм холодильної камери, л');

INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (1, 1, 1500); 
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (1, 2, 60);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (1, 3, 14500);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (2, 1, 1800);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (2, 2, 72);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (2, 3, 13640);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (2, 4, 24);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (4, 1, 1200);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (9, 3, 21000);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (10, 3, 18000);
INSERT INTO TValues (GoodID, CharacterID, Value) VALUES (12, 7, 4);
 
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (1, 3, 7, 5, 0, 2);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (10, 3, 4, 8, 12, 6);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (9, 18, 26, 7, 0, 1);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (5, 2, 5, 2, 0, 0);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (7, 0, 0, 0, 0, 0);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (8, 13, 56, 17, 4, 1);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (3, 6, 7, 5, 34, 4);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (4, 1, 1, 1, 0, 0);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (13, 10, 6, 2, 0, 1);
INSERT INTO TRating (GoodID, FiveStars, FourStars, ThreeStars, TwoStars, OneStar) VALUES (2, 0, 0, 5, 9, 9);

