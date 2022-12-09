--Database of 'luvashop'
--Init database 'luvashop'
set client_encoding = 'UTF8';
drop schema if exists luvashop cascade;
create schema luvashop;
set search_path = luvashop;
set datestyle to DMY;


--Init my define data types 
create domain phonenumber as text check (value ~ '(\+84|0[3|5|7|8|9])+([0-9]{8})');


--Create table for database 'luvashop'
create table Brand (
	BrandID serial not null,
	BrandName text not null unique,
	BrandCountry text not null,
	constraint pk_brand primary key (BrandID)
);
create table Product (
	ID serial not null,
	ProductID varchar(10) generated always as (lpad(MOD(ID, 100000)::text,4,'0')) stored unique,
	ProductName text not null unique,
	BrandID integer not null,
	AddDate date not null default current_date,
	DeleteDate date default null,
	PathImage text default null,
	constraint pk_product primary key (ID),
	constraint fk_brandproduct foreign key (BrandID) references Brand(BrandID)
);
create table PhoneInfo (
	ProductID text not null,
	Chip text not null,
	Screen text not null,
	Connected text not null,
	OS text not null,
	Material text not null,
	Battery text not null,
	Sim text not null,
	Camera text not null,
	constraint fk_phoneinfo foreign key (ProductID) references Product(ProductID),
	constraint uq_phoneinfo unique (ProductID, Chip, Screen, Connected, OS, Material, Battery, Sim, Camera)
);
create table LaptopInfo (
	ProductID text not null,
	Screen text not null,
	Connected text not null,
	OS text not null,
	Material text not null,
	LaptopSize text not null,
	Weight text not null,
	Camera text not null,
	CPU text not null,
	constraint fk_laptopinfo foreign key (ProductID) references Product(ProductID),
	constraint uq_laptopinfo unique (ProductID, Screen, Connected, OS, Material, LaptopSize, Weight, Camera, CPU)
);
create table SmartwatchInfo (
	ProductID text not null,
	Screen text not null,
	Frontglass text not null,
	OS text not null,
	Battery text not null,
	constraint fk_smartwatchinfo foreign key (ProductID) references Product(ProductID),
	constraint uq_smartwatchinfo unique (ProductID, Screen, Frontglass, OS, Battery)
);
create table HeadphoneInfo (
	ProductID text not null,
	Usetime text not null,
	Boxtime text not null,
	OS text not null,
	Charger text not null,
	Connected text not null,
	HeadphoneControl text not null,
	constraint fk_headphoneinfo foreign key (ProductID) references Product(ProductID),
	constraint uq_headphoneinfo unique (ProductID, Usetime, Boxtime, OS, Charger, Connected, HeadphoneControl)
);
create table KeyboardInfo (
	ProductID text not null,
	Led text not null,
	Keycap text not null,
	OS text not null,
	Battery text not null,
	constraint fk_keyboardinfo foreign key (ProductID) references Product(ProductID),
	constraint uq_keyboardinfo unique (ProductID, Led, Keycap, OS, Battery)
);
create table Specification (
	SKU text not null,
	ProductID text not null, 
	Price numeric not null check (Price > 0), 
	Instock int not null check (Instock > 0),
	constraint pk_specification primary key (SKU), 
	constraint fk_specification foreign key (ProductID) references Product(ProductID)
);
create table Colors (
	NameColor text not null,
	HexColor text not null,
	constraint pk_namecolor primary key (NameColor),
	constraint uq_colors unique (NameColor, HexColor)
);
create table PhoneVariation (
	ID serial not null,
	VariantID varchar(10) generated always as (lpad(MOD(ID, 100000)::text,4,'0')) stored unique,
	SKU text not null,
	PhoneRam text not null,
	PhoneColor text not null,
	PhoneStorage text not null,
	PathImage text default null,
	constraint pk_phonevariation primary key (ID),
	constraint fk_phonevariation foreign key (SKU) references Specification(SKU),
	constraint fk_colorphonevariation foreign key (PhoneColor) references Colors(NameColor),
	constraint uq_phonevariaiton unique (SKU, PhoneRam, PhoneColor, PhoneStorage, PathImage)
);
create table LaptopVariation (
	ID serial not null,
	VariantID varchar(10) generated always as (lpad(MOD(ID, 100000)::text,4,'0')) stored unique,
	SKU text not null,
	LaptopRam text not null,
	LaptopColor text not null, 
	LaptopStorage text not null,
	PathImage text default null,
	constraint pk_laptopvariation primary key (ID),
	constraint fk_laptopvariation foreign key (SKU) references Specification(SKU),
	constraint fk_colorlaptopvariation foreign key (LaptopColor) references Colors(NameColor),
	constraint uq_laptopvariation unique (SKU, LaptopRam, LaptopColor, LaptopStorage, PathImage)
);
create table SmartwatchVariation (
	ID serial not null,
	VariantID varchar(10) generated always as (lpad(MOD(ID, 100000)::text,4,'0')) stored unique,
	SKU text not null,
	SmartwatchEdition text not null,
	SmartwatchColor text not null,
	PathImage text default null,
	constraint pk_smartwatchvariation primary key (ID),
	constraint fk_smartwatchvariation foreign key (SKU) references Specification(SKU),
	constraint fk_colorsmartwatchvariation foreign key (SmartwatchColor) references Colors(NameColor),
	constraint uq_smartwatchvariation unique (SKU, SmartwatchEdition, SmartwatchColor, PathImage)
);
create table KeyboardVariation (
	ID serial not null,
	VariantID varchar(10) generated always as (lpad(MOD(ID, 100000)::text,4,'0')) stored unique,
	SKU text not null,
	KeyboardSwitch text not null,
	KeyboardColor text not null,
	PathImage text default null,
	constraint pk_keyboardvariation primary key (ID),
	constraint fk_keyboardvariation foreign key (SKU) references Specification(SKU),
	constraint fk_colorkeyboardvariation foreign key (KeyboardColor) references Colors(NameColor),
	constraint uq_keyboardvariation unique (SKU, KeyboardSwitch, KeyboardColor, PathImage)
);
create table HeadphoneVariation (
	ID serial not null,
	VariantID varchar(10) generated always as (lpad(MOD(ID, 100000)::text,4,'0')) stored unique,
	SKU text not null,
	HeadphoneColor text not null,
	PathImage text default null,
	constraint pk_headphonevariation primary key (ID),
	constraint fk_headphonevariation foreign key (SKU) references Specification(SKU),
	constraint fk_colorheadphonevariation foreign key (HeadphoneColor) references Colors(NameColor),
	constraint uq_headphonevariation unique (SKU, HeadphoneColor, PathImage)
);
create table Staff (
	StaffID serial not null,
	StaffName text not null,
	StaffBirthday date not null,
	StaffAddress text not null,
	StaffPosition text not null,
	constraint pk_staff primary key (StaffID),
	constraint uq_staff unique (StaffName, StaffBirthday, StaffAddress, StaffPosition)
);
create table Customer (
	CustomerID serial not null,
	CustomerName text not null,
	CustomerBirthday date not null,
	CustomerAddress text not null,
	CustomerPhone phonenumber not null unique,
	constraint pk_customer primary key (CustomerID),
	constraint uq_customer unique (CustomerName, CustomerBirthday, CustomerAddress, CustomerPhone)
);
create table Orders (
	OrderID serial not null,
	CustomerID integer not null,
	Totalprice numeric not null check (Totalprice > 0),
	OrderDate date not null default current_date,
	StaffSale integer default null,
	StaffBack integer default null,
	constraint pk_orders primary key (OrderID),
	constraint fk_orders_customer foreign key (CustomerID) references Customer(CustomerID),
	constraint fk_orders_sale foreign key (StaffSale) references Staff(StaffID),
	constraint fk_orders_back foreign key (StaffBack) references Staff(StaffID)
);
create table OrderDetails (
	OrderID integer not null,
	SKU text not null,
	Quantity integer not null check (Quantity > 0),
	constraint fk_order foreign key (OrderID) references Orders(OrderID),
	constraint fk_sku foreign key (SKU) references Specification(SKU),
	constraint pk_order_sku primary key (OrderID, SKU)
);
create table GivebackItems (
	OrderID integer not null,
	SKU text not null,
	Quantity integer not null check (Quantity > 0),
	Reason text not null,
	Payback numeric not null check (Payback > 0),
	BackDate date not null,
	constraint fk_orderback foreign key (OrderID) references Orders(OrderID),
	constraint fk_skuback foreign key (SKU) references Specification(SKU),
	constraint pk_orderback_skuback primary key (OrderID, SKU)
);
create table Attendence (
	StaffID integer not null,
	Workday date not null,
	Checkin time,
	Checkout time,
	constraint fk_attendence_staff foreign key (StaffID) references Staff(StaffID),
	constraint pk_attendence primary key (StaffID, Workday)
);
create table Account (
	StaffID integer not null,
	AccountUser text not null unique,
	AccountPass text not null,
	constraint pk_account primary key (AccountUser),
	constraint fk_account foreign key (StaffID) references Staff(StaffID)
);
create table Promotion (
	PromotionID serial not null,
	NamePromotion text not null unique,
	StartDate date not null,
	EndDate date not null,
	constraint pk_promotion primary key (PromotionID)
);
create table PromtionDetail (
	PromotionID integer not null,
	SKU text not null,
	PercentPromotion numeric not null,
	constraint fk_promotioniddetail foreign key (PromotionID) references Promotion(PromotionID),
	constraint fk_skudetail foreign key (SKU) references Specification(SKU),
	constraint pk_promotiondetail primary key (PromotionID, SKU)
);
CREATE TABLE PurchaseOrder (
	PurchaseOrderID serial NOT NULL,
	EmployeeIDCreate int NOT NULL,
	EmployeeIDConfirm int default null,
	TotalPrice int not null,
	PurchaseDate date not null,
	ExpectedDeliveryDate date not null,
	SupplierName text not null,
	SupplierAddress text not null,
	Status text not null,
	constraint fk_empcreate foreign key (EmployeeIDCreate) references Staff(StaffID),
	constraint fk_empconfirm foreign key (EmployeeIDConfirm) references Staff(StaffID),
	constraint pk_purchaseorder primary key (PurchaseOrderID)
);
create table PurchaseOrderDetail (
	PurchaseOrderID int NOT NULL,
	SKU text not null,
	OrderQty int not null,
	ReceiveQty int not null,
	constraint fk_purchasesku foreign key (SKU) references Specification(SKU),
	constraint fk_purchaseorderdetailid foreign key (PurchaseOrderID) references PurchaseOrder(PurchaseOrderID),
	constraint pk_purchaseorderdetail primary key (PurchaseOrderID, SKU)
);

