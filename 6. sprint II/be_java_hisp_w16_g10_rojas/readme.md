### Tencologias no usadas en clase:

##### Jacoco

Jacoco esta instalado como plugin en el pom. Esto es principalmente ya que no trabajo usando IntelliJ, mi editor de texto es Nvim y utilizo la terminal para correr tanto las instancias de spring como los test.

Para visualizar el resultado del coverage de Jacoco se debe ir a la carpeta ./target/site/jacoco/ y abrir el index.html que se encuenta dentro.

Comandos desde la terminal para levantar spring boot y tests:

   - mvn srping-boot:run (Para levantar servidor de spring boot, este comando levanta el servidor en modo escucha por lo cual se resetea automaticamente si se realiza un cambio en el codigo y se guarda el mismo)
   - mvn clean test (Para correr todos los test)
   - mvn test -Dtest=NombreDeClaseATestear (Para correr el test de una clase en particular)
   - mvn test -Dtest="NombreDeClaseATestear#nombreDelMetodo" (Para correr un test especifico)

Al realizar mvn clean test se actualiza la informacion de Jacoco.
