package agh.ics.oop;
import static java.lang.System.out;

public class World {

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
    }
}


