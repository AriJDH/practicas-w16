public class PracticaExepciones {

    private int a=0;
    private int b=300;



    public void  calcularDivision() {

        try {

            if(a==0){
                throw new IllegalArgumentException("No se puede dividir por 0");
            }


        } catch (IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
