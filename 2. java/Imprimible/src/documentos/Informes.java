package documentos;

import interfaces.Imprimible;

public class Informes implements Imprimible {

    private String texto;
    private int cantidad_paginas;
    private String autor;
    private String revisor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informes(String texto, int cantidad_paginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidad_paginas = cantidad_paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void realizarImpresion() {
        System.out.println("INFORMES");
        System.out.println("----------");

        System.out.println("Texto: " + this.texto);
        System.out.println("Cantidad de páginas: " + this.cantidad_paginas);
        System.out.println("Autor: " + this.autor);
        System.out.println("Revisor: " + this.revisor);
    }
}
