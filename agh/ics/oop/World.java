package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        int i = [1,2,3,4,1,2,2,4,4,3];
        run(i);
        out.println("Stop");

    }
    public static void run(int instrukcje) {
        out.println("Zwierzak idzie do przodu");
        for(int argument : instrukcje){
            switch(argument){
                case Direction.Directions.:
                    out.println("Do przodu");
                    break;
                case Direction.Directions.BACKWARD:
                    out.println("Do tyłu");
                    break;
                case Direction.Directions.RIGHT:
                    out.println("W prawo");
                    break;
                case Direction.Directions.LEFT:
                    out.println("W lewo");
                    break;
            }
        }
    }
}
