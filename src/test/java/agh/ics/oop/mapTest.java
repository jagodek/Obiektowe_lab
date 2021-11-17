package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class mapTest {
    @Test
    void MapTest(){
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"b","f","r","r","b","f","b","b"});
        IWorldMap map = new RectangularMap(3,4);
        Vector2d[] positions =  { new Vector2d(2,2), new Vector2d(0,0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertTrue(map.isOccupied(new Vector2d(0,1)));
        assertFalse(map.canMoveTo(new Vector2d(1,1)));
    }


}
