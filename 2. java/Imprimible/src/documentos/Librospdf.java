package documentos;

import interfaces.Imprimible;

public class Librospdf implements Imprimible {
    private int cantidad_paginas;
    private String autor;
    private String titulo;
    private String genero;


    public int getCantidad_paginas() {
        return cantidad_paginas;
    }

    public void setCantidad_paginas(int cantidad_paginas) {
        this.cantidad_paginas = cantidad_paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Librospdf(int cantidad_paginas, String autor, String titulo, String genero) {
        this.cantidad_paginas = cantidad_paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void realizarImpresion() {
        System.out.println(this.titulo);
        System.out.println("----------");

        System.out.println("Autor: " + this.autor);
        System.out.println("Cantidad de páginas: " + this.cantidad_paginas);
        System.out.println("Genero: " + this.genero);

    }
}
