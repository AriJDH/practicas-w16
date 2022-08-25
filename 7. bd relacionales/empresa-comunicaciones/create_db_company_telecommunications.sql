DROP DATABASE IF EXISTS company_tigo;
CREATE DATABASE company_tigo;
USE company_tigo;
CREATE TABLE `clients` (
	`id_client` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`dni` VARCHAR(50) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`last_name` VARCHAR(100) NOT NULL,
	`birth_date` timestamp NOT NULL,
	`province` VARCHAR(100) NOT NULL,
	`city` VARCHAR(100) NOT NULL,
	`is_active` BOOLEAN DEFAULT TRUE,
	PRIMARY KEY (`id_client`)
);
CREATE TABLE `services` (
	`id_service` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`id_client` INT UNSIGNED NOT NULL,
	`date_created` TIMESTAMP  NOT NULL,
	`is_active` BOOLEAN DEFAULT TRUE,
	PRIMARY KEY (`id_service`),
	KEY `services_clients` (`id_client`),
	CONSTRAINT `services_clients` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`)
);
CREATE TABLE `type_plans` (
	`id_type_plan` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`price` FLOAT  NOT NULL,
	`megas_byte` INT NOT NULL,
	`channels` INT NOT NULL,
	`hd` BOOLEAN DEFAULT FALSE,
	`minutes_cellphone` INT NOT NULL,
	`minutes_house` INT NOT NULL,
	`4k` BOOLEAN DEFAULT FALSE,
	`is_active` BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (`id_type_plan`)
);
CREATE TABLE `plans` (
	`id_plan` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `antiquity` INT NOT NULL,
    `is_active` BOOLEAN DEFAULT TRUE,
	PRIMARY KEY (`id_plan`)
);
CREATE TABLE `detail_plan` (
	`id_detail_plan` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `id_plan` INT UNSIGNED NOT NULL,
    `id_type_plan` INT UNSIGNED NOT NULL,
    `date_created` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id_detail_plan`),
	KEY `detail_plan_type_plan` (`id_type_plan`),
    KEY `detail_plan_plan` (`id_plan`),
	CONSTRAINT `detail_plan_type_plan` FOREIGN KEY (`id_type_plan`) REFERENCES `type_plans` (`id_type_plan`),
	CONSTRAINT `detail_plan_plan` FOREIGN KEY (`id_plan`) REFERENCES `plans` (`id_plan`)
);
CREATE TABLE `contracts` (
	`id_contract` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `id_service` INT UNSIGNED NOT NULL,
    `date_contract_init` TIMESTAMP NOT NULL,
    `date_contract_end` TIMESTAMP NOT NULL,
    `total_bruto` FLOAT NOT NULL,
    `total_neto` FLOAT NOT NULL,
    `iva` DOUBLE NOT NULL,
    `total_discount` FLOAT NOT NULL,
    `is_active` FLOAT NOT NULL,
	PRIMARY KEY (`id_contract`),
    KEY `contract_service` (`id_service`),
	CONSTRAINT `contract_service` FOREIGN KEY (`id_service`) REFERENCES `services` (`id_service`)
);
CREATE TABLE `detail_plan_contract` (
	`id_detail_plan_contract` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `id_contract` INT UNSIGNED NOT NULL,
    `id_plan` INT UNSIGNED NOT NULL,
	PRIMARY KEY (`id_detail_plan_contract`),
	KEY `detail_plan_contract_contract` (`id_contract`),
    KEY `id_detail_plan_contract_plan` (`id_plan`),
	CONSTRAINT `detail_plan_contract_contract` FOREIGN KEY (`id_contract`) REFERENCES `contracts` (`id_contract`),
	CONSTRAINT `id_detail_plan_contract_plan` FOREIGN KEY (`id_plan`) REFERENCES `plans` (`id_plan`)
);
