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


    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.follows(new Vector2d(0,0))&&position.precedes(new Vector2d(width,height))&&!isOccupied(position)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!(this.isOccupied(animal.getPosition()))) {
            animals.add(animal);
            return true;
        }
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
