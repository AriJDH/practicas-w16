# Grupo 10

## Test de Postman

- En la aplicación ya estan creados previamente 4 usuarios con la siguiente información:
  - User1: {"id": 1, "name": "user1"}
  - User2: {"id": 2, "name": "user2"}
  - User3: {"id": 3, "name": "user3"}
  - User4: {"id": 4, "name": "user4"}

- Los usuarios no poseen seguidores, seguidos ni posts.
- Solo se considera vendedor si el usuario tiene al menos un post.
- Solo se puede seguir a vendedores.
- Solo se puede listar seguidores .

## Parte Individual - Bonus

Para esta parte realicé 3 requerimientos extras:

US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor.
- Devuelve todos los post en promoción del usuario especificado.
- Es un GET al endpoint `/products/promo-post/list?user_id=1`.
- Ejemplo de respuesta:
```json
{
    "user_id": 1,
    "user_name": "user1",
    "posts": [
        {
            "user_id": 1,
            "post_id": 3,
            "date": "08-08-2022",
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

US 0013: Obtener un listado con todos los productos en promocion por vendedor.
- Devuelve un listado con todos los productos en promoción agrupados por usuario.
- Es un GET al endpoint `/products/promo-post/list/all`.
- Ejemplo de respuesta:
```json
[
  {
      "user_id": 1,
      "user_name": "user1",
      "posts": [
          {
              "user_id": 1,
              "post_id": 3,
              "date": "08-08-2022",
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
  },
  {
      "user_id": 2,
      "user_name": "user2",
      "posts": [
          {
              "user_id": 2,
              "post_id": 1,
              "date": "08-08-2022",
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
          },
          {
              "user_id": 2,
              "post_id": 2,
              "date": "08-08-2022",
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
]
```
  
  
US 0014: Obtener el usuario con más productos en promocion y su cantidad.
- Devuelve el usuario con mas productos en promoción.
- Es un GET al endpoint `/products/promo-post/user/max`.
- Ejemplo de respuesta:
```json
{
    "user_id": 2,
    "user_name": "user2",
    "promo_products_count": 2
}
```