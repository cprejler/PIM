drop table if exists phonetest;
drop table if exists winetest; 
drop table if exists toiletpapertest;
drop table if exists producttest;

drop table if exists images;
Drop table if exists phone;
Drop table if exists wine;
Drop table if exists toiletpaper;
Drop table if exists product;

CREATE TABLE product(
productID int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
productName VARCHAR(45),
productType ENUM('wine', 'phone', 'toiletpaper'),
manufacturer VARCHAR(45),
description VARCHAR(300),
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

    CREATE TABLE toiletpaper(
    layers enum('1', '2', '3'),  
    meter float,  
    numberOfRollsInBag enum('2', '4', '6'),  
    productID int(5) unsigned zerofill NOT NULL,   
    foreign key (productID) references product(productID)); 


CREATE TABLE phone(
    brand varchar(20),
    operatingSystem enum('IOS', 'Android'),
    screenSize float(3),
    displayType enum('plasma', 'LCD'),
    resolution enum ('HD', 'Full HD', 'QHD'),
    batteryCapacity int(2),
    simCardType enum ('mini', 'nano', 'micro', 'standard'),
    dualsim enum ('true', 'false'),
    megapixel float(3),
    hddStorage int (4),
    productID int(5) unsigned zerofill NOT NULL,
	foreign key (productID) references product(productID)
    
);

CREATE TABLE images(
	imageID int not null  auto_increment,
	image mediumblob,
    productID int(5) unsigned zerofill  NOT NULL,
    foreign key (productID) references product(productID),
    primary key (imageID)
);


insert into product (productName, productType, manufacturer, description)
values ("Iphone X", "phone", "Apple", "Nam quis nulla. Integer malesuada."),
('Samsung Galaxy S 7', 'phone', 'Samsung', "Nam quis nulla. Integer malesuada."),
('Moto G6', 'phone', 'Motorola', "Nam quis nulla. Integer malesuada."),
('Iphone 8', 'phone', 'Apple', "Nam quis nulla. Integer malesuada."),
('Oneplus 3', 'phone', 'Oneplus', "Nam quis nulla. Integer malesuada."),
('Nokia 5230', 'phone', 'Nokia', "Nam quis nulla. Integer malesuada."),
('Meandro Do Vale Meão 2014', 'wine', 'Quinta do Vale Meão', "Nam quis nulla. Integer malesuada."),
('test', 'wine', 'Dansk vin', "Nam quis nulla. Integer malesuada."),
('Lambi toiletpaper', 'toiletPaper', 'Bambi', "Nam quis nulla. Integer malesuada.");


insert into phone
values ("Apple", 'IOS', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 1),
("Samsung", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 2),
("Motorola", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 3),
("Apple", 'IOS', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 4),
("Oneplus", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 5),
("Nokia", 'Android', 3.3, 'plasma', 'HD', 8, 'standard', 0, 12, 32, 6); 

insert into wine
values ('2014', 'Red', 'Chardonay', '75', '13-14', 'Portugal', 7),
 ('2014', 'Red', 'Chardonay', '75', '13-14', 'Portugal', 8);


insert into toiletpaper
values(2, 2.0, 2, 9);


