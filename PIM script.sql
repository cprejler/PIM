Drop table if exists phone;
Drop table if exists wine;
Drop table if exists toiletPaper;
Drop table if exists product;

CREATE TABLE product(
productID int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
productName VARCHAR(45),
productType ENUM('wine', 'phone'),
manufacturer VARCHAR(45),
published tinyint(0),
PRIMARY KEY (productID)
);

CREATE TABLE wine(
    productYear int,
    wineType ENUM('Red', 'White', 'Rose', 'Port', 'Dessert', 'Sparkling'),
    grape ENUM('Chardonay', 'Trepat', ''),
    volume ENUM('75', '100', '300'),
    alcholpercentage ENUM('10-12','12-13', '13-14', '14-15', '25-20', '20-30'),
    country VARCHAR(30), 
    productID int(5) unsigned zerofill NOT NULL,
    FOREIGN KEY (productID) REFERENCES product(productID)
);


CREATE TABLE phone(
    brand varchar(20),
    operatingSystem enum('IOS', 'Android'),
    screenSize float(3),
    displayType enum('plasma', 'LCD'),
    resolution enum ('HD', 'Full HD', 'QHD'),
    batteryCapacity int(2),
    simCardType enum ('mini', 'nano', 'micro', 'standard'),
    dualsim tinyint,
    megapixel float(3),
    hddStorage int (4),
    productID int(5) unsigned zerofill NOT NULL,
	foreign key (productID) references product(productID)
    
);


insert into product (productName, productType, manufacturer)
values ("Iphone X", "phone", "Apple"),
('Samsung Galaxy S 7', 'phone', 'Samsung'),
('Moto G6', 'phone', 'Motorola'),
('Iphone 8', 'phone', 'Apple'),
('Oneplus 3', 'phone', 'Oneplus'),
('Nokia 5230', 'phone', 'Nokia'),
('Meandro Do Vale Meão 2014', 'wine', 'Quinta do Vale Meão');

insert into phone
values ("Apple", 'IOS', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 1),
("Samsung", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 2),
("Motorola", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 3),
("Apple", 'IOS', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 4),
("Oneplus", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 5),
("Nokia", 'Android', 3.3, 'plasma', 'HD', 8, 'standard', 0, 12, 32, 6); 

insert into wine
values ('2014', 'Red', 'Chardonay', '75', '13-14', 'Portugal', 7);