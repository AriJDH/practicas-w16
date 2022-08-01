package practicesIntegratorAbstracts;

import java.util.List;

public class Serie extends Prototype<Integer> {

    public Serie() {
    }

    public Serie(List<Integer> listNumbers, Integer num) {
        super(listNumbers, num);
    }

    @Override
    public List<Integer> countNetxNumber() {
        if (num == 0)
            num = (int)(Math.random()*(10)) + 1;

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
