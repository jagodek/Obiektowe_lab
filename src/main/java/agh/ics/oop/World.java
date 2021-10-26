package agh.ics.oop;
import java.util.Map;
import java.util.*;


import static java.lang.System.out;

public class World {

    enum MoveDirection{
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT;
    }





    public static void run(Direction.Directions[] instrukcje) {
        out.println("Zwierzak idzie do przodu");
        for (Direction.Directions argument : instrukcje) {
            if (argument == Direction.Directions.FORWARD) {
                out.println("Do przodu");
            }
            else if (argument ==Direction.Directions.BACKWARD) {
                out.println("Do tyłu");
            }
            else if (argument == Direction.Directions.LEFT) {
                out.println("W lewo");
            }
            else if (argument == Direction.Directions.RIGHT) {
                out.println("W prawo");
            }
        }
    }

    public static void main(String[] args) {
        out.println("Start");
        Direction.Directions[] i = {Direction.Directions.BACKWARD, Direction.Directions.FORWARD};
        run(i);
        out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        out.println(position2);
        out.println(position1.add(position2));
        MapDirection a = MapDirection.NORTH;
        out.println(a.next());
        out.println(a.previous());
        out.println(a.toUnitVector());
        out.println(a.toString());
        Vector2d position3 = new Vector2d(1,2);
        out.println(position1.hashCode());
        out.println(position3.hashCode());
        out.println(position1.equals(position3));
    }
}


