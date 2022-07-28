# Proyectos
Encontraras diferentes proyectos los cuales cuentan con sus respectivos paquetes ( Algunos de ellos )

# Compilacion
Para compilar y generar los archivos _.class_ de un proyecto en especifico debes ejecutar lo siguiente en la linea de comandos. **Es importante tener JDK instalado**

Con subdirectorios: 
```bash
javac Project/*/*.java
```

Sin subdirectorios:
```bash
javac Package/*.java
```

# Ejecucion
Para ejecutar los archivos compilados escribe lo siguiente en la linea de comandos. (**MainClass es la clase que contiene el metodo Main**)
```bash
java Package.subpackage.MainClass
```

# Ejemplo
```bash
cd ClasesAbstractasEInterfaces/ExerciseOne && javac ExerciseOne/*/*.java && java ExerciseOne.executable.Main
```