# ---------Meli Social----------

Meli Social es una plataforma en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de
todas las novedades que los mismos posteen.

## Endopoints disponibles en Beta

{url} url a definir...

## Creación de usuarios recibe una lista de users

```
POST /createUser
body[
       {
            "user_id": 7,
            "user_name": "vendedor1"
       }      
]
Return listaCompleta de users cargados.
```

## Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

```
GET /users/{userId}/followers/count
userId= Número que identifica a cada usuario
Response
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers_count": 35
}
```

## Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

```
GET /users/{userId}/followers/list
userId= Número que identifica a cada usuario
Response
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers": [
        {
            "user_id": 4698,
            "user_name": "usuario1"
        },
        {
            "user_id": 1536,
            "user_name": "usuario2"
        },
        {
            "user_id": 2236,
            "user_name": "usuario3"
        }
    ]
}

```

## Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

```
GET /users/{userId}/followers/list
userId= Número que identifica a cada usuario
Response
{
    "user_id": 4698,
    "user_name": "usuario1",
    "followed": [
        {
            "user_id": 234,
            "user_name": "vendedor1"
        },
        {
            "user_id": 6932,
            "user_name": "vendedor2"
        },
        {
            "user_id": 6631,
            "user_name": "vendedor3"
        }
    ]
}
```

## Dar de alta una nueva publicación

```
POST /products/post
body
{
    "user_id": 123,
    "date": "29-04-2021",
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
Response
Status Code 200 (todo OK)
Status Code 400 (Bad Request)

```

## Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero

```
GET /products/followed/{userId}/list
userId= Número que identifica a cada usuario
Response
{
    "user_id": 4698,
    "posts": [ {
            “user_id”: 123,
            "post_id": 32,
            "date": "01-05-2021",
            "product": {
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico",
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería"
            },
            "category": 120,
            "price": 2800.69
        },
        {
            “user_id”: 234,
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.50
        }
   ]
}

```

## Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

```
POST /users/{userId}/unfollow/{userIdToUnfollow}
userId= Número que identifica a cada usuario
userIdToUnfollow=Número que identifica al usuario a dejar de seguir
```

## Endpoints de ordenamiento

```
userId= Número que identifica a cada usuario

-----alfabético ascendente y descendente
/users/{UserID}/followers/list?order=name_asc
/users/{UserID}/followers/list?order=name_desc
/users/{UserID}/followed/list?order=name_asc
/users/{UserID}/followed/list?order=name_desc

------Ordenamiento por fecha ascendente y descendente

/products/followed/{userId}/list?order=date_asc
/products/followed/{userId}/list?order=date_desc

```

## Dar de alta una nueva publicacion en promoción

```
POST /products/promo-post
body
{
    "user_id": 123,
    "date": "29-04-2021",
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
    "has_promo":"true",
    "discount": 0.25
}
Response
Status Code 200 (todo OK)
Status Code 400 (Bad Request)

```

## Obtener el resultado de la cantidad de publicaciones en promocion que tiene un usuario

```
GET /products/promo-post/count?user_id={userId}
userId = Número que identifica a cada usuario
Response
{
    "user_id" : 234,
   "user_name": "vendedor1",
   "promo_products_count": 23
}
```

## Obtener un listado de todos los productos en promoción de un determinado vendedor

```
GET /products/promo-post/list?user_id={userId}
userId= Número que identifica a cada usuario
Response
{
    "user_id": 234,
    "user_name": "vendedor1",
    "posts": [
        {
            “user_id”: 234
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": "100",
            "price": 15000.50,
            "has_promo": true,
            "discount": 0.25
        }
    ]
}

```
