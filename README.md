# practicas-w16 🚀
by Digital House 💗

way to work 🎯

Repositorio de practicas de Bootcamp DH Java Wave 16

## Directrices de creación de ramas

Al momento de crear las ramas convenimos una directriz de "Naming" para las mismas:

* El nombre debe ser en lowercase (minuscula).
* Debe contener unicamente el nombre y apellido del bootcamper.
* Si tienen muchos nombres y apellidos, usar su primer nombre y su primer apellido.
* Usar snake_case.

Ejemplo:

```
 git branch [apellido]_[nombre]
```

## Flujo de trabajo


Cada desarrolador cuenta con un branch con la estructura ya creada a su nombre para trabajar en las prácticas y desafíos.

1. Clonar el repositorio (branch y estructura)
   
   `git clone git@github.com:AriJDH/practicas-w16.git`
   
2. Entrar a la carpeta del proyecto clonado y crear el branch con su apellido y nombre

   `git branch [apellido]_[nombre]`
   o
   `git checkout -b [apellido]_[nombre]`
   
3. Subir la rama que crearon
   
   `git push -u origin [apellido]_[nombre]`

4. Luego trabajar con el flujo habitual 

   `git add .`
   
   `git commit -m "mensaje de commit"`
   
   `git push`
