Drop table Admin

Drop table Payments

Drop table Vis_Per

Drop table Visitor

Drop table GuestInfo

Drop table ParkingRecord

Drop table ParkingSlot

Drop table Security

Drop table Persons


--CREATING TABLES--

Create table Persons
(
	Id varchar(20) primary key,
	FlatNo int not null,
	Name varchar(30) not null,
	Age int not null,
	Profession varchar(20) not null,
	ContactNo varchar(11) not null,
	PermanentAddress varchar(50) not null,
	Status varchar(10) not null,
);

Create table Admin
(
	AdminId int identity(10001,1) primary key,
	AdminName varchar(25) not null,
	Status varchar(20) not null,
	Id varchar(20)	foreign key references Persons(Id),
	Username varchar(20) unique not null,
	Password varchar(20) unique not null	
);

Create table Security
(
	SecurityId int identity(30001,1) primary key,
	SecurityName varchar(25) not null,
	Username varchar(20) unique not null,
	Password varchar(20) unique not null	
);

Create table Payments
(
	Id int identity(40001,1) primary key,
	FlatNo int,
	DateofPayment date not null,
	PaidFor varchar(255) 
);

Create table GuestInfo
(
	GuestId int identity(50001,1) primary key,
	GuestName varchar(25) not null,
	ContactNo varchar(11) not null,
);

Create table Visitor
(
	EntryId varchar(25) primary key,
	GuestId int foreign key references GuestInfo(GuestId),
	SecurityId int foreign key references Security(SecurityId) on Delete set null,
	EntryTime datetime not null
);

Create table ParkingSlot
(
	SlotNo int identity(70001,1) primary key,
	Status varchar(10) not null,
	SlotOwnerId varchar(20) foreign key references Persons(Id),
	SlotUserId varchar(20)
);

Create table ParkingRecord
(
	RecordNo varchar(25) primary key,
	VehicleNo varchar(20) unique not null,
	ParkingSlotNo int foreign key references ParkingSlot(SlotNo),
	EntryTime datetime not null,
	ExitTime  datetime not null,
);

Create table Vis_Per
(
	PersonID varchar(20) foreign  key references Persons(Id),
	VisitorID varchar(25) foreign key references Visitor(EntryId)
);

--INSERTING DATA--

Insert into Persons(Id,FlatNo,Name,Age,Profession,ContactNo,PermanentAddress,Status)
values('2569387410','402','Abdul Munna','48','Businessman','01748593215','Banani Dhaka','Owned'),
	  ('2174896520','102','Md Jubayer Khan','46','IT Engineer','01532154896','Lalbagh Dhaka','On Rent'),
	  ('2102563987','201','Selina Akter','37','Medicine Doctor','01748593265','Malibagh Dhaka','On Rent'),
	  ('2170458632','101','Hazi Jamal Uddin','56','Businessman','01925362147','Gendaria Dhaka','Owned'),
	  ('2125463917','302','Anisur Rahman','43','Marketing Manager','01579325147','Gulshan Dhaka','Owned'),
	  ('1526486321','401','Ahmed Sheikh','42','Bank Manager','01696583214','Amlapara Narayanganj','Owned')

Insert into Admin(AdminName,Status,Id,Username,Password)
values('Ahmed Sheikh','President','1526486321','Sheikh001','Sheikh12345'),
	  ('Anisur Rahman','Secretary','2125463917','Anisur002','Anisur56789'),
	  ('Hazi Jamal Uddin','Assisstant Secretary','2170458632','Jamal003','Jamal13579')

Insert into Security(SecurityName,Username,Password)
values('Bellal Hossen','Bellal01','Bellal240'),
	  ('Lutfur Rahman','Lutfur02','Lutfur840'),
	  ('Kamal Molla','Kamal03','Kamal350'),
	  ('Akim Hawlader','Akim04','Akim603'),
	  ('Asaduzzaman','Zaman05','Lutfur301'),
	  ('Kamran Rahman','Kamran02','Kamran150')

Insert into Payments(FlatNo,DateofPayment,PaidFor)
values(201,'2019-09-17','October-2019'),
	  (102,'2019-09-01','October-2019'),
	  (402,'2019-08-20','October-2019'),
	  (101,'2019-09-15','October-2019'),
	  (302,'2019-09-17','October-2019'),
	  (201,'2019-09-10','October-2019')

Insert into GuestInfo(GuestName,ContactNo)
values('Rumana Polli','01754286193'),
	  ('Raghman Shah','01301236598'),
	  ('Jumman Bepari','01758496321'),
	  ('Riad Ismail','01928256339'),
	  ('Riya Mollik','01785432116'),
	  ('Arifa Rahman','01865329471')

Insert into Visitor(EntryId,GuestId,SecurityId,EntryTime)
values('V2019-02-28 22:13:34',50003,30002,'2019-02-28 22:13:34'),
	  ('V2019-03-08 20:20:14',50001,30006,'2019-03-08 20:20:14'),
	  ('V2019-01-23 18:11:23',50002,30001,'2019-01-23 18:11:23'),
	  ('V2019-02-11 16:44:05',50002,30003,'2019-02-11 16:44:05'),
	  ('V2019-04-22 12:01:18',50004,30004,'2019-02-28 12:01:18'),
	  ('V2019-07-18 15:11:47',50001,30005,'2019-07-18 15:11:47'),
	  ('V2019-07-20 16:13:37',50005,30002,'2019-07-20 16:13:37'),
	  ('V2019-08-23 22:48:46',50006,30005,'2019-08-23 22:48:46')

Insert into ParkingSlot(Status,SlotOwnerId,SlotUserId)
values('Occupied','2170458632','2170458632'),
	  ('Occupied','2569387410','2569387410'),
	  ('Occupied','2569387410','2102563987'),
	  ('Unoccupied','2125463917',''),
	  ('Unoccupied','1526486321','')

Insert into ParkingRecord(RecordNo,VehicleNo,ParkingSlotNo,EntryTime,ExitTime)
values  ('P-2019-07-13 17:48:43','DHA MET 13-2586',70002,'2019-07-13 17:48:43','2019-07-14 18:13:25'),
		('P-2019-08-17 18:41:13','DHA MET 12-6354',70001,'2019-08-17 18:41:13','2019-08-17 21:38:58'),
		('P-2019-08-13 11:18:44','DHA MET 34-2623',70002,'2019-08-13 11:18:44','2019-08-15 15:21:35'),
		('P-2019-08-13 15:04:14','DHA MET 27-2256',70005,'2019-08-13 15:04:14','2019-09-15 19:58:36'),
		('P-2019-08-18 12:08:15','DHA MET 26-1579',70003,'2019-08-18 12:08:15','2019-09-21 21:11:05')

Insert into Vis_Per(PersonID,VisitorID)
values	('1526486321','V2019-04-22 12:01:18'),
		('2170458632','V2019-07-18 15:11:47'),
		('2125463917','V2019-02-28 22:13:34'),
		('1526486321','V2019-02-11 16:44:05'),
		('2174896520','V2019-03-08 20:20:14'),
		('2569387410','V2019-01-23 18:11:23')

Select * from Persons
Select * from Admin
Select * from Security
Select * from Payments
Select * from GuestInfo
Select * from Visitor
Select * from ParkingSlot
Select * from ParkingRecord
Select * from Vis_Per
