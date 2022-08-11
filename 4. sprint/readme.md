# Como usar

Primero abrir la coleccion de postman:

Sprint I.postman_collection.json

Vienen precargados 5 usuarios.

La aplicacion corre con spring en el puerto 8080 por defecto.

## Glosario:

### PathParams
Se utilizaran llaves dentro del path para denominar los nombres de los parametros. ejemplo: /product/{productId}
Siendo productId el id de un producto existente.

### Errores

Todos los errores van a ser devueltos con esta estructura. Donde error es el status http del error y message es el contenido del mensaje del error.

```javascript
{
    "error": 400,
    "message": "The user with the id 1 is not a seller."
}
```


Errores
## Usuarios

1. Seguir a un usuario:

>/users/{userId}/follow/{userToFollow}

Usar para que un usuario(userId) siga a un vendedor(userToFollow).
Es necesario que un usuario tenga publicado, por lo menos 1 producto para ser considerado vendedor, de lo contrario arrojara un error.

*Retorna*

Status http 200 OK.

Status http 400 Bad Request con un error relevante.

2. Contar seguidores:

>/users/1/followers/count

Usar para contar los seguidores de un usuario.

Retorna

Status http 200 OK.


Body
```javascript
{
    "user_id": 1,
    "user_name": "user1",
    "followers_count": 0
}
```

Status http 400 Bad Request con un error relevante.

3. Usar para listar los seguidores de un usuario

>/users/{userId}/followers/list

Query params:
- order: name_desc, name_asc OPTIONAL

Retorna

Status http 200 OK.

```javascript
{
    "user_id": 1,
    "user_name": "user1",
    "followers": [
        {
            "user_id": 3,
            "user_name": "user3"
        },
        {
            "user_id": 2,
            "user_name": "user2"
        }
    ]
}
```

Status http 400 Bad Request con un error relevante.

4. Usar para listar la lista de seguidos de un usuario
>/users/2/followed/list

```javascript
{
    "user_id": 2,
    "user_name": "user2",
    "followed": [
        {
            "user_id": 1,
            "user_name": "user1"
        }
    ]
}
```
### 5. Usar para dejar de seguir a un vendedor

> /users/{client_id}/unfollow/{seller_id}

*Retorna*

Status http 200 OK.

Status http 400 Bad Request con un error relevante.

## Productos

1. Agrega una publicacion de un producto

>/products/post

Body: 
```javascript
{
    "user_id": "1",
    "date": "01-08-2022",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```
*Retorna*

Status http 200 OK.

Status http 400 Bad Request con un error relevante.

2. Usar para listar todas las publicaciones de los seguidos de un usuario.

>/products/followed/{userId}/list

Query params:
- order: date_desc, date_asc

*Retorna*:

Http status 200

Body

```javascript
{
    "user_id": 2,
    "posts": [
        {
            "user_id": 1,
            "post_id": 1,
            "date": "01-08-2022",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 1500.5
        }
    ]
}
```

3. Usa para agregar una publicacion con promocion

>/products/promo-post

Body

```javascript
{
    "user_id": "1",
    "date": "01-08-2022",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "has_promo": true,
    "discount": 0.25
}
```

4. Usa para contar la cantidad de productos con promocion.
>/products/promo-post/count

Query params:
- user_id: integer REQUERIDO

ejemplo: /products/promo-post/count?userId=1


retorna
Status: Http 200
Body

```javascript
{
    "user_id": 1,
    "user_name": "user1",
    "promo_products_count": 1
}
```

5. Usa para listar la cantidad de productos en promocion de un usuario
>/products/promo-post/list
Query params:
- user_id: integer REQUERIDO

ejemplo /products/promo-post/list?userId=1

retorna
Status: Http 200
Body

```javascript
{
    "user_id": 1,
    "user_name": "user1",
    "posts": [
        {
            "user_id": 1,
            "post_id": 2,
            "date": "01-05-2022",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 1500.5,
            "has_promo": true,
            "discount": 0.25
        }
    ]
}
```