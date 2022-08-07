package PracticaExcepciones;

public class PracticaExcepciones {

    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a; }
    public int getB() { return b; }

    public void setA(int a, int b) {
        this.a =a;
        this.b =b;
    }

    public int cociente() {
        int res=0;
        try {
            res = this.a/ this.b;
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }finally{
            System.out.println("Programa finalizado: ");
        }
        return res;
    }

    public int cociente2(){
        int res=0;
        try {
            if(b==0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        return res;
    }

    }


