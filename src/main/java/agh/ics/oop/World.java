package agh.ics.oop;
import java.util.Map;
import java.util.*;


import static java.lang.System.in;
import static java.lang.System.out;

public class World {

    public static void run(MoveDirection[] instrukcje) {
        out.println("Zwierzak idzie do przodu");
        for (MoveDirection argument : instrukcje) {
            if (argument == MoveDirection.FORWARD) {
                out.println("Do przodu");
            }
            else if (argument ==MoveDirection.BACKWARD) {
                out.println("Do tyłu");
            }
            else if (argument == MoveDirection.LEFT) {
                out.println("W lewo");
            }
            else if (argument == MoveDirection.RIGHT) {
                out.println("W prawo");
            }
        }
    }

    public static void main(String[] args) {
        out.println("Start");
        MoveDirection[] i = {MoveDirection.BACKWARD, MoveDirection.FORWARD};
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
        out.println(a);
        Vector2d position3 = new Vector2d(1,2);
        out.println(position1.hashCode());
        out.println(position3.hashCode());
        out.println(position1.equals(position3));
        Animal piesek = new Animal();
        out.println(piesek);
        piesek.move(MoveDirection.RIGHT);
        piesek.move(MoveDirection.FORWARD);
        piesek.move(MoveDirection.FORWARD);
        piesek.move(MoveDirection.FORWARD);
        out.println(piesek);
        OptionsParser instrukcje1 = new OptionsParser();
        String[] instrukcje2 = {"r","r","f","f","f","f","l","f","f"};
        MoveDirection[] instrukcje3 = instrukcje1.parse(instrukcje2);
        for(MoveDirection dirr : instrukcje3){
            piesek.move(dirr);
        }
        out.println(piesek);
        // args =f b r l f f r r f f f f f f f f
        MoveDirection[] directions = new OptionsParser().parse(args);
        out.println(directions);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println(map);
    }
}


