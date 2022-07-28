package main;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum=new Curriculum("jorge",21,21);
        System.out.println(curriculum.imprimible());
        Informes informes=new Informes("luis fernando",1234,"burlando","luis");
        System.out.println(informes.imprimible());
        Libros libros=new Libros(21,"alfonso","alcapone","robo");
        System.out.println(libros.imprimible());
    }
}
