# How to use

### US 0012: Obtener un listado de todos los productos en promocion de un determinado vendedor

> Method SIGN:
> GET /products/promo-post/list?user_id={userId}

> RESPONSE:

```
   {
      "user_id": 234,
         "user_name": "vendedor1",
         "posts": [
         {
            "user_id": 234
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
````

### US 0013: Obtener un listado de todos los post con promocio que cualquier vendedor haya realizado en las ultimas 24 hs.

> Method SIGN:
> GET /products/promo-post/all24hs

> RESPONSE:

````
[
    {
        "user_id": 1,
        "user_name": "user1",
        "posts": [
            {
                "user_id": 1,
                "post_id": 1,
                "date": "2022-08-11",
                "product": {
                    "product_id": 3,
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
]
````
