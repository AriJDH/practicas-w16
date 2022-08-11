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


- ***_Nota: La colección de Postman se encuentra en la carpeta resources del proyecto_**

## Parte Individual - Bonus

- Para esta parte realicé un requerimiento nuevo el cual lista todo los posts que tengan un tipo de producto específico.
Por ejemplo, si se ingresa un producto tipo "Tech", mostrara los posts de todos los usuarios que tengan algún post con un producto tipo "Tech" (No importa si tiene descuento o no)
 

- El endpoint es método GET y se llama con "_/products/post/list/{type}_" ( _{type}_ debe ser de tipo String)


- La respuesta que arroje el endpoint en caso de que si existan post con ese tipo de producto debe ser de esta manera (Como se observa trae todos los post que tienen productos de tipo "_Tech_"):


```json
[
  {
    "user_id": 1111,
    "user_name": "John Doe",
    "posts": [
      {
        "user_id": 1111,
        "post_id": 1,
        "date": "2022-07-10",
        "product": {
          "product_id": 23232,
          "product_name": "Iphone",
          "type": "Tech",
          "brand": "Apple",
          "color": "White",
          "notes": "new"
        },
        "category": 120,
        "price": 2000.0,
        "has_promo": false,
        "discount": 0.0
      },
      {
        "user_id": 1111,
        "post_id": 2,
        "date": "2022-07-10",
        "product": {
          "product_id": 324234,
          "product_name": "Mouse",
          "type": "Tech",
          "brand": "HP",
          "color": "Black",
          "notes": "Special edition"
        },
        "category": 423,
        "price": 180.0,
        "has_promo": true,
        "discount": 0.1
      }
    ]
  },
  {
    "user_id": 2222,
    "user_name": "Alexander The Great",
    "posts": [
      {
        "user_id": 2222,
        "post_id": 3,
        "date": "2022-07-10",
        "product": {
          "product_id": 324234,
          "product_name": "Airpods",
          "type": "Tech",
          "brand": "Apple",
          "color": "White",
          "notes": "New collection"
        },
        "category": 423,
        "price": 390.0,
        "has_promo": true,
        "discount": 0.22
      }
    ]
  }
]
```

- En caso de que no existan post con el tipo de producto ingresado se arroja una excepción y un  mensaje que dice los siguiente:

```json
{
  "title": "No post with this type",
  "message": "There are no posts with products type:  Food"
}

```

