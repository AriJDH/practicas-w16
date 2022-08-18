package asteroid;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;

public class Game implements IGame {
    private List<IParticipant> participants;
    private List<Integer[]> targets;

    @Override
    public void addParticipant(IParticipant participant) {
        this.participants.add(participant);
    }

    @Override
    public void init(List<Integer[]> targets) {
        System.out.println("Juego iniciado!");
        if(this.targets == null) {
            System.out.println("Dale capo, tenes que iniciar el juego antes de empezarlo");
            return;
        }
        this.targets
                .stream()
                .forEach((target) -> {
                    IParticipant winner = this.calculateRoundWinner(target);
                    winner.getFleet().addScore();
                });
    }
    @Override
    public IParticipant calculateRoundWinner(Integer[] coordinates) {
        Integer x = coordinates[0];
        Integer y = coordinates[1];
        return this.participants
                .stream()
                .max(Comparator.comparing((a) -> a.getFleet().getDistanceAverage(x, y)))
                .get();
    }

    @Override
    public IParticipant end() {
        if(this.targets == null) {
            System.out.println("Dale capo, tenes que iniciar el juego antes de empezarlo");
            return null;
        }

        return this.participants
                .stream()
                .max(Comparator.comparing((a) -> a.getFleet().getScore()))
                .get();
    }
}
