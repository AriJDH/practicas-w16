# Grupo 10

## Test de Postman

- En la aplicación ya estan creados previamente 4 usuarios con la siguiente información:
  - User1: {"id": 1, "name": "user1"}
  - User2: {"id": 2, "name": "user2"}
  - User3: {"id": 3, "name": "user3"}
  - User4: {"id": 4, "name": "user4"}

- La collección contiene distintas request para los mismos endpoints donde se podrán probar cada una de las validaciones.
- **Para proceder con los test, lo primero que se deberá hacer es crear un Post para el user de id 2.**

### Consideraciones:

- Los usuarios no poseen seguidores, seguidos ni posts.
- Solo se considera vendedor si el usuario tiene al menos un post.
- Solo se puede seguir a vendedores.
- Solo se puede listar seguidores de un vendedor.
- Si los parámetros de filtro no se corresponden con los especificados, simplemente son ignorados y se utiliza la ordenación por defecto.