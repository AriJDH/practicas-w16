use empresa_internet;

CREATE TABLE `cliente` (
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `fecha_de_nacimiento` date NOT NULL,
  `provincia` varchar(255) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
);

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

CREATE TABLE `plan_internet` (
  `velocidad` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `descuento` int(11) DEFAULT NULL,
  `nombre_plan` varchar(255) DEFAULT NULL
);

ALTER TABLE `plan_internet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `plan_internet_cliente_null_fk` (`id_cliente`);
  
ALTER TABLE `plan_internet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
  
ALTER TABLE `plan_internet`
  ADD CONSTRAINT `plan_internet_cliente_null_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);
COMMIT;

