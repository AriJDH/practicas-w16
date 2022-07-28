package ejercicio2.clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Peréz");
        persona.setEdad(23);
        persona.setDni("123456");

        List<String> habilidadesPersona = new ArrayList<>();
        habilidadesPersona.add("Programación");
        habilidadesPersona.add("Analisis");

        Curriculum curriculumPersona = new Curriculum();
        curriculumPersona.setPersona(persona);
        curriculumPersona.setHabilidades(habilidadesPersona);

        curriculumPersona.imprimir();

        LibroPDF libro = new LibroPDF();
        libro.setGenero("Educativo");
        libro.setCantidadPaginas(320);
        libro.setNombreAutor("Juan Peréz");
        libro.setTitulo("Libro Educativo de Programación 1");

        libro.imprimir();

        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi";
        Informe informe = new Informe(texto, "Juan Peréz", "Jorge Díaz", 1);
        informe.imprimir();
    }
}
