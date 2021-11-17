package agh.ics.oop;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private ArrayList<Animal> animals = new ArrayList<>();
    private int width,height;

    public RectangularMap(int width,int height){
        this.width = width-1;
        this.height = height-1;
    }

    public String toString(){
        MapVisualizer mapa = new MapVisualizer(this);
        String draw = mapa.draw(new Vector2d(0,0),new Vector2d(width,height));
        return draw;
    }
    public ArrayList getAnimals(){
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.follows(new Vector2d(0,0))&&position.precedes(new Vector2d(width,height))&&!isOccupied(position)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(animals.contains(animal))
            return true;
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals) {
            if(animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals) {
            if(animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }
}
