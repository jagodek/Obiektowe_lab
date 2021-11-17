package agh.ics.oop;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedList;

public class Animal{
    private MapDirection direction;
    private Vector2d position;
    private RectangularMap map;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this.map = (RectangularMap) map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = (RectangularMap) map;
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
        ArrayList<Animal> animals = this.map.getAnimals();
        animals.add(this);
        this.map.setAnimals(animals);
    }


    public String toString() {
        switch(direction){
            case NORTH: return "N";
            case EAST: return "E";
            case SOUTH: return "S";
            case WEST: return "W";
        }
        return null;
    }

    public Boolean isAt(Vector2d position){
        return position.x == this.position.x && position.y == this.position.y;
    }
    public void move(MoveDirection dir){
        Vector2d nowaPozycja = position;
        if(dir==MoveDirection.LEFT)
            direction = direction.previous();
        else if (dir==MoveDirection.RIGHT)
            direction = direction.next();
        else {
            if (dir==MoveDirection.FORWARD)
                nowaPozycja = position.add(direction.toUnitVector());
            else if (dir==MoveDirection.BACKWARD)
                nowaPozycja = position.subtract(direction.toUnitVector());

            if(map!=null&&map.canMoveTo(nowaPozycja)){
                position = nowaPozycja;
            }

            else if(map==null&&(nowaPozycja.follows(new Vector2d(0,0))&&nowaPozycja.precedes(new Vector2d(4,4)))){
                position = nowaPozycja;
            }
        }

    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

}