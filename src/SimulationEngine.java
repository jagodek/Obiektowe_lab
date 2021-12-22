package agh.ics.oop;
import java.util.ArrayList;

public class SimulationEngine implements IEngine,Runnable{
    private MoveDirection[] directions;
    private int noAnimals,noSeries;
    IWorldMap map;
    ArrayList<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions,IWorldMap map,Vector2d[] positions){
        this.map = map;
        this.directions = directions;
        this.noAnimals = positions.length;
        this.noSeries = (int) directions.length/noAnimals;
        Animal animal;
        for(Vector2d pos: positions){
            animal = new Animal(map,pos);
            animals.add(animal);
            this.map.place(animal);
        }
    }

    @Override
    public void run() {
        Animal current;
        for(int k =0; k< noSeries;k++)
            for(int i =0 ; i < noAnimals;i++){
                current = animals.get(i);
                current.move(directions[k*noAnimals+i]);
            }

    }
}
