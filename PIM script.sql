drop table if exists phonetest;
drop table if exists winetest; 
drop table if exists toiletpapertest;
drop table if exists producttest;
drop table if exists soundsystemtest;

drop table if exists images;
drop table if exists soundsystem;
Drop table if exists phone;
Drop table if exists wine;
Drop table if exists toiletpaper;
Drop table if exists product;

CREATE TABLE product(
productID int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
productName VARCHAR(45),
productType ENUM('wine', 'phone', 'toiletpaper', 'soundsystem'),
manufacturer VARCHAR(45),
description VARCHAR(500),
PRIMARY KEY (productID)
);

CREATE TABLE wine(
    productYear int,
    wineType ENUM('Red', 'White', 'Rose', 'Port', 'Dessert', 'Sparkling'),
    grape ENUM('Chardonnay', 'Trepat', 'Garnacha', 'Granache Noir', 'Corvina', 'Macabeo', 'Riesling', 'Charbonet Sauvignon'),
    volume ENUM('75', '100', '300'),
    alcholpercentage ENUM('10-12','12-13', '13-14', '14-15', '25-20', '20-30'),
    country VARCHAR(30), 
    productID int(5) unsigned zerofill NOT NULL,
    FOREIGN KEY (productID) REFERENCES product(productID)
);

    CREATE TABLE toiletpaper(
    layers enum('2', '4', '6'),  
    meter float,  
    numberOfRollsInBag enum('2', '4', '6'),  
    productID int(5) unsigned zerofill NOT NULL,   
    foreign key (productID) references product(productID)); 


CREATE TABLE phone(
    brand varchar(20),
    operatingSystem enum('IOS', 'Android'),
    screenSize float(3),
    displayType enum('plasma', 'LCD', 'OLED', 'Fluid AMOLED'),
    resolution enum ('HD', 'Full HD', 'QHD', 'UHD'),
    batteryCapacity int(2),
    simCardType enum ('mini', 'nano', 'micro', 'standard'),
    dualsim tinyint,
    megapixel float(3),
    hddStorage int (4),
    productID int(5) unsigned zerofill NOT NULL,
	foreign key (productID) references product(productID)
    
);

CREATE TABLE soundsystem(
    brand varchar(20),
    airplay tinyint, 
    speakersystem varchar(30),
    cableconnection tinyint,
    color varchar(20),
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
values 
("Iphone X", "phone", 'Apple', "Nam quis nulla. Integer malesuada."),
('Samsung Galaxy S 7', 'phone', 'Samsung', "Nam quis nulla. Integer malesuada."),
('Moto G6', 'phone', 'Motorola', "Nam quis nulla. Integer malesuada."),
('Iphone 8', 'phone', 'Apple', "Nam quis nulla. Integer malesuada."),
('Oneplus 3', 'phone', 'Oneplus', "Nam quis nulla. Integer malesuada."),
('Nokia 5230', 'phone', 'Nokia', "Nam quis nulla. Integer malesuada."),
('OnePlus 7 Pro 8GB+256GB Almond', 'phone', 'Oneplus', "Nam quis nulla. Integer malesuada."),
('OnePlus 7 Pro 8GB+256GB HazeBlue', 'phone', 'Oneplus', "Nam quis nulla. Integer malesuada."),
('Samsung Galaxy S10+ 128GB Hvid', 'phone', 'Samsung', "Nam quis nulla. Integer malesuada."), 
('Samsung Galaxy S10+ 128GB Sort', 'phone', 'Samsung', "Nam quis nulla. Integer malesuada."),

('Amalia, Garnacha', 'wine', 'Campo De Borja', "Garnacha har tendens til at blive over moden, men grundet de hårde omgivelser og store temperaturforskelle mellem nat og dag, formår druerne fra Campo de Borja at bevare en elegant syre og friskhed, som gør den perfekt til at drikke i store mængder. Farven er klar rubin med noter af jordbær, hindbær, lakrids og skov."),
('Antinori', 'wine', 'Villa Antinori Riserva', 'I forbindelse med åbningen af det nye fantastiske vineri ved Bargino, genoplivede Antinori en gammel historisk etiket med en helt ny Villa Antinori Chianti Classico Riserva fremstillet af 90 % Sangiovese og 10 % Cabernet og Merlot. Vinifikationen har fokus på den blidest mulige ekstrahering for at sikre bløde tanniner. 60 % af den unge vin er lagret på de traditionelle store botti, resten på små barriques af fransk og ungarsk eg.'),
('Torbreck Vintners', 'wine', 'David Powell', 'Vinhuset er grundlagt af David Powell så sent som i 1994. I 1992 opdagede Dave nemlig nogle små parceller af ældgamle vinstokke, som han købte og renoverede til topform. Navnet Torbreck stammer fra Skotland, hvor Dave tidligere har arbejdet. Torbreck er baseret på klassiske Barossavine, som stilmæssigt ligner vine fra Frankrigs Rhônedal.'),
('Bertani', 'wine', 'Corvina', "Corvina, Rondinella og en smule Merlot fra marker i Valpantena dalen og Valpolicella Classico. Første gæring i ståltanke og anden gæring (Ripasso) på kvaset fra Amarone. Efterfølgende lagret 9 måneder i 750 liters store egetræsfade."),
('Amalia, Garnacha', 'wine', 'Campo De Borja', 'Macabeo druen er kendt for sin centrale rolle i cava produktionen, men druen kan også spille førsteviolin i sit eget show. Amalia Macabeo er lavet med et lavt udbytte, forsigtig vinifikation og et ønske om renhed. Resultatet er en vin, som er letdrikkelig og perfekt til sommerens dage på terrassen med lette salater og fiskeretter. I både duft og smag viser vinen friske aebler, ananas, blomster og citroner.'),
('Coppola', 'wine', 'Diamond Chardonnay', 'Diamond Series Chardonnay er lavet udelukkende på druer fra Monterey, en regionkendt for sine optimale forhold til dyrkning af koldklima-vine. Hvidvinen laves vedat presse hele klaser. Den bliver fermenteret halvt på franske egetræsfade og halvt på ståltanke. Fermentationen på fade bliver efterfulgt at en malolaktisk fermentation som bidrager til hvidvinens fede karakter.'),
('Columbia Crest', 'wine', 'Grand Estates', 'I duften finder man Chardonnays klassiske smørrede stil, med fylde og velour og med appetitgivende aromaer af grape, melon og hvide ferskner. Vinen afslører en smule vanilje fra gæringen og modningen på fad. Smagen er flot struktureret, med god fedme og en meget lækker og sprødhed i eftersmagen. Den er både kompleks og frisk.'),
('Villa Wolf', 'wine', 'Pfalz-ejendom J. L. Wolf', 'Noter af fersken, abrikoser, citroner og æbler danser for fuld fart op ad glasset, mens rank syre supplerer den delikate sødme smukt. Villa Wolf Riesling 2017 fik for nyligt 6 stjerner i Gastro og ord som læskende og pokkers god med på vejen! Det ryddede vores lager fuldstændig! Vi har været hurtige og skaffet et parti af den nyeste og sprødeste årgang 2018, som i kortene er en endnu bedre årgang!'),

('Lambi toiletpaper', 'toiletPaper', 'Bambi', "Nam quis nulla. Integer malesuada."),

('Sonos Play 5 black', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos Play 5 white', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos 5.1 black', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos 5.1 white', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos SONOS 5.1 Surroundsound black', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos SONOS 5.1 Surroundsound white', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos Beam black', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos Beam white', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos one black',  'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos one white',  'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos one sl black', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada."),
('Sonos one sl white', 'soundsystem', 'Sonos', "Nam quis nulla. Integer malesuada.")


;
insert into phone
values 
("Apple", 'IOS', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 1),
("Samsung", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 2),
("Motorola", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 3),
("Apple", 'IOS', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 4),
("Oneplus", 'Android', 3.3, 'plasma', 'HD', 8, 'nano', 0, 12, 32, 5),
("Nokia", 'Android', 3.3, 'plasma', 'HD', 8, 'standard', 0, 12, 32, 6), 
("OnePlus", 'Android', 4.0, 'Fluid AMOLED', 'UHD', 9, 'nano', 1, 30, 128,7),
("OnePlus", 'Android', 4.0, 'Fluid AMOLED', 'UHD', 9, 'nano', 1, 30, 128,8),
("Samsung", 'Android', 3.7, 'OLED', 'UHD', 9,'nano',  1, 28, 128,9),
("Samsung", 'Android', 3.7, 'OLED', 'UHD', 9, 'nano',  1, 28, 128,10);

insert into wine
values ('2018', 'Red', 'Garnacha', '75', '13-14', 'Spanien', 11),
 ('2013', 'Red', 'Charbonet Sauvignon', '75', '13-14', 'Italien', 12),
 ('2016', 'Red', 'Granache Noir', '75', '13-14', 'Australien', 13),
 ('2017', 'Red', 'Corvina', '75', '13-14', 'Italien', 14),
 ('2018', 'White', 'Macabeo', '75', '13-14', 'Spanien', 15),
 ('2017', 'White', 'Chardonnay', '75', '13-14', 'Californien', 16),
 ('2016', 'White', 'Chardonnay', '75', '13-14',  'Washington State', 17),
 ('2018', 'White', 'Riesling', '75', '10-12', 'Tyskland', 18);


insert into toiletpaper
values(2, 2.0, 2, 19);

insert into soundsystem
values('Sonos', 1,'2-way soundbar', 1, 'black', 20),
('Sonos', 1,'2-way soundbar', 1, 'white', 21),
('Sonos', 1,'2-way subwoofer soundbar', 1, 'black', 22),
('Sonos', 1,'2-way subwoofer soundbar', 1, 'white', 23),
('Sonos', 0,'3-way soundbar', 1, 'black', 24),
('Sonos', 0,'3-way soundbar', 1, 'white', 25),
('Sonos', 0,'Compact Smart Soundbar', 1, 'black', 26),
('Sonos', 0,'Compact Smart Soundbar', 1, 'white', 27),
('Sonos', 0,'2-way', 1, 'black', 28),
('Sonos', 0,'2-way', 1, 'white', 29),
('Sonos', 0,'2-way', 1, 'black', 30),
('Sonos', 0,'2-way', 1, 'white', 31)


;
