Drop table if exists phone;
Drop table if exists wine;
Drop table if exists product;

CREATE TABLE product(
productID int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
productName VARCHAR(45),
productType ENUM('Wine', 'Phone'),
manufacturer VARCHAR(45),
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
    productID int(5) unsigned zerofill NOT NULL,
    operatingSystem enum('IOS', 'Android'),
    screenSize float(3),
    displayType enum('plasma', 'LCD'),
    resolution enum ('HD', 'Full HD', 'QHD'),
    batteryCapacity int(2),
    simCardType enum ('mini', 'nano', 'micro', 'standard'),
    dualsim tinyint,
    megapixel float(3),
    hddStorage int (4),
	foreign key (productID) references product(productID)
    
);

