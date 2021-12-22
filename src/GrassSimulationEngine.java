package agh.ics.oop;
import agh.ics.oop.gui.App;

import java.util.ArrayList;

public class GrassSimulationEngine implements Runnable{
    private MoveDirection[] directions;
    private int noAnimals,noSeries;
    private GrassField map;
    private ArrayList<Animal> animals = new ArrayList<>();
    private App ap;

    public GrassSimulationEngine(MoveDirection[] directions, GrassField map, Vector2d[] positions,IPositionChangeObserver app) {
        this.map = map;
        this.directions = directions;
        this.noAnimals = positions.length;
        this.noSeries = directions.length / noAnimals;
        Animal animal;
        for (Vector2d pos : positions) {
            animal = new Animal(map, pos);
            animals.add(animal);
            map.place(animal);
            animal.addObserver(app);
        }
    }

    @Override
    public void run(){
        Animal current;
        for(int k =0; k< noSeries;k++)
            for(int i =0 ; i < noAnimals;i++){
                current = animals.get(i);
                current.move(directions[k*noAnimals+i]);
            }
    }


    public void setDirections(MoveDirection[] newD){
        this.directions = newD;
        this.noSeries = directions.length / noAnimals;
    }


}
