1. Las entidades serian 3: Producto, Cliente, Venta

2. Cliente: id, nombre y apellido, telefono, direccion
        Producto: id, codigo, precio, cantidad, nombre
            Venta: id, fecha, montoFinal, total, descuento, id_cliente, codigo

3. Relacion de uno a muchos: Cliente -> Venta
        Relacion de muchos a muchos: Venta <--> Producto. Donde se crearia una tabla intermedia; Venta_Producto: id, codigo, id_venta, id_producto, cantidad

4. Es el archivo que se llama Ej1BDRelacionalesPG.drawio