package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
    protected int width,height;
    protected ArrayList<Animal> animals = new ArrayList<>();
    protected ArrayList<Grass> grasses = new ArrayList<>();


    public String toString(){
        if(this instanceof RectangularMap)
            return toStringRectangle();
        if(this instanceof GrassField)
            return toStringGrass();
        return "  ";
    }


    private String toStringGrass(){
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
    }

    private String toStringRectangle(){
        MapVisualizer mapaR = new MapVisualizer(this);
        String draw = mapaR.draw(new Vector2d(0,0),new Vector2d(width,height));
        return draw;
    }

    public boolean place(Animal animal) {
        for(Animal a: animals){
            if(a.getPosition().equals(animal.getPosition())){
                return false;
            }
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        for(Grass grass : grasses) {
            if(grass.getPosition().equals(position))
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
