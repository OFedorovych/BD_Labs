IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'TValues') AND type in (N'U'))
	DROP TABLE TValues
GO

CREATE TABLE TValues(
	GoodID int NOT NULL,
	CharacterID int NOT NULL,
	[Value] float
	CONSTRAINT PK_Values PRIMARY KEY (GoodID, CharacterID)
) 
GO
-----------------------------------------------------------------------------------------------

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TCharacteristics]') AND type in (N'U'))
	DROP TABLE [dbo].[TCharacteristics]
GO

CREATE TABLE [dbo].[TCharacteristics](
	ID int IDENTITY(1,1) NOT NULL,
	[Name] varchar(50) NOT NULL
	CONSTRAINT PK_Characteristic PRIMARY KEY (ID)
	)
-----------------------------------------------------------------------------------------------
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TGoods]') AND type in (N'U'))
	DROP TABLE [dbo].[TGoods]
GO

CREATE TABLE TGoods(
	ID int IDENTITY(1,1) NOT NULL,
	[Name] varchar(50) NOT NULL,
	CategoryID int NOT NULL
	CONSTRAINT PK_Good PRIMARY KEY (ID)
)

-----------------------------------------------------------------------------------------------

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'TCategories') AND type in (N'U'))
	DROP TABLE TCategories
GO

CREATE TABLE TCategories(
	ID int IDENTITY(1,1) NOT NULL,
	[Name] varchar(50) NOT NULL
	CONSTRAINT PK_Category PRIMARY KEY (ID)
) 
GO
-----------------------------------------------------------------------------------------------
ALTER TABLE [dbo].[TGoods]  WITH CHECK ADD  CONSTRAINT [FK_TGoods_TCategories] FOREIGN KEY([CategoryID])
	REFERENCES [dbo].[TCategories] ([ID])
	ON UPDATE CASCADE
	ON DELETE CASCADE
GO

ALTER TABLE [dbo].[TValues]  WITH CHECK ADD  CONSTRAINT [FK_TValues_TGoods] FOREIGN KEY([GoodID])
	REFERENCES [dbo].[TGoods] ([ID])
	ON UPDATE CASCADE
	ON DELETE CASCADE
GO

ALTER TABLE [dbo].[TValues]  WITH CHECK ADD  CONSTRAINT [FK_TValues_TCharacteristics] FOREIGN KEY([CharacterID])
	REFERENCES [dbo].[TCharacteristics] ([ID])
	ON UPDATE CASCADE
	ON DELETE CASCADE
GO
-----------------------------------------------------------------------------------------------
CREATE NONCLUSTERED INDEX [ICategories_Name] ON [dbo].[TCategories]
(
	[Name] ASC
)

CREATE NONCLUSTERED INDEX [IGoods_categoryID] ON [dbo].[TGoods]
(
	categoryID ASC
)

CREATE NONCLUSTERED INDEX [IValues_goodID] ON [dbo].[tValues]
(
	goodID ASC
)

CREATE NONCLUSTERED INDEX [UICharacteristics_ID] ON [dbo].[tCharacteristics]
(
	ID ASC
)

INSERT INTO TCategories ([Name])   VALUES  ('������������')       --1
INSERT INTO TCategories ([Name])   VALUES  ('������ ������')     --2
INSERT INTO TCategories ([Name])   VALUES  ('̳����������� ��')  --3
INSERT INTO TCategories ([Name])   VALUES  ('��������� ������')  --4
INSERT INTO TCategories ([Name])   VALUES  ('������ �����')      --5
INSERT INTO TCategories ([Name])   VALUES  ('���������� ������') --6
INSERT INTO TCategories ([Name])   VALUES  ('����������')         --7
INSERT INTO TCategories ([Name])   VALUES  ('�����������')        --8
INSERT INTO TCategories ([Name])   VALUES  ('��������')           --9
INSERT INTO TCategories ([Name])   VALUES  ('����')              --10

INSERT INTO TGoods (Name, CategoryID)  VALUES ('LG GA-B509SLSM',1)             --1
INSERT INTO TGoods (Name, CategoryID)  VALUES ('INDESIT XIT8 T2E X',1)         --2
INSERT INTO TGoods (Name, CategoryID)  VALUES ('TOSHIBA GR-RB360WE',1)         --3
INSERT INTO TGoods (Name, CategoryID)  VALUES ('BOSCH WAJ20180UA',2)           --4
INSERT INTO TGoods (Name, CategoryID)  VALUES ('PANASONIC NN-ST25HBZPE',3)     --5
INSERT INTO TGoods (Name, CategoryID)  VALUES ('GORENJE K 5341 XF', 5)         --6
INSERT INTO TGoods (Name, CategoryID)  VALUES ('Greta 1470-00-17 C ��', 5)     --7
INSERT INTO TGoods (Name, CategoryID)  VALUES ('SIEMENS SR61IX05KE', 6)        --8
INSERT INTO TGoods (Name, CategoryID)  VALUES ('DELONGHI PrimaDonna', 7)       --9
INSERT INTO TGoods (Name, CategoryID)  VALUES ('KRUPS Evidence One', 7)        --10
INSERT INTO TGoods (Name, CategoryID)  VALUES ('PHILIPS Viva Collection', 8)   --11
INSERT INTO TGoods (Name, CategoryID)  VALUES ('TEFAL HB656838', 9)            --12
INSERT INTO TGoods (Name, CategoryID)  VALUES ('TEFAL PaniniGrill', 10)        --13

--INSERT INTO TGoods (Name, CategoryID)  VALUES ('g6',100)
--DELETE FROM TGoods WHERE CategoryID=100

INSERT INTO TCharacteristics ([Name]) VALUES ('���������, ��')                     --1
INSERT INTO TCharacteristics ([Name]) VALUES ('����, ��')                           --2
INSERT INTO TCharacteristics ([Name]) VALUES ('ֳ��, ���')                          --3
INSERT INTO TCharacteristics ([Name]) VALUES ('�������, �')                        --4
INSERT INTO TCharacteristics ([Name]) VALUES ('��� ���������� ��� ����, �')        --5
INSERT INTO TCharacteristics ([Name]) VALUES ('̳������ ���������� ��� �����, �')  --6
INSERT INTO TCharacteristics ([Name]) VALUES ('ʳ������ �������')                  --7
INSERT INTO TCharacteristics ([Name]) VALUES ('ʳ������ ������������� ������')    --8
INSERT INTO TCharacteristics ([Name]) VALUES ('г���� ����, ��')                    --9
INSERT INTO TCharacteristics ([Name]) VALUES ('�������� ��� ���������� ������, �')--10


INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (1, 1, 1500) 
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (1, 2, 60)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (1, 3, 14500)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (2, 1, 1800)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (2, 2, 72)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (2, 3, 13640)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (2, 4, 24)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (4, 1, 1200)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (9, 3, 21000)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (10, 3, 18000)
INSERT INTO TValues (GoodID, CharacterID, [Value]) VALUES (12, 7, 4)
----------------------------------------------------------------------------------------------------------
