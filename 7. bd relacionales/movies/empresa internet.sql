DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Plans;
DROP TABLE IF EXISTS Cities;
DROP TABLE IF EXISTS Provinces;

CREATE TABLE Provinces (
	provinceId INT NOT NULL AUTO_INCREMENT,
    provinceCode VARCHAR(100) NOT NULL UNIQUE,
    provinceName VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY(provinceId)
);

CREATE TABLE Cities (
	cityId INT NOT NULL AUTO_INCREMENT UNIQUE,
    cityCode VARCHAR(100) NOT NULL UNIQUE,
    cityName VARCHAR(100) NOT NULL,
    provinceId INT NOT NULL,
	PRIMARY KEY(cityId),
    FOREIGN KEY(provinceId) REFERENCES Provinces(provinceId)
);

CREATE TABLE Plans (
	planId INT NOT NULL AUTO_INCREMENT UNIQUE,
    planName VARCHAR(100) NOT NULL UNIQUE,
    planPrice FLOAT NOT NULL,
	planDiscount FLOAT NOT NULL,
    planSpeed VARCHAR(50) NOT NULL,
	PRIMARY KEY(planId)
);

CREATE TABLE Customers (
	customerId INT NOT NULL AUTO_INCREMENT,
    customerName VARCHAR(100) NOT NULL,
	customerLastname VARCHAR(100) NOT NULL,
    customerBirthdate DATE NOT NULL,
	customerDni INT NOT NULL,
	PRIMARY KEY(customerId),
	cityId INT NOT NULL,
	planId INT NOT NULL,
	FOREIGN KEY(cityId) REFERENCES Cities(cityId),
	FOREIGN KEY(planId) REFERENCES Plans(planId)
);

INSERT INTO Provinces
	(
    provinceCode,
    provinceName
    )
VALUES 
	("001", "CABA"),
	("002", "Buenos Aires");
    
INSERT INTO Cities
	(
    cityCode,
    cityName,
    provinceId
    )
VALUES 
	("001", "Belgrano", 1),
	("002", "La matanza", 2);
    
INSERT INTO Plans
	(planName, planPrice, planDiscount, planSpeed)
VALUES 
	("barato", 100, 10, '100mb'),
	("medio", 200, 20, '200mb'),
	("caro", 300, 20, '300mb'),
	("empresarial", 400, 50, '400mb'),
	("simetrico", 1000, 0, '500mb');
    
    
INSERT INTO Customers
	(
    customerName,
	customerLastname,
    customerBirthdate,
	customerDni,
	cityId,
	planId
    )
VALUES 
	("Matias", "Lamela", '1992-08-23', 37067108, 1, 1);

select * from Plans;
select * from Provinces;
select * from Cities;


