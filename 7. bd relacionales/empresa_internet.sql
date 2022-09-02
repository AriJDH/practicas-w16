CREATE DATABASE empresa_internet;

CREATE TABLE plan (
	PlanId integer not null,
    Velocidad decimal not null,
    Precio decimal not null,
    Descuento decimal not null,
    primary key (PlanId)
);

CREATE TABLE cliente (
	DNI integer not null,
    Nombre varchar(50) not null,
    Apellido varchar(100) not null, 
    FechaNacimiento date not null,
    Provincia varchar(50) not null, 
    Ciudad varchar(100)not null,
    PlanId integer not null, 
    primary key(DNI),
    foreign key (PlanId) references Plan(PlanId)
);    
    
-- 5 registros plan
INSERT INTO Plan VALUES (1,  50.0, 1000.0, 0.0);
INSERT INTO Plan VALUES (2,  150.0, 1200.0, 10.0);
INSERT INTO Plan VALUES (3,  200.0, 1400.0, 5.0);
INSERT INTO Plan VALUES (4,  250.0, 1600.0, 15.0);
INSERT INTO Plan VALUES (5,  300.0, 1800.0, 8.0);

-- 10 registros cliente
INSERT INTO Cliente VALUES (214301, 'German', 'Rodriguez', '19920504', 'Canelones', 'Santa Lucia', 3);
INSERT INTO Cliente VALUES (214302, 'Pedro', 'Perez', '19900504', 'Montevideo', 'Montevideo', 2);
INSERT INTO Cliente VALUES (214303, 'Pablo', 'Gonzalez', '19870804', 'Canelones', 'Las Piedras', 1);
INSERT INTO Cliente VALUES (214304, 'Juana', 'Gonzalez', '19890904', 'Rocha', 'La Paloma', 4);
INSERT INTO Cliente VALUES (214305, 'Silvia', 'Alvarez', '19750312', 'Rocha', 'Punta del Diablo', 5);
INSERT INTO Cliente VALUES (214306, 'Santiago', 'Lacretta', '19460504', 'Maldonado', 'Punta del Este', 3);
INSERT INTO Cliente VALUES (214307, 'Hernan', 'Utria', '19990704', 'Lavalleja', 'Minas', 2);
INSERT INTO Cliente VALUES (214308, 'Romina', 'Bica', '20000504', 'Colonia', 'Colonia', 1);
INSERT INTO Cliente VALUES (214309, 'Patricia', 'Rivero', '19980504', 'San Jose', 'San Jose', 4);
INSERT INTO Cliente VALUES (214310, 'Javier', 'Rodriguez', '19970707', 'Florida', '25 de Agosto', 5);

-- 10 consultas
SELECT PlanId, Velocidad, Precio, Descuento FROM Plan;
SELECT DNI, Nombre, FechaNacimiento, Apellido, Provincia, Ciudad, PlanId from Cliente;
SELECT c.Nombre, c.Apellido, p.PlanId FROM Cliente c JOIN Plan p ON c.PlanId = p.PlanId;
SELECT Nombre, Apellido FROM Cliente WHERE PlanId IN (1,2,3);
SELECT PlanId, Velocidad, Precio FROM Plan ORDER BY Velocidad DESC;
SELECT PlanId, Velocidad, Precio FROM Plan WHERE Precio > 1500.0;
SELECT c.Nombre, c.Apellido, p.PlanId FROM Cliente c JOIN Plan p ON c.PlanId = p.PlanId WHERE c.Apellido = 'Gonzalez';
SELECT DNI, Nombre, Apellido FROM Cliente WHERE DNI > 214305 ORDER BY Nombre; 
SELECT Nombre, Apellido, Provincia, Ciudad, PlanId FROM Cliente WHERE Provincia = 'Rocha' AND PlanId > 3;
SELECT PlanId, Velocidad, Precio, Descuento FROM Plan WHERE Descuento >= 10.0;