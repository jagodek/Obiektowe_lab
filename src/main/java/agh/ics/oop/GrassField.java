package agh.ics.oop;
import java.util.Random;
import java.lang.Math.*;
import java.util.ArrayList;

public class GrassField implements IWorldMap{
    private int noGrass;
    private ArrayList<Grass> grasses;
    private ArrayList<Animal> animals;
    GrassField(int noGrass){
        this.noGrass = noGrass;
        Random random = new Random();
        Vector2d newGrass;
        int i =0;
        while(i<noGrass)
        {
            newGrass = new Vector2d(random.nextInt((int) Math.sqrt(noGrass*10)),random.nextInt((int) Math.sqrt(noGrass*10)));
            if(!(objectAt(newGrass) instanceof Grass)){
                grasses.add(new Grass(newGrass));
                i++;
            }
        }
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position))
            return false;
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        animals.add(animal);
        if(animals.contains(animal))
            return true;
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals) {
            if(animal.getPosition().equals(position))
                return animal;
        }
        for(Grass grass : grasses) {
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }
}
