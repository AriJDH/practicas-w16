EJS

//tipos de datos a seguir

1. object storage, pq son datos binarios
2. kvs, por el escalamiento horiozntal, es mas flexible a cambios, se evita el cuello de botella en cuanto a llamados de datos

//CASOS DE USO

1. (cdc) golden gate con bigqueue, pq se adapta justo a la situacion 
2. activo la integracion con document search, para poder buscar a traves de el
3. se podria hacer lo mismo de arriba, pero lo mejor es el dump pq es mas barato
4. se podria con stream o bigqueue, pero lo mejor es stream 