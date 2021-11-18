package agh.ics.oop;
import java.util.Random;
import java.lang.Math.*;
import java.util.ArrayList;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private int noGrass;

    GrassField(int noGrass){
        this.noGrass = noGrass;
        Random random = new Random();
        Vector2d newGrass;
        int i =0;
        while(i<noGrass)
        {
            newGrass = new Vector2d(random.nextInt((int) Math.sqrt(noGrass*10)),random.nextInt((int) Math.sqrt(noGrass*10)));
            if(objectAt(newGrass) == null){
                grasses.add(new Grass(newGrass));
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
    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position)&&(objectAt(position) instanceof Animal))
            return false;
        return true;
    }





}
