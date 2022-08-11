
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

### Post con promo
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
    "user_id": 4,
    "date": "04-08-2022",
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
#### Notas
Formato Date: "01-05-2022"
#### Response (Created - 201)
```
{
    "user_id": 1,
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
### Post con promo
#### Endpoint (POST)
```
{host}/products/promo-post/count
```
#### Request Param
```
user_id= 1
```
#### Request Body
```
```
#### Notas
Formato Date: "01-05-2022"
#### Response (Created - 201)
```
{
    "user_id": 1,
    "user_name": "name",
    "promo_products_count": canitidad de posts con promo
}
```
### Obtener listado de usuarios que siguen a un vendedor
#### Endpoint (GET)
```
{host}/products/promo-post/list
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
"user_id": 4,
    "user_name": "lucas",
    "posts": [
        {
            "user_id": 4,
            "post_id": 0,
            "date": "04-08-2022",
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