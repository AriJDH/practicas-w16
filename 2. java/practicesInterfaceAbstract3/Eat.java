package practicesInterfaceAbstract3;

import java.lang.reflect.InvocationTargetException;

public class Eat<T>{

    public Eat() {
    }

    public void eatAnimal(T object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String especie = (String) object.getClass().getMethod("getKindOfAnimal", null).invoke(object,null);

        if (especie == "Carnivorous") {
            object.getClass().getMethod("eatMeat", null).invoke(object,null);
        } else if (especie == "Herbivorous"){
            object.getClass().getMethod("eatGrass", null).invoke(object,null);
        } else {
            System.out.println("Sin comida");
        }
    }
}
