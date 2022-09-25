package Documentos;

import java.util.List;

public class LibrosPdf implements IImprimibleService {

    private Integer cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibrosPdf(){}

    public LibrosPdf(Integer cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }
    public Integer getCantPaginas()
    {
        return cantPaginas;
    }
    public String getNombreAutor(){
        return nombreAutor;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getGenero(){
        return genero;
    }

    public void setCantPaginas(Integer cantPaginas){ this.cantPaginas = cantPaginas;}
    public void setNombreAutor(String nombreAutor){ this.nombreAutor = nombreAutor;}
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public void setGenero(String genero){ this.genero = genero; }

    @Override
    public void imprimible() {
        System.out.println("Imprimiendo LibrosPdf: "
                + "Cantidad de paginas: " + this.cantPaginas +","+ " Nombre Autor : "
                + this.nombreAutor +","+ " Titulo : " + this.titulo +","+ " Genero : " + this.genero);
    }
}
