public class Main {
    public static void main(String[] args) {
        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Juan",24,"1026302032");
        Persona personaTres = new Persona("Ivan", 34, "1010203040",78,185);
        String estado="";
        int imc=personaTres.calcularIMC();
        boolean esMayorDeEdad = personaTres.esMayorDeEdad();
        switch (imc){
            case -1:
                estado = "Bajo Peso";
                break;
            case 0:
                estado = "Peso Saludable";
                break;
            case 1:
                estado = "Sobrepeso";
                break;
        }

        System.out.println(personaTres.toString());
        System.out.println("----------------------------------------------");
        System.out.println("Indice de masa corporal (IMC)");
        System.out.println("----------------------------------------------");
        System.out.println(estado);

    }
}
