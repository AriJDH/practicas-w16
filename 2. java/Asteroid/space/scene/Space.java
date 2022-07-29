package Asteroid.space.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Asteroid.space.characters.Flota;
import Asteroid.space.characters.Nave;
import Asteroid.space.characters.NaveSimple;
import Asteroid.space.targets.Asteroide;

public class Space {
    private HashMap<String, Nave> players;
    private List<Asteroide> asteroids;
    private Object[][] map;

    public Space() {
        this.players = new HashMap<>();
        this.asteroids = new ArrayList<>();
    }

    public Space(HashMap<String, Nave> players, List<Asteroide> asteroids) {
        this.players = players;
        this.asteroids = asteroids;
    }

    public HashMap<String, Nave> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<String, Nave> players) {
        this.players = players;
    }

    public List<Asteroide> getAsteroids() {
        return asteroids;
    }

    public void setAsteroids(List<Asteroide> asteroids) {
        this.asteroids = asteroids;
    }

    public void addPlayer(String name, Nave player) {
        this.players.put(name, player);
    }

    public void removePlayer(String name) {
        this.players.remove(name);
    }

    public void addAsteroid(Asteroide asteroid) {
        this.asteroids.add(asteroid);
    }

    public void removeAsteroid(Asteroide asteroid) {
        this.asteroids.remove(asteroid);
    }

    public Object[][] getMap() {
        return map;
    }

    public void run(){
        int topX = Integer.MAX_VALUE; 
        int topY = Integer.MAX_VALUE;
        int bottomX = Integer.MIN_VALUE;
        int bottomY = Integer.MIN_VALUE;

        for(Nave player : players.values()){

            if(player instanceof NaveSimple){
                NaveSimple nave = (NaveSimple) player;
                if(nave.getX() < topX){
                    topX = nave.getX();
                }
                if(nave.getY() < topY){
                    topY = nave.getY();
                }
                if(nave.getX() > bottomX){
                    bottomX = nave.getX();
                }
                if(nave.getY() > bottomY){
                    bottomY = nave.getY();
                }
            }else if(player instanceof Flota){
                Flota nave = (Flota) player;
                for(Nave nave2 : nave.getNaves()){
                    if(nave2.getX() < topX){
                        topX = nave2.getX();
                    }
                    if(nave2.getY() < topY){
                        topY = nave2.getY();
                    }
                    if(nave2.getX() > bottomX){
                        bottomX = nave2.getX();
                    }
                    if(nave2.getY() > bottomY){
                        bottomY = nave2.getY();
                    }
                }
            }
        }

        for(Asteroide asteroid : asteroids){
            if(asteroid.getX() < topX) topX =  asteroid.getX();
            if(asteroid.getY() < topY) topY =  asteroid.getY();
            if(asteroid.getX() > bottomX) bottomX =  asteroid.getX();
            if(asteroid.getY() > bottomY) bottomY = asteroid.getY();
        }

        map = new Object[bottomX - topX + 1][bottomY - topY + 1];

        for(Nave player : players.values()){
            if(player instanceof NaveSimple){
                NaveSimple nave = (NaveSimple) player;
                map[nave.getX() - topX][nave.getY() - topY] = nave;
            }else if(player instanceof Flota){
                Flota nave = (Flota) player;
                for(Nave nave2 : nave.getNaves()){
                    map[nave2.getX() - topX][nave2.getY() - topY] = nave2;
                }
            }
        }

        for(Asteroide asteroid : asteroids){
            
            map[asteroid.getX() - topX][asteroid.getY() - topY] = asteroid;
            
            Nave best = null;
            double bestDistance = Double.MAX_VALUE;

            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[i].length; j++){
                    if(map[i][j] == null) continue;
                    if(map[i][j] instanceof Nave){
                        Nave player = (Nave) map[i][j];
                        if(player.collide(asteroid) < bestDistance){
                            best = player;
                            bestDistance = player.collide(asteroid);
                        }
                    }
                }
            }

            if(best != null){
                best.incrementScore();
            }

            map[asteroid.getX() - topX][asteroid.getY() - topY] = null;
        }

        Nave best = null;
        int bestScore = Integer.MIN_VALUE;

        for(Nave player : players.values()){
            if(player.getScore() > bestScore){
                best = player;
                bestScore = player.getScore();
            }    
        }

        if(best != null){
            System.out.println("El ganador es: " + best);
        }
    }



}
