​

# ---------Meli Social----------

​ Meli Social es una plataforma en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de
todas las novedades que los mismos posteen. ​

# Campos Validados
| Dato/Parametro | Obligatorio? | Validacion | Mensaje de error|
| --- | --- | --- | --- |
| `user_id `| Si | - Que el campo no esté vacío. & - Mayor 0 | El  id no puede estar vacío. & El id debe ser mayor a cero|
| `id_post `| Si | - Que el campo no esté  | El id_post no puede estar vacío.|
| `brand `| Si | - Que el campo no esté vací. & - Longitud máxima de 25 caracteres. & -Que no posea caracteres especiales (%, &, $, etc)| -El campo no puede estar vacío.La longitud no puede superar los 25 caracteres.& -El campo no puede poseer caracteres especiales.|
| `date `| Si | - Que el campo no esté vacío. | -La fecha no puede estar vacia|
| `product_id `| Si | - Que el campo no esté vacío. & - Mayor 0 | El  id no puede estar vacío. & El id debe ser mayor a cero|
| `product_name `| Si | - Que el campo no esté vacío. & Longitud máxima de 40 caracteres. & -Que no posea caracteres especiales (%, &, $, etc), permite espacios. | El campo no puede estar vacío.La longitud no puede superar los 40 caracteres.El campo no puede poseer caracteres especiales.|
| `type `| Si | -Que el campo no esté vacío.& -Longitud máxima de 15 caracteres.& -Que no posea caracteres especiales (%, &, $, etc)  | -El campo no puede estar vacío. & -La longitud no puede superar los 15 caracteres. & -El campo no puede poseer caracteres especiales.|
| `color `| Si | - Que el campo no esté vacío.|El campo no puede estar vacío.|
| `notes `| Si | -Longitud máxima de 80 caracteres.& -Que no posea caracteres especiales (%, &, $, etc), permite espacios. | -La longitud no puede superar los 80 caracteres.& -El campo no puede poseer caracteres especiales.|
| `category `| Si | - Que el campo no esté vacío.| El campo no puede estar vacío.|
| `price `| Si | - Que el campo no esté vacío. & -El precio máximo puede ser 10.000.000. | El campo no puede estar vacío. & -El precio máximo por producto es de 10.000.000|

## Endopoints disponibles en Beta

​

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

​ ​

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

​

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

​

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

​

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

​

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

​

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

​

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
