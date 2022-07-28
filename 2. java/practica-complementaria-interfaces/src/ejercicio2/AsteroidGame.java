package ejercicio2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AsteroidGame {

    private final List<Player> players;
    private final List<ScoreItem> scoreList;

    public static AsteroidGame prepareFor(List<Player> aPlayerList){
        return new AsteroidGame(aPlayerList);
    }

    private AsteroidGame(List<Player> aPlayerList){
        players = aPlayerList;
        scoreList = new ArrayList<>();
    }

    public void runGameWith(List<Point> asteroidsCoordinates){
        asteroidsCoordinates.forEach(coordinate -> {
            executeTurnForPlayersStoringResultsOn(scoreList, players, coordinate);
        });

        printWinner();
        printScoreList();
    }

    private void printScoreList() {
        scoreList.forEach(item -> item.toString());
    }

    private void printWinner() {
        Player winner = Collections.max(players, Comparator.comparing(player -> player.getSpacecraft().score()));
        System.out.println(winner.toString());
        System.out.println(winner.getSpacecraft().toString());
    }

    private void executeTurnForPlayersStoringResultsOn(List<ScoreItem> scoreList, List<Player> aPlayers, Point coordinate) {
        List<Spacecraft> spacecraftList = aPlayers.stream().map(Player::getSpacecraft).collect(Collectors.toList());

        Spacecraft spacecraftWinner = Collections.min(spacecraftList,
                                        Comparator.comparing(spacecraft -> spacecraft.distanceTo(coordinate)));


        scoreList.add(new ScoreItem(spacecraftWinner, coordinate));
        spacecraftWinner.incrementScore();
    }


}
