

# ---------Meli Social----------

Meli Social es una plataforma en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Endopoints disponibles en Beta

### US 0000: Creacion de usuarios
#### Endpoint (POST)
```
{host}/createUser
```
#### Request Param
```
```
#### Request Body
```
[
    {
        "user_id": number,
        "user_name": "String"
    }
]
```
#### Response (OK - 201)
```
[
    {
        "user_id": number,
        "user_name": "String"
    }
]
```

### US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
#### Endpoint (POST)
```
{host}/users/{userId}/follow/{userIdToFollow}
```
#### Request Param
```
userId - number
userIdToFollow - number
```
#### Request Body
```
```
#### Response (OK - 200)
```
```

### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
#### Endpoint (GET)
```
{host}/users/{userId}/followers/count
```
#### Request Param
```
userId - number
```
#### Request Body
```
```
#### Response (OK - 200)
```
{
    "user_id": number,
    "user_name": "String",
    "followers_count": number
}
```

### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
#### Endpoint (GET)
```
{host}/users/{userId}/followers/list
```
#### Request Param
```
userId - number
```
#### Request Body
```
```
#### Response (OK - 200)
```
{
    "user_id": number,
    "user_name": "String",
    "followers": [
        {
            "user_id": number,
            "user_name": "String"
        }
    ]
}
```

### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
#### Endpoint (GET)
```
{host}/users/{userId}/followed/list
```
#### Request Param
```
userId - number
```
#### Request Body
```
```
#### Response (OK - 200)
```
{
    "user_id": number,
    "user_name": "String",
    "followed": [
        {
            "user_id": number,
            "user_name": "String"
        }
    ]
}
```

### US 0005: Dar de alta una nueva publicación
#### Endpoint (POST)
```
{host}/products/post
```
#### Request Param
```
```
#### Request Body
```
{
    "user_id": number,
    "date": "Date",
    "product": {
        "product_id": number,
        "product_name": "String",
        "type": "String",
        "brand": "String",
        "color": "String",
        "notes": "String"
    },
    "category": number,
    "price": double
}
```
#### Notas
Formato Date: "20-05-2022"
#### Response (OK - 200)
```
```

### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
#### Endpoint (GET)
```
{host}/products/followed/{userId}/list
```
#### Request Param
```
userId - number
```
#### Request Body
```
```
#### Response (OK - 200)
```
{
    "user_id": number,
    "posts": [
        {
            userId = number,
            postId = number,
            date = Date,
            "product": {
                "product_id": number,
                "product_name": "String",
                "type": "String",
                "brand": "String",
                "color": "String",
                "notes": "String"
            },
            category = number,
            price = double
        }
    ]
}
```

### US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
#### Endpoint (POST)
```
{host}/users/{userId}/follow/{userIdToFollow}
```
#### Request Param
```
userId - number
userIdToFollow - number
```
#### Request Body
```
```
#### Response (OK - 200)
```
```

### US 0008: Ordenamiento alfabético ascendente y descendente
#### Endpoint (GET) - ejemplos
```
{host}/users/{UserID}/followers/list?order=name_asc
{host}/users/{UserID}/followers/list?order=name_desc
{host}/users/{UserID}/followed/list?order=name_asc
{host}/users/{UserID}/followed/list?order=name_desc
```
#### Request Param
```
userId - number
(Optional) order - "name_asc" or "name_desc"
```
#### Request Body
```
```
#### Response (OK - 200)
```
{
    "user_id": number,
    "user_name": "String",
    "followed": [
        {
            "user_id": number,
            "user_name": "String"
        }
    ]
}
```

### US 0009: Ordenamiento por fecha ascendente y descendente
#### Endpoint (GET) - ejemplos
```
{host}/products/followed/{userId}/list?order=date_asc
{host}/products/followed/{userId}/list?order=date_desc
```
#### Request Param
```
userId - number
(Optional) order - "date_asc" or "date_desc"
```
#### Request Body
```
```
#### Response (OK - 200)
```
{
    "user_id": number,
    "posts": [
        {
            userId = number,
            postId = number,
            date = Date,
            "product": {
                "product_id": number,
                "product_name": "String",
                "type": "String",
                "brand": "String",
                "color": "String",
                "notes": "String"
            },
            category = number,
            price = double
        }
    ]
}
```

### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
#### Endpoint (POST)
```
{host}/products/promo-post
```
#### Request Param
```
```
#### Request Body
```
{
    "user_id": number,
    "date": "Date",
    "product": {
        "product_id": number,
        "product_name": "String",
        "type": "String",
        "brand": "String",
        "color": "String",
        "notes": "String"
    },
    "category": number,
    "price": double,
    "has_promo": boolean,
    "discount": double
}
```
#### Notas
Formato Date: "20-05-2022"
#### Response (OK - 200)
```
```
### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
#### Endpoint (GET)
```
{host}/products/promo-post/count?user_id={userId}
```
#### Request Param
```
userId - number
```
#### Request Body
```
```
#### Response (OK - 200)
```
{
    "user_id": number,
    "user_name": "String",
    "promo_products_count": number
}
```
