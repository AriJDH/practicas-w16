

# ---------Meli Social----------

Meli Social es una plataforma en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Endopoints disponibles en Beta

### Creacion de usuarios
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


### Agregar seguidor a usuario
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

### Quitar seguidor de usuario
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

### Obtener cantidad de seguidores de usuario
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

### Obtener listado de usuarios que siguen a un vendedor
#### Endpoint (GET)
```
{host}/users/{userId}/followers/list?order={order}
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
    "followers": [
        {
            "user_id": number,
            "user_name": "String"
        }
    ]
}
```

### Obtener listado de vendedores que sigue un usuario
#### Endpoint (GET)
```
{host}/users/{userId}/followed/list?order={order}
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

### Alta de publicacion
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
Formato Date: "01-05-2022"
#### Response (OK - 200)
```
```

### Obtener listado de publicaciones de vendedor que usuario sigue de las ultimas dos semanas
#### Endpoint (GET)
```
{host}/products/followed/{userId}/list?order={order}
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
