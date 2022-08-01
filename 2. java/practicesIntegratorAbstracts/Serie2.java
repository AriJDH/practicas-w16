package practicesIntegratorAbstracts;

import java.util.List;

public class Serie2 extends Prototype<Integer>{

    public Serie2() {
    }

    public Serie2(List<Integer> listNumbers) {
        super(listNumbers, 2);
    }

    @Override
    public List<Integer> countNetxNumber() {
        if (listNumbers.size() == 0) {
            listNumbers.add(num);
        } else {
            int lastIndex = listNumbers.size() - 1;
            System.out.println(lastIndex);
            listNumbers.add(listNumbers.get(lastIndex)+num);
        }
        return listNumbers;
    }

    @Override
    public void resetListNumbers() {
        num = 0;
        listNumbers.clear();
    }

    @Override
    public void createWithInitialBase(Integer number) {
        resetListNumbers();
        num = number;
        listNumbers.add(number);
    }
}
