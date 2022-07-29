package EjercicioAbstraccion;

public class Main {
    public static void main(String[] args) {
        SerieOne one= new SerieOne();
        SerieTwo two= new SerieTwo();
        SerieThree three=new SerieThree();

        one.reiniciaSerie();
        //System.out.println(one.serieProgresiva());
        Integer imprime=0;

        System.out.println("dos ---------------------------dos");
        imprime=0;
        for (int i =0;i<7;i++){
            imprime+=two.serieProgresiva();
            if(i==3){
                imprime=two.reiniciaSerie();
            }
            System.out.println(imprime);
        }
        System.out.println("one ---------------------------one");
        imprime=0;

        for (int i =0;i<7;i++){
            imprime+=one.serieProgresiva();
            if(i==3){
                imprime=one.reiniciaSerie();
            }
            System.out.println(imprime);
        }

        System.out.println("tres ---------------------------tres");
        imprime=0;
        for (int i =0;i<7;i++){
            imprime+=three.serieProgresiva();
            if(i==3){
                imprime=three.reiniciaSerie();
            }
            System.out.println(imprime);
        }


    }
}
