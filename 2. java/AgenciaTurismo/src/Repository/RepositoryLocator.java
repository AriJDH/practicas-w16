package Repository;

import Entity.Locator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryLocator {
    private Map<String, List<Locator>> locators;
    private Double total = 0.0;

    public RepositoryLocator() {
        locators = new HashMap<>();
    }

    public void addLocator(String client, Locator locator, double amount){
        if (locators.get(client) == null){
            List<Locator> aux = new ArrayList<>();
            aux.add(locator);
            locators.put(client,aux);
        }
        else
            locators.get(client).add(locator);
        this.total += amount;
    }

    public double customerHistory(String cliente){
        double benefit = 1;
        if (locators.size() != 0 && locators.get(cliente) != null && locators.get(cliente).size() >= 2)
            benefit= 0.95;
        return benefit;
    }

    public int amountLocators(){
        int count = 0;
        for (List<Locator> l : locators.values()){
            count += l.size();
        }
        return count;
    }

    public int amountBokings(){
        int count = 0;
        for (List<Locator> locatorList  : locators.values()){
            for (int i = 0 ; i < locatorList.size();i++){
                count += locatorList.get(i).getBookings().size();
            }
        }
        return count;
    }

    public int getLocators(String client){
        return (locators.get(client).size());
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
