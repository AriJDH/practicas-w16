package asteroid;

import java.lang.reflect.Array;
import java.util.List;

public interface IGame {
    void addParticipant(IParticipant participant);
    void init(List<Integer[]> targets);
    IParticipant calculateRoundWinner(Integer[] coordinates);
    IParticipant end();
}
