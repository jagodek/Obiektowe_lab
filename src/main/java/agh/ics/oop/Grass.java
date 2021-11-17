package agh.ics.oop;
import static java.lang.System.out;

public class Grass {
    private Vector2d position;
    Grass(Vector2d position){
        this.position = position;
    }
    public Vector2d getPosition(){
        return position;
    }
    public String toString(){
        return "*";
    }

}
