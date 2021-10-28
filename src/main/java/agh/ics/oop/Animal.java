package agh.ics.oop;

import java.util.Map;

public class Animal {
    private MapDirection a_direction= MapDirection.NORTH;
    private Vector2d a_position = new Vector2d(2,2);

    public String toString(){
        return "(" + a_position.x + "," +  a_position.y + "," + a_direction + ")";
    }
    public void move(MoveDirection move_dir){
        switch (move_dir){
            case LEFT:
                a_direction = a_direction.previous();
                break;
            case RIGHT:
                a_direction = a_direction.next();
                break;
            case FORWARD:
                switch (a_direction){
                    case NORTH:
                        a_position = a_position.add(new Vector2d(0,1));
                        break;
                    case EAST:
                        a_position = a_position.add(new Vector2d(1,0));
                        break;
                    case SOUTH:
                        a_position = a_position.add(new Vector2d(0,-1));
                        break;
                    case WEST:
                        a_position = a_position.add(new Vector2d(-1,0));
                        break;
                }
                break;
            case BACKWARD:
                switch (a_direction){
                    case NORTH:
                        a_position = a_position.add(new Vector2d(0,-1));
                        break;
                    case EAST:
                        a_position = a_position.add(new Vector2d(-1,0));
                        break;
                    case SOUTH:
                        a_position = a_position.add(new Vector2d(0,1));
                        break;
                    case WEST:
                        a_position = a_position.add(new Vector2d(1,0));
                        break;
                }
                break;
        }
        if(a_position.x>4){
            a_position =a_position.subtract(new Vector2d(1,0));
        }
        if(a_position.y>4){
            a_position =a_position.subtract(new Vector2d(0,1));
        }
        if(a_position.x<0){
            a_position = a_position.add(new Vector2d(1,0));
        }
        if(a_position.y<0){
            a_position =a_position.add(new Vector2d(0,1));
        }
    }

}