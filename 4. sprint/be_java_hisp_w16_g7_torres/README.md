# Grupo 7

## Documentación Swagger

- La documentación de cada unos de los endopoints se puede observar ingresando a la siguiente URL, una vez la aplicación este corriendo: http://localhost:8080/swagger-ui/index.html#/
- En la anterior URL cada uno de los endpoints tiene su descripción, y explicación de cada posible status code que pueda arrojar

## Test de Postman

- En la aplicación ya estan creados previamente 4 usuarios con la siguiente información:
  - User1: {"id": 1111, "name": "John Doe"}
  - User2: {"id": 2222, "name": "Alexander The Great"}
  - User3: {"id": 3333, "name": "Me"}
  - User4: {"id": 4444, "name": "Bob"}

- Los anteriores usuarios están creados sin seguidores, sin seguidos, y sin posts. (Si se quiere observar la estructura de los usuarios previamente creados ir a la clase _UserRespository_._java_)
- Es importante tener en cuenta que en nuestra API un usuario es considerado "vendedor" si tiene 1 o más post publicados.
- Un usuario se puede seguir si es "vendedor" es decir, si tiene 1 o más post publicados.
- Y los seguidores se podrán listar sólo para los usuarios que son considerados "vendedores".

## BONUS

- Realicé el "reto" propuesto de añadir un endpoint bonus, este hace un resumen de los posts de un determinado vendedor, mostrando:
   - Id del usuario, Id de todos sus posts.
   - Cantidad total de posts, Cantidad total de promo posts. 
   - El valor monetario total de sus posts. 
   - La fecha del post más viejo y el más nuevo.
   - Y su post con el precio mas alto.
