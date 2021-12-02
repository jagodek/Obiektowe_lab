package agh.ics.oop;
import java.util.Map;
import java.util.Random;
import java.lang.Math.*;
import java.util.ArrayList;

public class GrassField extends AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    private int noGrass;


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

    /**public String toString(){
        MapVisualizer mapa = new MapVisualizer(this);
        Vector2d prawyGorny = new Vector2d(0,0);
        Vector2d lewyDolny  = new Vector2d(0,0);
        for(Grass grass: grasses){
            prawyGorny = prawyGorny.upperRight(grass.getPosition());
            lewyDolny = lewyDolny.lowerLeft(grass.getPosition());
        }
        for(Animal animal:animals){
            prawyGorny = prawyGorny.upperRight(animal.getPosition());
            lewyDolny = lewyDolny.lowerLeft(animal.getPosition());
        }

        String draw = mapa.draw(lewyDolny,prawyGorny);
        return draw;
    }*/
    @Override
    public Vector2d[] corners(){
        Vector2d lowerLeft = new Vector2d(boundary.xAxis.first().getPosition().getX(),boundary.yAxis.first().getPosition().getY());
        Vector2d upperRight = new Vector2d(boundary.xAxis.last().getPosition().getX(),boundary.yAxis.last().getPosition().getY());
        Vector2d[] output = {lowerLeft,upperRight};
        return output;
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
        if(b==true){
            boundary.addElement(animal);
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
