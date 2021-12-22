package agh.ics.oop;
import java.util.Map;
import java.util.Random;
import java.lang.Math.*;
import java.util.ArrayList;

public class GrassField extends AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    private int noGrass;
    private MapBoundary boundary = new MapBoundary(this);

    public GrassField(int noGrass){
        this.noGrass = noGrass;
        Random random = new Random();
        Vector2d grassFreeSpace;
        Grass grass;
        int i =0;
        while(i<noGrass)
        {
            grassFreeSpace = new Vector2d(random.nextInt((int) Math.sqrt(noGrass*10)),random.nextInt((int) Math.sqrt(noGrass*10)));
            if(objectAt(grassFreeSpace) == null){
                grass = new Grass(grassFreeSpace);
                grasses.put(grassFreeSpace,grass);
                boundary.addElement(grass);
                i++;
            }
        }
    }

    @Override
    public Vector2d[] corners(){
        return boundary.getCorners();
    }



    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position)&&(objectAt(position) instanceof Animal))
            return false;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        Boolean occupied = super.isOccupied(position);
        if(occupied==false){
            if(grasses.containsKey(position))
                    return true;
        }
        else
            return true;
        return false;
    }
    @Override
    public boolean place(Animal animal){
        Boolean b = super.place(animal);
        if(b){
            boundary.addElement(animal);
            animal.addObserver(boundary);
            return true;
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if(obj == null){
            if(grasses.containsKey(position)){
                return grasses.get(position);
            }

        }
        else
            return obj;
        return null;
    }



}
