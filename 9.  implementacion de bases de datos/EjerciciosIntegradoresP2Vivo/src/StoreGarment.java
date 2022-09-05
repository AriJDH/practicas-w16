import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreGarment {
  private Map<Integer, List<Garment>> garments;
  private Integer counter;

  public StoreGarment() {
  }

  public StoreGarment(Integer counter, Map<Integer, List<Garment>> garments ) {
    this.garments = garments;
    this.counter = counter;
  }

  public Map<Integer, List<Garment>> getGarments() {
    return garments;
  }

  public void setGarments(Map<Integer, List<Garment>> garments) {
    this.garments = garments;
  }

  public Integer getCounter() {
    return counter;
  }

  public void setCounter(Integer counter) {
    this.counter = counter;
  }



  public Integer garmentStorage(List<Garment> listOfGarments) {
    garments.put(++counter, listOfGarments);
    return counter;
  }

  public void getGarment(){
    for (Map.Entry<Integer, List<Garment>> entry: garments.entrySet()){
      System.out.println("Id: " + entry.getKey() + "-" + entry.getValue());
    }
  }

  public List<Garment> returnGarment(Integer number){
      List<Garment> garmentsOne = new ArrayList<>();
      for(Map.Entry<Integer, List<Garment>> entry: garments.entrySet()){
        if(entry.getKey().equals(number)){
          garmentsOne = entry.getValue();
        }
      }
      return garmentsOne;
  }








  @Override
  public String toString() {
    return "SaveClothing{" +
            "garments=" + garments +
            ", counter=" + counter +
            '}';
  }
}
