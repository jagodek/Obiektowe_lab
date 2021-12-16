package agh.ics.oop;

import java.awt.image.AbstractMultiResolutionImage;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Vector;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    protected int width,height;
    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected Map<Vector2d, Grass> grasses = new LinkedHashMap<>();




    public String toString(){
        MapVisualizer mapa = new MapVisualizer(this);
        Vector2d[] rogi = corners();
        return mapa.draw(rogi[0],rogi[1]);

    }

    public abstract Vector2d[] corners();



    public boolean place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if(!canMoveTo(pos)){
            throw new IllegalArgumentException("brak możliwości dodania zwierzęcia na tą pozycję");
        }
        animals.put(pos,animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(animals.containsKey(position))
                return true;
        return false;

    }

    @Override
    public Object objectAt(Vector2d position) {
        if(isOccupied(position))
                return animals.get(position);
        return null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,animal);
    }


}
