public class PracticaExcepcionesModificada {
    private static int a = 0;
    private static int b = 300;

    public void cocienteModificado(){
        try{
            if(a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");

        }catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }finally {
            System.out.println("Programa finalizado.");
        }
    }
}
