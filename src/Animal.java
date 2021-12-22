package agh.ics.oop;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedList;

public class Animal implements IMapElement{
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> observers = new ArrayList();




    public Animal(IWorldMap map){
        this(map,new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
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

            if(map.canMoveTo(nowaPozycja)){
                Vector2d staraPozycja = position;
                position = nowaPozycja;
                positionChanged(staraPozycja,position);
            }


        }

    }

    @Override
    public String looks(){
        switch (direction){
            case NORTH -> {
                return "up";
            }
            case EAST -> {
                return "right";
            }
            case SOUTH -> {
                return "down";
            }
            case WEST -> {
                return "left";
            }
        }
        return "";
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }



    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        observers.forEach(observer -> observer.positionChanged(oldPosition,newPosition));
    }

}