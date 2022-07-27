import java.util.Optional;

public class Persona {
    private String Nombre;
    private int Edad;
    private String DNI;

    public Persona(){

    }
    public Persona(String Nombre){
        this.Nombre = Nombre;
    }
    public Persona(String Nombre, int Edad)
    {
        this.Nombre = Nombre;
        this.Edad = Edad;
    }
    public Persona(String Nombre, int Edad, String DNI)
    {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.DNI = DNI;
    }
    public Persona(String Nombre, String DNI)
    {
        this.Nombre = Nombre;
        this.DNI = DNI;
    }
    public int calcularIMC(double peso, double altura)
    {
        double monto = peso/Math.pow(altura,altura);
        int retorno = 0;
        if(monto<20)
            retorno = -1;
        else if(monto>=20 && monto<=25)
            retorno =  0;
        else if(monto >25)
            retorno = 1;

        return retorno;

    }


    public boolean esMayorDeEdad()
    {
        if(this.Edad >=18)
            return true;
        else
            return false;
    }
    public String toString()
    {
        return "Nombre: "+this.Nombre+" Edad: "+this.Edad+" DNI:"+this.DNI;
    }
}
