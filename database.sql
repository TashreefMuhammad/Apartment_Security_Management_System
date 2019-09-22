Create table Persons
(
	Id varchar(20) primary key,
	FlatNo int unique not null,
	Name varchar(25) not null,
	Age int not null,
	Profession varchar(10) not null,
	ContactNo varchar(11) not null,
	PermanentAddress varchar(50) not null,
	Status varchar(10) not null,
);

Create table Admin
(
	AdminId int identity(1000,1) primary key,
	AdminName varchar(25) not null,
	Status varchar(10) not null,
	Id varchar(20)	foreign key references Persons(Id),
	Username varchar(20) unique not null,
	Password varchar(20) unique not null	
);

Create table Security
(
	SecurityId int identity(2000,1) primary key,
	SecurityName varchar(25) not null,
	Username varchar(20) unique not null,
	Password varchar(20) unique not null	
);

Create table Payments
(
	Id int identity(3000,1) primary key,
	FlatNo int foreign key references Persons(FlatNo),
	DateofPayment date not null,
	DueCharges int 
);

Create table GuestInfo
(
	GuestId int identity(4000,1) primary key,
	GuestName varchar(25) not null,
	ContactNo varchar(11) not null,
);

Create table Visitor
(
	EntryId int identity(5000,1) primary key,
	GuestId int foreign key references GuestInfo(GuestId),
	SecurityId int foreign key references Security(SecurityId),
	EntryTime datetime not null,
	WhomtoVisit varchar(20) foreign key references Persons(Id)
);

Create table ParkingSlot
(
	SlotNo int identity(1,1) primary key,
	Status varchar(10) not null,
	SlotOwnerId varchar(20) foreign key references Persons(Id),
	SlotUserId varchar(20) unique
);

Create table ParkingRecord
(
	RecordNo int identity(8000,1) primary key,
	VehicleNo varchar(20) unique not null,
	ParkingSlotNo int foreign key references ParkingSlot(SlotNo),
	EntryTime datetime not null,
	ExitTime  datetime not null,
);
####

Create table Checking
(
	Id int identity(1,1) primary key,
	UserName varchar(50),
	Password varchar(50),
)

insert into Checking(UserName, Password) values ('First','Pass1'),('Second','pass2')

select * from Checking