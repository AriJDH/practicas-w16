INSERT INTO clients(dni,name,last_name,birth_date,province,city,is_active) VALUES 
('4727171', 'Mariana','Cano','1998-9-9', 'Antioquia', 'Medellín', true),
('7631873', 'Ruth', 'Clap','1997-8-2', 'Arauca', 'Arauca', true),
('92884', 'Diego', 'Garcia','1996-7-3', 'Caldas', 'Manizales', true),
('0725748', 'Felipe', 'Nuñez','1995-6-4', 'Chocó', 'Quibdó', true),
('820745', 'Estiven', 'Mendez','1998-1-5', 'Cundinamarca', 'Bogotá', true),
('820745', 'Sebastian', 'Restrepo','1998-8-6', 'Santander', 'Bucaramanga', true),
('820745', 'Marge', 'Lopez','1990-6-8', 'Guainía', 'Inírida	', true),
('820745', 'Homero', 'gragrave','2000-3-9', 'Tolima', 'Ibagué', true),
('820745', 'kaka', 'gragrave','2000-3-9', 'Sucre', 'Sincelejo', true);


INSERT INTO services(id_client,date_created,is_active) VALUES 
(214,'1998-9-9', true),
(215,'1997-8-2', true),
(216,'1996-7-3', true),
(217,'1995-6-4', true),
(218,'1998-1-5', true),
(219,'1995-6-4', true),
(220,'1998-1-5', true),
(221,'1998-1-5', true),
(222,'1995-6-4', true);

INSERT INTO type_plans(name,price,megas_byte,channels,hd,minutes_cellphone,minutes_house,`4k`,is_active) VALUES 
('internet', 110000, 100, 0, false, 0, 0, false, true),
('television', 23000, 0, 120, true, 0, 0, true, true),
('telefonia mobile',50000, 12, 0, false, 100, 10, false, true),
('telefonia hogar',30000, 0, 0, false, 20, 200000, false, true),
('full hogar',180000, 100, 200, true, 100, 20000, true, true);

INSERT INTO plans(antiquity,is_active) VALUES 
(10, true),
(12,true),
(1, true),
(0, true),
(2, true),
(3, true),
(5, true),
(7, true),
(9, true);

INSERT INTO detail_plan(id_plan, id_type_plan, date_created) VALUES 
(1, 1, '2010-8-8'),
(2, 2,'2011-9-9'),
(3, 3,'2009-6-6'),
(4, 4,'2008-5-5'),
(5, 5,'2000-3-3'),
(6, 2,'2001-4-5'),
(7, 3,'2005-3-5'),
(8, 4,'2009-3-7'),
(9, 5,'2011-3-8');

INSERT INTO contracts(id_service,date_contract_init, date_contract_end, total_bruto, total_neto, iva, total_discount,is_active) VALUES 
(1,'1998-9-9', '1998-9-10', 1000, 80000, 19, 10000, true),
(2,'1997-8-2', '1997-8-3', 2000, 70000, 19, 2000, true),
(3,'1996-7-3', '1996-7-4', 3000, 80000, 19, 40000, true),
(4,'1995-6-4', '1995-6-5', 4000, 60000, 19, 7000, true),
(5,'1998-1-5', '1998-1-6', 1000, 50000, 19, 60000, true),
(6,'1995-6-4', '1995-6-5', 15000, 90000, 19, 80000, true),
(7,'1998-1-5', '1998-1-6', 1000, 340000, 19, 9000, true),
(8,'1998-1-5', '1998-1-6', 6000, 70000, 19, 8000, true),
(9,'1995-6-4', '1995-6-5', 9000, 90000, 19, 110000, true);

INSERT INTO detail_plan_contract(id_contract,id_plan) VALUES 
(1, 9),
(2,8),
(3, 7),
(4, 6),
(5, 5),
(6, 4),
(7, 3),
(8, 2),
(9, 1);