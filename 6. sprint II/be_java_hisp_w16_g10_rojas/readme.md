# Grupo 10

## Test de Postman

- En la aplicación ya estan creados previamente 4 usuarios con la siguiente información:
  - User1: {"id": 1, "name": "user1"}
  - User2: {"id": 2, "name": "user2"}
  - User3: {"id": 3, "name": "user3"}
  - User4: {"id": 4, "name": "user4"}

- La collección contiene distintas request para los mismos endpoints donde se podrán probar cada una de las validaciones.
- **Para proceder con los test, lo primero que se deberá hacer es crear un Post para el user de id 2.**

### Consideraciones:

- Los usuarios no poseen seguidores, seguidos ni posts.
- Solo se considera vendedor si el usuario tiene al menos un post.
- Solo se puede seguir a vendedores.
- Solo se puede listar seguidores de un vendedor.
- Si los parámetros de filtro no se corresponden con los especificados, simplemente son ignorados y se utiliza la ordenación por defecto.

## Tecnologias aplicadas fuera de lo visto en el bootcamp

### Mock de metodos estaticos

##### Situacion:

> El resultado de o los test que se realizan sobre todos aquellos servicios que requiera la utilizacion de un metodo externo para mappear desde la entity a un DTO o visceversa no deberian depender de si la logica dentro de estos metodos mapper esta escrita o esta mal escrita.

#### Solucion:

> Realizar el mock de los metodos estaticos de la clase Mapper a fin de lograr la funcionalidad requerida.

En la clase PostServiceTest linea 281 a 296 se encuenta comentado el siguiente codigo.

``````

try(MockedStatic<Mapper> mapper = Mockito.mockStatic(Mapper.class)){

   mapper.when(()-> Mapper.parseToPostResDTO(Mockito.any())).thenReturn(postResDTO);

   lenient().when(postRepository.findByUserId(Mockito.anyInt())).thenReturn(listPost);

   List<PostResDTO> resPostService =  postService.findByUserId(Mockito.anyInt());

   verify(postRepository,atMostOnce()).findByUserId(Mockito.anyInt());
   Assertions.assertTrue(resPostService.equals(listPostResDTO));

};
````````
Se puede comprobar que la solucion es efectiva realizando las siguientes modificaciones:

   - Quitar cometarios entre las lineas 281 a 296
   - Comentar las lineas 298 a 301
   - Cambiando cualquier valor del objeto "post" linea 257

Sin importar que valores cambiemos del objeto post el resultado del test sera verde ya que al estar el mapper mockeado da igual que lista de post le pasemos, siempre nos devolvera el objeto postResDTO (linea 287). De esta forma se logra encapsular el test y que el resultado del mismo solo dependa de la logica que este metodo maneja y no de metodos externos.

### A tener en cuenta:

Esta solucion acarrea la implementacion de test unitarios sobre la clase Mapper ya que al estar encapsulado el servicio el test nunca pasa por dicho metodo de la clase.

