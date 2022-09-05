import java.util.*;


public class Main {
  public static void main(String[] args) {
    Map<Integer, List<Garment>> map = new HashMap<>();

    StoreGarment storeGarment = new StoreGarment(0, map);

    Garment garments = new Garment("brand1", "model1");
    Garment garments2 = new Garment("brand2", "model2");
    Garment garments3 = new Garment("brand3", "model3");
    Garment garments4 = new Garment("brand4", "model4");

    List<Garment> listGarments = new ArrayList<>(Arrays.asList(garments, garments2, garments3, garments4));

    int code = storeGarment.garmentStorage(listGarments);
    System.out.println("El codigo de la prenda es : " + code);

    List<Garment> result = storeGarment.returnGarment(code);
    result.forEach(System.out::println);


  }
}
