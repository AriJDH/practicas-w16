# Grupo 7

## Documentación Swagger

- La documentación de cada uno de los endopoints se puede observar 
ingresando a la siguiente URL, una vez la aplicación esté en ejecución: 
http://localhost:8080/swagger-ui/index.html#/
- En la anterior URL cada uno de los endpoints tiene su descripción 
y explicación de sus posibles status codes.

## Test de Postman
- La colección de postman se encuentra en la carpeta resource.
- En la aplicación ya están creados previamente 4 usuarios con la siguiente información:
  - User1: {"id": 1111, "name": "John Doe"}
  - User2: {"id": 2222, "name": "Alexander The Great"}
  - User3: {"id": 3333, "name": "Me"}
  - User4: {"id": 4444, "name": "Bob"}

- Los anteriores usuarios están creados sin seguidores, 
sin seguidos, y sin posts.
- Es importante tener en cuenta que en nuestra API un usuario es 
considerado "vendedor" si tiene 1 o más post publicados.
- Un usuario se puede seguir si es "vendedor" es decir, si 
tiene 1 o más post publicados.
- Los seguidores se podrán listar sólo para los usuarios que 
son considerados "vendedores".

## Enpoint individual extra
- El endpoint individual extra consiste en listar las publicaciones 
de un vendedor, con la posibilidad de ordenarlos por fecha ascendente 
y descendentemente, y filtrarlos por promoción. Disponible en:
  /products/post/list. Documentado en Swagger.

