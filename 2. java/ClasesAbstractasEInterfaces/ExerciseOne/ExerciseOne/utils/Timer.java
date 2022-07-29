package   ExerciseOne.utils;

public class Timer {

    private static boolean state;

    public static void run(){
        run(3);
    }

    public static void run(int time){
        while(time > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }

        state = (int)(Math.random() * 2) == 1;
    }   

    public static boolean getState(){
        return state;
    }

}
