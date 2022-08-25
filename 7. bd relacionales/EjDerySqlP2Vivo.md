
1. https://drive.google.com/file/d/1gIHVgmewzGLzTbCz6pB3axrFfMudrCqN/view

2. a). Las primary key son id_cliente, dni. Porque el id_cliente siempre sera destinto a los demas al ser autoincremental como el dni
    b). La primary key es id_plan. Porque el id_lan siempre sera destinto a los demas al ser autoincremental
     c). La relacion seria muchos a muchos. En una tabla intermedia la cual se llamo contrato. Hace referencia a sus primary key las cuales son id_plan y id_cliente

3. Lo hice en workbench, adjunto db

4.  select * from plan;
    select * from contrato;
    select * from cliente;
    select * from ciudad;
    select * from provincia;
    select * from plan where velocidad > 100;
    select * from plan where precio < 1000;
    select * from cliente where nombre="Ruben";
    select * from cliente where ciudad="Tucuman" order by nombre;
    select * from cliente where ciudad between '2000-01-01' and '2002-12-31';