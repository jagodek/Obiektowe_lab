package agh.ics.oop;
import static java.lang.System.out;

public class Grass implements IMapElement{
    private Vector2d position;
    Grass(Vector2d position){
        this.position = position;
    }
    @Override
    public Vector2d getPosition(){
        return position;
    }
    public String toString(){
        return "*";
    }

    public String looks(){
        return "grass";
    }

}
