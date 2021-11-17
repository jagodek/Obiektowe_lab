package agh.ics.oop;
import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private MoveDirection[] directions;
    private int noAnimals,noSeries;
    RectangularMap map;

    public SimulationEngine(MoveDirection[] directions,IWorldMap map,Vector2d[] positions){
        this.map = (RectangularMap) map;
        this.directions = directions;
        this.noAnimals = positions.length;
        this.noSeries = (int) directions.length/noAnimals;
        for(Vector2d pos: positions){
            new Animal(map,pos);
        }
    }

    @Override
    public void run() {
        Animal current;
        ArrayList<Animal> animals = map.getAnimals();
        System.out.println("ilosc serii " + noSeries);
        for(int k =0; k< noSeries;k++)
            for(int i =0 ; i < noAnimals;i++){
                current = (Animal) animals.get(i);
                current.move(directions[k*noAnimals+i]);
            }

    }
}
